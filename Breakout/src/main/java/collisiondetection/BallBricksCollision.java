package collisiondetection;

import entities.Player;
import java.awt.Rectangle;
import sprites.Ball;
import sprites.Brick;

public class BallBricksCollision {

    public BallBricksCollision() {
    }

    public void checkCollisions(Brick[][] bricks, Ball ball, Player player) {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                checkCollision(ball, bricks[i][j], player);
            }
        }
    }

    private void checkCollision(Ball ball, Brick brick, Player player) {
        if (!brick.alive()) {
            return;
        }

        Rectangle ballRect = ball.getCollisionRect();
        Rectangle brickRect = brick.getCollisionRect();

        if (ballRect.intersects(brickRect)) {
            if (ballRect.getX() == brickRect.getX()) {
                ball.reverseHorizontalMomentum();
            } else {
                ball.reverseVerticalMomentum();
            }
            brick.hit();
            player.increaseScore(10);
        }

    }
}
