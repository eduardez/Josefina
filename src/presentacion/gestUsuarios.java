package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dominio.Usuario;
import persistencia.Agente;

public class gestUsuarios extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JButton okButton;
    private JLabel lblUsersSelec;
    private Agente ag = new Agente();
    private Usuario[] users = ag.leerUsuarios();

    /**
     * Create the dialog.
     */

    public gestUsuarios() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(gestUsuarios.class.getResource("/recursos/logo.png")));
	setMaximumSize(new Dimension(682, 736));
	setMinimumSize(new Dimension(470, 300));
	setTitle("Gestor Usuarios");
	setModal(true);
	setAlwaysOnTop(true);
	setBounds(100, 100, 638, 487);
	setLocationRelativeTo(null);
	DefaultListModel<String> model = new DefaultListModel<>();
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPanel.setBackground(new Color(0, 180, 188));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	GridBagLayout gbl_contentPanel = new GridBagLayout();
	gbl_contentPanel.columnWidths = new int[] { 182, 220, 0 };
	gbl_contentPanel.rowHeights = new int[] { 166, 43, 0 };
	gbl_contentPanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
	gbl_contentPanel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
	contentPanel.setLayout(gbl_contentPanel);

	JList<String> listUsers = new JList<>(model);
	listUsers.setBackground(new Color(200, 240, 248));
	listUsers.setFont(new Font("SansSerif", Font.PLAIN, 19));
	GridBagConstraints gbc_listUsers = new GridBagConstraints();
	gbc_listUsers.fill = GridBagConstraints.BOTH;
	gbc_listUsers.insets = new Insets(0, 0, 5, 0);
	gbc_listUsers.gridwidth = 2;
	gbc_listUsers.gridx = 0;
	gbc_listUsers.gridy = 0;
	contentPanel.add(listUsers, gbc_listUsers);

	JLabel lblSel = new JLabel("Usuarios seleccionados: ");
	lblSel.setFont(new Font("SansSerif", Font.PLAIN, 19));
	lblSel.setHorizontalAlignment(SwingConstants.RIGHT);
	GridBagConstraints gbc_lblSel = new GridBagConstraints();
	gbc_lblSel.fill = GridBagConstraints.BOTH;
	gbc_lblSel.insets = new Insets(0, 0, 0, 5);
	gbc_lblSel.gridx = 0;
	gbc_lblSel.gridy = 1;
	contentPanel.add(lblSel, gbc_lblSel);

	lblUsersSelec = new JLabel("");
	lblUsersSelec.setFont(new Font("SansSerif", Font.PLAIN, 19));
	lblUsersSelec.setHorizontalAlignment(SwingConstants.LEFT);
	GridBagConstraints gbc_lblUsersSelec = new GridBagConstraints();
	gbc_lblUsersSelec.fill = GridBagConstraints.BOTH;
	gbc_lblUsersSelec.gridx = 1;
	gbc_lblUsersSelec.gridy = 1;
	contentPanel.add(lblUsersSelec, gbc_lblUsersSelec);
	mostrarUser(model, users, lblUsersSelec);

	listUsers.addListSelectionListener(new ListSelectionListener() {
	    @Override
	    public void valueChanged(ListSelectionEvent arg0) {
		lblUsersSelec.setText(String.valueOf(listUsers.getSelectedIndices().length));
		okButton.setEnabled(true);
		if (listUsers.getSelectedIndices().length > 1) {
		    okButton.setText("Eliminar Usuarios");
		} else {
		    okButton.setText("Eliminar Usuario");
		}
	    }
	});

	{
	    JPanel buttonPane = new JPanel();
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    buttonPane.setBackground(new Color(38, 38, 38));
	    {
		okButton = new JButton("Eliminar Usuario");
		okButton.setEnabled(false);
		okButton.setVerifyInputWhenFocusTarget(false);
		okButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
			int opt = JOptionPane.showConfirmDialog(null,
				"¿Eliminar " + listUsers.getSelectedIndices().length + " usuario(s)?", "Atencion",
				JOptionPane.YES_NO_OPTION);
			if (opt == 0) {
			    for (int j = 0; j < listUsers.getSelectedIndices().length; j++)
				ag.EliminarUsuario(users[listUsers.getSelectedIndices()[j]]);
			    dispose();
			}
		    }
		});

		JButton btnAnadir = new JButton("A\u00F1adir Usuario");
		btnAnadir.setActionCommand("add");
		btnAnadir.addActionListener(new BtnAnadirActionListener());
		buttonPane.add(btnAnadir);
		okButton.setActionCommand("delete");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	    }
	    {
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
			dispose();
		    }
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	    }
	}
    }

    private void mostrarUser(DefaultListModel<String> model, Usuario[] users, JLabel lblTareas) {
	if (users.length < 1) {
	    lblTareas.setText("No existen usuarios.");
	} else {
	    for (int i = 0; i < users.length; i++) {
		model.add(i, users[i].getNombre() + " | user: " + users[i].getUser() + ", pass: " + users[i].getPass());
	    }
	    lblTareas.setText("0");
	}

    }

    private class BtnAnadirActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
	    dispose();
	    addUser au = new addUser();
	    au.setVisible(true);
	}
    }
}
