package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import dominio.Producto;
import dominio.Usuario;
import dominio.util;

public class panelProductos extends JPanel {
    private util ut;
    private JPanel panelPaneles;
    private Usuario user;

    /**
     * Create the panel
     * Este panel es un pifostio del carajo, casi se me rompe la cabeza haciendolo
     * 
     * @param utiles
     * 
     * @wbp.parser.constructor
     * 
     */
    public panelProductos(Producto[] productos, Usuario us, util utiles) {
	setOpaque(false); /* Si el flag de carta = 1, muestra todos los productos */
	user = us;
	ut = utiles;
	inicializar(productos, 0);
    }

    public panelProductos(Producto[] productos, int flagCarta, Usuario us, util utiles) {
	user = us;
	ut = utiles;
	inicializar(productos, 1);
    }

    public void inicializar(Producto[] productos, int flagCarta) {
	setLayout(new BorderLayout());
	setBackground(new Color(211, 238, 255));
	panelPaneles = new JPanel();
	panelPaneles.setOpaque(false);
	String[] allTipos = ut.contarTipos(productos);

	panelPaneles.setLayout(new BoxLayout(panelPaneles, BoxLayout.Y_AXIS));
	panelPaneles.add(Box.createHorizontalGlue());

	for (int j = 0; j < allTipos.length; j++) {// Recorrer todos los tipos

	    JPanel panelTipo = new JPanel();
	    panelTipo.setBorder(new TitledBorder(null, allTipos[j], TitledBorder.LEADING, TitledBorder.TOP,
		    new Font("SansSerif", Font.BOLD, 36), null));
	    panelTipo.setLayout(new GridLayout(1, 0, 0, 0));
	    int numS = 0;
	    for (int i = 0; i < productos.length; i++) {
		if (productos[i].getTipo().equals(allTipos[j])) {// Si coincide con el tipo que se esta recorriendo
		    panelTipo.add(new panelProdReut(productos[i],ut));
		    numS += 1;
		    panelTipo.setLayout(new GridLayout(numS, 0, 0, 0));
		    panelTipo.setBackground(new Color(255, 255, 255));
		}
	    }
	    panelPaneles.add(panelTipo);

	} // FIN RECORRER TODOS LOS TIPOS

	JScrollPane scrollPanel = new JScrollPane(panelPaneles);
	scrollPanel.setBackground(Color.WHITE);
	scrollPanel.getVerticalScrollBar().setUnitIncrement(16);// Aumentar la velocidad de scroll
	scrollPanel.setOpaque(false);
	add(scrollPanel, BorderLayout.CENTER);
	add(new panelGestionProd(user), BorderLayout.NORTH);

    }

}
