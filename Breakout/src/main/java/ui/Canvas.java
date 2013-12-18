package ui;

import entities.BrickCreator;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import sprites.Ball;
import sprites.Brick;
import sprites.Paddle;

public class Canvas extends JPanel implements Updatable {

    private Brick[][] bricks;
    private final Paddle paddle;
    private final Ball ball;

    public Canvas(Paddle paddle, Ball ball, Brick[][] bricks, int width, int height) {
        this.paddle = paddle;
        this.ball = ball;
        this.bricks = bricks;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Paint paddle
        g.setColor(Color.BLACK);
        g.fill3DRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight(), true);

        // Paint ball
        g.setColor(Color.RED);
        g.fill3DRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), true);

        // Paint bricks
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                Brick brick = bricks[i][j];
                if (brick.alive()) {
                    if(brick.getHitPoints() > 1) {
                        g.setColor(Color.MAGENTA);
                    } else {
                        g.setColor(Color.BLUE);
                    }
                    g.fill3DRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight(), true);
                }
            }
        }
        g.dispose();
    }

    @Override
    public void update() {
        repaint();
    }
}
