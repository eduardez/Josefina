package dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class util {
    private String[] dias = {"Lun", "Mar", "Mie", "Jue", "Vie","Sab","Dom" };

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
	fechaS = dias[calendar.get(Calendar.DAY_OF_WEEK)-2] + " " + (calendar.get(Calendar.DAY_OF_MONTH)) + " - "
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

}
