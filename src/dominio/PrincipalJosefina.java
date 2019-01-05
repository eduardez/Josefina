package dominio;

import javax.swing.UIManager;

import presentacion.splashJosefi;

public class PrincipalJosefina {

    public static void main(String[] args) {
	System.out.println("Inicio del restaurante...");

	// Cargar datos
	// ---------- CAMBIAR LOOK AND FEEL ----------
	try {
	    // Set cross-platform Java L&F (also called "Metal")
	    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");// O este otro javax.swing.plaf.metal.MetalLookAndFeel
	} catch (Exception e) {
	    System.out.println("ERROR en L&F");
	}
	splashJosefi spl = new splashJosefi();
	spl.setVisible(true);
    }
}
