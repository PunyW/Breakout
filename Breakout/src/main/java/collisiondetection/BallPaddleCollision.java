package collisiondetection;

import java.awt.Rectangle;
import sprites.Ball;
import sprites.Paddle;

/**
 * Checks for Collisions between ball and paddle
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
     * If the collision is on top of the paddle reverse horizontal momentum, and
     * check which "zone" was hit and change the vertical momentum accordingly
     *
     * @param ball Ball which is being inspected if it collides with the paddle
     *
     */
    public void collides(Ball ball) {
        Rectangle rect1 = ball.getCollisionRect();
        Rectangle rect2 = paddle.getCollisionRect();

        if (rect1.intersects(rect2)) {
            if (ball.getY() < paddle.getY()) {
                ball.reverseVerticalMomentum();

                /*
                 * Zone One is the leftmost part of the paddle, zone two 
                 * is the middle left part of the paddle, zone three middle right
                 * and lastly the rightmost part of the paddle
                 */
                int zoneWidth = paddle.getWidth() / 4;
                int zoneOne = paddle.getX() + zoneWidth;
                int zoneTwo = zoneOne + zoneWidth;
                int zoneThree = zoneTwo + zoneWidth;

                if (ball.getX() < zoneOne) {
                    ball.setDx(-8);
                } else if (ball.getX() < zoneTwo) {
                    ball.setDx(-5);
                } else if (ball.getX() < zoneThree) {
                    ball.setDx(5);
                } else {
                    ball.setDx(8);
                }

            } else {
                ball.reverseHorizontalMomentum();
            }
        }
    }

}
