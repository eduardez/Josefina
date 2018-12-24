package juego;

import java.awt.Image;
import java.awt.geom.AffineTransform;

public class rend {
    public int x;
    public int y;
    public Image img;
    public AffineTransform ajustar;

    public rend() {
        }

    public rend(int x, int y, String imagePath) {
            this.x = x;
            this.y = y;
            this.img = utilJuego.loadImage(imagePath);
        }

}
