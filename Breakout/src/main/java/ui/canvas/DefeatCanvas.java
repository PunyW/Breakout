package ui.canvas;

import breakout.Breakout;
import entities.Player;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Joel
 */
public class DefeatCanvas implements Canvas {

    private final Player player;

    public DefeatCanvas(Breakout breakout) {
        player = breakout.getPlayer();
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
        g.drawString("Game over", 275, 200);
        g.drawString("Score: " + player.getScore(), 300, 250);
    }

}
