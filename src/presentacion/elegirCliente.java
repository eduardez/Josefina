package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Cliente;
import dominio.util;
import javafx.scene.control.ComboBox;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * Bugs conocidos:
 * Si se le da a nuevo cliente, luego de que
 * se cree el cliente y se vuelva a abrir este dialog, no se podran obtener
 * la lista de pedido ya que, como despues de crear el cliente, abrimos este dialog con un
 * util=null, ese objeto no tene la jtable necesaria y es como si no hubiese elementos.
 * Bueno es que en verdad no los hay.

 * 
 * @author Eduardez
 *
 */
public class elegirCliente extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Agente ag;
    private Cliente[] clientes;
    private Cliente cli;
    private JList lstClientes;
    private JButton okButton;
    private boolean cancelado;
    private util ut;
    private String [] tipPedidos= {"domicilio", "recoger", "mesa"};
    private JComboBox cmbTipos;

    public elegirCliente(util ut1) {
	ut = ut1;
	ag = new Agente();
	clientes = ag.leerCliente();
	inicializar();
    }

    private void inicializar() {
	setLocationRelativeTo(null);
	this.cancelado = true;
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
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setOpaque(false);
	    contentPanel.add(scrollPane, BorderLayout.CENTER);
	    {
		lstClientes = new JList();
		updateList();
		lstClientes.setSelectedIndex(0);
		lstClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstClientes.setFont(new Font("SansSerif", Font.BOLD, 20));
		lstClientes.setBackground(new Color(0, 180, 188));
		scrollPane.setViewportView(lstClientes);
	    }
	}
	{
		cmbTipos = new JComboBox();
		cmbTipos.setModel(new DefaultComboBoxModel(new String[] { "Pedido a domicilio", "Recogida en local", "Servir en mesa"}));
		cmbTipos.setToolTipText("Seleccionar el tipo de pedido que se quiere realizar");
		cmbTipos.setSelectedIndex(0);
		cmbTipos.setFont(new Font("SansSerif", Font.PLAIN, 20));
		contentPanel.add(cmbTipos, BorderLayout.SOUTH);
	}
	{
	    JPanel buttonPane = new JPanel();
	    buttonPane.setBackground(new Color(38, 38, 38));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
		okButton = new JButton("Completar pedido");
		okButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
		okButton.setBackground(Color.WHITE);
		okButton.addActionListener(new OkButtonActionListener());
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
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
	repaint();
    }

    public boolean isCancelado() {
	return this.cancelado;
    }

    private class OkButtonActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    ut.setCliente(clientes[lstClientes.getSelectedIndex()]);
	    ut.setTipoPedido(tipPedidos[cmbTipos.getSelectedIndex()]);
	    ut.guardarPedido();
	    dispose();
	}
    }

    private class CancelButtonActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    dispose();
	}
    }
}
