package sprites;

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

    private void checkEverything(int x, int y, int h, int w, Ball ball) {
        assertEquals(ball.getX(), x);
        assertEquals(ball.getY(), y);
        assertEquals(ball.getHeight(), h);
        assertEquals(ball.getWidth(), w);
    }

}
