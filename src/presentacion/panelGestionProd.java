package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import dominio.Usuario;

public class panelGestionProd extends JPanel {
    private JPanel panel;
    private JButton btnAddProd;
    private JComboBox cmbOrdenar;

    /**
     * Create the panel.
     */
    public panelGestionProd(String tipoProd, Usuario user) {
	setBorder(null);
	setBackground(new Color(38, 38, 38));
	setMinimumSize(new Dimension(10, 86));
	setLayout(new BorderLayout(0, 0));
	{
	    panel = new JPanel();
	    panel.setBorder(null);
	    panel.setOpaque(false);
	    add(panel, BorderLayout.CENTER);
	    GridBagLayout gbl_panel = new GridBagLayout();
	    gbl_panel.columnWidths = new int[] { 38, 122, 0, 133, 147, 35, 0 };
	    gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
	    gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	    gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
	    panel.setLayout(gbl_panel);
	    {
		// btnNewButton = new JButton(getTipoProd(tipoProd));A�adir Producto
		btnAddProd = new JButton("A�adir Producto");
		btnAddProd.setForeground(Color.BLACK);
		btnAddProd.setBackground(Color.white);
		btnAddProd.setOpaque(false);
		btnAddProd.addActionListener(new BtnNewButtonActionListener());
		btnAddProd.setIcon(new ImageIcon(panelGestionProd.class.getResource("/recursos/anadirProd.png")));
		btnAddProd.setFont(new Font("SansSerif", Font.BOLD, 24));
		GridBagConstraints gbc_btnAddProd = new GridBagConstraints();
		gbc_btnAddProd.gridheight = 3;
		gbc_btnAddProd.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddProd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddProd.gridx = 1;
		gbc_btnAddProd.gridy = 0;
		panel.add(btnAddProd, gbc_btnAddProd);
	    }
	    {
		cmbOrdenar = new JComboBox();
		cmbOrdenar.setForeground(new Color(0, 180, 188));
		cmbOrdenar.setBackground(Color.WHITE);
		cmbOrdenar.setOpaque(false);
		cmbOrdenar.setFont(new Font("SansSerif", Font.PLAIN, 22));
		cmbOrdenar.setModel(new DefaultComboBoxModel(
			new String[] { "Ordenar productos...", "Precio ascendente", "Precio descendente" }));
		GridBagConstraints gbc_cmbOrdenar = new GridBagConstraints();
		gbc_cmbOrdenar.gridwidth = 2;
		gbc_cmbOrdenar.insets = new Insets(0, 0, 5, 5);
		gbc_cmbOrdenar.fill = GridBagConstraints.BOTH;
		gbc_cmbOrdenar.gridx = 3;
		gbc_cmbOrdenar.gridy = 1;
		panel.add(cmbOrdenar, gbc_cmbOrdenar);
	    }
	}

	if (!user.getUser().equalsIgnoreCase("admin")) {
	    btnAddProd.setEnabled(false);
	    btnAddProd.setToolTipText("Hay que ser administrador para poder a�adir productos.");
	}

    }

    /*
     * private String getTipoProd(String tipoProd) {
     * String pr = null;
     * switch (tipoProd) {
     * case "platInd":
     * pr = "A�adir Plato Individual";
     * break;
     * case "bebida":
     * pr = "A�adir Bebida";
     * break;
     * case "menu":
     * pr = "A�adir Men�";
     * break;
     * case "postre":
     * pr = "A�adir Postre";
     * break;
     * case "oferta":
     * pr = "A�adir Oferta";
     * break;
     * default:
     * pr = "A�adir Producto";
     * break;
     * }
     * 
     * return pr;
     * }
     */

    private class BtnNewButtonActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	    addProducto addPr = new addProducto();
	    addPr.setVisible(true);
	    addPr.setLocationRelativeTo(null);
	}
    }
}
