package ui;

import breakout.Breakout;
import gamestate.*;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Joel
 */
public class Canvas extends JPanel implements Updatable {

    private final int width, height;
    private final GameStateManager gsm;
    private final MenuCanvas menuCanvas;
    private final PlayCanvas playCanvas;
    private final PauseCanvas pauseCanvas;
    private final Breakout breakout;

    /**
     *
     * @param breakout breakout the game
     * @param width frame width
     * @param height frame height
     */
    public Canvas(Breakout breakout, int width, int height) {
        this.width = width;
        this.height = height;
        this.gsm = breakout.getGameStateManager();
        this.breakout = breakout;
        menuCanvas = new MenuCanvas();
        playCanvas = new PlayCanvas(breakout, width, height);
        pauseCanvas = new PauseCanvas();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        GameStates gameState = gsm.getState();
        switch (gameState) {
            case MENUSTATE:
                menuCanvas.paint(g);
                break;
            case PLAYSTATE:
                playCanvas.paint(g);
                break;
            case PAUSE:
                playCanvas.paint(g);
                pauseCanvas.paint(g, height);
                break;
            case ENDSCREEN:
                paintEndScreen(g);
                break;
            case HELP:
                paintHelp(g);
                break;
        }
        g.dispose();
    }

    private void paintHelp(Graphics g) {
    }

    private void paintEndScreen(Graphics g) {
    }

    /**
     *
     */
    @Override
    public void update() {
        repaint();
    }
}
