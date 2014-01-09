package util.highscore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

        FileReader fr;

        try {
            fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String points;

            //TOP 10
            for (int i = 0; i < 10; i++) {
                points = br.readLine();
                Score temp = new Score();
                String[] split = points.split(":");
                temp.setName(split[0]);
                temp.setScore(Integer.parseInt(split[1]));
                scores.add(temp);
            }

            fr.close();

        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }

        return scores;
    }
}
