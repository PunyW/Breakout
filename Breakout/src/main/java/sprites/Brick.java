package sprites;

public class Brick extends Sprite {

    private int hitPoints;
    private boolean alive;

    public Brick(int hitPoints, int x, int y) {
        // Hard coded size for now
        super(x, y, 20, 40);
        this.hitPoints = hitPoints;
        alive = true;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean alive() {
        return alive;
    }

    public void hit() {
        hitPoints--;
        if (hitPoints < 1) {
            alive = false;
        }
    }
}
