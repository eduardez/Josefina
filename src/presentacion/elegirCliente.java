package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Cliente;
import persistencia.Agente;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class elegirCliente extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Agente ag;
    private Cliente[] clientes;
    private Cliente cli;
    private JList lstClientes;
    private JButton okButton;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	try {
	    elegirCliente dialog = new elegirCliente();
	    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    dialog.setVisible(true);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public elegirCliente() {
	ag = new Agente();
	clientes = ag.leerCliente();
	inicializar();
    }

    private void inicializar() {
	setResizable(false);
	getContentPane().setBackground(new Color(38, 38, 38));
	setBackground(Color.WHITE);
	String[] clients = new String[clientes.length];
	for (int i = 0; i < clientes.length; i++) {
	    clients[i] = clientes[i].getNombre() + " | NºCliente: " + clientes[i].getNumCliente();
	}

	setBounds(100, 100, 479, 677);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setOpaque(false);
	contentPanel.setBackground(Color.BLACK);
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(new BorderLayout(0, 0));
	{
	    scrollPane = new JScrollPane();
	    scrollPane.setOpaque(false);
	    contentPanel.add(scrollPane, BorderLayout.CENTER);
	    {
		updateList();
		
	    }
	}
	{
	    JPanel buttonPane = new JPanel();
	    buttonPane.setBackground(new Color(38, 38, 38));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
		okButton = new JButton("Seleccionar Cliente");
		okButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
		okButton.setBackground(Color.WHITE);
		okButton.addActionListener(new OkButtonActionListener());
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		{
		    JButton btnNuevoCliente = new JButton("Nuevo Cliente");
		    btnNuevoCliente.addActionListener(new BtnNuevoClienteActionListener());
		    btnNuevoCliente.setBackground(Color.WHITE);
		    btnNuevoCliente.setEnabled(true);
		    btnNuevoCliente.setFont(new Font("SansSerif", Font.PLAIN, 17));
		    buttonPane.add(btnNuevoCliente);
		}
	    }
	    {
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new CancelButtonActionListener());
		cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	    }
	}
    }

    private void updateList() {
	ag.leerCliente();
	String[] clients = new String[clientes.length];
	for (int i = 0; i < clientes.length; i++) {
	    clients[i] = clientes[i].getNombre() + " | NºCliente: " + clientes[i].getNumCliente();
	}
	lstClientes = new JList(clients);
	
	lstClientes.setSelectedIndex(0);
	lstClientes.addListSelectionListener(new LstClientesListSelectionListener());
	lstClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	lstClientes.setFont(new Font("SansSerif", Font.BOLD, 20));
	lstClientes.setBackground(new Color(0, 180, 188));
	
	scrollPane.setViewportView(lstClientes);
	
	repaint();
	revalidate();
    }

    private class OkButtonActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    lstClientes.getSelectedIndex();

	}
    }

    private class LstClientesListSelectionListener implements ListSelectionListener {
	public void valueChanged(ListSelectionEvent arg0) {
	    cli = clientes[lstClientes.getSelectedIndex()];
	}
    }

    private class CancelButtonActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    dispose();
	}
    }

    private class BtnNuevoClienteActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    addCliente add = new addCliente();
	    add.setVisible(true);
	    updateList();

	}
    }
}
