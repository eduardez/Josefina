package dominio;

import java.util.Calendar;
import java.util.GregorianCalendar;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class util {
    private String[] dias = { "Sab", "Dom" , "Lun", "Mar", "Mie", "Jue", "Vie"};

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
	fechaS = dias[calendar.get(calendar.DAY_OF_WEEK)] + " " + (calendar.get(calendar.DAY_OF_MONTH)) + " - "
		+ (calendar.get(Calendar.MONTH) + 1) + " - " + (calendar.get(Calendar.YEAR)) + " | "
		+ (calendar.get(Calendar.HOUR_OF_DAY)) + ":" + minuto + ":" + (calendar.get(Calendar.SECOND));
	return fechaS;
    }
}
