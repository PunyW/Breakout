package util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import sprites.Paddle;

/**
 * Looks for mouse movements
 * 
 * @author Joel
 */
public class GameMouseMotionListener implements MouseMotionListener {

    private final Paddle paddle;

    /**
     * Create new GameMouseMotionListener
     * @param paddle Paddle that can be moved with the mouse
     */
    public GameMouseMotionListener(Paddle paddle) {
        this.paddle = paddle;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Get mouse x position and if paddle is docked to the mouse, center paddle
     * to the mouse x
     * 
     * @param e mouse 
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        if (paddle.docked()) {
            paddle.setPosition(e.getX() - paddle.getWidth() / 2);
        }
    }

}
