package ui.canvas;

import java.awt.Graphics;
import sprites.Help;

/**
 *
 * @author Joel
 */
public class HelpCanvas implements Canvas{
    
    private final Help help;
    
    public HelpCanvas() {
        help = new Help(0, 25, 800, 500);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(help.getImage(), help.getX(), help.getY(), null);
    }
    
}
