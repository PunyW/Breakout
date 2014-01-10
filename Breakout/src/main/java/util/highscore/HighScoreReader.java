package util.highscore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Reads old high scores from file
 *
 * @author Joel
 */
public class HighScoreReader {

    /**
     * Reads high scores text file and adds the scores into an arraylist.
     *
     * @param path filepath to the high scores table
     * @return returns new arraylist that holds the high scores
     */
    public ArrayList<Score> readScores(String path) {
        ArrayList<Score> scores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                HighScore.class.getResourceAsStream(path)))) {

            String points;

            //TOP 10
            for (int i = 0; i < 10; i++) {
                points = br.readLine();
                Score temp = new Score();
                temp.setScore(Integer.parseInt(points));
                scores.add(temp);
            }

        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }

        return scores;
    }
}
