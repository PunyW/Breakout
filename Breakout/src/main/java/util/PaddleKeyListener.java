/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sprites.Paddle;

/**
 *
 * @author Joel
 */
public class PaddleKeyListener implements KeyListener {
    private Paddle paddle;

    public PaddleKeyListener(Paddle paddle) {
        this.paddle = paddle;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.move(-5);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.move(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
