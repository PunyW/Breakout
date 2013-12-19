package sprites;

import java.awt.Rectangle;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joel
 */
public class BallTest {

    public BallTest() {
    }

    @Test
    public void constructorWorking() {
        Ball ball = new Ball(10, 20, 30, 40);
        checkEverything(10, 20, 30, 40, ball);
    }

    @Test
    public void constructorWithPaddleWorking() {
        Paddle paddle = new Paddle(50, 50, 20, 60, 280);
        Ball ball = new Ball(paddle);

        checkEverything(paddle.getCenter() - 7, 34, 15, 15, ball);
    }
    
    @Test
    public void collisionRectangleIsRightSize() {
        Ball ball = new Ball(10, 10, 10, 10);
        Rectangle rect = ball.getCollisionRect();
        assertEquals(10, rect.x);
        assertEquals(10, rect.y);
        assertEquals(10, rect.width);
        assertEquals(10, rect.height);
    }

    private void checkEverything(int x, int y, int h, int w, Ball ball) {
        assertEquals(x, ball.getX());
        assertEquals(y, ball.getY());
        assertEquals(h, ball.getHeight());
        assertEquals(w, ball.getWidth());
    }
}
