package sprites;

import java.awt.Rectangle;

public abstract class Sprite implements Collideable{
    protected int x;
    protected int y;
    protected final int height;
    protected int width;

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
