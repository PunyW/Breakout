package util;

import entities.Player;
import java.awt.Rectangle;
import sprites.Ball;
import sprites.Collideable;
import sprites.Paddle;

public class CollisionDetection {

    private BallWallCollision bwl;

    public CollisionDetection() {
    }

    public CollisionDetection(int width, int height) {
        bwl = new BallWallCollision(width, height);
    }

    public boolean collides(Collideable col1, Collideable col2) {
        // Return true if the given objects collide else false
        Rectangle rect1 = col1.getCollisionRect();
        Rectangle rect2 = col2.getCollisionRect();

        return rect1.intersects(rect2);
    }

    public boolean ballCollidesWithPaddle(Ball ball, Paddle paddle) {
        Rectangle ballRect = ball.getCollisionRect();
        Rectangle paddleRect = paddle.getCollisionRect();
        
        return false;
    }

    public void ballWallCollision(Ball ball, Player player) {
        bwl.checkCollisions(ball, player);
    }
}
