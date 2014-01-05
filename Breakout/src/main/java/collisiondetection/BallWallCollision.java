package collisiondetection;

import entities.Player;
import sprites.Ball;

/**
 * Checks for collisions between ball and the boundaries of the frame
 * 
 * @author Joel
 */
public class BallWallCollision {

    // GAME DIMENSIONS
    private final int width;
    private final int height;

    /**
     *
     * @param width frame width
     * @param height frame height
     */
    public BallWallCollision(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Go through each individual check.
     *
     * @param ball Ball which is being inspected
     * @param player Player who is playing the game
     * @return returns true if player has 0 lives otherwise false
     */
    public boolean checkCollisions(Ball ball, Player player) {
        checkCeiling(ball);
        checkRightWall(ball);
        checkLeftWall(ball);
        return checkFloor(ball, player);
    }

    /**
     * Check if ball is colliding with the ceiling of the frame, if true reverse
     * balls Y movement.
     *
     * @param ball ball which is being inspected
     */
    private void checkCeiling(Ball ball) {
        if (ball.getY() <= 0) {
            ball.reverseVerticalMomentum();
        }
    }

    /**
     * Check if the ball is colliding with the right side of the frame, if true
     * reverse X movement.
     *
     * @param ball ball which is being inspected
     */
    private void checkRightWall(Ball ball) {
        if (ball.getX() + ball.getWidth() >= width) {
            ball.reverseHorizontalMomentum();
        }
    }

    /**
     * Check if the ball is colliding with the left side of the frame, if true
     * reverse X movement.
     *
     * @param ball which is being inspected
     */
    private void checkLeftWall(Ball ball) {
        if (ball.getX() <= 0) {
            ball.reverseHorizontalMomentum();
        }
    }

    /**
     * Check if the ball is colliding with the floor.
     * <p>
     * If paddle is colliding with the floor, it has gone past the paddle. Reset
     * ball, remove one life from the player and check if there is lives left.
     * Return true if player has no lives left, otherwise return false.
     *
     * @return returns true if the player has 0 lives left
     */
    private boolean checkFloor(Ball ball, Player player) {
        if (ball.getY() + ball.getHeight() >= height) {
            player.loseLife();
            if (player.getLives() == 0) {
                ball.disableBall();
                return true;
            }
            // Reset ball only if player has lives
            ball.resetBall();
        }
        return false;
    }
}
