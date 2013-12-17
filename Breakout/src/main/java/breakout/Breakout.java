package breakout;

import entities.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import sprites.Ball;
import sprites.Paddle;
import ui.Updatable;
import util.CollisionDetection;

public class Breakout extends Timer implements ActionListener {

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

    public Breakout(int width, int height, int paddleWidth) {
        super(1000, null);
        init(width, height, paddleWidth);
    }

    private void init(int width, int height, int paddleWidth) {
        this.running = true;
        this.paddle = new Paddle(width / 2 - 30, height - 85, 20, paddleWidth);
        this.ball = new Ball(paddle);
        this.cd = new CollisionDetection(width, height);
        this.player = new Player(3);

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
        if (cd.collides(ball, paddle)) {
            if (ball.getY() < paddle.getY()) {
                ball.reverseUpwardsMomentum();
                // SET DIRECTION HERE
            }
        }
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

}