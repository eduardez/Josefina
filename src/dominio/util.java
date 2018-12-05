package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

}
