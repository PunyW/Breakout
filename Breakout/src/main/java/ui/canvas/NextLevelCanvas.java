package ui.canvas;

import breakout.Breakout;
import entities.Player;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.awt.SystemColor.menu;
import util.menus.Menu;

/**
 *
 * @author Joel
 */
public class NextLevelCanvas implements Canvas {
    private final Player player;

    public NextLevelCanvas(Breakout breakout) {
        this.player = breakout.getPlayer();
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
        g.drawString("You have cleared this level", 140, 245);
        g.drawString("Current Score: " + player.getScore(), 240, 295);
        g.drawString("Press enter to continue", 155, 345);

    }

}
