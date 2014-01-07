package ui;

import ui.canvas.BackgroundCanvas;
import ui.canvas.GameOverCanvas;
import ui.canvas.PauseCanvas;
import ui.canvas.PlayCanvas;
import ui.canvas.MainMenuCanvas;
import breakout.Breakout;
import gamestate.*;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import ui.canvas.Canvas;
import ui.canvas.HelpCanvas;
import ui.canvas.NextLevelCanvas;

/**
 * Canvas manager which is responsible for handling all the rendering of the
 * game
 *
 * @author Joel
 */
public class CanvasManager extends JPanel implements Updatable {

    private final GameStateManager gsm;
    private BackgroundCanvas bg;
    private final Map<GameStates, Canvas> canvases;

    /**
     * Construct canvas manager.
     *
     * @param breakout breakout the game
     * @param width frame width
     * @param height frame height
     */
    public CanvasManager(Breakout breakout, int width, int height) {
        this.gsm = breakout.getGameStateManager();
        canvases = new HashMap<>();
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
        canvases.put(GameStates.MENUSTATE, new MainMenuCanvas(breakout, gsm));
        canvases.put(GameStates.PLAYSTATE, new PlayCanvas(breakout, w, h));
        canvases.put(GameStates.PAUSE, new PauseCanvas(h));
        canvases.put(GameStates.GAME_OVER, new GameOverCanvas(breakout, gsm));
        canvases.put(GameStates.LEVEL_CLEARED, new NextLevelCanvas(breakout));
        canvases.put(GameStates.HELP, new HelpCanvas());
        bg = new BackgroundCanvas();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        bg.paint(g);

        // If pause or game over state is active, render play first then current
        if (gsm.getState() == GameStates.PAUSE
                || gsm.getState() == GameStates.GAME_OVER) {
            canvases.get(GameStates.PLAYSTATE).paint(g);
        }
        canvases.get(gsm.getState()).paint(g);

        g.dispose();
    }

    /**
     * Repaint the canvas.
     */
    @Override
    public void update() {
        repaint();
    }
}
