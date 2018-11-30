package dominio;

public class Producto {
    private String tipo;
    private String nombre;
    private String ingredientes;
    private String precio;

    /**
     * @param tipo
     * @param nombre
     * @param ingredientes
     * @param precio
     */
    
    public Producto(String tipo, String nombre, String ingredientes, String precio) {
	super();
	this.tipo = tipo;
	this.nombre = nombre;
	this.ingredientes = ingredientes;
	this.precio = precio;
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

    public String getIngredientes() {
	return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
	this.ingredientes = ingredientes;
    }

    public String getPrecio() {
	return precio;
    }

    public void setPrecio(String precio) {
	this.precio = precio;
    }

}
