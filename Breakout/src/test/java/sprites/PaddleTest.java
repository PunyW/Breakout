package sprites;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PaddleTest {

    private final Paddle paddle;

    public PaddleTest() {
        paddle = new Paddle(0, 0, 25, 60, 200);
    }

    @Test
    public void constructorWorking() {
        test(25, 60, false);
    }

    @Test
    public void constructorWorkingWithTooLargePaddle() {
        Paddle paddle2 = new Paddle(0, 0, 25, 200, 500);
        assertEquals(150, paddle2.getWidth());
    }

    @Test
    public void constructorWorkingWithTooSmallPaddle() {
        Paddle paddle2 = new Paddle(0, 0, 25, 25, 500);
        assertEquals(30, paddle2.getWidth());
    }

    @Test
    public void paddleGrowsCorrectly() {
        paddle.changeSize(25);
        test(25, 85, false);
    }

    @Test
    public void paddleCantGetLargerThanMaxWidth() {
        paddle.changeSize(500);
        testWidth(150);
    }

    @Test
    public void paddleCantBeSmallerThanMinWidth() {
        paddle.changeSize(-500);
        test(25, 30, false);
    }

    @Test
    public void tinyPaddleTest() {
        paddle.changeSize(-20);
        test(25, 40, false);
    }

    @Test
    public void getCenterGivesRightX() {
        assertEquals(paddle.getCenter(), 30);
    }

    @Test
    public void paddleCanBeDocked() {
        paddle.dockPaddle();
        assertEquals(true, paddle.docked());
    }

    @Test
    public void dockingAndUndockingWorks() {
        paddle.dockPaddle();
        paddle.undockPaddle();
        assertEquals(false, paddle.docked());
    }
    
    @Test
    public void resetWorks() {
        paddle.changeSize(50);
        paddle.reset();
        testWidth(60);
    }

    private void test(int h, int w, boolean docked) {
        testHeight(h);
        testWidth(w);
        assertEquals(docked, paddle.docked());
    }

    private void testWidth(int w) {
        assertEquals(w, paddle.getWidth());
    }

    private void testHeight(int h) {
        assertEquals(h, paddle.getHeight());
    }
}
