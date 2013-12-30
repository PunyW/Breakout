package collisiondetection;

import entities.BrickCreator;
import entities.Player;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sprites.Ball;
import sprites.Brick;

/**
 *
 * @author Joel
 */
public class BallBricksCollisionTest {

    private Ball ball;
    private final BallBricksCollision cd;
    private Brick[][] bricks;
    private final Player player;

    public BallBricksCollisionTest() {
        cd = new BallBricksCollision();
        player = new Player(3);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        BrickCreator bc = new BrickCreator();
        bricks = bc.createBricks(1, 1);
    }

    @After
    public void tearDown() {
    }

    /*
     * BrickCreator creates the Brick at 50, 50. With a size of w: 40 h: 20
     * 
     */
    @Test
    public void collisionOnRightSideOfBrick() {
        // Bricks right side is at 90'
        ball = new Ball(89, 60, 15, 15);
        ball.launchBall();
        ball.setDx(-5);
        cd.checkCollisions(bricks, ball, player);
        ball.move();
        testBrick(0, false);
        testPlayer(10);
        testBall(5, -5, 94, 55);
    }

    @Test
    public void collisionOnBottomOfBrick() {
        // Bricks bottom side is at 70
        ball = new Ball(60, 69, 15, 15);
        ball.launchBall();
        cd.checkCollisions(bricks, ball, player);
        ball.move();
        testBall(5, 5, 65, 74);
        testBrick(0, false);
        testPlayer(10);
    }

    @Test
    public void collisionOnTopOfBrick() {
        // Bricks top is at 50
        ball = new Ball(75, 36, 15, 15);
        ball.launchBall();
        ball.setDy(5);
        cd.checkCollisions(bricks, ball, player);
        ball.move();
        testBrick(0, false);
        testPlayer(10);
        testBall(5, -5, 80, 31);
    }

    @Test
    public void collisionOnLeftSideOfBrick() {
        // Bricks left side is at 50
        ball = new Ball(36, 60, 15, 15);
        ball.launchBall();
        cd.checkCollisions(bricks, ball, player);
        ball.move();
        testBall(-5, -5, 31, 55);
        testBrick(0, false);
        testPlayer(10);
    }

    @Test
    public void nothingHappensWhenCollidingWithDeadBrick() {
        Brick[][] bricks2 = new Brick[1][1];
        bricks2[0][0] = new Brick(0, 100, 100);
        ball = new Ball(86, 100, 15, 15);
        ball.launchBall();
        cd.checkCollisions(bricks, ball, player);
        ball.move();
        testBall(ball.getDefaultDx(), ball.getDefaultDy(), 91, 95);
        testPlayer(0);
    }

    private void testBall(int dX, int dY, int x, int y) {
        assertEquals(dX, ball.getDx());
        assertEquals(dY, ball.getDy());
        assertEquals(x, ball.getX());
        assertEquals(y, ball.getY());

    }

    private void testBrick(int hitpoints, boolean alive) {
        assertEquals(hitpoints, bricks[0][0].getHitPoints());
        assertEquals(alive, bricks[0][0].alive());
    }

    private void testPlayer(int score) {
        assertEquals(score, player.getScore());
    }
}
