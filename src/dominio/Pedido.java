package dominio;

import java.security.SecureRandom;
import java.util.Random;

public class Pedido {
    String nClient;
    String nPedido;
    String productos;
    Double total;
    String tipo;
    String estado;

    /**
     * @param nClient
     * @param nPedido
     * @param productos
     * @param total
     * @param tipo
     * @param estado
     */
    public Pedido(String nClient, String productos, Double total, String tipo) {
	super();
	this.nClient = nClient;
	this.nPedido =  getRandom(10);//Generar codigo de pedido aleatorio para cada nuevo pedido
	this.productos = productos;
	this.total = total;
	this.tipo = tipo;
	this.estado = "En preparacion";//Siempre que se cree un nuevo pedido se pondra automaticamente en estado de preparacion
    }

    public Pedido() {

    }

    public String getnClient() {
	return nClient;
    }

    public void setnClient(String nClient) {
	this.nClient = nClient;
    }

    public String getnPedido() {
	return nPedido;
    }
    public void setnPedido(String nPed) {
	this.nPedido = nPed;
    }

    public String getProductos() {
	return productos;
    }

    public void setProductos(String productos) {
	this.productos = productos;
    }

    public Double getTotal() {
	return total;
    }

    public void setTotal(double total) {
	this.total = total;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private String getRandom(int tam) {
	char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
		'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
		'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
		'z' };

	char[] c = new char[tam];
	Random random = new Random();
	for (int i = 0; i < tam; i++) {
	    c[i] = ch[random.nextInt(ch.length)];
	}

	return new String(c);
    }


}
