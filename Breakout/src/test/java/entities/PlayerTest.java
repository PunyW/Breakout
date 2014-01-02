package entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    public PlayerTest() {
        player = new Player(3);
    }

    @Before
    public void setUp() {
        player.increaseScore(10);
    }

    @Test
    public void constructorWorking() {
        checkStats(3, 10);
    }

    @Test
    public void constructorWorkingTwo() {
        Player player1 = new Player(1);
        assertEquals(player1.getLives(), 1);
    }

    @Test
    public void losingLivesWorks() {
        player.loseLife();
        checkStats(2, 10);
    }

    @Test
    public void LifeUpWorks() {
        player.increaseLives();
        checkStats(4, 10);
    }

    @Test
    public void scoreWorks() {
        player.increaseScore(100);
        checkStats(3, 110);
    }
    
    @Test
    public void resetWorks() {
        player.increaseLives();
        player.increaseScore(100);
        player.reset();
        checkStats(3, 0);
    }

    private void checkStats(int life, int score) {
        assertEquals(player.getLives(), life);
        assertEquals(player.getScore(), score);
    }
}
