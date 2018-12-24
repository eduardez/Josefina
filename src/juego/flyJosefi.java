package juego;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class flyJosefi {


        public int x;
        public int y;
        public int width;
        public int height;

        public boolean dead;

        public double yvel;
        public double gravity;

        private int jumpDelay;
        private double rotation;

        private Image img;
        private controlListener controlListener;

        public flyJosefi() {
            x = 100;
            y = 150;
            yvel = 0;
            width = 45;
            height = 32;
            gravity = 0.5;
            jumpDelay = 0;
            rotation = 0.0;
            dead = false;

            controlListener = controlListener.getInstance();
        }

        public void update() {
            yvel += gravity;

            if (jumpDelay > 0)
                jumpDelay--;

            if (!dead && controlListener.baja(KeyEvent.VK_SPACE) && jumpDelay <= 0) {
                yvel = -10;
                jumpDelay = 10;
            }

            y += (int)yvel;
        }

        public rend getRender() {
            rend r = new rend();
            r.x = x;
            r.y = y;

            if (img == null) {
                img = utilJuego.loadImage("src/recursos/juego/josefi.png");     
            }
            r.img = img;

            rotation = (90 * (yvel + 20) / 20) - 90;
            rotation = rotation * Math.PI / 180;

            if (rotation > Math.PI / 2)
                rotation = Math.PI / 2;

            r.ajustar = new AffineTransform();
            r.ajustar.translate(x + width / 2, y + height / 2);
            r.ajustar.rotate(rotation);
            r.ajustar.translate(-width / 2, -height / 2);

            return r;
        }
    
}
