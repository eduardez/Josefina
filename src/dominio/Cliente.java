package dominio;

import java.util.Date;

public class Cliente {
    String nombre;
    String numCliente;
    int numTel;
    String correo;
    String direccion;
    int pActuales;
    int pCanjeados;
    Date pCaducidad;
    String descripcion;
    String pedidos;
    boolean vip;

    /**
     * @param nombre
     * @param numCliente
     * @param numTel
     * @param correo
     * @param direccion
     * @param pActuales
     * @param pCanjeados
     * @param pCaducidad
     * @param descripcion
     * @param pedidos
     * @param vip
     */
    public Cliente(String nombre, String numCliente, int numTel, String correo, String direccion, int pActuales,
	    int pCanjeados, Date pCaducidad, String descripcion, String pedidos, boolean vip) {
	super();
	this.nombre = nombre;
	this.numCliente = numCliente;
	this.numTel = numTel;
	this.correo = correo;
	this.direccion = direccion;
	this.pActuales = pActuales;
	this.pCanjeados = pCanjeados;
	this.pCaducidad = pCaducidad;
	this.descripcion = descripcion;
	this.pedidos = pedidos;
	this.vip = vip;
    }

    public Cliente() {
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public String getPedidos() {
	return pedidos;
    }

    public void setPedidos(String pedidos) {
	this.pedidos = pedidos;
    }

    public boolean isVip() {
	return vip;
    }

    public void setVip(boolean vip) {
	this.vip = vip;
    }
    public String getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(String numCliente) {
        this.numCliente = numCliente;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getpActuales() {
        return pActuales;
    }

    public void setpActuales(int pActuales) {
        this.pActuales = pActuales;
    }

    public int getpCanjeados() {
        return pCanjeados;
    }

    public void setpCanjeados(int pCanjeados) {
        this.pCanjeados = pCanjeados;
    }

    public Date getpCaducidad() {
        return pCaducidad;
    }

    public void setpCaducidad(Date pCaducidad) {
        this.pCaducidad = pCaducidad;
    }

    @Override
    public String toString() {
	return "Cliente [nombre=" + nombre + ", numCliente=" + numCliente + ", numTel=" + numTel + ", correo=" + correo
		+ ", direccion=" + direccion + ", pActuales=" + pActuales + ", pCanjeados=" + pCanjeados
		+ ", pCaducidad=" + pCaducidad + ", descripcion=" + descripcion + ", pedidos=" + pedidos + ", vip="
		+ vip + "]";
    }

}
