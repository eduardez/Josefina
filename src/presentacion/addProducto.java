package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import dominio.Producto;
import dominio.Usuario;
import dominio.util;
import persistencia.Agente;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class addProducto extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombre;
    private JComboBox<String> cmbTipo;
    private JComboBox<String> cmbCat;
    private String[] categorias = { "menu", "platInd", "bebida", "postre", "oferta" };
    private JTextArea txtrDesc;
    private JSpinner spPrecio;
    private Agente ag = new Agente();
    private util ut = new util();
    private String tipoComida="";

    public addProducto() {
	setTitle("Restaurante la Josefina - A\u00F1adir Producto");
	setIconImage(Toolkit.getDefaultToolkit().getImage(addProducto.class.getResource("/recursos/logo.png")));
	setResizable(false);
	setBounds(100, 100, 552, 636);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	GridBagLayout gbl_contentPanel = new GridBagLayout();
	gbl_contentPanel.columnWidths = new int[] { 0, 0, 133, 97, 0, 0 };
	gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 204, 197, 0, 0, 0 };
	gbl_contentPanel.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
	gbl_contentPanel.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	contentPanel.setLayout(gbl_contentPanel);
	{
	    JLabel lblCategoria = new JLabel("Categoria:");
	    lblCategoria.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
	    gbc_lblCategoria.anchor = GridBagConstraints.EAST;
	    gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
	    gbc_lblCategoria.gridx = 0;
	    gbc_lblCategoria.gridy = 1;
	    contentPanel.add(lblCategoria, gbc_lblCategoria);
	}
	{
	    cmbCat = new JComboBox();
	    cmbCat.addItemListener(new CmbCatItemListener());
	    cmbCat.setModel(new DefaultComboBoxModel<String>(
		    new String[] { "Menú", "Plato Individual", "Bebida", "Postre", "Oferta" }));
	    cmbCat.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_cmbCat = new GridBagConstraints();
	    gbc_cmbCat.gridwidth = 2;
	    gbc_cmbCat.insets = new Insets(0, 0, 5, 5);
	    gbc_cmbCat.fill = GridBagConstraints.HORIZONTAL;
	    gbc_cmbCat.gridx = 1;
	    gbc_cmbCat.gridy = 1;
	    contentPanel.add(cmbCat, gbc_cmbCat);
	}
	{
	    JLabel lblTipo = new JLabel("Tipo:");
	    lblTipo.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_lblTipo = new GridBagConstraints();
	    gbc_lblTipo.anchor = GridBagConstraints.EAST;
	    gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
	    gbc_lblTipo.gridx = 0;
	    gbc_lblTipo.gridy = 2;
	    contentPanel.add(lblTipo, gbc_lblTipo);
	}
	{
	    cmbTipo = new JComboBox();
	    cmbTipo.addItemListener(new CmbTipoItemListener());
	    cmbTipo.addActionListener(new CmbTipoActionListener());
	    cmbTipo.setToolTipText("(Poner el tipo en plural. Ej: Cervezas, Vinos, Carnes...)");
	    cmbTipo.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_cmbTipo = new GridBagConstraints();
	    gbc_cmbTipo.gridwidth = 2;
	    gbc_cmbTipo.insets = new Insets(0, 0, 5, 5);
	    gbc_cmbTipo.fill = GridBagConstraints.HORIZONTAL;
	    gbc_cmbTipo.gridx = 1;
	    gbc_cmbTipo.gridy = 2;
	    contentPanel.add(cmbTipo, gbc_cmbTipo);
	}
	{
	    JLabel lblNombre = new JLabel("Nombre:");
	    lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_lblNombre = new GridBagConstraints();
	    gbc_lblNombre.anchor = GridBagConstraints.EAST;
	    gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNombre.gridx = 0;
	    gbc_lblNombre.gridy = 3;
	    contentPanel.add(lblNombre, gbc_lblNombre);
	}
	{
	    txtNombre = new JTextField();
	    txtNombre.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_txtNombre = new GridBagConstraints();
	    gbc_txtNombre.gridwidth = 3;
	    gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
	    gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtNombre.gridx = 1;
	    gbc_txtNombre.gridy = 3;
	    contentPanel.add(txtNombre, gbc_txtNombre);
	    txtNombre.setColumns(10);
	}
	{
	    JPanel panel = new JPanel();
	    panel.setBorder(new TitledBorder(null, "Descripcion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    GridBagConstraints gbc_panel = new GridBagConstraints();
	    gbc_panel.gridwidth = 5;
	    gbc_panel.insets = new Insets(0, 0, 5, 0);
	    gbc_panel.fill = GridBagConstraints.BOTH;
	    gbc_panel.gridx = 0;
	    gbc_panel.gridy = 4;
	    contentPanel.add(panel, gbc_panel);
	    panel.setLayout(new BorderLayout(0, 0));
	    {
		txtrDesc = new JTextArea();
		panel.add(txtrDesc, BorderLayout.CENTER);
	    }
	}
	{
	    JPanel pnlAlerg = new JPanel();
	    pnlAlerg.setBorder(
		    new TitledBorder(null, "Al\u00E9rgenos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    GridBagConstraints gbc_pnlAlerg = new GridBagConstraints();
	    gbc_pnlAlerg.insets = new Insets(0, 0, 5, 0);
	    gbc_pnlAlerg.gridwidth = 5;
	    gbc_pnlAlerg.fill = GridBagConstraints.BOTH;
	    gbc_pnlAlerg.gridx = 0;
	    gbc_pnlAlerg.gridy = 5;
	    contentPanel.add(pnlAlerg, gbc_pnlAlerg);
	    pnlAlerg.setLayout(new GridLayout(1, 0, 0, 0));
	}
	{
	    JLabel lblPrecio = new JLabel("Precio:");
	    lblPrecio.setFont(new Font("SansSerif", Font.PLAIN, 21));
	    GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
	    gbc_lblPrecio.anchor = GridBagConstraints.EAST;
	    gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPrecio.gridx = 0;
	    gbc_lblPrecio.gridy = 6;
	    contentPanel.add(lblPrecio, gbc_lblPrecio);
	}
	{
	    spPrecio = new JSpinner();
	    spPrecio.setModel(new SpinnerNumberModel(new Integer(5), new Integer(0), null, new Integer(1)));
	    spPrecio.setFont(new Font("SansSerif", Font.PLAIN, 21));
	    GridBagConstraints gbc_spPrecio = new GridBagConstraints();
	    gbc_spPrecio.fill = GridBagConstraints.HORIZONTAL;
	    gbc_spPrecio.insets = new Insets(0, 0, 5, 5);
	    gbc_spPrecio.gridx = 1;
	    gbc_spPrecio.gridy = 6;
	    contentPanel.add(spPrecio, gbc_spPrecio);
	}
	{
	    JLabel lblLeuro = new JLabel("\u20AC");
	    lblLeuro.setFont(new Font("SansSerif", Font.PLAIN, 21));
	    GridBagConstraints gbc_lblLeuro = new GridBagConstraints();
	    gbc_lblLeuro.anchor = GridBagConstraints.WEST;
	    gbc_lblLeuro.insets = new Insets(0, 0, 5, 5);
	    gbc_lblLeuro.gridx = 2;
	    gbc_lblLeuro.gridy = 6;
	    contentPanel.add(lblLeuro, gbc_lblLeuro);
	}
	{
	    JPanel buttonPane = new JPanel();
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
		JButton okButton = new JButton("A\u00F1adir");
		okButton.addActionListener(new OkButtonActionListener());
		okButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	    }
	    {
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new CancelButtonActionListener());
		cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	    }
	}
    }

    private class OkButtonActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {

	    Producto[] oldPr = ag.leerProducto();
	    Producto[] newPr = new Producto[oldPr.length + 1];
	    for (int i = 0; i < oldPr.length; i++) {
		newPr[i] = oldPr[i];
	    }
	    int precio = (Integer) spPrecio.getValue();
	    String precioS = String.valueOf(precio) + "€";
	    Producto newProd = new Producto(categorias[cmbCat.getSelectedIndex()], tipoComida,
		    txtNombre.getText(), txtrDesc.getText(), precioS, "Ninguno");
	    newPr[newPr.length - 1] = newProd;
	    ag.escribirProds(newPr);
	    dispose();

	}
    }

    private class CancelButtonActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    dispose();
	}
    }

    private class CmbCatItemListener implements ItemListener {
	public void itemStateChanged(ItemEvent arg0) {
	    String[] tipoSelec = ut
		    .contarTipos(ut.categorizarProds(categorias[cmbCat.getSelectedIndex()], ag.leerProducto()));
	    ArrayList <String> arrTipo=new ArrayList<String>();
	    for(int i=0;i<tipoSelec.length;i++)arrTipo.add(tipoSelec[i]);
	    arrTipo.add("+ Nuevo tipo");
	    cmbTipo.setModel(new DefaultComboBoxModel<String>(arrTipo.toArray(new String[arrTipo.size()])));

	}
    }
  
    private class CmbTipoActionListener implements ActionListener {
    	public void actionPerformed(ActionEvent arg0) {
    	if(cmbTipo.getSelectedItem().toString().equalsIgnoreCase("+ Nuevo tipo")) {
		tipoComida = JOptionPane.showInputDialog("Introducir tipo nuevo");
	    }else {
		tipoComida=cmbTipo.getSelectedItem().toString();
	    }
    	}
    }
    private class CmbTipoItemListener implements ItemListener {
    	public void itemStateChanged(ItemEvent arg0) {
    	    repaint();
    	}
    }
}
