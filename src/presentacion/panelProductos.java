package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import dominio.Producto;
import dominio.util;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import java.awt.FlowLayout.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

public class panelProductos extends JPanel {
    private JScrollPane scrollPane;
    private util ut = new util();
    private JPanel panelPaneles;

    /**
     * Create the panel.
     * 
     * Este panel es un pifostio del carajo, casi se me rompe la cabeza haciendolo
     * 
     * @wbp.parser.constructor
     * 
     */
    public panelProductos(Producto[] productos) { /* Si el flag de carta = 1, muestra todos los productos */
	inicializar(productos, 0);
    }

    public panelProductos(Producto[] productos, int flagCarta) {
	inicializar(productos, 1);
    }

    public void inicializar(Producto[] productos, int flagCarta) {
	setLayout(new BorderLayout());
	panelPaneles = new JPanel();
	panelPaneles.setOpaque(false);
	String[] allTipos = ut.contarTipos(productos);

	panelPaneles.setLayout(new BoxLayout(panelPaneles, BoxLayout.Y_AXIS));//ME CAGOEN EL BOX LAYOUT
	panelPaneles.add(Box.createHorizontalGlue());

	for (int j = 0; j < allTipos.length; j++) {// Recorrer todos los tipos

	    JPanel panelTipo = new JPanel();
	    panelTipo.setBorder(new TitledBorder(null, allTipos[j], TitledBorder.LEADING, TitledBorder.TOP,
		    new Font("SansSerif", Font.BOLD, 36), null));
	    panelTipo.setLayout(new GridLayout(1, 0, 0, 0));
	    int numS = 0;
	    for (int i = 0; i < productos.length; i++) {
		if (productos[i].getTipo().equals(allTipos[j])) {// Si coincide con el tipo que se esta recorriendo
		    panelTipo.add(new panelProdReut(productos[i]));
		    numS += 1;
		    panelTipo.setLayout(new GridLayout(numS, 0, 0, 0));

		}
	    }
	    panelPaneles.add(panelTipo);

	} // FIN RECORRER TODOS LOS TIPOS

	add(new JScrollPane(panelPaneles), BorderLayout.CENTER);

	if (flagCarta != 0) {
	    add(new panelGestionProd("carta"), BorderLayout.NORTH);
	} else {
	    add(new panelGestionProd(productos[0].getCategoria()), BorderLayout.NORTH);
	}
    }

}
