package util.highscore;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joel
 */
public class ScoreTest {
    
    @Test
    public void testScore() {
        Score score = new Score(10);
        assertEquals(10, score.getScore());
    }
}
