package collisiondetection;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sprites.Ball;
import sprites.Paddle;

/**
 *
 * @author Joel
 */
public class BallPaddleCollisionTest {

    private final Paddle paddle;
    private Ball ball;
    private BallPaddleCollision cd;

    public BallPaddleCollisionTest() {
        paddle = new Paddle(30, 175, 20, 60, 200);
        cd = new BallPaddleCollision(paddle);
    }

    /*
     * Zones to be examined 
     * Zone 1    30 - 44, dX set to -8
     * Zone 2    45 - 59, dX set to -5
     * Zone 3    60 - 74, dX set to 5
     * Zone 4    75 - 90, dX set to 8
     */
    @Test
    public void collisionInZoneOne() {
        ball = new Ball(35, 161, 15, 15);
        move();
        test(-8, -5, 27, 156);
    }

    @Test
    public void collisionInZoneTwo() {
        ball = new Ball(45, 161, 15, 15);
        move();
        test(-5, -5, 40, 156);
    }

    @Test
    public void collisionInZoneThree() {
        ball = new Ball(65, 161, 15, 15);
        // KILL THE MUTANT
        ball.setDx(-4);
        move();
        test(5, -5, 70, 156);
    }

    @Test
    public void collisionInZoneFour() {
        ball = new Ball(75, 161, 15, 15);
        move();
        test(8, -5, 83, 156);
    }
    
    @Test
    public void collisionOnSide() {
        ball = new Ball(89, 185, 15, 15);
        ball.setDx(-5);
        move();
        test(5, 5, 94, 190);
    }
    
    @Test
    public void noCollisionWorks() {
        ball = new Ball(50, 50, 15, 15);
        move();
        test(5, 5, 55, 55);
    }

    private void move() {
        ball.setDy(5);
        ball.launchBall();
        cd.collides(ball);
        ball.move();
    }

    private void test(int dX, int dY, int x, int y) {
        assertEquals(dX, ball.getDx());
        assertEquals(dY, ball.getDy());
        assertEquals(x, ball.getX());
        assertEquals(y, ball.getY());
    }
}
