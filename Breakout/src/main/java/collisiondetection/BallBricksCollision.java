package collisiondetection;

import entities.Player;
import java.awt.Point;
import java.awt.Rectangle;
import sprites.Ball;
import sprites.Brick;

/**
 *
 * @author Joel
 */
public class BallBricksCollision {

    public BallBricksCollision() {
    }

    /**
     * Loops through the array of bricks and checks if any of the bricks
     * collides with the ball.
     *
     * @param bricks Array of the bricks
     * @param ball The ball which collision is being inspected
     * @param player Player who is playing the game
     */
    public void checkCollisions(Brick[][] bricks, Ball ball, Player player) {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                checkCollision(ball, bricks[i][j], player);
            }
        }
    }

    /**
     * Method for checking collision between a Brick and the ball.
     * <p>
     * If ball is colliding with a brick, check which side of the ball collides
     * and reverse the correct movement adjustment.
     *
     * @param ball Ball which is being inspected
     * @param brick Brick which is being inspected
     * @param player Player who is playing
     */
    private void checkCollision(Ball ball, Brick brick, Player player) {
        if (!brick.alive()) {
            return;
        }

        Rectangle ballRect = ball.getCollisionRect();
        Rectangle brickRect = brick.getCollisionRect();

        Point ballRight = new Point(ballRect.x + ballRect.width + 2, ballRect.y + 1);
        Point ballLeft = new Point(ballRect.x - 3, ballRect.y + 1);
        Point ballTop = new Point(ballRect.x + 1, ballRect.y - 2);
        Point ballBottom = new Point(ballRect.x, ballRect.y + ballRect.height + 2);

        /*
        Check if the collision rectangles intersects each other, if they do 
        check which side of the ball is colliding
        */
        if (ballRect.intersects(brickRect)) {

            if (brickRect.contains(ballRight)) {
                ball.reverseHorizontalMomentum();
            } else if (brickRect.contains(ballLeft)) {
                ball.reverseHorizontalMomentum();
            }
            if (brickRect.contains(ballTop)) {
                ball.reverseVerticalMomentum();
            } else if (brickRect.contains(ballBottom)) {
                ball.reverseVerticalMomentum();
            }
            brick.hit();
            player.increaseScore(10);
        }
    }

}
