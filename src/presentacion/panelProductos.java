package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;

import dominio.Producto;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;

public class panelProductos extends JPanel {
    private JScrollPane scrollPane;
    private JPanel panelTipo;
    private JPanel panelPaneles;

    /**
     * Create the panel.
     * 
     * Este panel es un pifostio del carajo, casi se me rompe la cabeza haciendolo
     * 
     */
    public panelProductos(Producto[] productos) {
	inicializar(productos, 0);
    }

    public panelProductos(Producto[] productos, int flagCarta) {
	inicializar(productos, 1);
    }

    public void inicializar(Producto[] productos, int flagCarta) {
	setLayout(new BorderLayout());
	panelPaneles = new JPanel();
	String[] allTipos = contarTipos(productos);
	panelPaneles.setLayout(new GridLayout(allTipos.length, 0, 0, 0));

	for (int j = 0; j < allTipos.length; j++) {// Recorrer todos los tipos

	    panelTipo = new JPanel();
	    panelTipo.setBorder(new TitledBorder(null, allTipos[j], TitledBorder.LEADING, TitledBorder.TOP,
		    new Font("SansSerif", Font.BOLD, 36), null));
	    ArrayList<panelProdReut> panPlato = new ArrayList<panelProdReut>();
	    {
		int numPn = 0;
		for (int i = 0; i < productos.length; i++) {
		    if (productos[i].getTipo().equals(allTipos[j])) {// Si coincide con el tipo que se esta recorriendo

			System.out.println(productos[i].toString());

			panPlato.add(new panelProdReut(productos[i]));
			panelTipo.add(panPlato.get(numPn));
			panelTipo.setLayout(new GridLayout(numPn + 1, 0, 0, 0));
			numPn++;
		    }
		}
		panelPaneles.add(panelTipo);
	    }

	} // FIN RECORRER TODOS LOS TIPOS
	add(new JScrollPane(panelPaneles), BorderLayout.CENTER);
	if (flagCarta != 0) {
	    add(new panelGestionProd("carta"), BorderLayout.NORTH);
	} else {
	    add(new panelGestionProd(productos[0].getCategoria()), BorderLayout.NORTH);

	}
    }

    private String[] contarTipos(Producto[] productos) {
	ArrayList<String> tip = new ArrayList<String>(); // Contar numero de tipos de producto que hay
	for (int i = 0; i < productos.length; i++) {
	    if (!tip.contains(productos[i].getTipo()))
		tip.add(productos[i].getTipo());
	}
	String[] arrTipos = tip.toArray(new String[tip.size()]);
	return arrTipos;
    }
}
