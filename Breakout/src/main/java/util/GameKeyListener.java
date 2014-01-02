package util;

import gamestate.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sprites.Ball;
import sprites.Paddle;
import util.menus.Menu;

/**
 *
 * @author Joel
 */
public class GameKeyListener implements KeyListener {

    private final GameStateManager gsm;
    private Ball ball;
    private final Paddle paddle;
    private Menu currentMenu;

    /**
     * Listens for players input from keyboard.
     *
     * @param gsm GameStateManager
     * @param ball Game ball
     * @param paddle Players paddle
     */
    public GameKeyListener(GameStateManager gsm, Ball ball, Paddle paddle) {
        this.gsm = gsm;
        this.ball = ball;
        this.paddle = paddle;
        currentMenu = gsm.currentMenu(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gsm.getState() == GameStates.MENUSTATE) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                currentMenu.increaseChoice();
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                currentMenu.decreaseChoice();
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                int choice = currentMenu.getCurrentChoice();
                currentMenu.start(choice);
            }
        }

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
                paddle.dockPaddle();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
