package presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import dominio.Producto;
import dominio.Usuario;
import dominio.util;
import persistencia.Agente;

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
    private util ut = new util();

    public UI_Principal(Usuario us) {
	user = us;
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.addWindowFocusListener(new FrameWindowFocusListener());
	frame.setTitle("Restaurante La Josefina - Menu de Empleado");
	frame.setBounds(100, 100, 1180, 769);
	frame.getContentPane().setLayout(new BorderLayout(0, 0));
	frame.setUndecorated(true);
	frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
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
	    panNav.setBorder(null);
	    frame.getContentPane().add(panNav, BorderLayout.CENTER);
	    panNav.setLayout(new BorderLayout(0, 0));
	    {
		splitPane = new JSplitPane();
		splitPane.setBackground(new Color(38, 38, 38));
		panNav.add(splitPane, BorderLayout.CENTER);
		{
		    pnlArb = new JPanel();
		    pnlArb.setBackground(new Color(0,180,188));
		    pnlArb.setMinimumSize(new Dimension(278, 10));
		    splitPane.setLeftComponent(pnlArb);
		    pnlArb.setLayout(new BorderLayout(0, 0));
		    pnlArb.setBackground(new Color(38, 38, 38));
		    pnlArb.setOpaque(false);
		    {
			tree = new JTree();
			tree.setBorder(null);
			tree.addTreeSelectionListener(new TreeTreeSelectionListener());
			tree.setBackground(Color.WHITE);
			tree.setRootVisible(false);
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
			
			tree.setCellRenderer(new RenderMenu());
			tree.putClientProperty("JTree.lineStyle", "Horizontal");
		    }
		}
		{
		    pnlComida = new JPanel();
		    splitPane.setRightComponent(pnlComida);
		    GridBagLayout gbl_pnlComida = new GridBagLayout();
		    gbl_pnlComida.columnWidths = new int[] { 583, 544, 0 };
		    gbl_pnlComida.rowHeights = new int[] { 0, 0 };
		    gbl_pnlComida.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
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
			pnlInfo.setBackground(new Color(255, 255, 255));
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
			    pnlTabla.setOpaque(false);
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

    private void anadirPaneles() {

	pnlGest = new JPanel();
	pnlGest.setBackground(Color.WHITE);

	pnlProductos.add(pnlGest, "Gesti�n de Pedidos");
	pnlProductos.setBackground(new Color(255, 255, 255));
	Agente ag = new Agente();
	Producto[] prods = ag.leerProducto();
	// ------------- CARTA ------------------
	System.out.println("1  " + user.toString());

	pnlProductos.add(new panelProductos(prods, 1, user), "Carta");
	// ------------- MENUS ------------------
	pnlProductos.add(generarPanel("menu", prods), "Men�s");
	// ------------- BEBIDAS ------------------
	pnlProductos.add(generarPanel("bebida", prods), "Bebidas");
	// ------------- PLATOS INDIVIDUALES ------------------
	pnlProductos.add(generarPanel("platInd", prods), "Platos Individuales");
	// ------------- POSTRES ------------------
	pnlProductos.add(generarPanel("postre", prods), "Postres");
	// ------------- Ofertas ------------------
	pnlProductos.add(generarPanel("oferta", prods), "Ofertas");

    }

    private JPanel generarPanel(String categoria, Producto[] prods) {
	Producto[] newProds = ut.categorizarProds(categoria, prods);
	panelProductos pprod = new panelProductos(newProds, user);
	return pprod;
    }

    private class TreeTreeSelectionListener implements TreeSelectionListener {
	@Override
	public void valueChanged(TreeSelectionEvent e) {

	    String nodo = (e.getPath().getLastPathComponent()).toString();
	    switch (nodo) {
	    case "Gesti�n de Pedidos":
	    case "Listado de Clientes":
	    case "Carta":
	    case "Men�s":
	    case "Bebidas":
	    case "Platos Individuales":
	    case "Postres":
	    case "Ofertas":
		((CardLayout) pnlProductos.getLayout()).show(pnlProductos, nodo);
		System.out.println(nodo);
	    }
	}
    }

    // PARA QUE CADA VEZ QUE SE A�ADA UN PRODUCTO Y LUEGO CANE EL FOCUS, DE REPINTE. PERO NO FUNCIONA
    private class FrameWindowFocusListener implements WindowFocusListener {
	@Override
	public void windowGainedFocus(WindowEvent arg0) {
	    frame.repaint();
	    frame.revalidate();
	    anadirPaneles();
	}

	@Override
	public void windowLostFocus(WindowEvent arg0) {

	}

    }

}
