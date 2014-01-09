package util.highscore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joel
 */
public class HighScoreWriter {

    public void writeHighScores(ArrayList<Score> scores) {

        try {
            FileWriter fw = new FileWriter("highscores.txt");

            fw.write("");
            for (int i = 0; i < 10; i++) {
                fw.append(scores.get(i).getName() + ":" + scores.get(i).getScore());
                fw.write(System.lineSeparator());
                fw.flush();
            }

        } catch (IOException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
