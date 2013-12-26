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
        if(gsm.getState() == GameStates.PAUSE) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                gsm.changeState(GameStates.MENUSTATE);
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
