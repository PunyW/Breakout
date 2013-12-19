package collisiondetection;

import entities.Player;
import sprites.Ball;
import sprites.Brick;
import sprites.Paddle;

public class CollisionDetectionManager {
    private BallBricksCollision bbc;
    private BallWallCollision bwc;
    private BallPaddleCollision bpc;

    public CollisionDetectionManager(int width, int height, Paddle paddle) {
        bwc = new BallWallCollision(width, height);
        bpc = new BallPaddleCollision(paddle);
        bbc = new BallBricksCollision();
        
    }

    public boolean collisions(Brick[][] bricks, Ball ball, Player player) {
        // Ball & Paddle collision
        bpc.collides(ball);
        // Ball & Bricks collision
        bbc.checkCollisions(bricks, ball, player);
        // Ball & Wall collisions
        return bwc.checkCollisions(ball, player);
    }

}
