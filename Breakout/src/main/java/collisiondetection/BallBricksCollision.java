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
     * Loops through the array of bricks and checks if any of the bricks collides
     * with the ball.
     * 
     * @param bricks    Array of the bricks
     * @param ball      The ball which collision is being inspected
     * @param player    Player who is playing the game
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
     * If the ball is colliding with the brick, depending on where the ball
     * collides with the brick, the horizontal or vertical momentum of the ball 
     * is reversed. When ball collides with the brick players score is increased.
     * 
     * @param ball      Ball which is being inspected
     * @param brick     Brick which is being inspected
     * @param player    Player who is playing
     */
    private void checkCollision(Ball ball, Brick brick, Player player) {
        if (!brick.alive()) {
            return;
        }

        Rectangle ballRect = ball.getCollisionRect();
        Rectangle brickRect = brick.getCollisionRect();

        Point ballRight = new Point(ballRect.x + ballRect.width + 1, ballRect.y);
        Point ballLeft = new Point(ballRect.x - 1, ballRect.y);
        Point ballTop = new Point(ballRect.x, ballRect.y - 1);
        Point ballBottom = new Point(ballRect.x, ballRect.y + ballRect.height + 1);

        if (ballRect.intersects(brickRect)) {

            if (brickRect.contains(ballRight)) {
                ball.reverseHorizontalMomentum();
            }
            if (brickRect.contains(ballLeft)) {
                ball.reverseHorizontalMomentum();
            }
            if (brickRect.contains(ballTop)) {
                ball.reverseVerticalMomentum();
            }
            if (brickRect.contains(ballBottom)) {
                ball.reverseVerticalMomentum();
            }
            brick.hit();
            player.increaseScore(10);
        }

    }

}
