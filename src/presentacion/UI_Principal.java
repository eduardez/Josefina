package presentacion;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import dominio.Producto;
import dominio.Usuario;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Color;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;

public class UI_Principal {

    public JFrame frame;
    private JPanel panUser;
    private JPanel panNav;
    private JSplitPane splitPane;
    private JPanel pnlArb;
    private JTree tree;
    private JButton btnLl;
    private JPanel pnlComida;
    private JPanel pnlInfo;
    private JPanel pnlProductos;
    private Usuario user;
    private JPanel pnlGest;
    private JTextArea txtrInfo;
    private JPanel pnlTabla;
    private JTable tablaPedidos;
    private JScrollPane scPnlPlatos;
    private JPanel pnlCarta;

    public UI_Principal(Usuario us) {
	user = us;
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setTitle("Restaurante La Josefina - Menu de Empleado");
	frame.setBounds(100, 100, 974, 665);
	frame.getContentPane().setLayout(new BorderLayout(0, 0));
	frame.setUndecorated(true);
	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	{
	    panUser = new panelUser(user, frame);

	    panUser.setPreferredSize(new Dimension(90, 115));
	    frame.getContentPane().add(panUser, BorderLayout.NORTH);
	    GridBagLayout gbl_panUser = new GridBagLayout();
	    gbl_panUser.columnWidths = new int[] { 0, 0 };
	    gbl_panUser.rowHeights = new int[] { 0, 0 };
	    gbl_panUser.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
	    gbl_panUser.rowWeights = new double[] { 1.0, Double.MIN_VALUE };

	}
	{
	    panNav = new JPanel();
	    frame.getContentPane().add(panNav, BorderLayout.CENTER);
	    panNav.setLayout(new BorderLayout(0, 0));
	    {
		splitPane = new JSplitPane();
		panNav.add(splitPane, BorderLayout.CENTER);
		{
		    pnlArb = new JPanel();
		    pnlArb.setPreferredSize(new Dimension(150, 10));
		    pnlArb.setMinimumSize(new Dimension(270, 10));
		    splitPane.setLeftComponent(pnlArb);
		    pnlArb.setLayout(new BorderLayout(0, 0));
		    {
			tree = new JTree();
			tree.addTreeSelectionListener(new TreeTreeSelectionListener());
			tree.setBackground(new Color(255, 255, 255));
			tree.setRootVisible(false);
			tree.setCellRenderer(new RenderMenu());
			tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Inicio") {
			    {
				DefaultMutableTreeNode node_1;
				add(new DefaultMutableTreeNode("Gesti\u00F3n de Pedidos"));
				add(new DefaultMutableTreeNode("Listado de Clientes"));
				node_1 = new DefaultMutableTreeNode("Carta");
				node_1.add(new DefaultMutableTreeNode("Men\u00FAs"));
				node_1.add(new DefaultMutableTreeNode("Platos Individuales"));
				node_1.add(new DefaultMutableTreeNode("Bebidas"));
				node_1.add(new DefaultMutableTreeNode("Postres"));
				node_1.add(new DefaultMutableTreeNode("Ofertas"));
				add(node_1);
			    }
			}));
			pnlArb.add(tree);
			for (int i = 0; i < tree.getRowCount(); i++) {// Expandir todos los nodos
			    tree.expandRow(i);
			}
			tree.putClientProperty("JTree.lineStyle", "Horizontal");
		    }
		}
		{
		    pnlComida = new JPanel();
		    splitPane.setRightComponent(pnlComida);
		    GridBagLayout gbl_pnlComida = new GridBagLayout();
		    gbl_pnlComida.columnWidths = new int[] { 583, 146, 0 };
		    gbl_pnlComida.rowHeights = new int[] { 0, 0 };
		    gbl_pnlComida.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		    gbl_pnlComida.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		    pnlComida.setLayout(gbl_pnlComida);
		    {
			pnlProductos = new JPanel();
			GridBagConstraints gbc_pnlProductos = new GridBagConstraints();
			gbc_pnlProductos.insets = new Insets(0, 0, 0, 5);
			gbc_pnlProductos.fill = GridBagConstraints.BOTH;
			gbc_pnlProductos.gridx = 0;
			gbc_pnlProductos.gridy = 0;
			pnlComida.add(pnlProductos, gbc_pnlProductos);
			pnlProductos.setLayout(new CardLayout(0, 0));
			anadirPaneles();
		    }
		    {
			pnlInfo = new JPanel();
			GridBagConstraints gbc_pnlInfo = new GridBagConstraints();
			gbc_pnlInfo.fill = GridBagConstraints.BOTH;
			gbc_pnlInfo.gridx = 1;
			gbc_pnlInfo.gridy = 0;
			pnlComida.add(pnlInfo, gbc_pnlInfo);
			GridBagLayout gbl_pnlInfo = new GridBagLayout();
			gbl_pnlInfo.columnWidths = new int[] { 0, 0 };
			gbl_pnlInfo.rowHeights = new int[] { 272, 334, 0 };
			gbl_pnlInfo.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_pnlInfo.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			pnlInfo.setLayout(gbl_pnlInfo);
			{
			    txtrInfo = new JTextArea();
			    txtrInfo.setText("info");
			    GridBagConstraints gbc_txtrInfo = new GridBagConstraints();
			    gbc_txtrInfo.insets = new Insets(0, 0, 5, 0);
			    gbc_txtrInfo.fill = GridBagConstraints.BOTH;
			    gbc_txtrInfo.gridx = 0;
			    gbc_txtrInfo.gridy = 0;
			    pnlInfo.add(txtrInfo, gbc_txtrInfo);
			}
			{
			    pnlTabla = new JPanel();
			    pnlTabla.setBorder(new TitledBorder(null, "Productos a\u00F1adidos al pedido",
				    TitledBorder.LEADING, TitledBorder.TOP, null, null));
			    GridBagConstraints gbc_pnlTabla = new GridBagConstraints();
			    gbc_pnlTabla.fill = GridBagConstraints.BOTH;
			    gbc_pnlTabla.gridx = 0;
			    gbc_pnlTabla.gridy = 1;
			    pnlInfo.add(pnlTabla, gbc_pnlTabla);
			    pnlTabla.setLayout(new BorderLayout(0, 0));
			    {
				tablaPedidos = new JTable();
				pnlTabla.add(tablaPedidos);
			    }
			}
		    }
		}
	    }
	}
    }

    /*
     * ----------------------------------------------------------------------------------------------------------
     * ----------------------------------------------------------------------------------------------------------
     * ------------------------------------ ME HE QUEDADO POR AQUI ----------------------------------------------
     * ----------------------------------------------------------------------------------------------------------
     * ----------------------------------------------------------------------------------------------------------
     * PONER LO DE LOS NOMBRES Y TAL
     */
    private void anadirPaneles() {
	{
	    pnlGest = new JPanel();
	    pnlProductos.add(pnlGest, "Gestión de Pedidos");
	}
	{ // ------------- CARTA ------------------
	    Producto[] prod = new Producto[3];
	    String[] tipoProd = { "Menus", "Carnes", "Pescados", "Vinos", "Cervezas", "Helados" };
	    panelProductos pprod = new panelProductos(tipoProd, prod);
	    pnlProductos.add(pprod, "Carta");
	}
	{ // ------------- MENUS ------------------
	    Producto[] prod = new Producto[6];
	    String[] tipoProd = { "Menus Normales", "Menús Especiales" };
	    panelProductos pprod = new panelProductos(tipoProd, prod);
	    pnlProductos.add(pprod, "Menús");
	}
	{ // ------------- BEBIDAS ------------------
	    Producto[] prod = new Producto[4];
	    String[] tipoProd = { "Vinos", "Cervezas", "Tés" };
	    panelProductos pprod = new panelProductos(tipoProd, prod);
	    pnlProductos.add(pprod, "Bebidas");
	}
	{ // ------------- PANELES INDIVIDUALES ------------------
	    Producto[] prod = new Producto[6];
	    String[] tipoProd = { "Carnes", "Pescados" };
	    panelProductos pprod = new panelProductos(tipoProd, prod);
	    pnlProductos.add(pprod, "Platos Individuales");
	}
	{ // ------------- POSTRES ------------------
	    Producto[] prod = new Producto[6];
	    String[] tipoProd = { "Helados", "Furtas" };
	    panelProductos pprod = new panelProductos(tipoProd, prod);
	    pnlProductos.add(pprod, "Postres");
	}
	{ // ------------- Ofertas ------------------
	    Producto[] prod = new Producto[6];
	    String[] tipoProd = { "Menús Especiales", "Ofertas del Dia" };
	    panelProductos pprod = new panelProductos(tipoProd, prod);
	    pnlProductos.add(pprod, "Ofertas");
	}
    }

    private class TreeTreeSelectionListener implements TreeSelectionListener {
	public void valueChanged(TreeSelectionEvent e) {

	    String nodo = (e.getPath().getLastPathComponent()).toString();
	    switch (nodo) {
	    case "Gestión de Pedidos":
	    case "Listado de Clientes":
	    case "Carta":
	    case "Menús":
	    case "Bebidas":
	    case "Platos Individuales":
	    case "Postres":
	    case "Ofertas":
		((CardLayout) pnlProductos.getLayout()).show(pnlProductos, nodo);
		System.out.println(nodo);
	    }
	}
    }
}
