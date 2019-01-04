package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dominio.Producto;
import dominio.util;
import persistencia.Agente;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JCheckBox;

public class addProducto extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombre;
    private JComboBox<String> cmbTipo;
    private JComboBox<String> cmbCat;
    private final String[] categorias = { "menu", "platInd", "bebida", "postre", "oferta" };
    private JTextArea txtrDesc;
    private JSpinner spPrecio;
    private Agente ag = new Agente();
    private util ut = new util();
    private String tipoComida = "";
    private JCheckBox[] alerg = ut.anadirAlerg();
    private JPanel pnlAlerg;
    private JButton btnBorrar;
    private JButton okButton;
    private Producto producAct;

    public addProducto() {
	inicializar();
    }

    public addProducto(Producto p) {
	inicializar();
	producAct = p;
	editarProd(producAct);
    }

    private void editarProd(Producto p) {
	txtNombre.setText(p.getNombre());
	txtrDesc.setText(p.getDescripcion());
	String precio = p.getPrecio();
	spPrecio.setValue(Double.valueOf(precio.substring(0, precio.length() - 1)));

	for (int i = 0; i < categorias.length; i++) {
	    if (categorias[i].equalsIgnoreCase(p.getCategoria())) {
		cmbCat.setSelectedIndex(i);
		break;
	    }
	}
	
	for (int i = 0; i < cmbTipo.getItemCount(); i++) {
	    if (cmbTipo.getItemAt(i).toString().equalsIgnoreCase(p.getTipo())) {
		cmbTipo.setSelectedIndex(i);
		break;
	    }
	}

	StringTokenizer token = new StringTokenizer(p.getAlergenos(), ",");
	while (token.hasMoreTokens()) {
	    String al = token.nextToken();
	    for (int j = 0; j < alerg.length; j++) {
		if (alerg[j].getText().equals(al))
		    alerg[j].setEnabled(true);
	    }
	}
	okButton.setText("Modificar");
	btnBorrar.setVisible(true);
    }

    private void inicializar() {
	setModal(true);
	setTitle("Restaurante la Josefina - A\u00F1adir Producto");
	setIconImage(Toolkit.getDefaultToolkit().getImage(addProducto.class.getResource("/recursos/logo.png")));
	setResizable(false);
	setBounds(100, 100, 551, 703);
	setLocationRelativeTo(null);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBackground(new Color(255, 255, 255));
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	GridBagLayout gbl_contentPanel = new GridBagLayout();
	gbl_contentPanel.columnWidths = new int[] { 0, 123, 80, 97, 0, 0 };
	gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 154, 248, 0, 0, 0 };
	gbl_contentPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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
	    panel.setOpaque(false);
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
		txtrDesc.setLineWrap(true);
		panel.add(txtrDesc, BorderLayout.CENTER);
	    }
	}
	{
	    pnlAlerg = new JPanel();
	    pnlAlerg.setOpaque(false);
	    pnlAlerg.setBorder(
		    new TitledBorder(null, "Al\u00E9rgenos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    GridBagConstraints gbc_pnlAlerg = new GridBagConstraints();
	    gbc_pnlAlerg.insets = new Insets(0, 0, 5, 0);
	    gbc_pnlAlerg.gridwidth = 5;
	    gbc_pnlAlerg.fill = GridBagConstraints.BOTH;
	    gbc_pnlAlerg.gridx = 0;
	    gbc_pnlAlerg.gridy = 5;
	    contentPanel.add(pnlAlerg, gbc_pnlAlerg);
	    pnlAlerg.setLayout(new GridLayout(3, 4, 0, 0));

	    for (int i = 0; i < alerg.length; i++)
		pnlAlerg.add(alerg[i]);
	    // Se añaden todos los alergenos al panel

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
	    spPrecio.setModel(new SpinnerNumberModel(new Double(5), new Double(0), null, new Double(0.1)));
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
	    btnBorrar = new JButton("Borrar producto");
	    btnBorrar.addActionListener(new BtnBorrarActionListener());
	    btnBorrar.setVisible(false);
	    btnBorrar.setFont(new Font("SansSerif", Font.PLAIN, 22));
	    GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
	    gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
	    gbc_btnBorrar.gridx = 3;
	    gbc_btnBorrar.gridy = 6;
	    contentPanel.add(btnBorrar, gbc_btnBorrar);
	}
	{
	    JPanel buttonPane = new JPanel();
	    buttonPane.setBackground(new Color(38, 38, 38));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
		okButton = new JButton("A\u00F1adir");
		okButton.addActionListener(new OkButtonActionListener());
		okButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	    }
	    {
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new CancelButtonActionListener());
		cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	    }
	    actualizarTipos(false, null);
	}
    }

    private class OkButtonActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {

	    // Ver que alergenos han sido seleccionados
	    String alergenos = "";
	    for (int i = 0; i < alerg.length; i++)
		if (alerg[i].isEnabled())
		    alergenos = alerg[i].getText() + "," + alergenos;

	    if (alergenos.equalsIgnoreCase(""))
		alergenos = "Ninguno";

	    // Poner bien el precio
	    DecimalFormat dc = new DecimalFormat("0.00");//Para evitar el error de que muestre demasiados decimales
	    String precioS = String.valueOf(dc.format(spPrecio.getValue())) + "€";

	    // Crear Nuevo producto y añadirlo al array de Productos
	    Producto newProd = new Producto(categorias[cmbCat.getSelectedIndex()], tipoComida, txtNombre.getText(),
		    txtrDesc.getText(), precioS, alergenos);

	    // Si todo esta bien, se añade. Si no, se muestra un popUp de error
	    if (ut.stringValida(newProd.toString()) && !cmbTipo.getSelectedItem().toString().equalsIgnoreCase("")
		    && !txtNombre.getText().equals("") && !txtrDesc.getText().equals("")) {
		if (btnBorrar.isVisible()) {
		    ag.elimProds(producAct);
		    ag.escribirProds(newProd);
		} else {
		    ag.escribirProds(newProd);
		}
		dispose();
	    } else {
		JOptionPane.showMessageDialog(null, "Error en la entrada. \nNota: No usar guiones ( - )");
	    }
	}
    }

    private class CancelButtonActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	    dispose();
	}
    }

    private class CmbCatItemListener implements ItemListener {
	@Override
	public void itemStateChanged(ItemEvent arg0) {
	    actualizarTipos(false, null);
	}
    }

    private void actualizarTipos(boolean flagNuevo, String nuevo) {
	String[] tipoSelec = ut
		.contarTipos(ut.categorizarProds(categorias[cmbCat.getSelectedIndex()], ag.leerProducto()));
	ArrayList<String> arrTipo = new ArrayList<String>();
	arrTipo.add("Seleccionar tipo...");

	for (int i = 0; i < tipoSelec.length; i++)
	    arrTipo.add(tipoSelec[i]);
	if (flagNuevo) {
	    arrTipo.add(nuevo);
	}
	arrTipo.add("+ Nuevo tipo");
	cmbTipo.setModel(new DefaultComboBoxModel<String>(arrTipo.toArray(new String[arrTipo.size()])));

    }

    private class CmbTipoActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    if (cmbTipo.getSelectedItem().toString().equalsIgnoreCase("+ Nuevo tipo")) {

		tipoComida = JOptionPane.showInputDialog("Introducir tipo nuevo");
		if (ut.stringValida(tipoComida)) {
		    actualizarTipos(true, tipoComida);
		} else {
		    JOptionPane.showMessageDialog(null, "Error en la entrada. \nNota: No usar guiones ( - )");
		    dispose();
		}

	    } else {
		tipoComida = cmbTipo.getSelectedItem().toString();
	    }
	}
    }

    private class BtnBorrarActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    ag.elimProds(producAct);
	    dispose();
	}
    }
}
