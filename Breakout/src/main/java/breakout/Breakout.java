/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import sprites.Ball;
import sprites.Paddle;
import ui.Updatable;
import util.BallWallCollision;

/**
 *
 * @author Joel
 */
public class Breakout extends Timer implements ActionListener {
    private Ball ball;
    private Paddle paddle;
    private Updatable updatable;
    private BallWallCollision bwl;
    private boolean running;

    public Breakout(int width, int height) {
        super(1000, null);
        init(width, height, 60);
    }

    public Breakout(int width, int height, int paddleWidth) {
        super(1000, null);
        init(width, height, paddleWidth);
    }

    private void init(int width, int height, int paddleWidth) {
        this.running = true;
        this.paddle = new Paddle(width / 2 - 30, height - 85, 20, paddleWidth);
        this.ball = new Ball(paddle);
        this.bwl = new BallWallCollision(width, height);
        
        addActionListener(this);
        setInitialDelay(100);
    }

    public boolean running() {
        return running;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!running) {
            return;
        }
        ball.launchBall();
        ball.move();
        bwl.checkCollisions(ball, null);
        this.updatable.update();
        setDelay(1000 / 20);
    }

    public Paddle getPaddle() {
        return paddle;
    }
    
    public Ball getBall() {
        return ball;
    }

}
