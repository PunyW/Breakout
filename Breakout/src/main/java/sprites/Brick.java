package sprites;

/**
 *
 * @author Joel
 */
public class Brick extends Sprite {

    private int hitPoints;
    private boolean alive;

    /**
     *
     * @param hitPoints How many hits the brick can take before being destroyed
     * @param x x position of the brick
     * @param y y position of the brick
     */
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

    /**
     * The brick was hit, reduce 1 life point, if the brick has 0 hp it was
     * destroyed, change alive into false
     */
    public void hit() {
        hitPoints--;
        if (hitPoints == 0) {
            alive = false;
        }
    }
}
