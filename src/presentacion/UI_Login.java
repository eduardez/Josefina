package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dominio.Usuario;
import persistencia.Agente;

public class UI_Login extends JFrame {

    private JPanel contentPane;
    private JPanel panIcon;
    private JPanel panAut;
    private JPanel panAccesi;
    private JLabel lblLogo;
    private JLabel lblRestauranteLaJosefina;
    private JSeparator separator;
    private JLabel lblUsuario;
    private JLabel lblContrasea;
    private JButton btnEntrar;
    private JTextField txtUsuario;

    /* - - - - - Variables del Programa - - - - - - */
    private String fuente = "SansSerif";
    private JPasswordField txtContra;
    private JLabel lblRecuperar;
    private Agente ag = new Agente();
    public Usuario[] users = ag.leerUsuarios();;
    private int userIndex;
    private JLabel lblAvisouser;
    private JLabel lblAvisoPass;
    private JLabel lblIntern;

    public UI_Login() {
	setTitle("Restaurante La Josefina - Acceso a Personal");
	setMaximumSize(new Dimension(1050, 750));
	setMinimumSize(new Dimension(880, 630));
	// ---------- CAMBIAR LOOK AND FEEL ----------
	try {
	    // Set cross-platform Java L&F (also called "Metal")
	   UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");// O este otro javax.swing.plaf.metal.MetalLookAndFeel
	} catch (Exception e) {
	    System.out.println("ERROR en L&F");
	}
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 990, 689);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 180, 188));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	GridBagLayout gbl_contentPane = new GridBagLayout();
	gbl_contentPane.columnWidths = new int[] { 43, 523, 0, 481, 37, 0 };
	gbl_contentPane.rowHeights = new int[] { 598, 69, 0 };
	gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
	gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
	contentPane.setLayout(gbl_contentPane);
	{
	    panIcon = new JPanel();
	    panIcon.setOpaque(false);
	    GridBagConstraints gbc_panIcon = new GridBagConstraints();
	    gbc_panIcon.insets = new Insets(0, 0, 5, 5);
	    gbc_panIcon.fill = GridBagConstraints.BOTH;
	    gbc_panIcon.gridx = 1;
	    gbc_panIcon.gridy = 0;
	    contentPane.add(panIcon, gbc_panIcon);
	    GridBagLayout gbl_panIcon = new GridBagLayout();
	    gbl_panIcon.columnWidths = new int[] { 0, 0 };
	    gbl_panIcon.rowHeights = new int[] { 480, 88, 0 };
	    gbl_panIcon.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
	    gbl_panIcon.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
	    panIcon.setLayout(gbl_panIcon);
	    {
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(UI_Login.class.getResource("/recursos/logo.png")));
		GridBagConstraints gbc_lblLogo = new GridBagConstraints();
		gbc_lblLogo.anchor = GridBagConstraints.SOUTH;
		gbc_lblLogo.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogo.gridx = 0;
		gbc_lblLogo.gridy = 0;
		panIcon.add(lblLogo, gbc_lblLogo);
	    }
	    {
		lblRestauranteLaJosefina = new JLabel("Restaurante La Josefina");
		lblRestauranteLaJosefina.setFont(new Font(fuente, Font.PLAIN, 25));
		lblRestauranteLaJosefina.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblRestauranteLaJosefina = new GridBagConstraints();
		gbc_lblRestauranteLaJosefina.anchor = GridBagConstraints.NORTH;
		gbc_lblRestauranteLaJosefina.gridx = 0;
		gbc_lblRestauranteLaJosefina.gridy = 1;
		panIcon.add(lblRestauranteLaJosefina, gbc_lblRestauranteLaJosefina);
	    }
	}
	{
	    separator = new JSeparator();
	    separator.setOpaque(true);
	    separator.setBackground(new Color(38, 38, 38));
	    separator.setForeground(new Color(38, 38, 38));
	    separator.setPreferredSize(new Dimension(2, 19498));
	    separator.setMaximumSize(new Dimension(2, 19998));
	    separator.setMinimumSize(new Dimension(2, 2));
	    separator.setOrientation(SwingConstants.VERTICAL);
	    GridBagConstraints gbc_separator = new GridBagConstraints();
	    gbc_separator.fill = GridBagConstraints.VERTICAL;
	    gbc_separator.insets = new Insets(0, 0, 5, 5);
	    gbc_separator.gridx = 2;
	    gbc_separator.gridy = 0;
	    contentPane.add(separator, gbc_separator);
	}
	{
	    panAut = new JPanel();
	    panAut.setOpaque(false);
	    GridBagConstraints gbc_panAut = new GridBagConstraints();
	    gbc_panAut.insets = new Insets(0, 0, 5, 5);
	    gbc_panAut.fill = GridBagConstraints.BOTH;
	    gbc_panAut.gridx = 3;
	    gbc_panAut.gridy = 0;
	    contentPane.add(panAut, gbc_panAut);
	    GridBagLayout gbl_panAut = new GridBagLayout();
	    gbl_panAut.columnWidths = new int[] { 127, 289, 69, 0 };
	    gbl_panAut.rowHeights = new int[] { 125, -60, 0, -232, -188, 120, 116, 0 };
	    gbl_panAut.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
	    gbl_panAut.rowWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
	    panAut.setLayout(gbl_panAut);
	    {
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 19));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.SOUTH;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 1;
		panAut.add(lblUsuario, gbc_lblUsuario);
	    }
	    {
		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.addKeyListener(new TxtUsuarioKeyListener());
		txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 19));
		txtUsuario.setMinimumSize(new Dimension(6, 38));
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.anchor = GridBagConstraints.SOUTH;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 1;
		panAut.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
	    }
	    {
		lblAvisouser = new JLabel("");
		lblAvisouser.setFont(new Font("SansSerif", Font.ITALIC, 12));
		GridBagConstraints gbc_lblAvisouser = new GridBagConstraints();
		gbc_lblAvisouser.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvisouser.gridx = 1;
		gbc_lblAvisouser.gridy = 2;
		panAut.add(lblAvisouser, gbc_lblAvisouser);
	    }
	    {
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SansSerif", Font.BOLD, 19));
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 3;
		panAut.add(lblContrasea, gbc_lblContrasea);
	    }
	    {
		txtContra = new JPasswordField();
		txtContra.setHorizontalAlignment(SwingConstants.CENTER);
		txtContra.setMinimumSize(new Dimension(6, 38));
		txtContra.addKeyListener(new TxtContraKeyListener());
		txtContra.addActionListener(new BtnEntrarActionListener());

		txtContra.setVerifyInputWhenFocusTarget(false);
		txtContra.setFont(new Font("SansSerif", Font.PLAIN, 23));

		GridBagConstraints gbc_txtContra = new GridBagConstraints();
		gbc_txtContra.insets = new Insets(0, 0, 5, 5);
		gbc_txtContra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContra.gridx = 1;
		gbc_txtContra.gridy = 3;
		panAut.add(txtContra, gbc_txtContra);
	    }
	    {
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(SystemColor.menu);
		btnEntrar.addActionListener(new BtnEntrarActionListener());
		{
		    lblAvisoPass = new JLabel("");
		    lblAvisoPass.setFont(new Font("SansSerif", Font.ITALIC, 12));
		    GridBagConstraints gbc_lblAvisoPass = new GridBagConstraints();
		    gbc_lblAvisoPass.anchor = GridBagConstraints.NORTH;
		    gbc_lblAvisoPass.insets = new Insets(0, 0, 5, 5);
		    gbc_lblAvisoPass.gridx = 1;
		    gbc_lblAvisoPass.gridy = 4;
		    panAut.add(lblAvisoPass, gbc_lblAvisoPass);
		}
		btnEntrar.setFont(new Font("SansSerif", Font.BOLD, 33));
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.anchor = GridBagConstraints.NORTH;
		gbc_btnEntrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEntrar.gridx = 1;
		gbc_btnEntrar.gridy = 5;
		panAut.add(btnEntrar, gbc_btnEntrar);
	    }
	}
	{
	    panAccesi = new JPanel();
	    panAccesi.setOpaque(false);
	    GridBagConstraints gbc_panAccesi = new GridBagConstraints();
	    gbc_panAccesi.insets = new Insets(0, 0, 0, 5);
	    gbc_panAccesi.gridwidth = 3;
	    gbc_panAccesi.fill = GridBagConstraints.BOTH;
	    gbc_panAccesi.gridx = 1;
	    gbc_panAccesi.gridy = 1;
	    contentPane.add(panAccesi, gbc_panAccesi);
	    GridBagLayout gbl_panAccesi = new GridBagLayout();
	    gbl_panAccesi.columnWidths = new int[] { 139, 527, 186, 0 };
	    gbl_panAccesi.rowHeights = new int[] { 44, 0 };
	    gbl_panAccesi.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
	    gbl_panAccesi.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
	    panAccesi.setLayout(gbl_panAccesi);
	    {
		lblIntern = new JLabel("");
		lblIntern.addMouseListener(new LblInternMouseListener());
		lblIntern.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblIntern.setIcon(new ImageIcon(UI_Login.class.getResource("/recursos/idioma.png")));
		GridBagConstraints gbc_lblIntern = new GridBagConstraints();
		gbc_lblIntern.anchor = GridBagConstraints.WEST;
		gbc_lblIntern.insets = new Insets(0, 0, 0, 5);
		gbc_lblIntern.gridx = 0;
		gbc_lblIntern.gridy = 0;
		panAccesi.add(lblIntern, gbc_lblIntern);
	    }
	    {
		lblRecuperar = new JLabel("Recuperar Contrase\u00F1a");
		lblRecuperar.setFont(new Font("SansSerif", Font.ITALIC, 16));
		GridBagConstraints gbc_lblRecuperar = new GridBagConstraints();
		gbc_lblRecuperar.anchor = GridBagConstraints.EAST;
		gbc_lblRecuperar.gridx = 2;
		gbc_lblRecuperar.gridy = 0;
		panAccesi.add(lblRecuperar, gbc_lblRecuperar);
	    }
	}
    }

    private class BtnEntrarActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (comprobLogin()) {
		initPrincipal();
	    }
	}
    }

    private class TxtUsuarioKeyListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent k) {
	    if (k.getKeyCode() == 10) {// Si se pulsa intro
		txtContra.requestFocus();
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
	    txtUsuario.setBorder(null);
	    txtUsuario.setBackground(Color.white);
	}
    }

    private class TxtContraKeyListener extends KeyAdapter {

	@Override // Esto es para cuando esta en el area de la contra y pulsa enter
	public void keyPressed(KeyEvent k) {
	    if (k.getKeyCode() == 10) {// Si se pulsa intro se simula un click en el boton de entrar
		if (comprobLogin()) {
		    btnEntrar.doClick();
		} else {
		    System.out.println("Login INcorrecta ");

		}
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
	    txtContra.setBorder(null);
	    txtContra.setBackground(Color.white);
	}
    }

    private class LblInternMouseListener extends MouseAdapter {
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
    }

    private void initPrincipal() {
	dispose();

	UI_Principal prin = new UI_Principal(users[userIndex]);
	prin.frame.setVisible(true);
	prin.frame.setLocationRelativeTo(null);
	prin.frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    private boolean comprobLogin() {
	boolean valido = false;
	boolean UserV = false;
	String userLog = txtUsuario.getText();
	String passLog = String.valueOf(txtContra.getPassword());
	System.out.println(passLog);
	for (int i = 0; i < users.length && !UserV; i++) {
	    if (users[i].getUser().equalsIgnoreCase(userLog)) {// Si el usuario esta en la base de datos
		System.out.println("Usu correcta ");
		UserV = true;
		for (int j = 0; j < users.length && !valido; j++) {
		    if (users[i].getPass().equals(passLog) && (i == j)) {// Si la contraseña se encuentra almacenada y esta en eel mismo indice que el User
			lblAvisouser.setText("");
			lblAvisoPass.setText("");
			txtUsuario.setBorder(null);
			txtUsuario.setBackground(Color.white);
			txtContra.setBorder(null);
			txtContra.setBackground(Color.white);
			userIndex = i;// Esto es para pasar luego a la siguiente ventana el usuario que se ha autenticado
			valido = true;
		    } else {
			lblAvisoPass.setText("Contraseña Incorrecta");
			lblAvisouser.setText("");
			txtUsuario.setBorder(null);
			txtUsuario.setBackground(Color.white);
			txtContra.setBorder(new LineBorder(Color.RED));
			txtContra.setBackground(new Color(253, 215, 214));
		    }
		}
	    } else {
		lblAvisouser.setText("Usuario incorrecto");
		lblAvisoPass.setText("");
		txtContra.setBorder(null);
		txtContra.setBackground(Color.white);
		txtUsuario.setBorder(new LineBorder(Color.RED));
		txtUsuario.setBackground(new Color(253, 215, 214));
	    }

	}
	return valido;
    }
}
