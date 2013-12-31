package sprites;

/**
 *
 * @author Joel
 */
public class Ball extends Sprite {

    /**
     * @param dx balls horizontal movement
     * @param dy balls vertical movement
     */
    private int dx, dy, defaultDX, defaultDY;
    private Paddle paddle;
    private boolean moving;

    /**
     * Generate new Ball.
     * <p>
     * The ball which is being generated will have the height of 15 and width of
     * 15. It will be placed just above the paddle in the middle of the paddle.
     *
     * @param paddle To which paddle we want the ball to center
     */
    public Ball(Paddle paddle) {
        super(paddle.getCenter() - 7, paddle.getY() - 16, 15, 15);
        this.paddle = paddle;
        init();
    }

    /**
     * Generate new Ball.
     *
     * @param x Initial x position of the Ball.
     * @param y Initial y position of the Ball.
     * @param height Height of the Ball.
     * @param width Width of the Ball.
     */
    public Ball(int x, int y, int height, int width) {
        super(x, y, height, width);
        init();
    }

    /**
     * Set balls movement to false, and set default movement speeds.
     */
    private void init() {
        this.moving = false;
        dx = defaultDX = 5;
        dy = defaultDY = -5;
    }

    /**
     * Assign a paddle for the ball, this is the paddle we want the ball to
     * reset into.
     *
     * @param paddle the paddle that is being assigned for the ball
     */
    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    public int getDefaultDx() {
        return defaultDX;
    }

    public int getDefaultDy() {
        return defaultDY;
    }

    public boolean moving() {
        return moving;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    /**
     * If ball is moving, set balls new position with the movement adjustments.
     */
    public void move() {
        if (moving) {
            setPos(x + dx, y + dy);
        }
    }

    /**
     * Set balls movement true, which allows moving the ball
     */
    public void launchBall() {
        moving = true;
    }

    private void setPos(int x, int y) {
        super.x = x;
        super.y = y;
    }

    /**
     * Reverse horizontal movement. If ball was moving left change it to move
     * right and vice versa
     */
    public void reverseHorizontalMomentum() {
        dx = -dx;
    }

    /**
     * Reverse vertical movement. If ball was moving upwards change it to move
     * downwards and vice versa
     */
    public void reverseVerticalMomentum() {
        dy = -dy;
    }

    /**
     * Reset the ball on top of the paddle, in the middle of the paddle, and
     * change movement into false
     */
    public void resetBall() {
        moving = false;
        setPos(paddle.getCenter() - getWidth() / 2, paddle.getY() - (height + 1));
        dy = defaultDY;
        dx = defaultDX;
    }

}
