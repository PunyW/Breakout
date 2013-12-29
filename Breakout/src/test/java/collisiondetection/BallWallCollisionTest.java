package collisiondetection;

import entities.Player;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sprites.Ball;
import sprites.Paddle;

public class BallWallCollisionTest {

    private Ball ball;
    private final Player player;
    private BallWallCollision cd;
    private final Paddle paddle;

    public BallWallCollisionTest() {
        paddle = new Paddle(30, 175, 20, 60, 200);
        player = new Player(1);
        cd = new BallWallCollision(200, 200);
    }

    @Test
    public void ballCollidesWithRightWall() {
        // Ball(x, y, height, width
        ball = new Ball(185, 100, 15, 15);
        collision(false);
        ball.launchBall();
        ball.move();
        checkPlayer(1, 0);
        // Ball has collided with right wall, reverse dX and move once and check 
        // position
        checkBall(-5, -5, 180, 95);
    }

    @Test
    public void ballCollidesWithLeftWall() {
        ball = new Ball(5, 100, 15, 15);
        ball.setDx(-5);
        ball.launchBall();
        ball.move();
        collision(false);
        ball.move();
        checkPlayer(1, 0);
        checkBall(5, -5, 5, 90);
    }

    @Test
    public void ballCollidesWithCeiling() {
        ball = new Ball(100, 0, 15, 15);
        ball.launchBall();
        collision(false);
        ball.move();
        checkPlayer(1, 0);
        checkBall(5, 5, 105, 5);
    }

    @Test
    public void ballCollidesWithTheFloor() {
        // For floor collision we have to set the paddle or get nullpointer
        ball = new Ball(100, 185, 15, 15);
        ball.setPaddle(paddle);
        ball.launchBall();
        collision(true);
        checkPlayer(0, 0);
        assertEquals(false, ball.moving());
        checkBall(5, -5, paddle.getCenter() - ball.getWidth() / 2, paddle.getY() - (ball.getHeight() + 1));
    }

    private void collision(boolean reduceLife) {
        assertEquals(reduceLife, cd.checkCollisions(ball, player));
    }

    private void checkPlayer(int lives, int score) {
        assertEquals(lives, player.getLives());
        assertEquals(score, player.getScore());
    }

    private void checkBall(int dX, int dY, int x, int y) {
        assertEquals(dX, ball.getDx());
        assertEquals(dY, ball.getDy());
        assertEquals(x, ball.getX());
        assertEquals(y, ball.getY());

    }
}
