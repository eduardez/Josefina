package dominio;

import java.awt.Component;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import presentacion.*;

public class util {
    private String[] dias = { "Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab" };
    private JTable tabla;
    private panelUser pnlUser;

    public util() {
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
	    tabla.setValueAt(0, model.getRowCount() - 1, 2);
	} else {
	    this.pnlUser.setPrecioTot(nuevoTotal);
	    tabla.setValueAt(nuevoTotal, model.getRowCount() - 1, 2);
	}
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
    /**
     * 
     * 
     */
    public void guardarPedido() {
	elegirCliente eleg=new elegirCliente();
	eleg.setVisible(true);
	
    }

}
