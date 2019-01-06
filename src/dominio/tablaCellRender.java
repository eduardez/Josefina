package dominio;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class tablaCellRender {
    private prodsCellRender render;
    private ButtonEditor btnEditor;
    private util ut;
    private int fila;

    public prodsCellRender getRender() {
	return render;
    }

    public ButtonEditor getEditor() {
	return btnEditor;
    }

    public tablaCellRender(String tipo, util uti) {
	this.ut = uti;
	if (tipo.equalsIgnoreCase("productos")) {
	    initProd();
	} else {
	    // initPedidos();
	}

    }

    private void initProd() {
	prodsCellRender model = new prodsCellRender();
	this.render = model;
	ButtonEditor btn = new ButtonEditor(new JCheckBox());
	this.btnEditor = btn;
    }

    public class prodsCellRender extends JButton implements TableCellRenderer {

	public prodsCellRender() {
	    setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
		int row, int column) {
	    if (isSelected) {
		setForeground(table.getSelectionForeground());
		setBackground(table.getSelectionBackground());
	    } else {
		setForeground(table.getForeground());
		setBackground(Color.WHITE);
	    }
	    setText((value == null) ? "" : value.toString());
	    return this;

	}

    }// Fin class

    class ButtonEditor extends DefaultCellEditor {
	protected JButton btnMenos;

	private String label;
	private boolean isPushed;

	public ButtonEditor(JCheckBox checkBox) {
	    super(checkBox);
	    btnMenos = new JButton("Borrar");
	    btnMenos.setOpaque(true);
	    btnMenos.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    fireEditingStopped();
		}
	    });
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
		int column) {
	    fila = row;
	    if (isSelected) {
		btnMenos.setForeground(Color.BLACK);
		btnMenos.setBackground(Color.white);
	    } else {
		btnMenos.setForeground(table.getForeground());
		btnMenos.setBackground(table.getBackground());
	    }

	    btnMenos.setText("Borrar");
	    label = "Borrar";
	    isPushed = true;
	    if (fila != table.getRowCount() - 1) {
		return btnMenos;

	    } else {
		return new JLabel();
	    }
	}

	public Object getCellEditorValue() {
	    if (isPushed) {
		ut.borrarProd(getRow());
	    }
	    isPushed = false;
	    return new String(label);
	}

	public boolean stopCellEditing() {
	    isPushed = false;
	    return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
	    super.fireEditingStopped();
	}
    }

    public int getRow() {
	return fila;
    }

}
