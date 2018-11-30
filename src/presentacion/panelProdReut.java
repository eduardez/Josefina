package presentacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JSeparator;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class panelProdReut extends JPanel {
    private JLabel lblNombre;
    private JLabel lblIngred;
    private JLabel lblAlerg;
    private JSeparator separator;
    private JSeparator separator_1;
    private JLabel lblFoto;

    /**
     * Create the panel.
     * 
     */
    public panelProdReut(){
    	setOpaque(false);
	inicializar("Nombre del plato", "Ingredientes:", "Alergenos:");
    }
    public panelProdReut(String nombre, String ingredientes, String alergenos) {
	inicializar(nombre,ingredientes,alergenos);
    }
    private void inicializar(String nombre, String ingredientes, String alergenos) {
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{36, 20, 64, 615, 56, 0};
	gridBagLayout.rowHeights = new int[]{17, 14, 14, 0, 0, 15, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
	setLayout(gridBagLayout);
	{
		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 3;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		add(separator, gbc_separator);
	}
	{
	    lblNombre = new JLabel(nombre);
	    lblNombre.setFont(new Font("SansSerif", Font.BOLD, 19));
	    GridBagConstraints gbc_lblNombre = new GridBagConstraints();
	    gbc_lblNombre.gridwidth = 2;
	    gbc_lblNombre.anchor = GridBagConstraints.NORTH;
	    gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
	    gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNombre.gridx = 2;
	    gbc_lblNombre.gridy = 1;
	    add(lblNombre, gbc_lblNombre);
	}
	{
		lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon(panelProdReut.class.getResource("/recursos/fotos/fotoCarne.png")));
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.gridheight = 3;
		gbc_lblFoto.gridwidth = 2;
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 2;
		add(lblFoto, gbc_lblFoto);
	}
	{
	    lblIngred = new JLabel(ingredientes);
	    lblIngred.setFont(new Font("SansSerif", Font.PLAIN, 16));
	    GridBagConstraints gbc_lblIngred = new GridBagConstraints();
	    gbc_lblIngred.anchor = GridBagConstraints.NORTH;
	    gbc_lblIngred.fill = GridBagConstraints.HORIZONTAL;
	    gbc_lblIngred.insets = new Insets(0, 0, 5, 5);
	    gbc_lblIngred.gridx = 3;
	    gbc_lblIngred.gridy = 2;
	    add(lblIngred, gbc_lblIngred);
	}
	{
	    lblAlerg = new JLabel(alergenos);
	    lblAlerg.setFont(new Font("SansSerif", Font.PLAIN, 16));
	    GridBagConstraints gbc_lblAlerg = new GridBagConstraints();
	    gbc_lblAlerg.anchor = GridBagConstraints.NORTH;
	    gbc_lblAlerg.fill = GridBagConstraints.HORIZONTAL;
	    gbc_lblAlerg.insets = new Insets(0, 0, 5, 5);
	    gbc_lblAlerg.gridx = 3;
	    gbc_lblAlerg.gridy = 4;
	    add(lblAlerg, gbc_lblAlerg);
	}
	{
		separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 0, 5);
		gbc_separator_1.gridwidth = 3;
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 5;
		add(separator_1, gbc_separator_1);
	}

    }
}
