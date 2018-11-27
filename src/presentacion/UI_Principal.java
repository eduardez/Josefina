package presentacion;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;

public class UI_Principal {

    private JFrame frame;
    private JPanel panUser;
    private JPanel panNav;
    private JSplitPane splitPane;
    private JScrollPane scrollPane;
    private JTree tree;
    private JPanel panelCard;
    private JPanel panelTeclado;
    private JPanel panelComponentesDinamicos;
    private JPanel panelLayoutDinamico;
    private JPanel panel;
    private JLabel labelSelecc;
    private JSeparator separator;
    private JPanel pnlAutores;
    private JScrollPane scrollPane_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    UI_Principal window = new UI_Principal();
		    window.frame.setVisible(true);
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
	frame = new JFrame();
	frame.setTitle("Restaurante La Josefina - Menu de Empleado");
	frame.setBounds(100, 100, 974, 665);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(new BorderLayout(0, 0));

	splitPane = new JSplitPane();
	frame.getContentPane().add(splitPane, BorderLayout.CENTER);
	{
	    scrollPane = new JScrollPane();
	    scrollPane.setMinimumSize(new Dimension(200, 25));
	    splitPane.setLeftComponent(scrollPane);
	    {
		tree = new JTree();
		tree.addTreeSelectionListener(new TreeTreeSelectionListener());
		tree.setCellRenderer(new MiRenderizadoArbol());
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Inicio") {
		    {
			DefaultMutableTreeNode node_1;
			node_1 = new DefaultMutableTreeNode("Ejemplo Teclado");
			node_1.add(new DefaultMutableTreeNode("Ayuda"));
			node_1.add(new DefaultMutableTreeNode("Adjunto"));
			add(node_1);
			node_1 = new DefaultMutableTreeNode("Ejemplo Componentes Dinámicos");
			node_1.add(new DefaultMutableTreeNode("Ayuda"));
			node_1.add(new DefaultMutableTreeNode("Adjunto"));
			add(node_1);
			node_1 = new DefaultMutableTreeNode("Ejemplo Layout Dinámicos");
			node_1.add(new DefaultMutableTreeNode("Ayuda"));
			node_1.add(new DefaultMutableTreeNode("Adjunto"));
			add(node_1);
		    }
		}));
		scrollPane.setViewportView(tree);
	    }
	    {
		panel = new JPanel();
		panel.setMinimumSize(new Dimension(10, 31));
		scrollPane.setColumnHeaderView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		{
		    labelSelecc = new JLabel("Inicio");
		    labelSelecc.setMinimumSize(new Dimension(25, 27));
		    labelSelecc.setHorizontalAlignment(SwingConstants.CENTER);
		    labelSelecc.setFont(new Font("Tahoma", Font.ITALIC, 13));
		    panel.add(labelSelecc, BorderLayout.CENTER);
		}
		{
		    separator = new JSeparator();
		    panel.add(separator, BorderLayout.SOUTH);
		}
	    }
	}
	{
	    panelCard = new JPanel();
	    splitPane.setRightComponent(panelCard);
	    panelCard.setLayout(new CardLayout(0, 0));
	    {
		panelTeclado = new tecladoNum();
		panelCard.add(panelTeclado, "Ejemplo Teclado");
	    }
	    {
		panelComponentesDinamicos = new MiPanelAutores();
		panelCard.add(panelComponentesDinamicos, "Ejemplo Componentes Dinámicos");
		panelComponentesDinamicos.setLayout(new BorderLayout(0, 0));
		{
		    pnlAutores = new MiPanelAutores();
		    pnlAutores.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		    panelComponentesDinamicos.add(pnlAutores, BorderLayout.CENTER);
		}
	    }
	    {
		panelLayoutDinamico = new MiPanelGridConfigurable();
		panelCard.add(panelLayoutDinamico, "Ejemplo Layout Dinámicos");
	    }
	}

    }

    private class TreeTreeSelectionListener implements TreeSelectionListener {
	public void valueChanged(TreeSelectionEvent e) {
	    labelSelecc.setText(("Nodo seleccionado: " + e.getPath().getLastPathComponent()));

	    String nodo = (e.getPath().getLastPathComponent()).toString();
	    switch (nodo) {
	    case "Ejemplo Teclado":
	    case "Ejemplo Componentes Dinámicos":
	    case "Ejemplo Layout Dinámicos":
		((CardLayout) panelCard.getLayout()).show(panelCard, nodo);
	    }
	}
    }
}
