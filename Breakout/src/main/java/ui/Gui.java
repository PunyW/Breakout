/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Joel
 */
public class Gui implements Runnable {

    private JFrame frame;
    private Canvas canvas;

    @Override
    public void run() {
        frame = new JFrame("Breakout");
        frame.setPreferredSize(new Dimension(800, 640));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        canvas = new Canvas();
        container.add(canvas);
    }

}
