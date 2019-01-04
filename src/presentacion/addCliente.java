package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import dominio.Cliente;
import persistencia.Agente;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.ComponentOrientation;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.sql.Date;

public class addCliente extends JFrame {

    private JPanel contentPane;
    private JPanel pnlInfo;
    private JLabel lblIcon;
    private JLabel lblNombre;
    private JTextField txtNom;
    private JLabel lblNumcl;
    private JTextField txtNcli;
    private JLabel lblNumtelf;
    private JFormattedTextField txtNumtel;
    private JLabel lblCorreo;
    private JLabel lblDireccion;
    private JLabel lblPuntac;
    private JTextField txtCorreo;
    private JTextField txtDireccion;
    private JFormattedTextField txtPuntac;
    private JLabel lblPuntcanj;
    private JFormattedTextField txtPuntca;
    private JLabel lblCadpunt;
    private JDatePickerImpl datePicker;
    private JPanel pnlAnotaciones;
    private JPanel pnlOpt;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JPanel pnlPuntos;
    private JCheckBox chckbxVip;
    private Agente ag=new Agente();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    addCliente frame = new addCliente();
		    frame.setVisible(true);
		    try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");// O este otro javax.swing.plaf.metal.MetalLookAndFeel
		    } catch (Exception e) {
			System.out.println("ERROR en L&F");
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public addCliente() {
	setResizable(false);
	setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 617, 628);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	NumberFormat format = NumberFormat.getInstance();
	format.setGroupingUsed(false);
	NumberFormatter formatter = new NumberFormatter(format);
	formatter.setValueClass(Integer.class);
	formatter.setMinimum(0);
	formatter.setAllowsInvalid(false);
	formatter.setCommitsOnValidEdit(true);
	{
	    pnlInfo = new JPanel();
	    pnlInfo.setBackground(Color.WHITE);
	    contentPane.add(pnlInfo, BorderLayout.CENTER);
	    GridBagLayout gbl_pnlInfo = new GridBagLayout();
	    gbl_pnlInfo.columnWidths = new int[] { 21, 63, 64, 75, 78, 70, 67, 14, 0 };
	    gbl_pnlInfo.rowHeights = new int[] { 0, 128, 0, 0, 0, 0, 0, 77, 0, 172, 0, 0 };
	    gbl_pnlInfo.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
	    gbl_pnlInfo.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0,
		    Double.MIN_VALUE };
	    pnlInfo.setLayout(gbl_pnlInfo);
	    {
		lblIcon = new JLabel("");
		setFotoCliente();
		GridBagConstraints gbc_lblIcon = new GridBagConstraints();
		gbc_lblIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lblIcon.gridx = 1;
		gbc_lblIcon.gridy = 1;
		pnlInfo.add(lblIcon, gbc_lblIcon);
	    }
	    {
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 1;
		pnlInfo.add(lblNombre, gbc_lblNombre);
	    }
	    {
		txtNom = new JTextField();
		txtNom.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.gridwidth = 3;
		gbc_txtNom.insets = new Insets(0, 0, 5, 5);
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.gridx = 3;
		gbc_txtNom.gridy = 1;
		pnlInfo.add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);
	    }
	    {
		chckbxVip = new JCheckBox("\u00BFCliente Vip?");

		chckbxVip.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		chckbxVip.setHorizontalTextPosition(SwingConstants.CENTER);
		chckbxVip.setVerticalTextPosition(SwingConstants.TOP);
		chckbxVip.setOpaque(false);
		GridBagConstraints gbc_chckbxVip = new GridBagConstraints();
		gbc_chckbxVip.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVip.gridx = 6;
		gbc_chckbxVip.gridy = 1;
		pnlInfo.add(chckbxVip, gbc_chckbxVip);
	    }
	    {
		lblNumcl = new JLabel("Numero de cliente:");
		lblNumcl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumcl.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNumcl = new GridBagConstraints();
		gbc_lblNumcl.anchor = GridBagConstraints.EAST;
		gbc_lblNumcl.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumcl.gridx = 1;
		gbc_lblNumcl.gridy = 2;
		pnlInfo.add(lblNumcl, gbc_lblNumcl);
	    }
	    {
		txtNcli = new JTextField();
		txtNcli.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_txtNcli = new GridBagConstraints();
		gbc_txtNcli.gridwidth = 2;
		gbc_txtNcli.insets = new Insets(0, 0, 5, 5);
		gbc_txtNcli.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNcli.gridx = 2;
		gbc_txtNcli.gridy = 2;
		pnlInfo.add(txtNcli, gbc_txtNcli);
		txtNcli.setColumns(10);
	    }
	    {
		lblNumtelf = new JLabel("Numero de telefono:");
		lblNumtelf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumtelf.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNumtelf = new GridBagConstraints();
		gbc_lblNumtelf.anchor = GridBagConstraints.EAST;
		gbc_lblNumtelf.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumtelf.gridx = 4;
		gbc_lblNumtelf.gridy = 2;
		pnlInfo.add(lblNumtelf, gbc_lblNumtelf);
	    }
	    {
		txtNumtel = new JFormattedTextField(formatter);
		txtNumtel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_txtNumtel = new GridBagConstraints();
		gbc_txtNumtel.gridwidth = 2;
		gbc_txtNumtel.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumtel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumtel.gridx = 5;
		gbc_txtNumtel.gridy = 2;
		pnlInfo.add(txtNumtel, gbc_txtNumtel);
		txtNumtel.setColumns(10);
	    }
	    {
		lblCorreo = new JLabel("Correo electronico:");
		lblCorreo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCorreo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 4;
		pnlInfo.add(lblCorreo, gbc_lblCorreo);
	    }
	    {
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_txtCorreo = new GridBagConstraints();
		gbc_txtCorreo.gridwidth = 5;
		gbc_txtCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCorreo.gridx = 2;
		gbc_txtCorreo.gridy = 4;
		pnlInfo.add(txtCorreo, gbc_txtCorreo);
		txtCorreo.setColumns(10);
	    }
	    {
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 1;
		gbc_lblDireccion.gridy = 6;
		pnlInfo.add(lblDireccion, gbc_lblDireccion);
	    }
	    {
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_txtDireccion = new GridBagConstraints();
		gbc_txtDireccion.gridwidth = 5;
		gbc_txtDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDireccion.gridx = 2;
		gbc_txtDireccion.gridy = 6;
		pnlInfo.add(txtDireccion, gbc_txtDireccion);
		txtDireccion.setColumns(10);
	    }
	    {
		pnlPuntos = new JPanel();
		pnlPuntos.setOpaque(false);
		pnlPuntos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Puntos del cliente",
			TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlPuntos = new GridBagConstraints();
		gbc_pnlPuntos.gridheight = 2;
		gbc_pnlPuntos.gridwidth = 6;
		gbc_pnlPuntos.insets = new Insets(0, 0, 5, 5);
		gbc_pnlPuntos.fill = GridBagConstraints.BOTH;
		gbc_pnlPuntos.gridx = 1;
		gbc_pnlPuntos.gridy = 7;
		pnlInfo.add(pnlPuntos, gbc_pnlPuntos);
		GridBagLayout gbl_pnlPuntos = new GridBagLayout();
		gbl_pnlPuntos.columnWidths = new int[] { 17, 0, 0, 0, 0, 0, 16, 0 };
		gbl_pnlPuntos.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnlPuntos.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnlPuntos.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		pnlPuntos.setLayout(gbl_pnlPuntos);
		{
		    lblPuntac = new JLabel("Actuales");
		    GridBagConstraints gbc_lblPuntac = new GridBagConstraints();
		    gbc_lblPuntac.fill = GridBagConstraints.HORIZONTAL;
		    gbc_lblPuntac.insets = new Insets(0, 0, 5, 5);
		    gbc_lblPuntac.gridx = 1;
		    gbc_lblPuntac.gridy = 0;
		    pnlPuntos.add(lblPuntac, gbc_lblPuntac);
		    lblPuntac.setHorizontalAlignment(SwingConstants.CENTER);
		    lblPuntac.setFont(new Font("SansSerif", Font.PLAIN, 15));
		}
		{
		    lblPuntcanj = new JLabel("Canjeados");
		    GridBagConstraints gbc_lblPuntcanj = new GridBagConstraints();
		    gbc_lblPuntcanj.fill = GridBagConstraints.HORIZONTAL;
		    gbc_lblPuntcanj.insets = new Insets(0, 0, 5, 5);
		    gbc_lblPuntcanj.gridx = 3;
		    gbc_lblPuntcanj.gridy = 0;
		    pnlPuntos.add(lblPuntcanj, gbc_lblPuntcanj);
		    lblPuntcanj.setHorizontalAlignment(SwingConstants.CENTER);
		    lblPuntcanj.setFont(new Font("SansSerif", Font.PLAIN, 15));
		}
		{
		    lblCadpunt = new JLabel("Fecha de Caducidad");
		    GridBagConstraints gbc_lblCadpunt = new GridBagConstraints();
		    gbc_lblCadpunt.fill = GridBagConstraints.HORIZONTAL;
		    gbc_lblCadpunt.insets = new Insets(0, 0, 5, 5);
		    gbc_lblCadpunt.gridx = 5;
		    gbc_lblCadpunt.gridy = 0;
		    pnlPuntos.add(lblCadpunt, gbc_lblCadpunt);
		    lblCadpunt.setHorizontalAlignment(SwingConstants.CENTER);
		    lblCadpunt.setFont(new Font("SansSerif", Font.PLAIN, 15));
		}
		{
		    txtPuntac = new JFormattedTextField(formatter);
		    txtPuntac.setHorizontalAlignment(SwingConstants.CENTER);
		    GridBagConstraints gbc_txtPuntac = new GridBagConstraints();
		    gbc_txtPuntac.fill = GridBagConstraints.HORIZONTAL;
		    gbc_txtPuntac.insets = new Insets(0, 0, 0, 5);
		    gbc_txtPuntac.gridx = 1;
		    gbc_txtPuntac.gridy = 1;
		    pnlPuntos.add(txtPuntac, gbc_txtPuntac);
		    txtPuntac.setFont(new Font("SansSerif", Font.PLAIN, 15));
		    txtPuntac.setColumns(10);
		}
		{
		    txtPuntca = new JFormattedTextField(formatter);
		    txtPuntca.setHorizontalAlignment(SwingConstants.CENTER);
		    GridBagConstraints gbc_txtPuntca = new GridBagConstraints();
		    gbc_txtPuntca.fill = GridBagConstraints.HORIZONTAL;
		    gbc_txtPuntca.insets = new Insets(0, 0, 0, 5);
		    gbc_txtPuntca.gridx = 3;
		    gbc_txtPuntca.gridy = 1;
		    pnlPuntos.add(txtPuntca, gbc_txtPuntca);
		    txtPuntca.setFont(new Font("SansSerif", Font.PLAIN, 15));
		    txtPuntca.setColumns(10);
		}
		{
		    calendario();
		}
	    }
	    {
		pnlAnotaciones = new JPanel();
		pnlAnotaciones.setOpaque(false);
		pnlAnotaciones.setBorder(
			new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Anotaciones sobre el cliente",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlAnotaciones = new GridBagConstraints();
		gbc_pnlAnotaciones.gridwidth = 6;
		gbc_pnlAnotaciones.insets = new Insets(0, 0, 5, 5);
		gbc_pnlAnotaciones.fill = GridBagConstraints.BOTH;
		gbc_pnlAnotaciones.gridx = 1;
		gbc_pnlAnotaciones.gridy = 9;
		pnlInfo.add(pnlAnotaciones, gbc_pnlAnotaciones);
	    }
	}
	{
	    pnlOpt = new JPanel();
	    pnlOpt.setBackground(new Color(38, 38, 38));
	    contentPane.add(pnlOpt, BorderLayout.SOUTH);
	    GridBagLayout gbl_pnlOpt = new GridBagLayout();
	    gbl_pnlOpt.columnWidths = new int[] { 36, 100, 0, 100, 0, 0 };
	    gbl_pnlOpt.rowHeights = new int[] { 28, 0 };
	    gbl_pnlOpt.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	    gbl_pnlOpt.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
	    pnlOpt.setLayout(gbl_pnlOpt);
	    {
		btnAceptar = new JButton("A\u00F1adir");
		btnAceptar.addActionListener(new BtnAceptarActionListener());
		btnAceptar.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 0;
		pnlOpt.add(btnAceptar, gbc_btnAceptar);
	    }
	    {
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.addActionListener(new BtnCancelarActionListener());
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 0;
		pnlOpt.add(btnCancelar, gbc_btnCancelar);
	    }
	}
    }

    private void setFotoCliente() {
	int numero = (int) (Math.random() * 50) + 1;
	String genero = null;
	if (numero < 25) {
	    genero = "M";
	} else {
	    genero = "F";
	}
	lblIcon.setIcon(new ImageIcon(addCliente.class.getResource("/recursos/fotos/fotoCliente" + genero + ".png")));
    }

    private void anadirCliente() {
	Cliente c = new Cliente();
	c.setNombre(txtNom.getText());
	c.setVip(chckbxVip.isSelected());
	c.setNumCliente(txtNcli.getText());
	c.setNumTel(Integer.valueOf(txtNumtel.getText()));
	c.setCorreo(txtCorreo.getText());
	c.setDireccion(txtDireccion.getText());
	c.setpActuales(Integer.valueOf(txtPuntac.getText()));
	c.setpCanjeados(Integer.valueOf(txtPuntca.getText()));
	c.setpCaducidad(Date.valueOf(datePicker.getJFormattedTextField().getText()));
	
	
	c.setDescripcion("asdjfhoa");
	ag.escribirClientes(c);
	
    }

    private void calendario() {
	Properties p = new Properties();
	p.put("text.today", "Hoy");
	p.put("text.month", "Mes");
	p.put("text.year", "Año");

	UtilDateModel model = new UtilDateModel();
	JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	datePicker.getJFormattedTextField().setFont(new Font("SansSerif", Font.PLAIN, 15));
	datePicker.getJFormattedTextField().setBackground(Color.WHITE);
	datePicker.getJFormattedTextField().setHorizontalAlignment(SwingConstants.CENTER);

	GridBagConstraints gbc_txtCadpu = new GridBagConstraints();
	gbc_txtCadpu.insets = new Insets(0, 0, 0, 5);
	gbc_txtCadpu.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtCadpu.gridx = 5;
	gbc_txtCadpu.gridy = 1;
	pnlPuntos.add(datePicker, gbc_txtCadpu);
    }

    public class DateLabelFormatter extends AbstractFormatter {

	String datePattern = "yyyy-MM-dd";
	SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	@Override
	public Object stringToValue(String text) throws ParseException {
	    return dateFormatter.parseObject(text);
	}

	@Override
	public String valueToString(Object value) throws ParseException {
	    if (value != null) {
		Calendar cal = (Calendar) value;
		return dateFormatter.format(cal.getTime());
	    }

	    return "";
	}

    }

    private class BtnCancelarActionListener implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
	    dispose();
	}
    }

    private class BtnAceptarActionListener implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
	    anadirCliente();
	}
    }

}
