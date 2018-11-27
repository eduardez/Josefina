package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Dimension;
import java.awt.Color;

public class panelUser extends JPanel {
	private JLabel lblCamarero;
	private JLabel lblNombre;
	private JLabel lblFechaDeUltimo;
	private JLabel lblMarEnero;
	private JSeparator separator;
	private JLabel lblComida;
	private JLabel lblPedido;

    /**
     * Create the panel.
     */
    public panelUser() {
    	setBackground(new Color(38, 38, 38));
    	GridBagLayout gridBagLayout = new GridBagLayout();
    	gridBagLayout.columnWidths = new int[]{43, 0, 189, 250, 0, 92, 116, 0, 0, 0};
    	gridBagLayout.rowHeights = new int[]{69, 73, 0};
    	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    	gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
    	setLayout(gridBagLayout);
    	{
    		lblCamarero = new JLabel("");
    		lblCamarero.setIcon(new ImageIcon(panelUser.class.getResource("/recursos/panelUser/camarero.png")));
    		GridBagConstraints gbc_lblCamarero = new GridBagConstraints();
    		gbc_lblCamarero.insets = new Insets(0, 0, 0, 5);
    		gbc_lblCamarero.gridheight = 2;
    		gbc_lblCamarero.gridx = 1;
    		gbc_lblCamarero.gridy = 0;
    		add(lblCamarero, gbc_lblCamarero);
    	}
    	{
    		lblNombre = new JLabel("Aitor Gomez Serrano");
    		lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 15));
    		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
    		gbc_lblNombre.anchor = GridBagConstraints.SOUTHEAST;
    		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
    		gbc_lblNombre.gridx = 2;
    		gbc_lblNombre.gridy = 0;
    		add(lblNombre, gbc_lblNombre);
    	}
    	{
    		separator = new JSeparator();
    		separator.setSize(new Dimension(2, 156));
    		separator.setOpaque(true);
    		separator.setMinimumSize(new Dimension(2, 156));
    		separator.setPreferredSize(new Dimension(2, 156));
    		separator.setOrientation(SwingConstants.VERTICAL);
    		GridBagConstraints gbc_separator = new GridBagConstraints();
    		gbc_separator.gridheight = 2;
    		gbc_separator.insets = new Insets(0, 0, 0, 5);
    		gbc_separator.gridx = 4;
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
    		gbc_lblComida.gridx = 5;
    		gbc_lblComida.gridy = 0;
    		add(lblComida, gbc_lblComida);
    	}
    	{
    		lblPedido = new JLabel("Pedido Actual");
    		lblPedido.setForeground(new Color(0, 153, 153));
    		lblPedido.setFont(new Font("SansSerif", Font.BOLD, 22));
    		lblPedido.setHorizontalAlignment(SwingConstants.CENTER);
    		GridBagConstraints gbc_lblPedido = new GridBagConstraints();
    		gbc_lblPedido.gridheight = 2;
    		gbc_lblPedido.insets = new Insets(0, 0, 5, 5);
    		gbc_lblPedido.gridx = 6;
    		gbc_lblPedido.gridy = 0;
    		add(lblPedido, gbc_lblPedido);
    	}
    	{
    		lblFechaDeUltimo = new JLabel("Fecha de ultimo acceso: ");
    		lblFechaDeUltimo.setFont(new Font("SansSerif", Font.PLAIN, 15));
    		GridBagConstraints gbc_lblFechaDeUltimo = new GridBagConstraints();
    		gbc_lblFechaDeUltimo.anchor = GridBagConstraints.EAST;
    		gbc_lblFechaDeUltimo.insets = new Insets(0, 0, 0, 5);
    		gbc_lblFechaDeUltimo.gridx = 2;
    		gbc_lblFechaDeUltimo.gridy = 1;
    		add(lblFechaDeUltimo, gbc_lblFechaDeUltimo);
    	}
    	{
    		lblMarEnero = new JLabel("Mar 15 - 01 - 2018 | 18:00:12");
    		lblMarEnero.setHorizontalAlignment(SwingConstants.LEFT);
    		lblMarEnero.setFont(new Font("SansSerif", Font.PLAIN, 15));

    		GridBagConstraints gbc_lblMarEnero = new GridBagConstraints();
    		gbc_lblMarEnero.insets = new Insets(0, 0, 0, 5);
    		gbc_lblMarEnero.gridx = 3;
    		gbc_lblMarEnero.gridy = 1;
    		add(lblMarEnero, gbc_lblMarEnero);
    	}

    }

}
