package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dominio.Usuario;
import persistencia.Agente;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addUser extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtNom;
    private JTextField txtUser;
    private JTextField txtPass;
    private JTextField txtRepPass;
    private JCheckBox chckbxDsfg;

    public addUser() {
	setTitle("Gestor Usuarios - A\u00F1adir nuevo usuario");
	setIconImage(Toolkit.getDefaultToolkit().getImage(addUser.class.getResource("/recursos/logo.png")));
	setResizable(false);
	setBounds(100, 100, 683, 498);
	setModal(true);
	setAlwaysOnTop(true);
	setLocationRelativeTo(null);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPanel.setBackground(new Color(0, 180, 188));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	GridBagLayout gbl_contentPanel = new GridBagLayout();
	gbl_contentPanel.columnWidths = new int[] { 219, 0, 0, 142, 0, 0 };
	gbl_contentPanel.rowHeights = new int[] { 24, 37, 0, 0, 0, 0, 0, 0, 0, 0 };
	gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
	gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
	contentPanel.setLayout(gbl_contentPanel);
	{
	    JLabel lblNombreCompleto = new JLabel("Nombre completo:");
	    lblNombreCompleto.setFont(new Font("SansSerif", Font.PLAIN, 20));
	    GridBagConstraints gbc_lblNombreCompleto = new GridBagConstraints();
	    gbc_lblNombreCompleto.fill = GridBagConstraints.VERTICAL;
	    gbc_lblNombreCompleto.anchor = GridBagConstraints.EAST;
	    gbc_lblNombreCompleto.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNombreCompleto.gridx = 0;
	    gbc_lblNombreCompleto.gridy = 1;
	    contentPanel.add(lblNombreCompleto, gbc_lblNombreCompleto);
	}
	{
	    txtNom = new JTextField();
	    txtNom.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_txtNom = new GridBagConstraints();
	    gbc_txtNom.gridwidth = 2;
	    gbc_txtNom.insets = new Insets(0, 0, 5, 5);
	    gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtNom.gridx = 2;
	    gbc_txtNom.gridy = 1;
	    contentPanel.add(txtNom, gbc_txtNom);
	    txtNom.setColumns(10);
	}
	{
	    JLabel lblUsuario = new JLabel("Usuario:");
	    lblUsuario.setFont(new Font("SansSerif", Font.PLAIN, 20));
	    GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
	    gbc_lblUsuario.fill = GridBagConstraints.VERTICAL;
	    gbc_lblUsuario.anchor = GridBagConstraints.EAST;
	    gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
	    gbc_lblUsuario.gridx = 0;
	    gbc_lblUsuario.gridy = 3;
	    contentPanel.add(lblUsuario, gbc_lblUsuario);
	}
	{
	    txtUser = new JTextField();
	    txtUser.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_txtUser = new GridBagConstraints();
	    gbc_txtUser.insets = new Insets(0, 0, 5, 5);
	    gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtUser.gridx = 2;
	    gbc_txtUser.gridy = 3;
	    contentPanel.add(txtUser, gbc_txtUser);
	    txtUser.setColumns(10);
	}
	
	{
	    JLabel lblContrasea = new JLabel("Contrase\u00F1a");
	    lblContrasea.setFont(new Font("SansSerif", Font.PLAIN, 20));
	    GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
	    gbc_lblContrasea.fill = GridBagConstraints.VERTICAL;
	    gbc_lblContrasea.anchor = GridBagConstraints.EAST;
	    gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
	    gbc_lblContrasea.gridx = 0;
	    gbc_lblContrasea.gridy = 5;
	    contentPanel.add(lblContrasea, gbc_lblContrasea);
	}
	{
	    txtPass = new JTextField();
	    txtPass.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    GridBagConstraints gbc_txtPass = new GridBagConstraints();
	    gbc_txtPass.insets = new Insets(0, 0, 5, 5);
	    gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtPass.gridx = 2;
	    gbc_txtPass.gridy = 5;
	    contentPanel.add(txtPass, gbc_txtPass);
	    txtPass.setColumns(10);
	}
	{
	    JLabel lblRepetirContrasea = new JLabel("Repetir Contrase\u00F1a");
	    lblRepetirContrasea.setFont(new Font("SansSerif", Font.PLAIN, 20));
	    GridBagConstraints gbc_lblRepetirContrasea = new GridBagConstraints();
	    gbc_lblRepetirContrasea.anchor = GridBagConstraints.EAST;
	    gbc_lblRepetirContrasea.insets = new Insets(0, 0, 5, 5);
	    gbc_lblRepetirContrasea.gridx = 0;
	    gbc_lblRepetirContrasea.gridy = 7;
	    contentPanel.add(lblRepetirContrasea, gbc_lblRepetirContrasea);
	}
	{
	    txtRepPass = new JTextField();
	    txtRepPass.addKeyListener(new TxtRepPassKeyListener());
	    txtRepPass.setFont(new Font("SansSerif", Font.PLAIN, 17));
	    txtRepPass.setColumns(10);
	    GridBagConstraints gbc_txtRepPass = new GridBagConstraints();
	    gbc_txtRepPass.insets = new Insets(0, 0, 5, 5);
	    gbc_txtRepPass.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtRepPass.gridx = 2;
	    gbc_txtRepPass.gridy = 7;
	    contentPanel.add(txtRepPass, gbc_txtRepPass);
	}
	{
	    JPanel buttonPane = new JPanel();
	    buttonPane.setBackground(new Color(38, 38, 38));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
		JButton okButton = new JButton("A\u00F1adir");
		okButton.addActionListener(new OkButtonActionListener());
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	    }
	    {
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new CancelButtonActionListener());
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	    }
	}
    }

    private class OkButtonActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {

	    Agente ag = new Agente();
	    Usuario[] oldUs = ag.leerUsuarios();
	    Usuario[] newUs = new Usuario[oldUs.length + 1];
	    for (int i = 0; i < oldUs.length; i++) {
		newUs[i] = oldUs[i];
	    }
	    Usuario newUser = new Usuario(txtUser.getText(), txtPass.getText(), txtNom.getText(),
		    "Era mi primerito dia :D");
	    newUs[newUs.length - 1] = newUser;
	    ag.escribirUsuarios(newUs);
	    gestUsuarios gest = new gestUsuarios();
	    dispose();
	    gest.setVisible(true);

	}
    }

    private class CancelButtonActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	    dispose();
	    gestUsuarios gest = new gestUsuarios();
	    gest.setVisible(true);
	}
    }

    private class TxtRepPassKeyListener extends KeyAdapter {
	@Override
	public void keyReleased(KeyEvent arg0) {
	    if (!txtPass.getText().equals(txtRepPass.getText())) {

		txtPass.setBackground(Color.white);
		txtPass.setBorder(null);
		txtRepPass.setBackground(new Color(253, 215, 214));
		txtRepPass.setBorder(new LineBorder(Color.RED));
	    } else {
		txtRepPass.setBackground(new Color(213, 253, 214));
		txtRepPass.setBorder(new LineBorder(Color.green));
		txtPass.setBackground(new Color(213, 253, 214));
		txtPass.setBorder(new LineBorder(Color.green));
	    }
	}
    }


}
