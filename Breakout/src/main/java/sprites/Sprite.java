package sprites;

import java.awt.Rectangle;

/**
 * Sprite that holds the basic attributes of certain game object
 * 
 * @author Joel
 */
public abstract class Sprite implements Collideable{

    protected int x;
    protected int y;
    protected final int height;
    protected int width;

    /**
     * Constructor for Sprites
     * 
     * @param x Initial x coordinate for the object
     * @param y Initial y coordinate for the object
     * @param height
     * @param width 
     */
    public Sprite(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    @Override
    public Rectangle getCollisionRect() {
        Rectangle collisionRect = new Rectangle(this.x, this.y, this.width, this.height);
        return collisionRect;
    }

}
