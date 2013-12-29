package sprites;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PaddleMoveTest {

    private Paddle paddle;

    public PaddleMoveTest() {
        paddle = new Paddle(0, 0, 25, 60, 200);
    }

    @Test
    public void manualPositionSetWorks() {
        paddle.setPosition(20);
        testX(20);
    }
    
    @Test
    public void cantPlacePaddleOutsideOfFrame() {
        paddle.setPosition(-100);
        testX(0);
    }

    @Test
    public void paddleCanMoveRight() {
        paddle.move(10);
        testX(10);
    }

    @Test
    public void paddleWontGoOverLeftSideOfTheWindow() {
        paddle.move(-1);
        testX(0);
    }

    @Test
    public void paddleCanMoveLeft() {
        paddle.move(100);
        paddle.move(-50);
        testX(50);
    }

    @Test
    public void paddleWontGoPastTheScreenOnTheRight() {
        paddle.move(200);
        testX(200 - paddle.width);
    }

    private void testX(int x) {
        assertEquals(x, paddle.getX());
    }
}
