package sprites;

public class Ball extends Sprite {

    private int dx, dy, defaultDX, defaultDY;
    private Paddle paddle;
    private boolean moving;
    private int speed, maxSpeed;
    private int counter;

    public Ball(Paddle paddle) {
        super(paddle.getCenter() - 7, paddle.getY() - 16, 15, 15);
        this.paddle = paddle;
        init();
    }

    public Ball(int x, int y, int height, int width) {
        super(x, y, height, width);
        init();
    }

    private void init() {
        this.moving = false;
        maxSpeed = 10;
        speed = 5;
        dx = defaultDX = 5;
        dy = defaultDY = -5;
        counter = 0;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    public int getDefaultDX() {
        return defaultDX;
    }

    public int getDefaultDY() {
        return defaultDY;
    }

    public boolean moving() {
        return moving;
    }

    public void setDirection(int x) {
        dx = x;
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

    public void move() {
        if (moving) {
            counter++;
            if (counter == 5) {
                increaseSpeed();
                counter = 0;
            }
            setPos(super.x + dx, super.y + dy);
        }
    }

    private void increaseSpeed() {
        if (dy < 0) {
            dy--;
            if (dy < -maxSpeed) {
                dy = -maxSpeed;
            }
        } else {
            dy++;
            if (dy > maxSpeed) {
                dy = maxSpeed;
            }
        }
    }

    public void launchBall() {
        moving = true;
    }

    private void setPos(int x, int y) {
        super.x = x;
        super.y = y;
    }

    public void reverseHorizontalMomentum() {
        dx = -dx;
    }

    public void reverseVerticalMomentum() {
        dy = -dy;
    }

    // Reset the ball back onto the paddle
    public void resetBall() {
        moving = false;
        setPos(paddle.getCenter() - getWidth() / 2, paddle.getY() - (height + 1));
        dy = defaultDY;
        dx = defaultDX;
    }
}
