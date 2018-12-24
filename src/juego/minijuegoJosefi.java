package juego;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class minijuegoJosefi {

    public static final int PIPE_DELAY = 100;

    private Boolean paused;

    private int pauseDelay;
    private int restartDelay;
    private int tenDelay;

    private flyJosefi josefi;
    private ArrayList<tenedor> tenedores;
    private controlListener controlListener;

    public int score;
    public Boolean gameover;
    public Boolean started;

    public minijuegoJosefi() {
	controlListener = controlListener.getInstance();
            restart();
        }

    public void restart() {
	paused = false;
	started = false;
	gameover = false;

	score = 0;
	pauseDelay = 0;
	restartDelay = 0;
	tenDelay = 0;

	josefi = new flyJosefi();
	tenedores = new ArrayList<tenedor>();
    }

    public void update() {
	watchForStart();

	if (!started)
	    return;

	watchForPause();
	watchForReset();

	if (paused)
	    return;

	josefi.update();

	if (gameover)
	    return;

	movetenedores();
	checkForCollisions();
    }

    public ArrayList<rend> getRenders() {
	ArrayList<rend> renders = new ArrayList<rend>();
	renders.add(new rend(0, 0, "src/recursos/juego/background.png"));
	for (tenedor ten : tenedores)
	    renders.add(ten.getRender());
	renders.add(new rend(0, 0, "src/recursos/juego/foreground.png"));
	renders.add(josefi.getRender());
	return renders;
    }

    private void watchForStart() {
	if (!started && controlListener.baja(KeyEvent.VK_SPACE)) {
	    started = true;
	}
    }

    private void watchForPause() {
	if (pauseDelay > 0)
	    pauseDelay--;

	if (controlListener.baja(KeyEvent.VK_P) && pauseDelay <= 0) {
	    paused = !paused;
	    pauseDelay = 10;
	}
    }

    private void watchForReset() {
	if (restartDelay > 0)
	    restartDelay--;

	if (controlListener.baja(KeyEvent.VK_R) && restartDelay <= 0) {
	    restart();
	    restartDelay = 10;
	    return;
	}
    }

    private void movetenedores() {
	tenDelay--;

	if (tenDelay < 0) {
	    tenDelay = PIPE_DELAY;
	    tenedor northtenedor = null;
	    tenedor southtenedor = null;

	    // Look for tenedores off the screen
	    for (tenedor ten : tenedores) {
		if (ten.x - ten.width < 0) {
		    if (northtenedor == null) {
			northtenedor = ten;
		    } else if (southtenedor == null) {
			southtenedor = ten;
			break;
		    }
		}
	    }

	    if (northtenedor == null) {
		tenedor ten = new tenedor("north");
		tenedores.add(ten);
		northtenedor = ten;
	    } else {
		northtenedor.reset();
	    }

	    if (southtenedor == null) {
		tenedor ten = new tenedor("south");
		tenedores.add(ten);
		southtenedor = ten;
	    } else {
		southtenedor.reset();
	    }

	    northtenedor.y = southtenedor.y + southtenedor.height + 175;
	}

	for (tenedor ten : tenedores) {
	    ten.update();
	}
    }

    private void checkForCollisions() {

	for (tenedor ten : tenedores) {
	    if (ten.collides(josefi.x, josefi.y, josefi.width, josefi.height)) {
		gameover = true;
		josefi.dead = true;
	    } else if (ten.x == josefi.x && ten.orientation.equalsIgnoreCase("south")) {
		score++;
	    }
	}

	// Ground + josefi collision
	if (josefi.y + josefi.height > mainJuego.HEIGHT - 80) {
	    gameover = true;
	    josefi.y = mainJuego.HEIGHT - 80 - josefi.height;
	}

    }
}
