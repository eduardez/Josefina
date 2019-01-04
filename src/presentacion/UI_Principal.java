package presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.table.DefaultTableModel;

public class UI_Principal {

    public JFrame frame;
    private panelUser panUser;
    private JPanel panNav;
    private JSplitPane splitPane;
    private JPanel pnlArb;
    private JTree tree;
    private JPanel pnlComida;
    private JPanel pnlInfo;
    private JPanel pnlProductos;
    private Usuario user;
    private JPanel pnlGest;
    private util ut = new util();
    private JTextArea textArea;
    private JPanel pnlTabla;
    Agente ag = new Agente();

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
		    pnlArb.setBackground(new Color(0, 180, 188));
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
			gbl_pnlInfo.rowHeights = new int[] { 373, 386, 0 };
			gbl_pnlInfo.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_pnlInfo.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
			pnlInfo.setBackground(new Color(255, 255, 255));
			pnlInfo.setLayout(gbl_pnlInfo);
			{
			    pnlTabla = new JPanel();
			    pnlTabla.setOpaque(false);
			    GridBagConstraints gbc_pnlTabla = new GridBagConstraints();
			    gbc_pnlTabla.insets = new Insets(0, 0, 5, 0);
			    gbc_pnlTabla.fill = GridBagConstraints.BOTH;
			    gbc_pnlTabla.gridx = 0;
			    gbc_pnlTabla.gridy = 0;
			    pnlInfo.add(pnlTabla, gbc_pnlTabla);
			    pnlTabla.setLayout(new BorderLayout(0, 0));

			    // Añadir tabla ----------
			    anadirTabla();
			}
			{
			    textArea = new JTextArea();
			    textArea.setText("info");
			    GridBagConstraints gbc_textArea = new GridBagConstraints();
			    gbc_textArea.fill = GridBagConstraints.BOTH;
			    gbc_textArea.gridx = 0;
			    gbc_textArea.gridy = 1;
			    pnlInfo.add(textArea, gbc_textArea);
			}
		    }
		}
	    }
	}
	anadirPaneles();
    }

    private void anadirTabla() {
	String columnas[] = { "Producto", "Tipo", "Precio", "Cantidad" }; // Que se va a poner en cada columna
	DefaultTableModel modelo_tabla = new DefaultTableModel(columnas, 0);
	JTable tabla = new JTable(modelo_tabla); // Crear tabla
	tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	tabla.setFont(new Font("SansSerif", Font.PLAIN, 17));
	JScrollPane scrollpan = new JScrollPane(tabla);
	scrollpan.setVerticalScrollBarPolicy(scrollpan.VERTICAL_SCROLLBAR_AS_NEEDED);
	pnlTabla.add(scrollpan);
	pnlTabla.add(tabla.getTableHeader(), BorderLayout.NORTH);
	ut.setTabla(tabla);
	ut.setPnlUser(panUser);
    }

    private void anadirPaneles() {
	pnlGest = new JPanel();
	pnlGest.setBackground(Color.WHITE);
	pnlProductos.removeAll();// Quitar todos los paneles y volver a meterlos. Es muy basto, pero funciona.

	Producto[] prods = ag.leerProducto();
	// ------------- CARTA ------------------
	System.out.println("1  " + user.toString());

	pnlProductos.add(new panelProductos(prods, 1, user, ut), "Carta");
	// ------------- MENUS ------------------
	pnlProductos.add(generarPanel("menu", prods), "Menús");
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
	panelProductos pprod = new panelProductos(newProds, user, ut);
	return pprod;
    }

    private class TreeTreeSelectionListener implements TreeSelectionListener {
	@Override
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

    // PARA QUE CADA VEZ QUE SE AÑADA UN PRODUCTO Y LUEGO GANE EL FOCUS
    private class FrameWindowFocusListener implements WindowFocusListener {
	@Override
	public void windowGainedFocus(WindowEvent arg0) {
	    anadirPaneles();
	    ((CardLayout) pnlProductos.getLayout()).show(pnlProductos, tree.getLastSelectedPathComponent().toString());
	    pnlProductos.repaint();
	    pnlProductos.revalidate();
	}

	@Override
	public void windowLostFocus(WindowEvent arg0) {

	}

    }

}
