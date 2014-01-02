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
public class DefeatCanvas implements Canvas{

    public DefeatCanvas() {
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(Color.BLACK);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
        g2.fill3DRect(150, 400, 525, 125, true);
        g2.dispose();

        g.setFont(new Font("Century", 1, 40));
        g.setColor(Color.WHITE);
        g.drawString("Game is paused", 240, 20);
        g.drawString("Hit Space to continue", 190, 20);
    }

}
