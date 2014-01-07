package ui.canvas;

import breakout.Breakout;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import util.highscore.Score;

/**
 * Canvas for rendering high scores
 *
 * @author Joel
 */
public class HighScoreCanvas implements Canvas {

    private final ArrayList<Score> hs;

    /**
     * Create new High Score canvas
     *
     * @param breakout main game
     */
    public HighScoreCanvas(Breakout breakout) {
        this.hs = breakout.getHighScores();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(Color.BLACK);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
        g2.fill3DRect(40, 40, 720, 540, true);
        g2.dispose();

        g.setFont(new Font("Century", 1, 40));
        g.setColor(Color.WHITE);
        g.drawString("High Scores", 275, 200);
        g.setFont(new Font("Century", 1, 25));

        int y = 250;

        for (int i = 0; i < 10; i++) {
            g.drawString((i + 1) + "", 275, y);
            g.drawString(hs.get(i).getScore() + "", 350, y);
            y += 30;
        }
    }

}
