package breakout;

import entities.BrickCreator;
import entities.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import sprites.Ball;
import sprites.Brick;
import sprites.Paddle;
import ui.Updatable;
import collisiondetection.CollisionDetection;

public class Breakout extends Timer implements ActionListener {

    private Brick[][] bricks;
    private Ball ball;
    private Paddle paddle;
    private Updatable updatable;
    private CollisionDetection cd;
    private Player player;
    private boolean running;

    public Breakout(int width, int height) {
        super(1000, null);
        init(width, height, 60);
    }

    // Constructor for custom paddle size
    public Breakout(int width, int height, int paddleWidth) {
        super(1000, null);
        init(width, height, paddleWidth);
    }

    private void init(int width, int height, int paddleWidth) {
        this.running = true;
        this.paddle = new Paddle(width / 2 - 30, height - 85, 20, paddleWidth, width);
        this.ball = new Ball(paddle);
        this.cd = new CollisionDetection(width, height);
        this.player = new Player(3);
        BrickCreator bc = new BrickCreator(width, height);
        bricks = bc.createBrickLayout();

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

        // Ball & Paddle Collision
        if (cd.collides(ball, paddle)) {
            if (ball.getY() < paddle.getY()) {
                ball.reverseUpwardsMomentum();
                // SET DIRECTION HERE
            } else {
                ball.reverseSidewaysMomentum();
            }
        }

        // Ball and brick collision
        // Ball & Wall collision
        this.cd.ballWallCollision(ball, player);
        this.updatable.update();
        setDelay(1000 / 20);
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public Ball getBall() {
        return ball;
    }
    
    public Brick[][] getBricks() {
        return bricks;
    }

}
