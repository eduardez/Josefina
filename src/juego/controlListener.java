package juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class controlListener implements KeyListener {

    private static controlListener inst;

    private boolean[] teclas;// Array para saber que tecla esta pulsada

    private controlListener() {
	teclas = new boolean[256];
    }

    public static controlListener getInstance() {// Generar instancia para controlar el teclado
	if (inst == null) {
	    inst = new controlListener();
	}
	return inst;
    }

    public void keyPressed(KeyEvent e) {// Poner tecla lambda a true
	if (e.getKeyCode() >= 0 && e.getKeyCode() < teclas.length) {
	    teclas[e.getKeyCode()] = true;
	}
    }

    public void keyReleased(KeyEvent e) {// Regresarla a false
	if (e.getKeyCode() >= 0 && e.getKeyCode() < teclas.length) {
	    teclas[e.getKeyCode()] = false;
	}
    }

    public void keyTyped(KeyEvent e) {
    }

    public boolean baja(int tec) {
	if (tec >= 0 && tec < teclas.length) {
	    return teclas[tec];
	}
	return false;
    }
}
