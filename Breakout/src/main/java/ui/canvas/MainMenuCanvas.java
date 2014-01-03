package ui.canvas;

import breakout.Breakout;
import gamestate.GameStateManager;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import util.menus.Menu;

/**
 *
 * @author Joel
 */
public class MainMenuCanvas implements Canvas {

    private final Menu menu;

    /**
     * Create menu canvas, which creates Main Menu
     *
     * Canvas which handles the rendering of menu
     *
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

        painter.paintMenu(g, 400, 330, menu, 20);
    }
}
