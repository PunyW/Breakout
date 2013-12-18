package collisiondetection;

import java.awt.Rectangle;
import sprites.Ball;
import sprites.Brick;

public class BallBricksCollision {

    public BallBricksCollision() {
    }

    public void checkCollisions(Brick[][] bricks, Ball ball) {
        for(int i = 0; i < bricks.length; i++) {
            for(int j = 0; j < bricks[0].length; j++) {
                checkCollision(ball, bricks[i][j]);
            }
        }
    }
    
    private void checkCollision(Ball ball, Brick brick) {
        if(!brick.alive()) {
            return;
        }
        
        Rectangle rect1 = ball.getCollisionRect();
        Rectangle rect2 = brick.getCollisionRect();
        
        if(rect1.intersects(rect2)) {
            if(rect1.getX() == rect2.getX() && rect1.getY() == rect2.getY()) {
                ball.reverseSidewaysMomentum();
                ball.reverseUpwardsMomentum();
            } else if(rect1.getX() == rect2.getX()) {
                ball.reverseSidewaysMomentum();
            } else {
                ball.reverseUpwardsMomentum();
            }
            brick.hit();
        }
        
    }
}
