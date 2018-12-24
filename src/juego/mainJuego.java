package juego;

import javax.swing.*;

public class mainJuego {

    public static int WIDTH = 500;
    public static int HEIGHT = 510;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);

        controlListener control = controlListener.getInstance();
        frame.addKeyListener(control);

        pnlJuego panel = new pnlJuego();
        frame.add(panel);
    }
}