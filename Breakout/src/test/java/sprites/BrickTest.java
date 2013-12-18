package sprites;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BrickTest {

    private Brick brick;

    public BrickTest() {
    }

    @Before
    public void setUp() {
        brick = new Brick(2, 0, 0);
    }

    @Test
    public void constructorWorking() {
        check(2, true);
    }

    @Test
    public void gettingHitWorks() {
        brick.hit();
        check(1, true);
    }

    @Test
    public void brickDies() {
        brick.hit();
        brick.hit();
        check(0, false);
    }

    private void check(int hp, boolean alive) {
        assertEquals(brick.getHitPoints(), hp);
        assertEquals(brick.alive(), alive);
    }

}
