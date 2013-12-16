package ui;

import java.awt.Graphics;
import javax.swing.JPanel;
import objects.Paddle;

public class Canvas extends JPanel {
    private Paddle paddle;
    
    public Canvas() {
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paint(g);
        
    }
}
