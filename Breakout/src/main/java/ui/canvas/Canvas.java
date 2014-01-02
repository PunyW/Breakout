package ui.canvas;

import java.awt.Graphics;

/**
 *
 * @author Joel
 */
public interface Canvas {

    /**
     * Render certain gamestate.
     *
     * @param g Graphics object which is used for rendering
     */
    void paint(Graphics g);
}
