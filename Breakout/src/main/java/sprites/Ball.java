package sprites;

public class Ball extends Sprite {
    private int dx, dy;
    private Paddle paddle;
    private boolean moving;

    public Ball(Paddle paddle) {
        super(paddle.getCenter() - 7, paddle.getY() - 8, 15, 15);
        this.paddle = paddle;
        this.moving = false;
        dx = 5;
        dy = -5;
    }

    public Ball(int x, int y, int height, int width) {
        super(x, y, height, width);
    }

    public void move() {
        if (moving) {
            setPos(super.x + dx, super.y + dy);
        }
    }

    public void launchBall() {
        moving = true;
    }

    private void setPos(int x, int y) {
        super.x = x;
        super.y = y;
    }

    // Reset the ball back onto the paddle
    public void resetBall() {
        moving = false;
        setPos(paddle.getCenter() - super.getWidth() / 2, paddle.getY() - (super.height + 1));
        dy = -5;
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

}
