package presentacion;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import dominio.Producto;
import dominio.util;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelProdReut extends JPanel {
    private JLabel lblNombre;
    private JLabel lblDesc;
    private JLabel lblAlerg;
    private JSeparator separator;
    private JLabel lblFoto;
    private JLabel lblPrecio;
    private JButton btnAdd;
    private JButton btnEditar;
    private JPanel panelAlerg;
    private util ut;
    private Producto pro;

    public panelProdReut(Producto prod, util utiles) {
	ut=utiles;
	pro=prod;
	setMinimumSize(new Dimension(500, 150));
	setPreferredSize(new Dimension(826, 176));
	setMaximumSize(new Dimension(500, 152));
	inicializar(pro);
    }

    private void inicializar(Producto pro) {
	setOpaque(false);
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 36, 20, 64, 615, 58, 0, 0, 56, 0 };
	gridBagLayout.rowHeights = new int[] { 32, 14, 14, 49, 44, 15, 0 };
	gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	setLayout(gridBagLayout);
	{
	    separator = new JSeparator();
	    separator.setMinimumSize(new Dimension(0, 2));
	    GridBagConstraints gbc_separator = new GridBagConstraints();
	    gbc_separator.anchor = GridBagConstraints.SOUTH;
	    gbc_separator.gridwidth = 7;
	    gbc_separator.fill = GridBagConstraints.HORIZONTAL;
	    gbc_separator.insets = new Insets(0, 0, 5, 0);
	    gbc_separator.gridx = 1;
	    gbc_separator.gridy = 0;
	    add(separator, gbc_separator);
	}
	{
	    lblNombre = new JLabel(pro.getNombre());
	    lblNombre.setFont(new Font("SansSerif", Font.BOLD, 19));
	    GridBagConstraints gbc_lblNombre = new GridBagConstraints();
	    gbc_lblNombre.gridwidth = 2;
	    gbc_lblNombre.anchor = GridBagConstraints.NORTH;
	    gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
	    gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNombre.gridx = 2;
	    gbc_lblNombre.gridy = 1;
	    add(lblNombre, gbc_lblNombre);
	}
	{
	    lblFoto = new JLabel("");
	    lblFoto.setIcon(pseudoRenderFoto(pro.getTipo()));
	    GridBagConstraints gbc_lblFoto = new GridBagConstraints();
	    gbc_lblFoto.gridheight = 3;
	    gbc_lblFoto.gridwidth = 2;
	    gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
	    gbc_lblFoto.gridx = 1;
	    gbc_lblFoto.gridy = 2;
	    add(lblFoto, gbc_lblFoto);
	}
	{
	    lblDesc = new JLabel("<html>" + pro.getDescripcion() + "</html>");
	    lblDesc.setFont(new Font("SansSerif", Font.PLAIN, 16));
	    GridBagConstraints gbc_lblDesc = new GridBagConstraints();
	    gbc_lblDesc.gridheight = 2;
	    gbc_lblDesc.gridwidth = 2;
	    gbc_lblDesc.anchor = GridBagConstraints.NORTH;
	    gbc_lblDesc.fill = GridBagConstraints.HORIZONTAL;
	    gbc_lblDesc.insets = new Insets(0, 0, 5, 5);
	    gbc_lblDesc.gridx = 3;
	    gbc_lblDesc.gridy = 2;
	    add(lblDesc, gbc_lblDesc);
	}
	{
	    btnAdd = new JButton("A\u00F1adir al pedido");
	    btnAdd.addActionListener(new BtnAddActionListener());
	    btnAdd.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_btnAdd = new GridBagConstraints();
	    gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
	    gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
	    gbc_btnAdd.gridx = 7;
	    gbc_btnAdd.gridy = 2;
	    add(btnAdd, gbc_btnAdd);
	}
	{
	    btnEditar = new JButton("Editar");
	    btnEditar.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_btnEditar = new GridBagConstraints();
	    gbc_btnEditar.fill = GridBagConstraints.HORIZONTAL;
	    gbc_btnEditar.insets = new Insets(0, 0, 5, 0);
	    gbc_btnEditar.gridx = 7;
	    gbc_btnEditar.gridy = 3;
	    add(btnEditar, gbc_btnEditar);
	}
	{
	    panelAlerg = new JPanel();
	    panelAlerg.setOpaque(false);
	    GridBagConstraints gbc_panelAlerg = new GridBagConstraints();
	    gbc_panelAlerg.anchor = GridBagConstraints.WEST;
	    gbc_panelAlerg.insets = new Insets(0, 0, 5, 5);
	    gbc_panelAlerg.fill = GridBagConstraints.VERTICAL;
	    gbc_panelAlerg.gridx = 3;
	    gbc_panelAlerg.gridy = 4;
	    add(panelAlerg, gbc_panelAlerg);
	    panelAlerg.setLayout(new GridLayout(1, 0, 0, 0));
	}
	{
	    lblPrecio = new JLabel(pro.getPrecio());
	    lblPrecio.setFont(new Font("SansSerif", Font.PLAIN, 20));
	    GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
	    gbc_lblPrecio.anchor = GridBagConstraints.WEST;
	    gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPrecio.gridx = 4;
	    gbc_lblPrecio.gridy = 4;
	    add(lblPrecio, gbc_lblPrecio);
	}
	showAlergenos(pro.getAlergenos());

    }

    private void showAlergenos(String alerg) {
	StringTokenizer token = new StringTokenizer(alerg, ",");

	while (token.hasMoreTokens()) {
	    String al = token.nextToken();
	    System.out.println(al);
	    JLabel lblAler = new JLabel();
	    try {
		if (!al.equalsIgnoreCase("Ninguno")) {
		    lblAler.setToolTipText("Puede contener " + al);
		    lblAler.setIcon(new ImageIcon(addUser.class.getResource("/recursos/alergenos/" + al + ".png")));
		} else {
		    lblAler.setToolTipText("Plato libre de alergenos");
		    lblAler.setIcon(new ImageIcon(addUser.class.getResource("/recursos/alergenos/Ninguno.png")));
		}
	    } catch (Exception e) {
		lblAler.setToolTipText("Puede contener " + al);
		lblAler.setIcon(new ImageIcon(addUser.class.getResource("/recursos/alergenos/noImage.png")));
	    }
	    panelAlerg.add(lblAler);

	}

    }

    private ImageIcon pseudoRenderFoto(String tipo) {
	String ruta;
	switch (tipo) {
	case "Carnes":
	    ruta = "/recursos/fotos/fotoCarne.png";
	    break;
	case "Pescados":
	    ruta = "/recursos/fotos/fotoPescado.png";
	    break;
	case "Pastas":
	    ruta = "/recursos/fotos/fotoPasta.png";
	    break;
	case "Vinos":
	    ruta = "/recursos/fotos/fotoVino.png";
	    break;
	case "Cervezas":
	    ruta = "/recursos/fotos/fotoCerve.png";
	    break;
	case "Helados":
	    ruta = "/recursos/fotos/fotoHelado.png";
	    break;
	case "Frutas":
	    ruta = "/recursos/fotos/fotoFruta.png";
	    break;
	case "Men�s":
	    ruta = "/recursos/fotos/fotoMenu.png";
	    break;
	case "Promociones":
	    ruta = "/recursos/fotos/fotoPromosio.png";
	    break;
	default:
	    ruta = "/recursos/fotos/noFoto.png";
	    break;
	}
	ImageIcon ic = new ImageIcon(panelProdReut.class.getResource(ruta));
	return ic;
    }
	private class BtnAddActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		    ut.anadirAtabla(pro);
		}
	}
}
