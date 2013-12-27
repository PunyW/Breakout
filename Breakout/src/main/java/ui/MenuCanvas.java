package ui;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Joel
 */
public class MenuCanvas {

    public MenuCanvas() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fill3DRect(50, 50, 150, 150, true);

        g.dispose();
    }
}
