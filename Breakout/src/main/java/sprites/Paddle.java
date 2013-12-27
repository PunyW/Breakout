package sprites;

/**
 *
 * @author Joel
 */
public class Paddle extends Sprite {

    private final int minWidth, maxWidth, frameWidth;
    private boolean docked;

    /**
     * Generate new Paddle with the given attributes.
     *
     * @param x initial x position
     * @param y initial y position
     * @param height paddle height
     * @param width paddle width
     * @param frameWidth width of the frame
     */
    public Paddle(int x, int y, int height, int width, int frameWidth) {
        super(x, y, height, width);
        this.minWidth = 30;
        this.maxWidth = 150;
        this.frameWidth = frameWidth;
        docked = false;
        checkSize();
    }

    /**
     *
     * @return returns the center x position of the paddle
     */
    public int getCenter() {
        return x + (width / 2);
    }

    /**
     * Increase or decrease paddles size according to the amount, paddle can't
     * be larger or smaller than the max/min width.
     *
     * @param amount how much paddle should be increased or decreased
     */
    public void changeSize(int amount) {
        width += amount;
        checkSize();
    }

    /**
     * Checks that the paddle isn't too large or small, if it is change the size
     */
    private void checkSize() {
        if (width < minWidth) {
            width = minWidth;
        } else if (width > maxWidth) {
            width = maxWidth;
        }
    }

    /**
     * Checks that the paddle isn't being positioned past the frame
     */
    private void checkPosition() {
        if (x < 0) {
            x = 0;
        } else if (x > frameWidth - (width + 8)) {
            x = frameWidth - (width + 8);
        }
    }

    /**
     * Move the paddle according to movement adjustment, after which check
     * position.
     *
     * @param x how much the paddle should move, negative value to move left,
     * positive to right
     */
    public void move(int x) {
        this.x += x;
        checkPosition();
    }
    
    /**
     * "Docks" the paddle to the mouse, when docked is true paddle follows mouse
     * movements
     */
    public void dockPaddle(){
        docked = true;
    }
    
    public void undockPaddle() {
        docked = false;
    }
    
    public boolean docked(){
        return docked;
    }

    public void setPosition(int pos) {
        this.x = pos;
        checkPosition();
    }
}
