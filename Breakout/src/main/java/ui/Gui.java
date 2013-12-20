
package ui;

import breakout.Breakout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import util.PaddleKeyListener;
import util.PaddleMouseMotionListener;

public class Gui implements Runnable {

    private JFrame frame;
    private Canvas canvas;
    private final Breakout breakout;

    public Gui(Breakout breakout) {
        this.breakout = breakout;
    }

    @Override
    public void run() {
        frame = new JFrame("Breakout");
        frame.setPreferredSize(new Dimension(800, 640));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane(), 800, 640);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container, int w, int h) {
        canvas = new Canvas(breakout, w, h);
        container.add(canvas);

        PaddleKeyListener pkl = new PaddleKeyListener();
        frame.addKeyListener(pkl);

        PaddleMouseMotionListener pmml = new PaddleMouseMotionListener(breakout.getPaddle());
        frame.addMouseMotionListener(pmml);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Updatable getUpdatable() {
        return this.canvas;
    }

}
