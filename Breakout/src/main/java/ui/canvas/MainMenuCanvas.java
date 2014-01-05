package ui.canvas;

import breakout.Breakout;
import gamestate.GameStateManager;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import util.menus.Menu;

/**
 * Canvas which is handling the rendering of the Main Menu
 *
 * @author Joel
 */
public class MainMenuCanvas implements Canvas {

    private final Menu menu;

    /**
     * Create new MainMenuCanvas
     * @param breakout main game to be passed for MainMenu
     * @param gsm Game State manager to be passed for MainMenu
     */
    public MainMenuCanvas(Breakout breakout, GameStateManager gsm) {
        menu = gsm.getMenu(0);
    }

    @Override
    public void paint(Graphics g) {
        PaintMenu painter = new PaintMenu();

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(Color.BLACK);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
        g2.fill3DRect(290, 350, 225, 150, true);
        g2.dispose();

        g.setFont(new Font("Century", 1, 100));
        g.setColor(Color.LIGHT_GRAY);
        g.drawString("BREAKOUT", 85, 145);

        painter.paintMenu(g, 400, 330, menu, 20);
    }
}
