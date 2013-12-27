package ui;

import breakout.Breakout;
import gamestate.*;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
                paintMenuState(g);
                break;
            case PLAYSTATE:
                playCanvas.paint(g);
                g.dispose();
                break;
            case PAUSE:
                playCanvas.paint(g);
                pauseCanvas.paint(g, height);
                g.dispose();
                break;
            case ENDSCREEN:
                paintEndScreen(g);
                break;
            case HELP:
                paintHelp(g);
                break;
        }

    }

    private void paintMenuState(Graphics g) {
        menuCanvas.paint(g);
        g.dispose();
    }

    private void paintHelp(Graphics g) {
        g.dispose();
    }

    private void paintEndScreen(Graphics g) {
        g.dispose();
    }

    /**
     *
     */
    @Override
    public void update() {
        repaint();
    }
}
