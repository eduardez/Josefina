package presentacion;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class RenderMenu extends DefaultTreeCellRenderer {
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
	    int row, boolean hasFocus) {
	super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
	DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
	String c = (String) (nodo.getUserObject());
	switch (c) {
	case "Inicio":
	    setIcon(new ImageIcon(RenderMenu.class.getResource("inicio.png")));
	    break;
	case "Ayuda":
	    setIcon(new ImageIcon(RenderMenu.class.getResource("ayuda.png")));
	    break;
	case "Adjunto":
	    setIcon(new ImageIcon(RenderMenu.class.getResource("adjunto.png")));
	    break;
	default:
	    setIcon(new ImageIcon(RenderMenu.class.getResource("pantalla.png")));
	    break;
	}
	return this;
    }
}
