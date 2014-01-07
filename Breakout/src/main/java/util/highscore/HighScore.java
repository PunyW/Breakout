package util.highscore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * High Score listing, load the high scores from external file
 *
 * @author Joel
 */
public class HighScore {

    private ArrayList<Score> hs;
    private final String filepath;

    public HighScore(String filepath) {
        hs = new ArrayList<>();
        this.filepath = filepath;
        getScores(filepath);
    }

    /**
     * Get the old high scores from the file and add them into arraylist
     */
    private void getScores(String filepath) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                HighScore.class.getResourceAsStream(filepath)))) {
            String line;

            // TOP 10
            for (int i = 0; i < 10; i++) {
                line = in.readLine();
                String[] score = line.split(" ");
                Score temp = new Score(Integer.parseInt(score[1]));
                hs.add(temp);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
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
                Score temp = new Score(newScore);
                hs.add(i, temp);
                writeNewHighScores();
                return;
            }
        }
    }

    public ArrayList<Score> getHighScores() {
        return hs;
    }

    /**
     * Write new high scores into the file
     */
    public void writeNewHighScores() {

    }
}
