package util;

import gamestate.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sprites.Ball;
import sprites.Paddle;

/**
 *
 * @author Joel
 */
public class GameKeyListener implements KeyListener {

    private final GameStateManager gsm;
    private Ball ball;
    private final Paddle paddle;

    /**
     *
     * @param gsm GameStateManager
     */
    public GameKeyListener(GameStateManager gsm, Ball ball, Paddle paddle) {
        this.gsm = gsm;
        this.ball = ball;
        this.paddle = paddle;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gsm.getState() == GameStates.PAUSE) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                gsm.setState(GameStates.PLAYSTATE);
            }
        }

        if (gsm.getState() == GameStates.PLAYSTATE) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                gsm.setState(GameStates.PAUSE);
                paddle.undockPaddle();
            }

            if (e.getKeyChar() == KeyEvent.VK_SPACE) {
                ball.launchBall();
                paddle.undockPaddle();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
