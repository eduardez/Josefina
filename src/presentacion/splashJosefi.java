package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class splashJosefi extends JFrame implements Runnable {

    private JPanel contentPane;
    private JLabel lblBg;
    private JLabel lblGif;
    private Thread tiempo = null;

    public splashJosefi() {
	inicializar();
	tiempo = new Thread(this);
	tiempo.start();
    }

    private void inicializar() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setAlwaysOnTop(true);
	setBounds(100, 100, 547, 325);
	setUndecorated(true);
	setLocationRelativeTo(null);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	{
	    lblGif = new JLabel("");
	    lblGif.setIcon(new ImageIcon(splashJosefi.class.getResource("/recursos/cargando.gif")));
	    lblGif.setBounds(387, 225, 89, 89);
	    contentPane.add(lblGif);
	}
	{
	    lblBg = new JLabel("");
	    lblBg.setBounds(0, 0, getWidth(), getHeight());
	    lblBg.setIcon(new ImageIcon(splashJosefi.class.getResource("/recursos/splash.jpg")));
	    contentPane.add(lblBg);
	}
    }

    @Override
    public void run() {
	try {
	    File f = new File("datos.accdb");
	    //Pasan 5 segundos y se inicia el login
	    Thread.sleep(4300);
	    //Comprobar si existe una base de datos
	    
	    if(f.exists()) {
	    UI_Login log = new UI_Login();
	    log.setVisible(true);
	    log.setLocationRelativeTo(null);
	    }else {
		JOptionPane optP = new JOptionPane("La base de datos ha sido borrada o ha cambiado.\nPor favor, compruebe que existe una BBDD llamada 'datos.accdb' en este mismo nivel.", JOptionPane.ERROR_MESSAGE);    
		JDialog di = optP.createDialog("Error BBDD");
		di.setAlwaysOnTop(true);
		di.setVisible(true);
	    }
	    this.dispose();

	} catch (InterruptedException e) {
	    e.printStackTrace();

	}
    }
}
