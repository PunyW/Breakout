package ui.canvas;

import java.awt.Graphics;
import sprites.Background;

/**
 * Canvas which renders the backgrounds
 * 
 * @author Joel
 */
public class BackgroundCanvas implements Canvas {

    private Background bg;

    public BackgroundCanvas() {
        bg = new Background(0, 0, 640, 800);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bg.getImage(), 0, 0, null);
    }

}
