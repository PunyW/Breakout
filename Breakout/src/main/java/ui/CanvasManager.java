package ui;

import ui.canvas.BackgroundCanvas;
import ui.canvas.GameOverCanvas;
import ui.canvas.PauseCanvas;
import ui.canvas.PlayCanvas;
import ui.canvas.MainMenuCanvas;
import breakout.Breakout;
import gamestate.*;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Joel
 */
public class CanvasManager extends JPanel implements Updatable {

    private final GameStateManager gsm;
    private MainMenuCanvas menuCanvas;
    private PlayCanvas playCanvas;
    private PauseCanvas pauseCanvas;
    private GameOverCanvas defeatCanvas;
    private BackgroundCanvas bg;

    /**
     * Construct canvas manager, which is responsible for handling rendering of
     * the game.
     *
     * @param breakout breakout the game
     * @param width frame width
     * @param height frame height
     */
    public CanvasManager(Breakout breakout, int width, int height) {
        this.gsm = breakout.getGameStateManager();
        init(breakout, width, height);

    }

    /**
     * Initialize all the different canvas's
     *
     * @param breakout main game
     * @param w frame width
     * @param h frame height
     */
    private void init(Breakout breakout, int w, int h) {
        menuCanvas = new MainMenuCanvas(breakout, gsm);
        playCanvas = new PlayCanvas(breakout, w, h);
        pauseCanvas = new PauseCanvas(h);
        defeatCanvas = new GameOverCanvas(breakout, gsm);
        bg = new BackgroundCanvas();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        bg.paint(g);

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
                pauseCanvas.paint(g);
                break;
            case DEFEAT:
                playCanvas.paint(g);
                defeatCanvas.paint(g);
                break;
            case HELP:
                paintHelp(g);
                break;
            case NEXTLEVEL:
                break;
        }
        g.dispose();
    }

    private void paintHelp(Graphics g) {
    }

    private void paintEndScreen(Graphics g) {
    }

    /**
     * Repaint the canvas.
     */
    @Override
    public void update() {
        repaint();
    }
}
