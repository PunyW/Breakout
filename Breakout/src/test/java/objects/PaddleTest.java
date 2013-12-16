/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

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
    
    private void test(int h, int w) {
        // X and Y checks here later?
        assertEquals(paddle.getWidth(), w);
        assertEquals(paddle.getHeight(), h);
    }
}
