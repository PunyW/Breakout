package util;

import gamestate.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Joel
 */
public class GameKeyListener implements KeyListener {
    private GameStateManager gsm;
    
    /**
     * 
     * @param gsm GameStateManager
     */
    public GameKeyListener(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(gsm.getState() == GameStates.PAUSE) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                gsm.changeState(GameStates.PLAYSTATE);
            }
        }
        
        if(gsm.getState() == GameStates.PLAYSTATE) {
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                gsm.changeState(GameStates.PAUSE);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
