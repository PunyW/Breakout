package sprites;

public class Ball extends Sprite {

    private int dx, dy;
    private Paddle paddle;
    private boolean moving;
    private int speed, maxSpeed;
    private int counter;

    public Ball(Paddle paddle) {
        super(paddle.getCenter() - 7, paddle.getY() - 10, 15, 15);
        this.paddle = paddle;
        this.moving = false;
        maxSpeed = 10;
        speed = 5;
        dx = 5;
        dy = -5;
        counter = 0;
    }

    public Ball(int x, int y, int height, int width) {
        super(x, y, height, width);
    }

    public void move() {
        if (moving) {
            counter++;
            if(counter == 5) {
                increaseSpeed();
                counter = 0;
            }
            setPos(super.x + dx, super.y + dy);
        }
    }

    public void increaseSpeed() {
        if (dx < 0) {
            dx--;
            if (dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else {
            dx++;
            if (dx > maxSpeed) {
                dx = maxSpeed;
            }
        }

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

    public void reverseSidewaysMomentum() {
        dx = -dx;
    }

    public void reverseUpwardsMomentum() {
        dy = -dy;
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
