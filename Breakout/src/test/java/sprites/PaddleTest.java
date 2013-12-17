/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprites;

import sprites.Paddle;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Joel
 */
public class PaddleTest {

    Paddle paddle;

    public PaddleTest() {
        paddle = new Paddle(0, 0, 25, 60);
    }

    @Test
    public void constructorWorking() {
        test(25, 60);
    }
    
    @Test
    public void paddleGrowsCorrectly() {
        paddle.changeSize(25);
        test(25, 85);
    }
    
    @Test
    public void paddleCantBeSmallerThanMinWidth() {
        paddle.changeSize(-100);
        test(25, 30);
    }
    
    @Test
    public void tinyPaddleTest() {
        paddle.changeSize(-20);
        test(25, 40);
    }
    
    @Test
    public void getCenterGivesRightX() {
        assertEquals(paddle.getCenter(), 30);
    }
    
    @Test
    public void paddleCanMoveRight() {
        paddle.move(10);
        testX(10);
    }
    
    @Test
    public void paddleWontGoOverLeftSideOfTheWindow() {
        paddle.move(-10);
        testX(0);
    }
    
    @Test
    public void paddleCanMoveLeft() {
        paddle.move(100);
        paddle.move(-50);
        testX(50);
    }
    
    private void test(int h, int w) {
        assertEquals(paddle.getWidth(), w);
        assertEquals(paddle.getHeight(), h);
    }
    
    private void testX(int x) {
        assertEquals(paddle.getX(), x);
    }
}
