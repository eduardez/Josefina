package presentacion;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelGestionProd extends JPanel {
    private JPanel panel;
    private JButton btnNewButton;
    private JComboBox comboBox;

    /**
     * Create the panel.
     */
    public panelGestionProd(String tipoProd) {
	setMinimumSize(new Dimension(10, 86));
	setLayout(new BorderLayout(0, 0));
	{
	    panel = new JPanel();
	    add(panel, BorderLayout.CENTER);
	    GridBagLayout gbl_panel = new GridBagLayout();
	    gbl_panel.columnWidths = new int[] { 0, 122, 0, 133, 147, 0, 0 };
	    gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
	    gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	    gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
	    panel.setLayout(gbl_panel);
	    {
		//btnNewButton = new JButton(getTipoProd(tipoProd));Añadir Producto
		btnNewButton = new JButton("Añadir Producto");
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setIcon(new ImageIcon(panelGestionProd.class.getResource("/recursos/anadirProd.png")));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 3;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
	    }
	    {
		comboBox = new JComboBox();
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ordenar productos..."}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
	    }
	}

    }

    /*
    private String getTipoProd(String tipoProd) {
	String pr = null;
	switch (tipoProd) {
	case "platInd":
	    pr = "Añadir Plato Individual";
	    break;
	case "bebida":
	    pr = "Añadir Bebida";
	    break;
	case "menu":
	    pr = "Añadir Menú";
	    break;
	case "postre":
	    pr = "Añadir Postre";
	    break;
	case "oferta":
	    pr = "Añadir Oferta";
	    break;
	default:
	    pr = "Añadir Producto";
	    break;
	}

	return pr;
    }*/

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		    addProducto addPr=new addProducto();
		    addPr.setVisible(true);
		    addPr.setLocationRelativeTo(null);
		    
		}
	}
}
