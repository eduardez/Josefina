package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;

import dominio.Producto;

import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

public class panelProductos extends JPanel {
    private JScrollPane scrollPane;
    private JPanel panelTipo;
    private JPanel panelPaneles;

    /**
     * Create the panel.
     */
    public panelProductos(String[] tipoProd, Producto[] productos) {
	setLayout(new BorderLayout());
	panelPaneles = new JPanel();
	panelPaneles.setLayout(new GridLayout(tipoProd.length, 0, 0, 0));

	for (int j = 0; j < tipoProd.length; j++) {// Recorrer todos los tipos

	    int tam = productos.length;
	    panelTipo = new JPanel();
	    panelTipo.setBorder(new TitledBorder(null, tipoProd[j], TitledBorder.LEADING, TitledBorder.TOP,
		    new Font("SansSerif", Font.BOLD, 36), null));
	    panelTipo.setLayout(new GridLayout(tam, 0, 0, 0));
	    panelProdReut[] panPlato = new panelProdReut[tam];
	    {
		/*
		 * for (int i = 0; i < tam; i++) {
		 * panPlato[i] = new panelProdReut(productos[i].getNombre(), productos[i].getIngredientes, productos[i].getAlergenos());
		 * panelTipo.add(panPlato[i]);
		 * }
		 * 
		 */
		for (int i = 0; i < tam; i++) { // Recorrer todos los productos de ese tipo
		    panPlato[i] = new panelProdReut();
		    panelTipo.add(panPlato[i]);
		}
		panelPaneles.add(panelTipo);
	    }
	} // FIN RECORRER TODOS LOS TIPOS
	add(new JScrollPane(panelPaneles), BorderLayout.CENTER);
    }
}
