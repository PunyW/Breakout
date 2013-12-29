package collisiondetection;

import entities.Player;
import sprites.Ball;

/**
 *
 * @author Joel
 */
public class BallWallCollision {

    /**
     * game dimensions
     */
    private final int width;
    private final int height;

    /**
     *
     * @param width     width of the game frame
     * @param height    height of the game frame
     */
    public BallWallCollision(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Go through each individual check.
     * 
     * @param ball      Ball which is being inspected
     * @param player    Player who is playing the game
     * @return  returns true if player has 0 lives
     */
    public boolean checkCollisions(Ball ball, Player player) {
        checkCeiling(ball);
        checkRightWall(ball);
        checkLeftWall(ball);
        return checkFloor(ball, player);
    }

    /**
     * Check if the ball is colliding with the ceiling, reverse vertical momentum
     * if it is.
     * 
     * @param ball 
     */
    private void checkCeiling(Ball ball) {
        if (ball.getY() <= 0) {
            ball.reverseVerticalMomentum();
        }
    }

    /**
     * Check if the ball is colliding with the right side of the frame, reverse 
     * horizontal momentum if it is.
     * 
     * @param ball 
     */
    private void checkRightWall(Ball ball) {
        if (ball.getX() + ball.getWidth() >= width) {
            ball.reverseHorizontalMomentum();
        }
    }

    /**
     * Check if the ball is colliding with the left side of the frame, reverse
     * horizontal momentum if it is.
     * 
     * @param ball 
     */
    private void checkLeftWall(Ball ball) {
        if (ball.getX() <= 0) {
            ball.reverseHorizontalMomentum();
        }
    }

    /**
     * Check if the ball is colliding with the floor.
     * <p>
     * If the ball is colliding with the floor, ball has passed paddle. Reset the
     * ball, and player loses a life.
     * 
     * @return returns true if the player has 0 lives left
     */
    private boolean checkFloor(Ball ball, Player player) {
        if (ball.getY() + ball.getHeight() >= height) {
            ball.resetBall();
            player.loseLife();
            if (player.getLives() == 0) {
                return true;
            }
        }
        return false;
    }
}
