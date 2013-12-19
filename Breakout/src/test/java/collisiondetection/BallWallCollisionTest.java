/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collisiondetection;

import entities.Player;
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
 * @author jajojajo
 */
public class BallWallCollisionTest {

    private Ball ball;
    private Player player;
    private BallWallCollision cd;
    private Paddle paddle;

    public BallWallCollisionTest() {
        paddle = new Paddle(60, 175, 20, 60, 200);
        cd = new BallWallCollision(200, 200);
        ball = new Ball(100, 100, 10, 10);
        ball.setDy(0);
        ball.setDx(0);
        player = new Player(1);
        ball.launchBall();
        ball.setPaddle(paddle);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ballCollidesWithRightWall() {
        ball.setDx(50);
        moveBall();
        assertEquals(-50, ball.getDx());
    }

    @Test
    public void ballCollidesWithLeftWall() {
        ball.setDx(-50);
        moveBall();
        assertEquals(50, ball.getDx());
    }

    @Test
    public void ballCollidesWithCeiling() {
        ball.setDy(-50);
        moveBall();
        assertEquals(50, ball.getDy());
    }
    
    @Test
    public void ballCollidesWithTheFloor() {
        ball.setDy(50);
        moveBall();
        assertEquals(ball.getDefaultDy(), ball.getDy());
        assertEquals(ball.getDefaultDx(), ball.getDx());
    }
    
    @Test
    public void collisionWithFloorReducesLifeFromPlayer() {
        ball.setDy(50);
        ball.move();
        ball.move();
        assertEquals(true, cd.checkCollisions(ball, player));
        assertEquals(0, player.getLives());
    }

    private void moveBall() {
        ball.move();
        ball.move();
        cd.checkCollisions(ball, player);
    }
}