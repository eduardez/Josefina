package presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class RenderMenu extends DefaultTreeCellRenderer {
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
	    int row, boolean hasFocus) {
	super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
	DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
	setFont(new Font("SansSerif", Font.PLAIN, 19));
	setForeground(new Color(38,38,38));
	setOpaque(false);
	String c = (String) (nodo.getUserObject());
	switch (c) {
	case "Gestión de Pedidos":
	    setIcon(new ImageIcon(RenderMenu.class.getResource("/recursos/Gestion.png")));
	    break;
	case "Listado de Clientes":
	    setIcon(new ImageIcon(RenderMenu.class.getResource("/recursos/Clientes.png")));
	    break;
	case "Carta":
	    setIcon(new ImageIcon(RenderMenu.class.getResource("/recursos/Carta.png")));
	    break;
	case "Menús":
	    setIcon(new ImageIcon(RenderMenu.class.getResource("/recursos/Menus.png")));
	    break;
	case "Bebidas":
	    setIcon(new ImageIcon(RenderMenu.class.getResource("/recursos/Bebidas.png")));
	    break;
	case "Platos Individuales":
	    setIcon(new ImageIcon(RenderMenu.class.getResource("/recursos/Platos.png")));
	    break;
	case "Postres":
	    setIcon(new ImageIcon(RenderMenu.class.getResource("/recursos/Postres.png")));
	    break;
	case "Ofertas":
	    setIcon(new ImageIcon(RenderMenu.class.getResource("/recursos/Ofertas.png")));
	    break;
	default:
	    setIcon(new ImageIcon(RenderMenu.class.getResource("/recursos/Gestion.png")));
	    break;
	}
	return this;
    }
}
