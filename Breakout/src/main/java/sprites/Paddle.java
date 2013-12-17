package sprites;

public class Paddle extends Sprite {
    private final int minWidth, maxWidth;

    public Paddle(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.minWidth = 30;
        this.maxWidth = 150;
        checkSize();
    }

    public int getCenter() {
        return x + (width / 2);
    }

    public void changeSize(int amount) {
        width += amount;
        checkSize();
    }

    private void checkSize() {
        if (width < minWidth) {
            width = minWidth;
        }
        if (width > maxWidth) {
            width = maxWidth;
        }
    }
    
    private void checkPosition() {
        if(x < 0) {
            x = 0;
        }
    }

    public void move(int x) {
        this.x += x;
        checkPosition();
    }
    
    public void setPosition(int pos) {
        this.x = pos;
        checkPosition();
    }
}