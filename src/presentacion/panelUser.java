package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import dominio.Usuario;
import dominio.util;
import persistencia.Agente;

public class panelUser extends JPanel {
    private JLabel lblCamarero;
    private JLabel lblNombre;
    private JLabel lblFechaDeUltimo;
    private JLabel lblMarEnero;
    private JSeparator separator;
    private JLabel lblComida;
    private JLabel lblPedido;
    private JLabel lblProductos;
    private JLabel lblTotal;
    private JLabel lblTotalEU;
    private JSeparator separator_1;
    private JLabel lblConfig;
    private JLabel lblLogout;
    private JLabel lblGestUsuarios;
    private Usuario user1;
    private util ut = new util();
    private JFrame frame1;

    /**
     * Create the panel.
     * 
     * @param user
     * @param frame
     */
    public panelUser(Usuario user, JFrame frame) {
	setBorder(null);
	frame1 = frame;
	user1 = user;
	setBackground(new Color(38, 38, 38));
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 62, 0, 40, 189, 250, 0, 0, 0, 92, 116, 166, 0, 89, 0, 0, 57, 75, 74,
		68, 24, 0 };
	gridBagLayout.rowHeights = new int[] { 69, 73, 0 };
	gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
	gridBagLayout.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
	setLayout(gridBagLayout);
	{
	    lblCamarero = new JLabel("");
	    lblCamarero.setToolTipText("Imagen de Perfil");
	    lblCamarero.setIcon(new ImageIcon(panelUser.class.getResource("/recursos/panelUser/camarero.png")));
	    GridBagConstraints gbc_lblCamarero = new GridBagConstraints();
	    gbc_lblCamarero.insets = new Insets(0, 0, 0, 5);
	    gbc_lblCamarero.gridheight = 2;
	    gbc_lblCamarero.gridx = 1;
	    gbc_lblCamarero.gridy = 0;
	    add(lblCamarero, gbc_lblCamarero);
	}
	{
	    lblNombre = new JLabel(user.getNombre());
	    lblNombre.setForeground(Color.WHITE);
	    lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_lblNombre = new GridBagConstraints();
	    gbc_lblNombre.anchor = GridBagConstraints.SOUTHWEST;
	    gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNombre.gridx = 3;
	    gbc_lblNombre.gridy = 0;
	    add(lblNombre, gbc_lblNombre);
	}
	{
	    separator = new JSeparator();
	    separator.setBackground(new Color(0, 153, 153));
	    separator.setForeground(new Color(0, 153, 153));
	    separator.setSize(new Dimension(2, 156));
	    separator.setOpaque(true);
	    separator.setMinimumSize(new Dimension(2, 156));
	    separator.setPreferredSize(new Dimension(2, 156));
	    separator.setOrientation(SwingConstants.VERTICAL);
	    GridBagConstraints gbc_separator = new GridBagConstraints();
	    gbc_separator.gridheight = 2;
	    gbc_separator.insets = new Insets(0, 0, 0, 5);
	    gbc_separator.gridx = 6;
	    gbc_separator.gridy = 0;
	    add(separator, gbc_separator);
	}
	{
	    lblComida = new JLabel("");
	    lblComida.setHorizontalAlignment(SwingConstants.CENTER);
	    lblComida.setIcon(new ImageIcon(panelUser.class.getResource("/recursos/panelUser/comida.png")));
	    GridBagConstraints gbc_lblComida = new GridBagConstraints();
	    gbc_lblComida.gridheight = 2;
	    gbc_lblComida.insets = new Insets(0, 0, 0, 5);
	    gbc_lblComida.gridx = 8;
	    gbc_lblComida.gridy = 0;
	    add(lblComida, gbc_lblComida);
	}
	{
	    lblPedido = new JLabel("Pedido Actual: ");
	    lblPedido.setForeground(new Color(0, 183, 183));
	    lblPedido.setFont(new Font("SansSerif", Font.BOLD, 22));
	    lblPedido.setHorizontalAlignment(SwingConstants.CENTER);
	    GridBagConstraints gbc_lblPedido = new GridBagConstraints();
	    gbc_lblPedido.gridheight = 2;
	    gbc_lblPedido.insets = new Insets(0, 0, 0, 5);
	    gbc_lblPedido.gridx = 9;
	    gbc_lblPedido.gridy = 0;
	    add(lblPedido, gbc_lblPedido);
	}
	{
	    lblProductos = new JLabel("0 productos");
	    lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
	    lblProductos.setForeground(new Color(255, 255, 255));
	    lblProductos.setFont(new Font("SansSerif", Font.BOLD, 22));
	    GridBagConstraints gbc_lblProductos = new GridBagConstraints();
	    gbc_lblProductos.anchor = GridBagConstraints.WEST;
	    gbc_lblProductos.gridheight = 2;
	    gbc_lblProductos.insets = new Insets(0, 0, 0, 5);
	    gbc_lblProductos.gridx = 10;
	    gbc_lblProductos.gridy = 0;
	    add(lblProductos, gbc_lblProductos);
	}
	{
	    lblTotal = new JLabel("Total: ");
	    lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTotal.setForeground(new Color(0, 183, 183));
	    lblTotal.setFont(new Font("SansSerif", Font.BOLD, 22));
	    GridBagConstraints gbc_lblTotal = new GridBagConstraints();
	    gbc_lblTotal.gridheight = 2;
	    gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
	    gbc_lblTotal.gridx = 11;
	    gbc_lblTotal.gridy = 0;
	    add(lblTotal, gbc_lblTotal);
	}
	{
	    lblTotalEU = new JLabel("0 \u20AC");
	    lblTotalEU.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTotalEU.setForeground(Color.WHITE);
	    lblTotalEU.setFont(new Font("SansSerif", Font.BOLD, 22));
	    GridBagConstraints gbc_lblTotalEU = new GridBagConstraints();
	    gbc_lblTotalEU.anchor = GridBagConstraints.WEST;
	    gbc_lblTotalEU.gridheight = 2;
	    gbc_lblTotalEU.insets = new Insets(0, 0, 0, 5);
	    gbc_lblTotalEU.gridx = 12;
	    gbc_lblTotalEU.gridy = 0;
	    add(lblTotalEU, gbc_lblTotalEU);
	}
	{
	    separator_1 = new JSeparator();
	    separator_1.setSize(new Dimension(2, 156));
	    separator_1.setPreferredSize(new Dimension(2, 156));
	    separator_1.setOrientation(SwingConstants.VERTICAL);
	    separator_1.setOpaque(true);
	    separator_1.setMinimumSize(new Dimension(2, 156));
	    separator_1.setForeground(new Color(0, 153, 153));
	    separator_1.setBackground(new Color(0, 153, 153));
	    GridBagConstraints gbc_separator_1 = new GridBagConstraints();
	    gbc_separator_1.gridheight = 2;
	    gbc_separator_1.insets = new Insets(0, 0, 0, 5);
	    gbc_separator_1.gridx = 14;
	    gbc_separator_1.gridy = 0;
	    add(separator_1, gbc_separator_1);
	}
	{
	    lblGestUsuarios = new JLabel("");
	    lblGestUsuarios.setToolTipText("Gestion de Usuarios ");
	    lblGestUsuarios.addMouseListener(new LblGestUsuariosMouseListener());
	    lblGestUsuarios
		    .setIcon(new ImageIcon(panelUser.class.getResource("/recursos/panelUser/manejoUsuarios.png")));
	    GridBagConstraints gbc_lblGestUsuarios = new GridBagConstraints();
	    gbc_lblGestUsuarios.gridheight = 2;
	    gbc_lblGestUsuarios.insets = new Insets(0, 0, 0, 5);
	    gbc_lblGestUsuarios.gridx = 16;
	    gbc_lblGestUsuarios.gridy = 0;
	    add(lblGestUsuarios, gbc_lblGestUsuarios);
	    if (!user.getUser().equalsIgnoreCase("admin")) {
		lblGestUsuarios.setEnabled(false);
	    }
	}
	{
	    lblConfig = new JLabel("");
	    lblConfig.setToolTipText("Configuraci\u00F3n");
	    lblConfig.setIcon(new ImageIcon(panelUser.class.getResource("/recursos/panelUser/icons8-ajustes-68.png")));
	    GridBagConstraints gbc_lblConfig = new GridBagConstraints();
	    gbc_lblConfig.gridheight = 2;
	    gbc_lblConfig.insets = new Insets(0, 0, 0, 5);
	    gbc_lblConfig.gridx = 17;
	    gbc_lblConfig.gridy = 0;
	    add(lblConfig, gbc_lblConfig);
	}
	{
	    lblLogout = new JLabel("");
	    lblLogout.setToolTipText("Cerrar Sesi\u00F3n");
	    lblLogout.addMouseListener(new LblLogoutMouseListener());
	    lblLogout.setIcon(new ImageIcon(panelUser.class.getResource("/recursos/panelUser/icons8-apagar-85.png")));
	    GridBagConstraints gbc_lblLogout = new GridBagConstraints();
	    gbc_lblLogout.gridheight = 2;
	    gbc_lblLogout.insets = new Insets(0, 0, 0, 5);
	    gbc_lblLogout.gridx = 18;
	    gbc_lblLogout.gridy = 0;
	    add(lblLogout, gbc_lblLogout);
	}
	{
	    lblFechaDeUltimo = new JLabel("Fecha de ultimo acceso: ");
	    lblFechaDeUltimo.setForeground(Color.WHITE);
	    lblFechaDeUltimo.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_lblFechaDeUltimo = new GridBagConstraints();
	    gbc_lblFechaDeUltimo.anchor = GridBagConstraints.EAST;
	    gbc_lblFechaDeUltimo.insets = new Insets(0, 0, 0, 5);
	    gbc_lblFechaDeUltimo.gridx = 3;
	    gbc_lblFechaDeUltimo.gridy = 1;
	    add(lblFechaDeUltimo, gbc_lblFechaDeUltimo);
	}
	{
	    lblMarEnero = new JLabel(user.getUltAcc());
	    lblMarEnero.setForeground(Color.WHITE);
	    lblMarEnero.setHorizontalAlignment(SwingConstants.LEFT);
	    lblMarEnero.setFont(new Font("SansSerif", Font.PLAIN, 17));

	    GridBagConstraints gbc_lblMarEnero = new GridBagConstraints();
	    gbc_lblMarEnero.insets = new Insets(0, 0, 0, 5);
	    gbc_lblMarEnero.gridx = 4;
	    gbc_lblMarEnero.gridy = 1;
	    add(lblMarEnero, gbc_lblMarEnero);
	}

    }

    private class LblGestUsuariosMouseListener extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent arg0) {
	    if (user1.getUser().equalsIgnoreCase("admin")) {
		gestUsuarios gest = new gestUsuarios();
		gest.setVisible(true);
	    }
	}
    }

    private class LblLogoutMouseListener extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent arg0) {
	    Agente ag = new Agente();
	    Usuario[] uwu = ag.leerUsuarios();
	    for (int i = 0; i < uwu.length; i++) {
		if (uwu[i].getUser().equalsIgnoreCase(user1.getUser()))
		    uwu[i].setUltAcc(ut.genFecha());
	    }
	    ag.escribirUsuarios(uwu);
	    frame1.dispose();
	    UI_Login ui = new UI_Login();
	    ui.setVisible(true);
	    ui.setLocationRelativeTo(null);
	}
    }
}
