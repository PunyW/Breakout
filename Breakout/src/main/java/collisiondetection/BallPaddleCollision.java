package collisiondetection;

import java.awt.Rectangle;
import sprites.Ball;
import sprites.Paddle;

/**
 *
 * @author Joel
 */
public class BallPaddleCollision {

    private final Paddle paddle;

    /**
     *
     * @param paddle the game paddle
     */
    public BallPaddleCollision(Paddle paddle) {
        this.paddle = paddle;
    }

    /**
     * Checks if the ball is colliding with the paddle.
     * <p>
     * If the collision is on top of the paddle reverse horizontal momentum, 
     * and calculate where the hit was after which change vertical momentum
     * accordingly.
     * 
     * @param ball  Ball which is being inspected if it collides with the paddle
     * 
     */
    public void collides(Ball ball) {
        Rectangle rect1 = ball.getCollisionRect();
        Rectangle rect2 = paddle.getCollisionRect();

        if (rect1.intersects(rect2)) {
            if (ball.getY() < paddle.getY()) {
                ball.reverseVerticalMomentum();
                int direction = paddle.getCenter() - ball.getX();
                ball.setDx(-direction);
            } else {
                ball.reverseHorizontalMomentum();
            }
        }
    }

}
