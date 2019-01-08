package presentacion;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.util;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;

public class gestPedidos extends JPanel {
    private JTabbedPane pnlPedidos;
    private JPanel pnlDomicilio;
    private JPanel pnlMesa;
    private JPanel pnlRecoger;
    private JPanel pnlOpciones;
    private JTable tblDomicilio;
    private util ut = new util();
    private JTable tblRecoger;
    private JTable tblMesa;
    private JScrollPane scroll_1;
    private JScrollPane scroll_2;
    private JPanel pnlInfo;
    private JTabbedPane pnlMapas;
    private mapaCiu mapaCiu;
    private JLabel mapaRest;
    private JTextPane txtpnInfo;

    /**
     * Create the panel.
     */
    public gestPedidos() {
	setBackground(Color.WHITE);
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 956, 0 };
	gridBagLayout.rowHeights = new int[] { 248, 450, 0 };
	gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
	gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
	setLayout(gridBagLayout);
	{
	    pnlOpciones = new JPanel();
	    pnlOpciones.setBackground(Color.WHITE);
	    GridBagConstraints gbc_pnlOpciones = new GridBagConstraints();
	    gbc_pnlOpciones.fill = GridBagConstraints.BOTH;
	    gbc_pnlOpciones.gridx = 0;
	    gbc_pnlOpciones.gridy = 1;
	    add(pnlOpciones, gbc_pnlOpciones);
	    GridBagLayout gbl_pnlOpciones = new GridBagLayout();
	    gbl_pnlOpciones.columnWidths = new int[] { 304, 182, 0 };
	    gbl_pnlOpciones.rowHeights = new int[] { 0, 0 };
	    gbl_pnlOpciones.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
	    gbl_pnlOpciones.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
	    pnlOpciones.setLayout(gbl_pnlOpciones);
	    {
		pnlInfo = new JPanel();
		pnlInfo.setBorder(new TitledBorder(null, "Informacion sobre el restaurante", TitledBorder.LEADING,
			TitledBorder.TOP, new Font("SansSerif", Font.PLAIN, 15), null));
		pnlInfo.setOpaque(false);
		GridBagConstraints gbc_pnlInfo = new GridBagConstraints();
		gbc_pnlInfo.insets = new Insets(0, 0, 0, 5);
		gbc_pnlInfo.fill = GridBagConstraints.BOTH;
		gbc_pnlInfo.gridx = 0;
		gbc_pnlInfo.gridy = 0;
		pnlOpciones.add(pnlInfo, gbc_pnlInfo);
		pnlInfo.setLayout(new BorderLayout(0, 0));
		{
		    txtpnInfo = new JTextPane();
		    txtpnInfo.setFont(new Font("SansSerif", Font.PLAIN, 16));
		    txtpnInfo.setContentType("text/html");
		    txtpnInfo.setText(
			    "<html><body><h1><span style=\"color: #009999;\">Restaurante La Josefina</span></h1>\r\n"
				    + "<h3>Telefono de contacto:</h3>\r\n" + "<blockquote>\r\n"
				    + "<p>926 548 7365</p>\r\n" + "</blockquote>\r\n" + "<h3>Direccion:</h3>\r\n"
				    + "<blockquote>\r\n" + "<p>Calle de la Amargura, N&ordm;14</p>\r\n"
				    + "</blockquote>\r\n" + "<h3>Horario:</h3>\r\n" + "<blockquote>\r\n"
				    + "<p>Martes - Domingo</p>\r\n" + "<p>10:00 - 16:30</p>\r\n"
				    + "<p>20:00 - 01:00</p>\r\n" + "</blockquote></body></html>");
		    pnlInfo.add(txtpnInfo, BorderLayout.CENTER);
		}
	    }
	    {
		pnlMapas = new JTabbedPane(JTabbedPane.TOP);
		pnlMapas.setBorder(new TitledBorder(null, "Planos", TitledBorder.LEADING, TitledBorder.TOP,
			new Font("SansSerif", Font.PLAIN, 15), null));
		pnlMapas.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_pnlMapas = new GridBagConstraints();
		gbc_pnlMapas.fill = GridBagConstraints.BOTH;
		gbc_pnlMapas.gridx = 1;
		gbc_pnlMapas.gridy = 0;
		pnlOpciones.add(pnlMapas, gbc_pnlMapas);
		{
		    mapaCiu = new mapaCiu();
		    pnlMapas.addTab("Ciudad Real",
			    new ImageIcon(gestPedidos.class.getResource("/recursos/mapa/mapaIcon.png")),
			    mapaCiu.getPanel(), null);
		}
		{
		    mapaRest = new JLabel("");
		    mapaRest.setIcon(new ImageIcon(gestPedidos.class.getResource("/recursos/fotos/restaurante.jpg")));
		    pnlMapas.addTab("Restaurante ",
			    new ImageIcon(gestPedidos.class.getResource("/recursos/mapa/restMapIcon.png")), mapaRest,
			    null);
		}
	    }
	}
	{
	    pnlPedidos = new JTabbedPane(JTabbedPane.TOP);
	    pnlPedidos.setOpaque(true);
	    pnlPedidos.setBackground(new Color(38, 38, 38));
	    pnlPedidos.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    GridBagConstraints gbc_pnlPedidos = new GridBagConstraints();
	    gbc_pnlPedidos.insets = new Insets(0, 0, 5, 0);
	    gbc_pnlPedidos.fill = GridBagConstraints.BOTH;
	    gbc_pnlPedidos.gridx = 0;
	    gbc_pnlPedidos.gridy = 0;
	    add(pnlPedidos, gbc_pnlPedidos);
	    {
		pnlDomicilio = new JPanel();
		pnlDomicilio.setBackground(Color.WHITE);
		pnlPedidos.addTab("Envios a domicilio  ",
			new ImageIcon(gestPedidos.class.getResource("/recursos/fotos/envioDomicilio.png")),
			pnlDomicilio, null);
		pnlDomicilio.setLayout(new BorderLayout(0, 0));

	    }
	    {
		pnlMesa = new JPanel();
		pnlMesa.setBackground(Color.WHITE);
		pnlPedidos.addTab("Tomar en mesa  ",
			new ImageIcon(gestPedidos.class.getResource("/recursos/fotos/servMesa.png")), pnlMesa, null);
		pnlMesa.setLayout(new BorderLayout(0, 0));
	    }
	    {
		pnlRecoger = new JPanel();
		pnlRecoger.setBackground(Color.WHITE);
		pnlPedidos.addTab("Recogida en local",
			new ImageIcon(gestPedidos.class.getResource("/recursos/fotos/recogidaLoc.png")), pnlRecoger,
			null);
		pnlRecoger.setLayout(new BorderLayout(0, 0));
	    }
	    {

		tblDomicilio = ut.generarTabla("domicilio");
		JScrollPane scroll = new JScrollPane(tblDomicilio);
		scroll.setOpaque(false);
		scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_AS_NEEDED);
		pnlDomicilio.add(scroll, BorderLayout.CENTER);
		pnlDomicilio.add(tblDomicilio.getTableHeader(), BorderLayout.NORTH);

		tblRecoger = ut.generarTabla("recoger");
		scroll_1 = new JScrollPane(tblRecoger);
		scroll_1.setOpaque(false);
		scroll_1.setVerticalScrollBarPolicy(scroll_1.VERTICAL_SCROLLBAR_AS_NEEDED);
		pnlRecoger.add(scroll_1, BorderLayout.CENTER);
		pnlRecoger.add(tblRecoger.getTableHeader(), BorderLayout.NORTH);

		tblMesa = ut.generarTabla("mesa");
		scroll_2 = new JScrollPane(tblMesa);
		scroll_2.setOpaque(false);
		scroll_2.setVerticalScrollBarPolicy(scroll_2.VERTICAL_SCROLLBAR_AS_NEEDED);
		pnlMesa.add(scroll_2, BorderLayout.CENTER);
		pnlMesa.add(tblMesa.getTableHeader(), BorderLayout.NORTH);

	    }
	}

    }

}
