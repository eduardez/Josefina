package presentacion;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import dominio.Cliente;
import dominio.Producto;
import dominio.util;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class panelCliente extends JPanel {
    private JLabel lblNombre;
    private JSeparator separator;
    private JLabel lblFoto;
    private JButton btnPedidos;
    private JButton btnEditar;
    private util ut;
    private Cliente cli;
    private JLabel lblNumeroDeCliente;
    private JLabel lblNcli;
    private JLabel lblDireccion;
    private JLabel lblDir;
    private JLabel lblTelefono;
    private JLabel lblTel;
    private JLabel lblCorreoElectronico;
    private JLabel lblCorreo;
    private JLabel lblPuntosAcuales;
    private JLabel lblPact;
    private JLabel lblPuntosCanjeados;
    private JLabel lblPcaj;
    private JLabel lblFechaDeCaducidad;
    private JLabel lblFcad;
    private JPanel panel;
    private JLabel lblDesc;

    public panelCliente(Cliente clie, util utiles) {
	ut = utiles;
	cli = clie;
	setMinimumSize(new Dimension(500, 150));
	setPreferredSize(new Dimension(1031, 251));
	setMaximumSize(new Dimension(500, 152));
	inicializar(cli);
    }

    private void inicializar(Cliente cli) {
	setOpaque(false);
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 26, 20, 64, 0, 0, 136, 124, 111, 0, 99, 56, 0, 22, 0 };
	gridBagLayout.rowHeights = new int[] { 32, 14, 14, 49, 44, 15, 0 };
	gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
		Double.MIN_VALUE };
	gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
	setLayout(gridBagLayout);
	{
	    separator = new JSeparator();
	    separator.setMinimumSize(new Dimension(0, 2));
	    GridBagConstraints gbc_separator = new GridBagConstraints();
	    gbc_separator.anchor = GridBagConstraints.SOUTH;
	    gbc_separator.gridwidth = 11;
	    gbc_separator.fill = GridBagConstraints.HORIZONTAL;
	    gbc_separator.insets = new Insets(0, 0, 5, 5);
	    gbc_separator.gridx = 1;
	    gbc_separator.gridy = 0;
	    add(separator, gbc_separator);
	}
	{
	    lblNombre = new JLabel(cli.getNombre());
	    lblNombre.setFont(new Font("SansSerif", Font.BOLD, 19));
	    GridBagConstraints gbc_lblNombre = new GridBagConstraints();
	    gbc_lblNombre.gridwidth = 6;
	    gbc_lblNombre.anchor = GridBagConstraints.NORTH;
	    gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
	    gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNombre.gridx = 2;
	    gbc_lblNombre.gridy = 1;
	    add(lblNombre, gbc_lblNombre);
	}
	{
	    lblFoto = new JLabel("");
	    lblFoto.setIcon(pseudoRenderFoto());
	    GridBagConstraints gbc_lblFoto = new GridBagConstraints();
	    gbc_lblFoto.gridheight = 3;
	    gbc_lblFoto.gridwidth = 3;
	    gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
	    gbc_lblFoto.gridx = 1;
	    gbc_lblFoto.gridy = 2;
	    add(lblFoto, gbc_lblFoto);
	}
	{
	    btnPedidos = new JButton("Ver pedidos");
	    btnPedidos.setBackground(Color.WHITE);
	    {
		lblNumeroDeCliente = new JLabel("N\u00BA Cliente: ");
		lblNumeroDeCliente.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNumeroDeCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNumeroDeCliente = new GridBagConstraints();
		gbc_lblNumeroDeCliente.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroDeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroDeCliente.gridx = 4;
		gbc_lblNumeroDeCliente.gridy = 2;
		add(lblNumeroDeCliente, gbc_lblNumeroDeCliente);
	    }
	    {
		lblNcli = new JLabel(cli.getNumCliente());
		lblNcli.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNcli.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNcli = new GridBagConstraints();
		gbc_lblNcli.anchor = GridBagConstraints.WEST;
		gbc_lblNcli.insets = new Insets(0, 0, 5, 5);
		gbc_lblNcli.gridx = 5;
		gbc_lblNcli.gridy = 2;
		add(lblNcli, gbc_lblNcli);
	    }
	    {
		lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 6;
		gbc_lblDireccion.gridy = 2;
		add(lblDireccion, gbc_lblDireccion);
	    }
	    {
		lblDir = new JLabel(cli.getDireccion());
		lblDir.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblDir.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDir = new GridBagConstraints();
		gbc_lblDir.gridwidth = 2;
		gbc_lblDir.anchor = GridBagConstraints.WEST;
		gbc_lblDir.insets = new Insets(0, 0, 5, 5);
		gbc_lblDir.gridx = 7;
		gbc_lblDir.gridy = 2;
		add(lblDir, gbc_lblDir);
	    }
	    btnPedidos.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_btnPedidos = new GridBagConstraints();
	    gbc_btnPedidos.fill = GridBagConstraints.HORIZONTAL;
	    gbc_btnPedidos.insets = new Insets(0, 0, 5, 5);
	    gbc_btnPedidos.gridx = 10;
	    gbc_btnPedidos.gridy = 2;
	    add(btnPedidos, gbc_btnPedidos);
	}
	{
	    btnEditar = new JButton("Editar cliente");
	    btnEditar.setBackground(Color.WHITE);
	    btnEditar.addActionListener(new BtnEditarActionListener());
	    {
		lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 4;
		gbc_lblTelefono.gridy = 3;
		add(lblTelefono, gbc_lblTelefono);
	    }
	    {
		lblTel = new JLabel(String.valueOf(cli.getNumTel()));
		lblTel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblTel = new GridBagConstraints();
		gbc_lblTel.anchor = GridBagConstraints.WEST;
		gbc_lblTel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTel.gridx = 5;
		gbc_lblTel.gridy = 3;
		add(lblTel, gbc_lblTel);
	    }
	    {
		lblCorreoElectronico = new JLabel("Correo electronico: ");
		lblCorreoElectronico.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCorreoElectronico.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCorreoElectronico = new GridBagConstraints();
		gbc_lblCorreoElectronico.anchor = GridBagConstraints.EAST;
		gbc_lblCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoElectronico.gridx = 6;
		gbc_lblCorreoElectronico.gridy = 3;
		add(lblCorreoElectronico, gbc_lblCorreoElectronico);
	    }
	    {
		lblCorreo = new JLabel(cli.getCorreo());
		lblCorreo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.gridwidth = 2;
		gbc_lblCorreo.anchor = GridBagConstraints.WEST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 7;
		gbc_lblCorreo.gridy = 3;
		add(lblCorreo, gbc_lblCorreo);
	    }
	    btnEditar.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_btnEditar = new GridBagConstraints();
	    gbc_btnEditar.fill = GridBagConstraints.HORIZONTAL;
	    gbc_btnEditar.insets = new Insets(0, 0, 5, 5);
	    gbc_btnEditar.gridx = 10;
	    gbc_btnEditar.gridy = 3;
	    add(btnEditar, gbc_btnEditar);
	}
	{
	    lblPuntosAcuales = new JLabel("Puntos Actuales: ");
	    lblPuntosAcuales.setForeground(new Color(204, 0, 0));
	    lblPuntosAcuales.setFont(new Font("SansSerif", Font.PLAIN, 15));
	    lblPuntosAcuales.setHorizontalAlignment(SwingConstants.RIGHT);
	    GridBagConstraints gbc_lblPuntosAcuales = new GridBagConstraints();
	    gbc_lblPuntosAcuales.anchor = GridBagConstraints.EAST;
	    gbc_lblPuntosAcuales.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPuntosAcuales.gridx = 4;
	    gbc_lblPuntosAcuales.gridy = 4;
	    add(lblPuntosAcuales, gbc_lblPuntosAcuales);
	}
	{
	    lblPact = new JLabel(String.valueOf(cli.getpActuales()));
	    lblPact.setFont(new Font("SansSerif", Font.PLAIN, 15));
	    lblPact.setHorizontalAlignment(SwingConstants.LEFT);
	    GridBagConstraints gbc_lblPact = new GridBagConstraints();
	    gbc_lblPact.anchor = GridBagConstraints.WEST;
	    gbc_lblPact.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPact.gridx = 5;
	    gbc_lblPact.gridy = 4;
	    add(lblPact, gbc_lblPact);
	}
	{
	    lblPuntosCanjeados = new JLabel("Puntos Canjeados: ");
	    lblPuntosCanjeados.setForeground(new Color(204, 0, 0));
	    lblPuntosCanjeados.setFont(new Font("SansSerif", Font.PLAIN, 15));
	    lblPuntosCanjeados.setHorizontalAlignment(SwingConstants.RIGHT);
	    GridBagConstraints gbc_lblPuntosCanjeados = new GridBagConstraints();
	    gbc_lblPuntosCanjeados.anchor = GridBagConstraints.EAST;
	    gbc_lblPuntosCanjeados.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPuntosCanjeados.gridx = 6;
	    gbc_lblPuntosCanjeados.gridy = 4;
	    add(lblPuntosCanjeados, gbc_lblPuntosCanjeados);
	}
	{
	    lblPcaj = new JLabel(String.valueOf(cli.getpCanjeados()));
	    lblPcaj.setFont(new Font("SansSerif", Font.PLAIN, 15));
	    lblPcaj.setHorizontalAlignment(SwingConstants.LEFT);
	    GridBagConstraints gbc_lblPcaj = new GridBagConstraints();
	    gbc_lblPcaj.anchor = GridBagConstraints.WEST;
	    gbc_lblPcaj.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPcaj.gridx = 7;
	    gbc_lblPcaj.gridy = 4;
	    add(lblPcaj, gbc_lblPcaj);
	}
	{
	    lblFechaDeCaducidad = new JLabel("Fecha de Caducidad: ");
	    lblFechaDeCaducidad.setForeground(new Color(204, 0, 0));
	    lblFechaDeCaducidad.setFont(new Font("SansSerif", Font.PLAIN, 15));
	    GridBagConstraints gbc_lblFechaDeCaducidad = new GridBagConstraints();
	    gbc_lblFechaDeCaducidad.insets = new Insets(0, 0, 5, 5);
	    gbc_lblFechaDeCaducidad.gridx = 8;
	    gbc_lblFechaDeCaducidad.gridy = 4;
	    add(lblFechaDeCaducidad, gbc_lblFechaDeCaducidad);
	}
	{
	    lblFcad = new JLabel(cli.getpCaducidad().toString());
	    lblFcad.setFont(new Font("SansSerif", Font.PLAIN, 15));
	    lblFcad.setHorizontalAlignment(SwingConstants.LEFT);
	    GridBagConstraints gbc_lblFcad = new GridBagConstraints();
	    gbc_lblFcad.insets = new Insets(0, 0, 5, 5);
	    gbc_lblFcad.gridx = 9;
	    gbc_lblFcad.gridy = 4;
	    add(lblFcad, gbc_lblFcad);
	}
	{
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Anotaciones", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 153)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 4;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		{
			lblDesc = new JLabel("  "+cli.getDescripcion());
			lblDesc.setHorizontalAlignment(SwingConstants.LEFT);
			lblDesc.setVerticalAlignment(SwingConstants.TOP);
			lblDesc.setFont(new Font("SansSerif", Font.PLAIN, 15));
			panel.add(lblDesc, BorderLayout.CENTER);
		}
	}

    }

    private ImageIcon pseudoRenderFoto() {
	int numero = (int) (Math.random() * 50) + 1;
	String genero = null;
	if (numero < 25) {
	    genero = "M";
	} else {
	    genero = "F";
	}
	ImageIcon ic = new ImageIcon(panelProdReut.class.getResource("/recursos/fotos/fotoCliente" + genero + ".png"));
	return ic;
    }


    private class BtnEditarActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	     addCliente pnlCli = new addCliente(cli);
	     pnlCli.setVisible(true);
	     pnlCli.setAlwaysOnTop(true);
	     pnlCli.setLocationRelativeTo(null);
	}
    }
}
