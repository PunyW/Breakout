package ui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Joel
 */
public class PauseCanvas {

    /**
     * Canvas for pause screen.
     */
    public PauseCanvas() {
    }

    /**
     * Render the pause information
     * 
     * @param g Graphics paintbrush
     * @param height frame height
     */
    public void paint(Graphics g, int height) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(Color.BLACK);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
        g2.fill3DRect(150, height / 2 - 85, 525, 125, true);
        g2.dispose();

        g.setFont(new Font("Century", 1, 40));
        g.setColor(Color.WHITE);
        g.drawString("Game is paused", 240, height / 2 - 40);
        g.drawString("Hit Space to continue", 190, height / 2);
    }
}
