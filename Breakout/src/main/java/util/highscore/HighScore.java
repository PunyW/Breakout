package util.highscore;

import java.util.ArrayList;

/**
 * High Score listing
 *
 * @author Joel
 */
public class HighScore {

    private final ArrayList<Score> hs;

    public HighScore(String filepath) {
        HighScoreReader reader = new HighScoreReader();
        hs = reader.readScores(filepath);
    }

    public void checkForNewHighScore(int newScore) {
        if (newScore > hs.get(9).getScore()) {
            addNewHighScore(newScore);
        }
    }

    /**
     * Add new score to the high score list, if the new score is equal to old
     * one add it after the original
     *
     * @param newScore how many points the player got
     */
    private void addNewHighScore(int newScore) {
        for (int i = 0; i < 10; i++) {
            if (newScore > hs.get(i).getScore()) {
                Score temp = new Score();
                temp.setScore(newScore);
                hs.add(i, temp);
                writeHighScores();
                return;
            }
        }
    }

    public ArrayList<Score> getHighScores() {
        return hs;
    }

    public void writeHighScores() {
        HighScoreWriter hsw = new HighScoreWriter();
        hsw.writeHighScores(hs);
    }

}
