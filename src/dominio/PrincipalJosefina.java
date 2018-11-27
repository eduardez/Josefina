package dominio;

import presentacion.UI_Login;

public class PrincipalJosefina {

    public static void main(String [] args) {
	System.out.println("Inicio del restaurante...");
	
	//Cargar datos
	
	UI_Login log= new UI_Login();
	log.setVisible(true);
	log.setLocationRelativeTo(null);
	
    }
}
