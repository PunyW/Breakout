package sprites;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BallMoveTest {

    private Ball ball;
    private Paddle paddle;

    public BallMoveTest() {
        ball = new Ball(10, 10, 15, 15);
        paddle = new Paddle(150, 500, 20, 60, 800);
    }

    @Before
    public void setUp() {
    }

    @Test
    public void ballResetWorks() {
        ball.setPaddle(paddle);
        ball.resetBall();
        testPos(paddle.getCenter() - 7, paddle.getY() - 16);
        assertEquals(false, ball.moving());
        assertEquals(ball.getDefaultDx(), ball.getDx());
        assertEquals(ball.getDefaultDy(), ball.getDy());
    }

    @Test
    public void ballWontMoveIfNotMoving() {
        ball.move();
        testPos(10, 10);
    }

    @Test
    public void lauchingBallWorks() {
        assertEquals(false, ball.moving());
        ball.launchBall();
        assertEquals(true, ball.moving());
    }

    @Test
    public void movingUpWorks() {
        ball.launchBall();
        ball.move();
        // Moving up 10 - 5
        testPos(15, 5);
    }

    @Test
    public void movingDownWorks() {
        ball.launchBall();
        ball.setDy(5);
        ball.move();
        // Moving down 10 + 5
        testPos(15, 15);
    }

    private void testPos(int x, int y) {
        assertEquals(x, ball.getX());
        assertEquals(y, ball.getY());
    }
}
