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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
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
	    contentPane.add(panIcon, renderObjeto(1, 0, -2, new int[] { 0, 0, 5, 5 }, -1, GridBagConstraints.BOTH));

	    GridBagLayout gbl_panIcon = new GridBagLayout();
	    gbl_panIcon.columnWidths = new int[] { 0, 0 };
	    gbl_panIcon.rowHeights = new int[] { 480, 88, 0 };
	    gbl_panIcon.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
	    gbl_panIcon.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
	    panIcon.setLayout(gbl_panIcon);
	    {
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(UI_Login.class.getResource("/recursos/logo.png")));
		lblLogo.addMouseListener(new lblMouseListener());
		panIcon.add(lblLogo, renderObjeto(0, 0, GridBagConstraints.SOUTH, new int[] { 0, 0, 5, 0 }, -1, -2));

	    }
	    {
		lblRestauranteLaJosefina = new JLabel("Restaurante La Josefina");
		lblRestauranteLaJosefina.setFont(new Font(fuente, Font.PLAIN, 25));
		lblRestauranteLaJosefina.setHorizontalAlignment(SwingConstants.CENTER);
		panIcon.add(lblRestauranteLaJosefina, renderObjeto(0, 1, GridBagConstraints.NORTH, null, -1, -2));
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

	    contentPane.add(separator,
		    renderObjeto(2, 0, -2, new int[] { 0, 0, 5, 5 }, -1, GridBagConstraints.VERTICAL));
	}
	{
	    panAut = new JPanel();
	    panAut.setOpaque(false);
	    contentPane.add(panAut, renderObjeto(3, 0, -2, new int[] { 0, 0, 5, 5 }, -1, GridBagConstraints.BOTH));

	    GridBagLayout gbl_panAut = new GridBagLayout();
	    gbl_panAut.columnWidths = new int[] { 127, 289, 69, 0 };
	    gbl_panAut.rowHeights = new int[] { 125, -60, 0, -232, -188, 120, 116, 0 };
	    gbl_panAut.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
	    gbl_panAut.rowWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
	    panAut.setLayout(gbl_panAut);
	    {
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 19));
		panAut.add(lblUsuario, renderObjeto(0, 1, GridBagConstraints.SOUTH, new int[] { 0, 0, 5, 5 }, -1, -2));
	    }
	    {
		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.addKeyListener(new TxtUsuarioKeyListener());
		txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 19));
		txtUsuario.setMinimumSize(new Dimension(6, 38));
		panAut.add(txtUsuario, renderObjeto(1, 1, GridBagConstraints.SOUTH, new int[] { 0, 0, 5, 5 }, -1,
			GridBagConstraints.HORIZONTAL));
		txtUsuario.setColumns(10);
	    }
	    {
		lblAvisouser = new JLabel("");
		lblAvisouser.setForeground(Color.RED);
		lblAvisouser.setFont(new Font("SansSerif", Font.ITALIC, 12));
		panAut.add(lblAvisouser, renderObjeto(1, 2, -2, new int[] { 0, 0, 5, 5 }, -1, -2));
	    }
	    {
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("SansSerif", Font.BOLD, 19));
		panAut.add(lblContrasea, renderObjeto(0, 3, -2, new int[] { 0, 0, 5, 5 }, -1, -2));
	    }
	    {
		txtContra = new JPasswordField();
		txtContra.setHorizontalAlignment(SwingConstants.CENTER);
		txtContra.setMinimumSize(new Dimension(6, 38));
		txtContra.addKeyListener(new TxtContraKeyListener());
		txtContra.addActionListener(new BtnEntrarActionListener());

		txtContra.setVerifyInputWhenFocusTarget(false);
		txtContra.setFont(new Font("SansSerif", Font.PLAIN, 23));
		panAut.add(txtContra,
			renderObjeto(1, 3, -2, new int[] { 0, 0, 5, 5 }, -1, GridBagConstraints.HORIZONTAL));
	    }
	    {
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(SystemColor.menu);
		btnEntrar.addActionListener(new BtnEntrarActionListener());
		{
		    lblAvisoPass = new JLabel("");
		    lblAvisoPass.setForeground(Color.RED);
		    lblAvisoPass.setFont(new Font("SansSerif", Font.ITALIC, 12));
		    panAut.add(lblAvisoPass,
			    renderObjeto(1, 4, GridBagConstraints.NORTH, new int[] { 0, 0, 5, 5 }, -1, -2));
		}
		btnEntrar.setFont(new Font("SansSerif", Font.BOLD, 33));
		panAut.add(btnEntrar, renderObjeto(1, 5, GridBagConstraints.NORTH, new int[] { 0, 0, 5, 5 }, -1,
			GridBagConstraints.HORIZONTAL));
	    }
	}
	{
	    panAccesi = new JPanel();
	    panAccesi.setOpaque(false);
	    contentPane.add(panAccesi, renderObjeto(1, 1, -2, new int[] { 0, 0, 0, 5 }, 3, GridBagConstraints.BOTH));

	    GridBagLayout gbl_panAccesi = new GridBagLayout();
	    gbl_panAccesi.columnWidths = new int[] { 139, 527, 186, 0 };
	    gbl_panAccesi.rowHeights = new int[] { 44, 0 };
	    gbl_panAccesi.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
	    gbl_panAccesi.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
	    panAccesi.setLayout(gbl_panAccesi);
	    {
		// Crear boton 'Cambiar Idioma'
		lblIntern = new JLabel("");
		lblIntern.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblIntern.setIcon(new ImageIcon(UI_Login.class.getResource("/recursos/idioma.png")));
		panAccesi.add(lblIntern, renderObjeto(0, 0, GridBagConstraints.WEST, new int[] { 0, 0, 0, 5 }, -1, -2));
	    }
	    {
		// Crear boton 'Recuperar Contrasena'
		lblRecuperar = new JLabel("Recuperar Contrase\u00F1a");
		lblRecuperar.setFont(new Font("SansSerif", Font.ITALIC, 16));
		panAccesi.add(lblRecuperar, renderObjeto(2, 0, GridBagConstraints.EAST, null, -1, -2));
	    }
	}
    }

    private class lblMouseListener extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent arg0) {
	    // Mostrar copirigth
	    JOptionPane.showMessageDialog(null, "Eduardo Garcia Aparicio \nAna Valero Monedero", "Programadores",
		    JOptionPane.WARNING_MESSAGE);
	}
    }

    /**
     * Metodo que devuelve un objeto GridBagConstraints. Usado para simplificar codigo.
     * 
     * @param x
     *            (coord. X)
     * @param y
     *            (coord. Y)
     * @param anch
     *            (anchor, -2 para no usar)
     * @param insts
     *            (insets, null para no usar)
     * @param gridW
     *            (gridWidth, -1 para no usar)
     * @param fll
     *            (fill, -2 para no usar)
     * @return Devuelve un objeto GridBagConstraints llamado 'gbc_generico'
     */
    private GridBagConstraints renderObjeto(int x, int y, int anch, int[] insts, int gridW, int fll) {
	GridBagConstraints gbc_generico = new GridBagConstraints();
	gbc_generico.gridx = x;
	gbc_generico.gridy = y;
	if (gridW != -1)
	    gbc_generico.gridwidth = gridW;

	if (fll != -2)
	    gbc_generico.fill = fll;

	if (anch != -2)
	    gbc_generico.anchor = anch;// Set anchor, tipo int. Si el valor es -2 no se modifica (valor libre en Constant Field de GBC)

	if (insts != null)
	    gbc_generico.insets = new Insets(insts[0], insts[1], insts[2], insts[3]);

	return gbc_generico;
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
			lblAvisouser.setText("");
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
		lblAvisoPass.setText("");
		txtUsuario.setBorder(new LineBorder(Color.RED));
		txtUsuario.setBackground(new Color(253, 215, 214));
	    }

	}
	return valido;
    }
}
