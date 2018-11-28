package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Dimension;

public class gestUsuarios extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JButton okButton;
    private JLabel lblUsersSelec;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	try {
	    gestUsuarios dialog = new gestUsuarios();
	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    dialog.setVisible(true);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /**
     * Create the dialog.
     */

    public gestUsuarios() {
	setMaximumSize(new Dimension(682, 736));
	setMinimumSize(new Dimension(470, 300));
	Agente ag = new Agente();
	Usuario[] users = ag.getUsers();
	setTitle("Gestor Usuarios");
	// setIconImage(Toolkit.getDefaultToolkit().getImage(gestUsuarios.class.getResource("/org/hsqldb/util/RedCircle.gif")));
	setBounds(100, 100, 638, 487);
	DefaultListModel<String> model = new DefaultListModel<>();
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	GridBagLayout gbl_contentPanel = new GridBagLayout();
	gbl_contentPanel.columnWidths = new int[] { 182, 220, 0 };
	gbl_contentPanel.rowHeights = new int[] { 166, 43, 0 };
	gbl_contentPanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
	gbl_contentPanel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
	contentPanel.setLayout(gbl_contentPanel);

	JList<String> listUsers = new JList<>(model);
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
	mostTareas(model, users, lblUsersSelec);

	listUsers.addListSelectionListener(new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent arg0) {
		lblUsersSelec.setText(String.valueOf(listUsers.getSelectedIndices().length));
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
	    {
		okButton = new JButton("Eliminar Usuario");
		okButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			int opt = JOptionPane.showConfirmDialog(null,
				"¿Eliminar " + listUsers.getSelectedIndices().length + " tarea(s)?", "Atencion",
				JOptionPane.YES_NO_OPTION);
			if (opt == 0) {
			    elimUser(listUsers, users);
			    dispose();
			}
		    }
		});
		
		JButton btnAnadir = new JButton("A\u00F1adir Usuario");
		buttonPane.add(btnAnadir);
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	    }
	    {
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
			dispose();
		    }
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	    }
	}
    }

    protected void elimUser(JList<String> listUsers, Usuario[] users) {
	try {
	    int[] elimPos = listUsers.getSelectedIndices();
	    for (int i = 0; i < elimPos.length; i++) {
		Agente ag = new Agente();
		ag.EliminarTarea(users[i]);
	    }
	} catch (Exception e) {

	}

    }

    private void mostTareas(DefaultListModel<String> model, Usuario[] users, JLabel lblTareas) {
	if (users.length == 1) {
	    lblTareas.setText("No existen usuarios.");
	} else {
	    for (int i = 0; i < users.length; i++) {
		model.add(i, users[i].getNombre());
	    }
	    lblTareas.setText("0");
	}

    }
}
