package util.highscore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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
            URL url = this.getClass().getResource(path);
            File file = new File(url.getFile());
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String points;

            //TOP 10
            for (int i = 0; i < 10; i++) {
                points = br.readLine();
                Score temp = new Score();
                temp.setScore(Integer.parseInt(points));
                scores.add(temp);
            }

            fr.close();

        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }

        return scores;
    }
}
