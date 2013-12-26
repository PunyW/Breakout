package util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import sprites.Paddle;

/**
 *
 * @author Joel
 */
public class PaddleMouseMotionListener implements MouseMotionListener {
    private final Paddle paddle;

    /**
     *
     * @param paddle
     */
    public PaddleMouseMotionListener(Paddle paddle) {
        this.paddle = paddle;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        // Center the paddle to the middle of the mouse
        paddle.setPosition(e.getX() - paddle.getWidth() / 2);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
