package sprites;

public class Ball extends Sprite {
    private int angle;
    
    public Ball(Paddle paddle) {
        super(paddle.getCenter(), paddle.getY() -11, 10, 10);
    }

    public Ball(int x, int y, int height, int width) {
        super(x, y, height, width);
    }

}
