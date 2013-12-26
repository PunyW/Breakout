package util;

import gamestate.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Joel
 */
public class PaddleKeyListener implements KeyListener {
    private GameStateManager gsm;
    
    /**
     * 
     * @param gsm GameStateManager
     */
    public PaddleKeyListener(GameStateManager gsm) {
        this.gsm = gsm;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(gsm.getState() == GameState.PAUSE) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                gsm.changeState(GameState.PLAYSTATE);
            }
        }
        
        if(gsm.getState() == GameState.PLAYSTATE) {
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                gsm.changeState(GameState.PAUSE);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
