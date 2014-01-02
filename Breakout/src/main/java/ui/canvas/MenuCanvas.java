package ui.canvas;

import breakout.Breakout;
import gamestate.GameStateManager;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import util.menus.MainMenu;
import util.menus.Menu;

/**
 *
 * @author Joel
 */
public class MenuCanvas implements Canvas {

    private final Menu menu;
    ArrayList<String> choices;

    /**
     * Create menu canvas, which creates Main Menu
     *
     * Canvas which handles the rendering of menu
     *
     * @param breakout main game to be passed for MainMenu
     * @param gsm Game State manager to be passed for MainMenu
     */
    public MenuCanvas(Breakout breakout, GameStateManager gsm) {
        menu = gsm.currentMenu(0);
        choices = menu.getChoices();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(Color.BLACK);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
        g2.fill3DRect(290, 350, 225, 150, true);
        g2.dispose();

        g.setFont(new Font("Century", 1, 20));

        int startY = 400;

        for (int i = 0; i < choices.size(); i++) {
            String option = choices.get(i);

            // Check if the current choice is being rendered, if it is change
            // the color to CYAN else render in WHITE
            if (menu.getCurrentChoice() == i) {
                g.setColor(Color.CYAN);
            } else {
                g.setColor(Color.WHITE);
            }

            g.drawString(option, 330, startY + (i * 25));
        }
    }
}
