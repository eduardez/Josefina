package persistencia;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import dominio.Usuario;
import recursos.*;

public class Agente {
    private Usuario[] users;

    public Agente() {
	this.users = null;
	leerUsuarios();
    }

    public Usuario[] getUsers() {
	return users;
    }

    private void leerUsuarios() {
	try {
	    System.out.println("Leyendo Usuarios...");

	    File f = new File("src/recursos/usuarios.txt");
	    Scanner datos = new Scanner(f);
	    datos.useDelimiter(",");
	    ArrayList<Usuario> arrUsers = new ArrayList<Usuario>();
	    String linea = "";
	    
	    while (datos.hasNext()) {
		// Lectura por lineas
		linea = datos.nextLine();

		StringTokenizer token = new StringTokenizer(linea, ",");

		String user = token.nextToken();
		String pass = token.nextToken();
		String nom = token.nextToken();
		String ult = token.nextToken();
		arrUsers.add(new Usuario(user, pass, nom, ult));
	    }
	    datos.close();// Cerrar el fichero Auxiliar
	    this.users = arrUsers.toArray(new Usuario[arrUsers.size()]);

	} catch (Exception e) {
	    System.out.println("Error en la lectura.");
	    e.printStackTrace();
	}

    }

}
