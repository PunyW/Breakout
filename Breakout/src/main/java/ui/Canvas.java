package ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import sprites.Paddle;

public class Canvas extends JPanel implements Updatable {
    private final Paddle paddle;

    public Canvas(Paddle paddle) {
        this.paddle = paddle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Paint paddle, just a rectangle for now
        g.setColor(Color.BLACK);
        g.fill3DRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight(), true);
    }

    @Override
    public void update() {
        repaint();
    }
}
