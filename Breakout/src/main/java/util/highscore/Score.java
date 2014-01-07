package util.highscore;

/**
 * Holds the points for high score
 *
 * @author Joel
 */
public class Score {

    private final int score;

    /**
     * Create new score
     * 
     * @param score how many points
     */
    public Score(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
