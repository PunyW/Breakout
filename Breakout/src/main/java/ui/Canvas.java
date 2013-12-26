package ui;

import breakout.Breakout;
import gamestate.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import sprites.Ball;
import sprites.Brick;
import sprites.Paddle;

/**
 *
 * @author Joel
 */
public class Canvas extends JPanel implements Updatable {

    private final int width, height;
    private final GameStateManager gsm;
    private final MenuCanvas menuCanvas;
    private final PlayCanvas playCanvas;

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
                playCanvas.paintPlayState(g);
                break;
            case PAUSE:
                paintPauseState(g);
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
        menuCanvas.paintMenu(g);
        g.dispose();
    }

    private void paintPauseState(Graphics g) {
        g.setFont(new Font("Century", 1, 40));
        g.setColor(Color.BLACK);
        g.drawString("Game is paused", 240, height / 2 - 80);
        g.drawString("Hit Space to continue", 190, height / 2 + 35);

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
