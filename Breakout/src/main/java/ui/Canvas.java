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

    private final Breakout breakout;
    private final int width, height;
    private final GameStateManager gsm;

    /**
     *
     * @param breakout breakout the game
     * @param width frame width
     * @param height frame height
     */
    public Canvas(Breakout breakout, int width, int height) {
        this.breakout = breakout;
        this.width = width;
        this.height = height;
        this.gsm = breakout.getGameStateManager();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        GameStates gameState = gsm.getState();
        switch(gameState) {
            case MENUSTATE:
                paintMenuState(g);
                break;
            case PLAYSTATE:
                paintPlayState(g);
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
        g.dispose();
    }
    
    private void paintPauseState(Graphics g) {
        g.setFont(new Font("Century", 1, 40));
        g.setColor(Color.BLACK);
        g.drawString("Game is paused", 240, height / 2 - 80);
        g.drawString("Hit Space to continue", 190, height / 2 + 35);
        
        g.dispose();
    }
    
    private void paintHelp(Graphics g){
        g.dispose();
    }
    
    private void paintEndScreen(Graphics g) {
        g.dispose();
    }
    
    private void paintPlayState(Graphics g) {
        // Paint paddle
        Paddle paddle = breakout.getPaddle();
        g.setColor(Color.BLACK);
        g.fill3DRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight(), true);

        // Paint ball
        Ball ball = breakout.getBall();
        g.setColor(Color.RED);
        g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());

        // Paint bricks
        Brick[][] bricks = breakout.getBricks();
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                Brick brick = bricks[i][j];
                if (brick.alive()) {
                    if (brick.getHitPoints() > 1) {
                        g.setColor(Color.MAGENTA);
                    } else {
                        g.setColor(Color.BLUE);
                    }
                    g.fill3DRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight(), true);
                }
            }
        }

        // Print lives and score
        g.setFont(new Font("Century", 1, 20));
        g.setColor(Color.BLACK);
        g.drawString("Lives: " + breakout.getPlayer().getLives(), 10, 30);
        g.drawString("Score: " + breakout.getPlayer().getScore(), width - 150, 30);

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
