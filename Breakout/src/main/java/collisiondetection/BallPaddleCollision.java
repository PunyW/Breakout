package collisiondetection;

import java.awt.Rectangle;
import sprites.Ball;
import sprites.Paddle;

public class BallPaddleCollision {

    private final Paddle paddle;

    public BallPaddleCollision(Paddle paddle) {
        this.paddle = paddle;
    }

    public void collides(Ball ball) {
        Rectangle rect1 = ball.getCollisionRect();
        Rectangle rect2 = paddle.getCollisionRect();

        if (rect1.intersects(rect2)) {
            if (ball.getY() < paddle.getY()) {
                ball.reverseUpwardsMomentum();
                // SET DIRECTION HERE
            } else {
                ball.reverseSidewaysMomentum();
            }
        }
    }

}
