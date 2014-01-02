package ui.canvas;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Joel
 */
public class MenuCanvas implements Canvas {

    /**
     * Canvas which handles the rendering of menu
     */
    public MenuCanvas() {

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);

        g.dispose();
    }
}
