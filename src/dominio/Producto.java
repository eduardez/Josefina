package dominio;

import java.text.DecimalFormat;

public class Producto {
    private String categoria;
    private String tipo;
    private String nombre;
    private String descripcion;
    private String precio;
    private String alergenos;

    /**
     * @param tipo
     * @param nombre
     * @param descripcion
     * @param precio
     * @param alergenos
     */
    public Producto(String cat, String tipo, String nombre, String descripcion, String precio, String alergenos) {
	super();
	this.categoria = cat;
	this.tipo = tipo;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.precio = precio;
	this.alergenos = alergenos;
    }

    public String getCategoria() {
	return categoria;
    }

    public void setCategoria(String categoria) {
	this.categoria = categoria;
    }

    public String getAlergenos() {
	return alergenos;
    }

    public void setAlergenos(String alergenos) {
	this.alergenos = alergenos;
    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
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

    public String getPrecio() {
	return precio;
    }

    public void setPrecio(String precio) {
	this.precio = precio;
    }

    @Override
    public String toString() {
	return "Producto = " + categoria + ", " + tipo + ", " + nombre + ", " + descripcion + ", " + precio + ", "
		+ alergenos;
    }

}
