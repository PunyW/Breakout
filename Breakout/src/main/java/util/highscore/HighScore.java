package util.highscore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * High Score listing, load the high scores from external file
 *
 * @author Joel
 */
public class HighScore {

    private ArrayList<Score> hs;
    private File file;

    public HighScore(String filepath) {
        getScores();
    }

    /**
     * Get the high scores file
     *
     * @param filepath filepath for high scores table
     */
    private void getFile(String filepath) {
        URL url = this.getClass().getResource(filepath);
        file = new File(url.getFile());
    }

    /**
     * Get the old high scores from the file and add them into arraylist
     */
    private void getScores() {
        hs = new ArrayList<>();
        FileReader fr;

        try {
            fr = new FileReader("highscores.txt");

            BufferedReader br = new BufferedReader(fr);
            String points;

            //TOP 10
            for (int i = 0; i < 10; i++) {
                points = br.readLine();
                Score temp = new Score(Integer.parseInt(points));
                hs.add(temp);
            }

            fr.close();

        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
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
        try {
            FileWriter fw = new FileWriter("highscores.txt");
            
            System.out.println("TESTI");
            fw.write("");
            for(int i = 0; i < 10; i++) {
                
            }
            fw.flush();
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ei toimi");
        }
        
    }
}
