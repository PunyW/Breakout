package sprites;

public class Brick extends Sprite {

    private int hitPoints;
    private boolean alive;

    public Brick(int hitPoints) {
        super(0, 0, 0, 0);
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
