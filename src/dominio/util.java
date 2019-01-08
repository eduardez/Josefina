package dominio;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Locale.Category;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import persistencia.Agente;
import presentacion.*;

public class util {
    private String[] dias = { "Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab" };
    private JTable tabla;
    private panelUser pnlUser;
    private Cliente client;
    private String tipoPed;
    private Agente ag = new Agente();
    private String[] estados = { "En preparacion", "completado", "entregado" };
    private JTextArea debugArea;

    public util() {
    }

    public void setDebugArea(JTextArea db) {
	this.debugArea = db;
    }

    public void printText(String cadena) {
	if (this.debugArea != null) {
	    this.debugArea.append("\n" + cadena);
	}
    }

    /**
     * Genera un String con la fecha actual, incluyendo hora, minuto y segundo.
     * Ej:
     * Mar 2 - 11 - 2019 | 13:54:45
     * 
     * @return String fecha
     */
    public String genFecha() {
	String fechaS;
	Calendar calendar = new GregorianCalendar();// Objeto calendario
	String minuto;
	if (calendar.get(Calendar.MINUTE) < 10) {
	    minuto = "0" + (calendar.get(Calendar.MINUTE));
	} else {
	    minuto = String.valueOf((calendar.get(Calendar.MINUTE)));
	}
	fechaS = dias[calendar.get(Calendar.DAY_OF_WEEK) - 1] + " " + (calendar.get(Calendar.DAY_OF_MONTH)) + " - "
		+ (calendar.get(Calendar.MONTH) + 1) + " - " + (calendar.get(Calendar.YEAR)) + " | "
		+ (calendar.get(Calendar.HOUR_OF_DAY)) + ":" + minuto + ":" + (calendar.get(Calendar.SECOND));
	return fechaS;
    }

    /**
     * Devuelve un array de Producto cuya categoria coincida con el valor del parametro {@code categoria}
     * 
     * @param categoria
     * @param prods
     * @return Producto [] prods
     */
    public Producto[] categorizarProds(String categoria, Producto[] prods) {
	ArrayList<Producto> prodList = new ArrayList<Producto>();

	for (int i = 0; i < prods.length; i++) {
	    if (prods[i].getCategoria().equalsIgnoreCase(categoria))
		prodList.add(prods[i]);
	}

	Producto[] productos = prodList.toArray(new Producto[prodList.size()]);
	return productos;
    }

    public String[] contarTipos(Producto[] productos) {
	ArrayList<String> tip = new ArrayList<String>(); // Contar numero de tipos de producto que hay
	for (int i = 0; i < productos.length && productos.length > 0; i++) {
	    if (!tip.contains(productos[i].getTipo()))
		tip.add(productos[i].getTipo());
	}
	String[] arrTipos = tip.toArray(new String[tip.size()]);
	return arrTipos;
    }

    /**
     * Metodo utilizado para generar los checkbox de alergenos de la clase {@linkplain addProducto}
     * 
     * @return
     */
    public JCheckBox[] anadirAlerg() {
	int maxI = 3, maxJ = 4, alerg = 0;
	String[] alergenos = { "Crustaceos", "Gluten", "Huevos", "Pescado", "Cacahuetes", "Soja", "Lacteos",
		"Frutos de Cascara", "Apio", "Mostaza", "Sulfitos", "Vegano" };
	JCheckBox[] chckbx = new JCheckBox[alergenos.length];
	try {
	    for (int i = 0; i < maxI; i++) {
		for (int j = 0; j < maxJ; j++) {
		    chckbx[alerg] = new JCheckBox(alergenos[alerg]);
		    chckbx[alerg].addMouseListener(new ChckbxMouseListener(chckbx[alerg]));
		    chckbx[alerg].setIcon(new ImageIcon(
			    addUser.class.getResource("/recursos/alergenos/" + alergenos[alerg] + ".png")));
		    chckbx[alerg].setEnabled(false);
		    alerg++;
		}
	    }
	} catch (Exception e) {

	}
	return chckbx;
    }

    public JTable getTabla() {
	return this.tabla;
    }

    private class ChckbxMouseListener extends MouseAdapter {
	JCheckBox chckbx;

	public ChckbxMouseListener(JCheckBox chckbx) {
	    this.chckbx = chckbx;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	    if (!chckbx.isEnabled()) {
		chckbx.setEnabled(true);
	    } else {
		chckbx.setEnabled(false);
	    }

	}
    }

    /**
     * 
     * 
     * 
     * --------------- METODOS PARA ACTUALIZAR LA TABLA ---------------------
     * 
     * 
     * 
     * @param tablaPedidos
     */

    public void setTabla(JTable tablaPedidos) {
	this.tabla = tablaPedidos;
    }

    public void setPnlUser(panelUser panel) {
	this.pnlUser = panel;
    }

    public void anadirAtabla(Producto pro) {
	addProdTabla(pro);
	this.pnlUser.setNumProd(this.pnlUser.getNumProd() + 1);
	this.pnlUser.setPrecioTot(this.pnlUser.getPrecioTot() + sinEuro(pro.getPrecio()));

	reajustarTabla();
    }

    /**
     * 
     * Cada vez que se añade un producto, ver si se ha añadido
     * antes, y si ese es el caso, aumentar su cantidad
     * 
     * @param prod
     * @return
     */
    private void addProdTabla(Producto prod) {
	DefaultTableModel model = (DefaultTableModel) tabla.getModel();
	boolean esta = false;
	double total;
	if (model.getRowCount() > 0) {
	    total = sinEuro(tabla.getValueAt(model.getRowCount() - 1, 2).toString());
	} else {
	    total = 0.0;
	}
	total += sinEuro(prod.getPrecio());

	for (int fila = 0; fila < model.getRowCount() - 1 && !esta; fila++) {
	    if (tabla.getValueAt(fila, 0).toString().equals(prod.getNombre())) {
		int cantidad = Integer.parseInt(tabla.getValueAt(fila, 2).toString());
		tabla.setValueAt((cantidad + 1), fila, 2);
		tabla.setValueAt(String.format("%.2f", total) + "€", model.getRowCount() - 1, 2);
		esta = true;
	    }
	}

	if (!esta && (tabla.getRowCount() != 0)) {
	    model.removeRow(model.getRowCount() - 1);
	    model.addRow(new Object[] { prod.getNombre(), prod.getPrecio(), "1" });
	    model.addRow(new Object[] { "", "Total: ", String.format("%.2f", total) + "€", null });// añadir y actualizar precio total
	}

	if (tabla.getRowCount() == 0) {
	    model.addRow(new Object[] { prod.getNombre(), prod.getPrecio(), "1" });
	    model.addRow(new Object[] { "", "Total: ", String.format("%.2f", total) + "€", null });// añadir y actualizar precio total
	}
	printText(prod.getNombre() + " añadido al pedido");

    }

    public void borrarProd(int row) {
	DefaultTableModel model = (DefaultTableModel) tabla.getModel();
	Double nuevoTotal = sinEuro(tabla.getValueAt(model.getRowCount() - 1, 2).toString())
		- sinEuro(tabla.getValueAt(row, 1).toString());// Calcular nuevo precio

	if (Integer.valueOf(tabla.getValueAt(row, 2).toString()) == 1) {
	    model.removeRow(row);
	} else {
	    tabla.setValueAt((Integer.valueOf(tabla.getValueAt(row, 2).toString()) - 1), row, 2);
	}

	this.pnlUser.setNumProd(this.pnlUser.getNumProd() - 1);

	if (this.pnlUser.getNumProd() == 0) {
	    this.pnlUser.setPrecioTot(0);
	    tabla.setValueAt(String.format("%.2f", 0.00) + "€", model.getRowCount() - 1, 2);
	} else {
	    this.pnlUser.setPrecioTot(nuevoTotal);
	    tabla.setValueAt(String.format("%.2f", nuevoTotal) + "€", model.getRowCount() - 1, 2);
	}
	  printText("Borrada una unidad del producto");
	reajustarTabla();
    }

    /**
     * Se introduce un String y se devuelve un Double con el valor de dicho String pero sin el caracter '€'
     * 
     * @param num
     * @return
     */

    private double sinEuro(String num) {

	char[] precio = num.toCharArray();
	char[] preNuevo = new char[precio.length - 1];
	for (int j = 0; j < preNuevo.length; j++) {
	    if (precio[j] == ',') {// Como en algunos locales se usa la coma para separar decimales, si el numero tiene coma la sustituye por un punto
		preNuevo[j] = '.';
	    } else {
		preNuevo[j] = precio[j];
	    }
	}

	double tot = Double.parseDouble(String.valueOf(preNuevo));
	return tot;
    }

    /**
     * Como hemos cambiado el tamaño de la fuente de la tabla para que se vea mejor, cada vez que se añada
     * una nueva fila a la tabla tendremos que redimensionarla para que se vea bien el texto de cada celda.
     * 
     */
    private void reajustarTabla() {
	for (int fila = 0; fila < tabla.getRowCount(); fila++) {
	    int tamFila = tabla.getRowHeight();

	    for (int columna = 0; columna < tabla.getColumnCount(); columna++) {
		Component comp = tabla.prepareRenderer(tabla.getCellRenderer(fila, columna), fila, columna);
		tamFila = Math.max(tamFila, comp.getPreferredSize().height);
		switch (columna) {
		case 0:
		    tabla.getColumnModel().getColumn(0).setMinWidth(300);
		    break;
		}
	    }
	    tabla.setRowHeight(fila, tamFila);
	}
    }

    public void limpiarTabla() {
	if (tabla.getRowCount() > 0) {
	    ((DefaultTableModel) tabla.getModel()).setNumRows(1);
	    this.pnlUser.setNumProd(0);
	    this.pnlUser.setPrecioTot(0);
	    tabla.setValueAt(String.format("%.2f", 0.00) + "€", 0, 2);
	    tabla.setValueAt("Total: ", 0, 1);
	    tabla.setValueAt("", 0, 0);
	    printText("Lista de productos limpiada");
	}
    }

    /**
     * Metodos para guardar el pedido
     * 
     */
    public void elegCliente() {
	elegirCliente eleg = new elegirCliente(this);
	eleg.setVisible(true);
	printText("Pedido realizado por el cliente '" + this.client.getNombre() + "'");

    }

    public void guardarPedido() {
	if (pnlUser.getPrecioTot() > 0) {
	    String client = this.client.getNombre();
	    String allProductos = genProds();
	    double total = pnlUser.getPrecioTot();
	    String tipo = this.tipoPed;
	    Pedido ped = new Pedido(client, allProductos, total, tipo);
	    Agente ag = new Agente();
	    ag.escribirPedido(ped);
	    limpiarTabla();
	    printText("Guardado pedido numero: " + ped.getnPedido());
	}

    }

    /**
     * Genera un string con todos los productos elegidos y su cantidad
     * 
     * @return
     */
    private String genProds() {
	String pro = "";
	int filas = tabla.getRowCount() - 1;
	for (int i = 0; i < filas; i++) {
	    pro += tabla.getValueAt(i, 0) + "x" + tabla.getValueAt(i, 2) + "-";
	}
	return pro;
    }

    public void setTipoPedido(String tipo) {
	this.tipoPed = tipo;

    }

    public void setCliente(Cliente cliente) {
	this.client = cliente;
    }

    /**
     * 
     * Metodos para mostrar todos los pedidos en las tablas de la pestaña de gestion de pedidos
     * 
     */

    public JTable generarTabla(String tipo) {

	JTable tabla = crearModelo(tipo);
	((DefaultTableModel) tabla.getModel()).removeRow(0);
	ponerPedidos(tabla, leerPedTipo(tipo));

	return tabla;
    }

    private void ponerPedidos(JTable tab, Pedido[] pedis) {
	Cliente[] cli = ag.leerCliente();
	boolean caliente, pagado;
	ponerColEstado(tab, tab.getColumnModel().getColumn(9));// Generar la columna de JComboBox de estados
	for (int i = 0; i < cli.length; i++) {
	    for (int j = 0; j < pedis.length; j++) {

		if (pedis[j].getnClient().equals(cli[i].getNombre())) {

		    int hora = (int) ((Math.random() * 24));
		    int aleat = (int) ((Math.random() * 50) + 1);
		    if (aleat > 25) {
			caliente = false;
			pagado = false;

		    } else {
			caliente = true;
			pagado = true;
		    }
		    String horaAleat = hora + ":" + aleat + " - " + hora + ":" + (aleat + 10);
		    ((DefaultTableModel) tab.getModel())
			    .addRow(new Object[] { pedis[j].getnPedido(), cli[i].getDireccion(), cli[i].getNombre(),
				    pedis[j].getProductos(), String.format("%.2f", pedis[j].getTotal()) + "€",
				    horaAleat, caliente, cli[i].isVip(), pagado, pedis[j].getEstado() });
		}
	    }
	}
	ponerColEstado(tab, tab.getColumnModel().getColumn(9));// Generar la columna de JComboBox de estados
	printText("Añadiendo tablas de pedidos...");
    }

    private void ponerColEstado(JTable table, TableColumn col) {
	// Editor
	JComboBox comboBox = new JComboBox(estados);
	col.setCellEditor(new DefaultCellEditor(comboBox));

	// tooltip
	DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	renderer.setToolTipText("Seleccionar estado del pedido");
	col.setCellRenderer(renderer);

	// seleccionar estado

    }

    private JTable crearModelo(String tipo) {
	JTable modelo = new JTable();
	modelo.setModel(new DefaultTableModel(
		new Object[][] { { null, null, null, null, null, null, null, null, null, null }, },
		new String[] { "NºPedido", "Direccion", "Cliente", "Pedido", "Total", "Hora de Entrega", "Caliente",
			"VIP", "Pagado", "Estado" }) {
	    Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
		    String.class, Boolean.class, Boolean.class, Boolean.class, Component.class };

	    public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	    }
	});

	modelo.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	modelo.setFont(new Font("SansSerif", Font.PLAIN, 15));
	modelo.setSurrendersFocusOnKeystroke(false);
	modelo.setShowVerticalLines(true);
	modelo.setShowHorizontalLines(true);
	modelo.setRowSelectionAllowed(true);
	modelo.setEnabled(true);
	modelo.setFillsViewportHeight(false);
	modelo.setColumnSelectionAllowed(false);
	modelo.setCellSelectionEnabled(false);
	modelo.setRowHeight(28);

	return modelo;
    }

    private Pedido[] leerPedTipo(String tipoPed) {
	Pedido[] peds = ag.leerPedidos();
	ArrayList<Pedido> arrPeds = new ArrayList<Pedido>();
	for (int i = 0; i < peds.length; i++) {
	    if (peds[i].getTipo().equalsIgnoreCase(tipoPed)) {
		arrPeds.add(peds[i]);
	    }
	}
	return arrPeds.toArray(new Pedido[arrPeds.size()]);
    }

}
