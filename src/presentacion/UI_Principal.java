package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.TreeSelectionListener;
import javax.swing.border.BevelBorder;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import presentacion.EjemploArbol.TreeTreeSelectionListener;

import javax.swing.tree.DefaultMutableTreeNode;

public class UI_Principal {

    private JFrame frmRestauranteLaJosefina;
    private JPanel panUser;
    private JPanel panNav;
    private JSplitPane splitPane;
    private JPanel pnlArb;
    private JTree tree;
    private JButton btnLl;
    private JPanel pnlComida;
    private JPanel pnlInfo;
    private JPanel pnlProductos;
    private JTextArea txtrInfo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UI_Principal window = new UI_Principal();
		    window.frmRestauranteLaJosefina.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public UI_Principal() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frmRestauranteLaJosefina = new JFrame();
	frmRestauranteLaJosefina.setTitle("Restaurante La Josefina - Menu de Empleado");
	frmRestauranteLaJosefina.setBounds(100, 100, 974, 665);
	frmRestauranteLaJosefina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmRestauranteLaJosefina.getContentPane().setLayout(new BorderLayout(0, 0));
	{
	    panUser = new JPanel();
	    panUser.setPreferredSize(new Dimension(10, 85));
	    panUser.setMinimumSize(new Dimension(10, 150));
	    panUser.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
	    frmRestauranteLaJosefina.getContentPane().add(panUser, BorderLayout.NORTH);
	    GridBagLayout gbl_panUser = new GridBagLayout();
	    gbl_panUser.columnWidths = new int[] { 0, 0 };
	    gbl_panUser.rowHeights = new int[] { 0, 0 };
	    gbl_panUser.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
	    gbl_panUser.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
	    panUser.setLayout(gbl_panUser);
	    {
		btnLl = new JButton("ll");
		GridBagConstraints gbc_btnLl = new GridBagConstraints();
		gbc_btnLl.gridx = 0;
		gbc_btnLl.gridy = 0;
		panUser.add(btnLl, gbc_btnLl);
	    }
	}
	{
	    panNav = new JPanel();
	    frmRestauranteLaJosefina.getContentPane().add(panNav, BorderLayout.CENTER);
	    panNav.setLayout(new BorderLayout(0, 0));
	    {
		splitPane = new JSplitPane();
		panNav.add(splitPane, BorderLayout.CENTER);
		{
		    pnlArb = new JPanel();
		    pnlArb.setPreferredSize(new Dimension(150, 10));
		    pnlArb.setMinimumSize(new Dimension(250, 10));
		    splitPane.setLeftComponent(pnlArb);
		    pnlArb.setLayout(new BorderLayout(0, 0));
		    {
			tree = new JTree();
			tree.setCellRenderer(new RenderMenu());
			tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("JTree") {
			    {
				DefaultMutableTreeNode node_1;
				add(new DefaultMutableTreeNode("Gesti\u00F3n de Pedidos"));
				add(new DefaultMutableTreeNode("Listado de Clientes"));
				node_1 = new DefaultMutableTreeNode("Carta");
				node_1.add(new DefaultMutableTreeNode("Men\u00FA"));
				node_1.add(new DefaultMutableTreeNode("Platos Individuales"));
				node_1.add(new DefaultMutableTreeNode("Bebidas"));
				node_1.add(new DefaultMutableTreeNode("Postres"));
				node_1.add(new DefaultMutableTreeNode("Ofertas"));
				add(node_1);
			    }
			}));
			pnlArb.add(tree);
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
		    }
		    {
			pnlInfo = new JPanel();
			GridBagConstraints gbc_pnlInfo = new GridBagConstraints();
			gbc_pnlInfo.fill = GridBagConstraints.BOTH;
			gbc_pnlInfo.gridx = 1;
			gbc_pnlInfo.gridy = 0;
			pnlComida.add(pnlInfo, gbc_pnlInfo);
			pnlInfo.setLayout(new BorderLayout(0, 0));
			{
			    txtrInfo = new JTextArea();
			    pnlInfo.add(txtrInfo, BorderLayout.CENTER);
			}
		    }
		}
	    }
	}
    }
}
