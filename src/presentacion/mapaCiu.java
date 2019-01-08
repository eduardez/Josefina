package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class mapaCiu extends JPanel {

    private JPanel contentPane;
    private JToolBar toolBar;
    private JScrollPane scrollPane;
    // private JLabel AreaDibuj;
    private JButton btnEnReparto;
    private JButton btnEntregado;
    // Area de dibujo personalizada (creada extendiendo de JLabel)
    private AreaDibujo AreaDibuj;
    // Variable que almacena el modo de dibujado seleccionado por el usuario
    int modo = -1;
    private final int PEDIDO = 1;
    private final int ENREPARTO = 2;
    private final int ENTREGADO = 3;
    // Cuersores e imagenes
    private Toolkit toolkit;
    private Image imagPedido;
    private Image imagEnReparto;
    private Image imagEntregado;
    private Image imagCursorPedido;
    private Image imagCursorEnReparto;
    private Image imagCursorEntregado;
    private Cursor cursorPedido;
    private Cursor cursorEnReparto;
    private Cursor cursorEntregado;
    // Variables para almacenar las coordenadas actuales
    private int x, y;

    
    public mapaCiu() {
	initialize();
    }
    public JPanel getPanel() {
	return contentPane;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	setBounds(100, 100, 1180, 769);

	// Creación de imágenes y cursores
	toolkit = Toolkit.getDefaultToolkit();
	imagPedido = toolkit.getImage(getClass().getClassLoader().getResource("recursos/mapa/maps-and-flags.png"));
	imagEnReparto = toolkit.getImage(getClass().getClassLoader().getResource("recursos/mapa/scooter-2.png"));
	imagEntregado = toolkit.getImage(getClass().getClassLoader().getResource("recursos/mapa/check.png"));
	imagCursorPedido = toolkit
		.getImage(getClass().getClassLoader().getResource("recursos/mapa/maps-and-flags.png"));
	imagCursorEnReparto = toolkit.getImage(getClass().getClassLoader().getResource("recursos/mapa/scooter-2.png"));
	imagCursorEntregado = toolkit.getImage(getClass().getClassLoader().getResource("recursos/mapa/check.png"));
	// Creación de los cursores
	cursorEntregado = toolkit.createCustomCursor(imagEntregado, new Point(0, 0), "CURSOR_ENTREGADO");
	cursorPedido = toolkit.createCustomCursor(imagCursorPedido, new Point(0, 0), "CURSOR_PEDIDO");
	cursorEnReparto = toolkit.createCustomCursor(imagCursorEnReparto, new Point(0, 0), "CURSOR_ENREPARTO");
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	{
	    toolBar = new JToolBar();
	    toolBar.setBackground(Color.WHITE);
	    contentPane.add(toolBar, BorderLayout.NORTH);
	    {
		JButton btnPedido = new JButton("");
		btnPedido.setBackground(Color.WHITE);
		btnPedido.addActionListener(new BtnPedidoActionListener());
		btnPedido.setIcon(new ImageIcon(mapaCiu.class.getResource("/recursos/mapa/maps-and-flags.png")));
		toolBar.add(btnPedido);
	    }
	    {
		btnEnReparto = new JButton("");
		btnEnReparto.setBackground(Color.WHITE);
		btnEnReparto.addActionListener(new BtnEnRepartoActionListener());
		btnEnReparto.setIcon(new ImageIcon(mapaCiu.class.getResource("/recursos/mapa/scooter-2.png")));
		toolBar.add(btnEnReparto);
	    }
	    {
		btnEntregado = new JButton("");
		btnEntregado.setBackground(Color.WHITE);
		btnEntregado.addActionListener(new BtnEntregadoActionListener());
		btnEntregado.setIcon(new ImageIcon(mapaCiu.class.getResource("/recursos/mapa/check.png")));
		toolBar.add(btnEntregado);
	    }
	}
	{
	    scrollPane = new JScrollPane();
	    contentPane.add(scrollPane, BorderLayout.CENTER);
	    {
		AreaDibuj = new AreaDibujo();
		AreaDibuj.addMouseListener(new AreaDibujMouseListener());
		AreaDibuj.setIcon(new ImageIcon(mapaCiu.class.getResource("/recursos/fotos/mapaCiu.jpg")));
		scrollPane.setViewportView(AreaDibuj);
	    }
	}
    }

    private class BtnPedidoActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    modo = PEDIDO;
	    contentPane.setCursor(cursorPedido);
	}
    }

    private class BtnEnRepartoActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    modo = ENREPARTO;
	    contentPane.setCursor(cursorEnReparto);
	}
    }

    private class BtnEntregadoActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    modo = ENTREGADO;
	    contentPane.setCursor(cursorEntregado);
	}
    }

    private class AreaDibujMouseListener extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
	    x = e.getX();
	    y = e.getY();
	    toolkit = Toolkit.getDefaultToolkit();
	    switch (modo) {
	    case PEDIDO:
		AreaDibuj.addObjetoGrafico(new Imagen(x, y, imagPedido));
		AreaDibuj.repaint();
		break;
	    case ENREPARTO:
		AreaDibuj.addObjetoGrafico(new Imagen(x, y, imagEnReparto));
		AreaDibuj.repaint();
		break;
	    case ENTREGADO:
		AreaDibuj.addObjetoGrafico(new Imagen(x, y, imagEntregado));
		AreaDibuj.repaint();
		break;
	    }
	}
    }

    public class AreaDibujo extends JLabel {

	private ArrayList<ObjetoGraf> objetosGraficos = new ArrayList<ObjetoGraf>();

	public AreaDibujo() {
	}

	void addObjetoGrafico(ObjetoGraf objg) {
	    objetosGraficos.add(objg);
	}

	public ObjetoGraf getUltimoObjetoGrafico() {
	    return objetosGraficos.get(objetosGraficos.size() - 1);
	}

	public void paint(Graphics g) {
	    super.paint(g);
	    System.out.println(objetosGraficos.size());
	    for (int i = 0; i < objetosGraficos.size(); i++) {
		ObjetoGraf objg = objetosGraficos.get(i);
		if (objg instanceof Imagen) {
		    g.drawImage(((Imagen) objg).getImagen(), objg.getX(), objg.getY(), null);
		}

	    }
	}
    }

    public class ObjetoGraf implements Serializable {
	private int x, y;

	public ObjetoGraf(int x, int y) {
	    this.x = x;
	    this.y = y;
	}

	public void setX(int x) {
	    this.x = x;
	}

	public void setY(int y) {
	    this.y = y;
	}

	public int getX() {
	    return x;
	}

	public int getY() {
	    return y;
	}
    }

    public class Imagen extends ObjetoGraf implements Serializable {
	private Image imagen;

	public Imagen(int x, int y, Image imagen) {
	    super(x, y);
	    this.imagen = imagen;
	}

	public void setImagen(Image imagen) {
	    this.imagen = imagen;
	}

	public Image getImagen() {
	    return imagen;
	}

    }
}
