package entities;

public class Brick {

    private int hitPoints;
    private boolean alive;

    public Brick(int hitPoints) {
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
