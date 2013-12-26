package collisiondetection;

import entities.Player;
import java.awt.Point;
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

        Point ballRight = new Point(ballRect.x + ballRect.width + 1, ballRect.y);
        Point ballLeft = new Point(ballRect.x - 1, ballRect.y);
        Point ballTop = new Point(ballRect.x, ballRect.y - 1);
        Point ballBottom = new Point(ballRect.x, ballRect.y + ballRect.height + 1);

        if (ballRect.intersects(brickRect)) {

            if (brickRect.contains(ballRight)) {
                ball.reverseVerticalMomentum();
            }
            if (brickRect.contains(ballLeft)) {
                ball.reverseVerticalMomentum();
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

//        if (ballRect.intersects(brickRect)) {
//            if (ballRect.y == brickRect.y + brickRect.height) {
//                ball.reverseVerticalMomentum();
//            } else if (ballRect.getY() + ballRect.height == brickRect.getY()) {
//                ball.reverseVerticalMomentum();
//            }
//            brick.hit();
//            player.increaseScore(10);
//        }
    }

}
