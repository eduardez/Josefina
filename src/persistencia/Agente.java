package persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import dominio.Producto;
import dominio.Usuario;
import dominio.util;

public class Agente {
    private util ut = new util();

    public Agente() {
    }

    public Producto[] leerProducto() {
	Producto[] prod;
	try {
	    System.out.println("Leyendo productos...");

	    File f = new File("productos.txt");
	    Scanner datos = new Scanner(f);
	    datos.useDelimiter(",");
	    ArrayList<Producto> arrProd = new ArrayList<Producto>();
	    String linea = "";

	    while (datos.hasNext()) {
		// Lectura por lineas
		linea = datos.nextLine();
		StringTokenizer token = new StringTokenizer(linea, "-");

		String cat = token.nextToken();
		String tipo = token.nextToken();
		String nombre = token.nextToken();
		String descr = token.nextToken();
		String prec = token.nextToken();
		String alerg = token.nextToken();
		arrProd.add(new Producto(cat, tipo, nombre, descr, prec, alerg));
	    }
	    datos.close();// Cerrar el fichero Auxiliar

	    prod = arrProd.toArray(new Producto[arrProd.size()]);

	} catch (Exception e) {
	    String respuesta = JOptionPane.showInputDialog("Base de datos no encontrada o da�ada.\n�Crear una nueva?",
		    "Si/no");
	    if (respuesta.equalsIgnoreCase("si")) {
		try {
		    File f = new File("productos.txt");
		    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		} catch (IOException e1) {
		}
	    } else {
		System.exit(0);
	    }
	    System.out.println("Error en la lectura.");
	    e.printStackTrace();
	    prod = null;
	}

	return prod;
    }

    public void escribirProds(Producto[] prod) {
	BufferedWriter out;
	try {
	    out = new BufferedWriter(new FileWriter("productos.txt"));

	    for (int i = 0; i < prod.length; i++) {
		out.write(prod[i].getCategoria() + "-");
		out.write(prod[i].getTipo() + "-");
		out.write(prod[i].getNombre() + "-");
		out.write(prod[i].getDescripcion() + "-");
		out.write(prod[i].getPrecio() + "-");
		out.write(prod[i].getAlergenos());
		out.newLine();
	    }
	    out.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 
     * 
     * --------------------------- USUARIOS -------------------------------------
     * 
     * 
     * @return
     */
    public Usuario[] leerUsuarios() {
	Usuario[] users;
	try {
	    System.out.println("Leyendo Usuarios...");

	    File f = new File("usuarios.txt");
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
	    users = arrUsers.toArray(new Usuario[arrUsers.size()]);

	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Base de datos no encontrada o da�ada.");
	    System.out.println("Error en la lectura.");
	    e.printStackTrace();
	    users = null;
	}
	return users;

    }

    public void EliminarUsuario(Usuario usuario) {
	Usuario[] users = leerUsuarios();
	Usuario[] newUser = new Usuario[users.length - 1];
	int j = 0;
	for (int i = 0; i < users.length; i++) {
	    if (!usuario.getUser().equalsIgnoreCase(users[i].getUser())) {
		newUser[j] = users[i];
		j++;
	    }
	}
	users = newUser;
	escribirUsuarios(users);
    }

    public void escribirUsuarios(Usuario[] usu) {
	BufferedWriter out;
	try {
	    out = new BufferedWriter(new FileWriter("usuarios.txt"));

	    for (int i = 0; i < usu.length; i++) {
		out.write(usu[i].getUser() + ",");
		out.write(usu[i].getPass() + ",");
		out.write(usu[i].getNombre() + ",");
		out.write(usu[i].getUltAcc());
		out.newLine();
	    }
	    out.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
