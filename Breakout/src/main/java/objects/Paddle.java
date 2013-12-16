
package objects;

public class Paddle extends Sprite {
    private final int minWidth, maxWidth;

    public Paddle(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.minWidth = 30;
        this.maxWidth = 150;
        checkSize();
    }
    

    
    @Override
    public void move() {
    }
    
    public void changeSize(int amount) {
        width += amount;
        checkSize();
    }
    
    private void checkSize() {
        if(width < minWidth) {
            width = minWidth;
        }
        if(width > maxWidth) {
            width = maxWidth;
        }
    }

}
