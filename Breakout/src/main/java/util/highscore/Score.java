package util.highscore;

/**
 * Holds the points for high score
 *
 * @author Joel
 */
public class Score {

    private int score;
    private String name;

    public Score() {
        this.name = "Name";
    }
    
    

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
