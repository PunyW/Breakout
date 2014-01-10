package util.highscore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
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
            URL url = this.getClass().getResource("/resources/highscores.txt");
            File file = new File(url.getPath());
            FileWriter fw = new FileWriter(file);

            fw.write("");
            for (int i = 0; i < 10; i++) {
                fw.append(scores.get(i).getScore() + "\n");
                fw.flush();
            }

        } catch (IOException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
