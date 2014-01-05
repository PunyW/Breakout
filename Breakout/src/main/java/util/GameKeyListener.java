package util;

import gamestate.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sprites.Ball;
import sprites.Paddle;
import util.menus.Menu;

/**
 * Listens for player input
 * 
 * @author Joel
 */
public class GameKeyListener implements KeyListener {

    private final GameStateManager gsm;
    private Ball ball;
    private final Paddle paddle;
    private Menu currentMenu;

    /**
     * Create new GameKeyListener
     *
     * @param gsm GameStateManager
     * @param ball Game ball
     * @param paddle Players paddle
     */
    public GameKeyListener(GameStateManager gsm, Ball ball, Paddle paddle) {
        this.gsm = gsm;
        this.ball = ball;
        this.paddle = paddle;
        currentMenu = gsm.getMenu(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gsm.getState() == GameStates.MENUSTATE || gsm.getState() == GameStates.GAME_OVER) {
            // Change menu to the correct one
            if(gsm.getState() == GameStates.MENUSTATE) {
                currentMenu = gsm.getMenu(0);
            } else {
                currentMenu = gsm.getMenu(1);
            }
            
            
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

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                ball.launchBall();
                paddle.dockPaddle();
            }
        }
        
        if(gsm.getState() == GameStates.LEVEL_CLEARED) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                gsm.setState(GameStates.PLAYSTATE);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
