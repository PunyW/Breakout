package collisiondetection;

import entities.Player;
import sprites.Ball;

public class BallWallCollision {
    // Game dimensions

    private final int width;
    private final int height;

    public BallWallCollision(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean checkCollisions(Ball ball, Player player) {
        checkCeiling(ball);
        checkRightWall(ball);
        checkLeftWall(ball);
        return checkFloor(ball, player);
    }

    private void checkCeiling(Ball ball) {
        if (ball.getY() <= 0) {
            ball.reverseVerticalMomentum();
        }
    }

    private void checkRightWall(Ball ball) {
        if (ball.getX() + ball.getWidth() * 2 >= width) {
            ball.reverseHorizontalMomentum();
        }
    }

    private void checkLeftWall(Ball ball) {
        if (ball.getX() <= 0) {
            ball.reverseHorizontalMomentum();
        }
    }

    private boolean checkFloor(Ball ball, Player player) {
        if (ball.getY() + 15 + ball.getHeight() * 2 >= height) {
            ball.resetBall();
            player.loseLife();
            if (player.getLives() == 0) {
                return true;
            }
        }
        return false;
    }
}
