package ui.canvas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import util.menus.Menu;

/**
 * Canvas which is handling the rendering of the menu options
 * 
 * @author Joel
 */
public class PaintMenu {

    /**
     * Render the menu options on the screen at the given coordinates
     * 
     * @param g Graphics object
     * @param y At what y position the list should start at
     * @param x At what x position the lists left side should be situated at
     * @param menu Which menus items are being rendered
     * @param fontSize How large the text should be
     */
    public void paintMenu(Graphics g, int y, int x, Menu menu, int fontSize) {
        g.setFont(new Font("Century", 1, fontSize));

        for (int i = 0; i < menu.getChoices().size(); i++) {
            String option = menu.getChoices().get(i);

            // Check if the current choice is being rendered, if it is change
            // the color to CYAN else render in WHITE
            if (menu.getCurrentChoice() == i) {
                g.setColor(Color.CYAN);
            } else {
                g.setColor(Color.WHITE);
            }

            g.drawString(option, x, y + (i * 25));
        }
    }
}
