package util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import sprites.Paddle;

/**
 *
 * @author Joel
 */
public class GameMouseMotionListener implements MouseMotionListener {

    private final Paddle paddle;

    /**
     *
     * @param paddle
     */
    public GameMouseMotionListener(Paddle paddle) {
        this.paddle = paddle;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Center the paddle to the middle of the mouse
        if (paddle.docked()) {
            paddle.setPosition(e.getX() - paddle.getWidth() / 2);
        }
    }

}
