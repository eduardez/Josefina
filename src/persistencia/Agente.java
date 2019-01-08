package persistencia;

/**
 * 
 * A ver, se que lo de crear un ArrayList con los diferentes objetos y luego pasarlo a 
 * array normal es increiblemente estupido, por lo de poder usar 
 * streams y tal, pero pfffffftttt es un agente reutilizado de el año pasado
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import dominio.Cliente;
import dominio.Pedido;
import dominio.Producto;
import dominio.Usuario;
import dominio.util;

public class Agente {
    private final String url = "jdbc:ucanaccess://.//datos.accdb";

    public Agente() {
    }

    /**
     * 
     * 
     * --------------------------- PRODUCTOS -------------------------------------
     * 
     * 
     * @return
     */
    public Producto[] leerProducto() {
	Producto[] prod;

	try {
	    String sql = "SELECT * FROM productos ";
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();
	    ResultSet res = stm.executeQuery(sql);

	    ArrayList<Producto> arrProd = new ArrayList<Producto>();
	    while (res.next()) {

		String cat = res.getString("cat");
		String tipo = res.getString("tipo");
		String nombre = res.getString("nombre");
		String descr = res.getString("descr");
		String prec = res.getString("prec");
		String alerg = res.getString("alerg");
		arrProd.add(new Producto(cat, tipo, nombre, descr, prec, alerg));
	    }
	    conn.commit();
	    stm.close();
	    conn.close();
	    prod = arrProd.toArray(new Producto[arrProd.size()]);
	    return prod;
	} catch (Exception e) {
	    e.printStackTrace();
	    prod = null;
	}
	return prod;
    }

    public void escribirProds(Producto p) {
	try {
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();

	    String sql = "INSERT INTO productos VALUES(1,'" + p.getCategoria() + "','" + p.getTipo() + "','"
		    + p.getNombre() + "','" + p.getDescripcion() + "', '" + p.getPrecio() + "', '" + p.getAlergenos()
		    + "')";
	    stm.executeUpdate(sql);

	    conn.commit();
	    stm.close();
	    conn.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void elimProds(Producto p) {
	try {
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();
	    stm.executeUpdate("DELETE FROM productos WHERE descr='" + p.getDescripcion() + "' ; ");
	    conn.commit();
	    stm.close();
	    conn.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void actualizarProd(Producto p) {
	elimProds(p);
	escribirProds(p);
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
	    String sql = "SELECT * FROM usuarios ";
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();
	    ResultSet res = stm.executeQuery(sql);

	    ArrayList<Usuario> arrUsers = new ArrayList<Usuario>();
	    while (res.next()) {

		String user = res.getString("user1");
		String pass = res.getString("pass");
		String nom = res.getString("nom");
		String ult = res.getString("ult");
		arrUsers.add(new Usuario(user, pass, nom, ult));
	    }
	    conn.commit();
	    stm.close();
	    conn.close();
	    users = arrUsers.toArray(new Usuario[arrUsers.size()]);
	    return users;
	} catch (Exception e) {
	    e.printStackTrace();
	    users = null;
	}
	return users;

    }

    public void EliminarUsuario(Usuario u) {
	try {
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();

	    stm.executeUpdate("DELETE FROM usuarios WHERE user1='" + u.getUser() + "' ; ");

	    conn.commit();
	    stm.close();
	    conn.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void escribirUsuarios(Usuario u) {
	try {
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();

	    String sql = "INSERT INTO usuarios VALUES(1,'" + u.getUser() + "','" + u.getPass() + "','" + u.getNombre()
		    + "','" + u.getUltAcc() + "')";
	    stm.executeUpdate(sql);

	    conn.commit();
	    stm.close();
	    conn.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void actualizarUsuario(Usuario u) {
	EliminarUsuario(u);
	escribirUsuarios(u);
    }

    /**
     * 
     * 
     * --------------------------- CLIENTES -------------------------------------
     * 
     * 
     * @return
     */

    public Cliente[] leerCliente() {
	Cliente[] clientes;

	try {
	    String sql = "SELECT * FROM clientes ";
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();
	    ResultSet res = stm.executeQuery(sql);

	    ArrayList<Cliente> arrCli = new ArrayList<Cliente>();
	    while (res.next()) {

		Cliente c = new Cliente();
		c.setNombre(res.getString("nom"));
		c.setVip(res.getBoolean("vip"));
		c.setNumCliente(res.getString("nClien"));
		c.setNumTel(res.getInt("nTel"));
		c.setCorreo(res.getString("correo"));
		c.setDireccion(res.getString("direc"));
		c.setpActuales(res.getInt("pAct"));
		c.setpCanjeados(res.getInt("pCan"));
		c.setpCaducidad(res.getDate("fCad"));
		c.setDescripcion(res.getString("desc"));

		arrCli.add(c);
	    }
	    conn.commit();
	    stm.close();
	    conn.close();
	    clientes = arrCli.toArray(new Cliente[arrCli.size()]);
	    return clientes;
	} catch (Exception e) {
	    e.printStackTrace();
	    clientes = null;
	}
	return clientes;

    }

    public void EliminarCliente(Cliente c) {
	try {
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();

	    stm.executeUpdate("DELETE FROM clientes WHERE nClien='" + c.getNumCliente() + "' ; ");

	    conn.commit();
	    stm.close();
	    conn.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void escribirClientes(Cliente c) {
	try {
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();

	    Date fech = c.getpCaducidad();

	    @SuppressWarnings("deprecation")
	    Object fechaIni = new java.sql.Timestamp((fech.getYear()), fech.getMonth(), fech.getDate(), 0, 0, 0, 0);

	    String sql = "INSERT INTO clientes VALUES(1,'" + c.getNombre() + "','" + c.getNumCliente() + "','"
		    + c.getNumTel() + "','" + c.getCorreo() + "','" + c.getDireccion() + "','" + c.getpActuales()
		    + "','" + c.getpCanjeados() + "','" + fechaIni + "','" + c.getDescripcion() + "','" + c.getPedidos()
		    + "','" + c.isVip() + "')";
	    stm.executeUpdate(sql);

	    conn.commit();
	    stm.close();
	    conn.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void actualizarUsuario(Cliente c) {
	EliminarCliente(c);
	// escribirCliente(c);
    }

    /**
     * 
     * 
     * --------------------------- PEDIDOS -------------------------------------
     * 
     * @param ped
     * 
     * 
     * @return
     */
    public void escribirPedido(Pedido p) {
	try {
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();

	    String sql = "INSERT INTO pedidos VALUES(1,'" + p.getnClient() + "','" + p.getnPedido() + "','"
		    + p.getProductos() + "','" + p.getTotal().toString() + "','" + p.getTipo() + "','" + p.getEstado()
		    + "')";
	    stm.executeUpdate(sql);

	    conn.commit();
	    stm.close();
	    conn.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void eliminarPedido(Pedido p) {
	try {
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();

	    stm.executeUpdate("DELETE FROM pedidos WHERE numPed='" + p.getnPedido() + "' ; ");

	    conn.commit();
	    stm.close();
	    conn.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public Pedido[] leerPedidos() {
	Pedido[] pedidos;

	try {
	    String sql = "SELECT * FROM pedidos ";
	    Connection conn = DriverManager.getConnection(url);
	    Statement stm = conn.createStatement();
	    ResultSet res = stm.executeQuery(sql);

	    ArrayList<Pedido> arrPed = new ArrayList<Pedido>();
	    while (res.next()) {

		Pedido p = new Pedido();
		p.setnClient(res.getString("clien"));
		p.setnPedido(res.getString("numPed"));
		p.setProductos(res.getString("productos"));
		p.setTotal(res.getDouble("total"));
		p.setTipo(res.getString("tipoPed"));
		p.setEstado(res.getString("estado"));

		arrPed.add(p);
	    }
	    conn.commit();
	    stm.close();
	    conn.close();
	    pedidos = arrPed.toArray(new Pedido[arrPed.size()]);
	} catch (Exception e) {
	    e.printStackTrace();
	    pedidos = null;
	}
	return pedidos;
    }
}
