package dominio;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import presentacion.addUser;

public class util {
    private String[] dias = { "Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab" };

    public util() {
    }

    public String genFecha() {
	String fechaS;
	Calendar calendar = new GregorianCalendar();// Objeto calendario
	String minuto;
	if (calendar.get(Calendar.MINUTE) < 10) {
	    minuto = "0" + (calendar.get(Calendar.MINUTE));
	} else {
	    minuto = String.valueOf((calendar.get(Calendar.MINUTE)));
	}
	System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
	fechaS = dias[calendar.get(Calendar.DAY_OF_WEEK) - 1] + " " + (calendar.get(Calendar.DAY_OF_MONTH)) + " - "
		+ (calendar.get(Calendar.MONTH) + 1) + " - " + (calendar.get(Calendar.YEAR)) + " | "
		+ (calendar.get(Calendar.HOUR_OF_DAY)) + ":" + minuto + ":" + (calendar.get(Calendar.SECOND));
	return fechaS;
    }

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
	for (int i = 0; i < productos.length; i++) {
	    if (!tip.contains(productos[i].getTipo()))
		tip.add(productos[i].getTipo());
	}
	String[] arrTipos = tip.toArray(new String[tip.size()]);
	return arrTipos;
    }

    public boolean stringValida(String cadena) {
	boolean valido = true;
	char[] cadenaChar = cadena.toCharArray();
	for (int i = 0; i < cadenaChar.length && valido; i++) {
	    if (cadenaChar[i] == '-') {
		valido = false;
	    }
	}
	return valido;
    }

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
}
