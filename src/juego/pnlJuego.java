package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class pnlJuego extends JPanel implements Runnable {

    private minijuegoJosefi jueg;

    public pnlJuego() {
	jueg = new minijuegoJosefi();
	new Thread(this).start();
    }

    public void update() {
	jueg.update();
	repaint();
    }

    protected void paintComponent(Graphics g) {
	super.paintComponent(g);

	Graphics2D g2D = (Graphics2D) g;
	for (rend r : jueg.getRenders())
	    if (r.ajustar != null)
		g2D.drawImage(r.img, r.ajustar, null);
	    else
		g.drawImage(r.img, r.x, r.y, null);

	g2D.setColor(Color.BLACK);

	if (!jueg.started) {
	    g2D.setFont(new Font("Sans", Font.PLAIN, 20));
	    g2D.drawString("Pulsa ESPACIO para la diversion", 150, 240);
	} else {
	    g2D.setFont(new Font("Sans", Font.PLAIN, 24));
	    g2D.drawString(Integer.toString(jueg.score), 10, 465);
	}

	if (jueg.gameover) {
	    g2D.setFont(new Font("Sans", Font.PLAIN, 20));
	    g2D.drawString("R para reiniciar", 150, 240);
	}
    }

    public void run() {
	try {
	    while (true) {
		update();
		Thread.sleep(25);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
