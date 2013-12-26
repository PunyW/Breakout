package ui;

import breakout.Breakout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import sprites.Ball;
import sprites.Brick;
import sprites.Paddle;

public class Canvas extends JPanel implements Updatable {
    private final Breakout breakout;
    private final int width, height;

    public Canvas(Breakout breakout, int width, int height) {
        this.breakout = breakout;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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
        g.setFont(new Font("Dante", 1, 20));
        g.setColor(Color.BLACK);
        g.drawString("Lives: " + breakout.getPlayer().getLives(), 10, 30);
        g.drawString("Score: " + breakout.getPlayer().getScore(), width - 150, 30);
        
        g.dispose();
    }

    @Override
    public void update() {
        repaint();
    }
}
