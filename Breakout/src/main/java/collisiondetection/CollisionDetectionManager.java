package collisiondetection;

import entities.Player;
import sprites.Ball;
import sprites.Brick;
import sprites.Paddle;

/**
 *
 * @author Joel
 */
public class CollisionDetectionManager {
    private final BallBricksCollision bbc;
    private final BallWallCollision bwc;
    private final BallPaddleCollision bpc;

    /**
     *
     * @param width     frame width
     * @param height    frame height
     * @param paddle    games paddle
     */
    public CollisionDetectionManager(int width, int height, Paddle paddle) {
        bwc = new BallWallCollision(width, height);
        bpc = new BallPaddleCollision(paddle);
        bbc = new BallBricksCollision();
        
    }

    /**
     * Check for balls collision with walls, paddle or bricks.
     * 
     * @param bricks    Array of bricks that are being checked for
     * @param ball      Ball which is being inspected
     * @param player    Player who is playing the game
     * @return  returns true if the player has 0 lives left
     */
    public boolean collisions(Brick[][] bricks, Ball ball, Player player) {
        // Ball & Paddle collision
        bpc.collides(ball);
        // Ball & Bricks collision
        bbc.checkCollisions(bricks, ball, player);
        // Ball & Wall collisions
        return bwc.checkCollisions(ball, player);
    }

}
