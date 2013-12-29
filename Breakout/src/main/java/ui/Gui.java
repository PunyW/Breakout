package ui;

import breakout.Breakout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import util.GameKeyListener;
import util.GameMouseMotionListener;

/**
 *
 * @author Joel
 */
public class Gui implements Runnable {

    private JFrame frame;
    private Canvas canvas;
    private final Breakout breakout;

    /**
     *
     * @param breakout
     */
    public Gui(Breakout breakout) {
        this.breakout = breakout;
    }

    @Override
    public void run() {
        frame = new JFrame("Breakout");
        frame.setPreferredSize(new Dimension(807, 640));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane(), 800, 640);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createComponents(Container container, int w, int h) {
        canvas = new Canvas(breakout, w, h);
        container.add(canvas);

        GameKeyListener pkl = new GameKeyListener(breakout.getGameStateManager(),
                breakout.getBall(), breakout.getPaddle());
        frame.addKeyListener(pkl);

        GameMouseMotionListener pmml = new GameMouseMotionListener(breakout.getPaddle());
        frame.addMouseMotionListener(pmml);
    }

    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     *
     * @return
     */
    public Updatable getUpdatable() {
        return this.canvas;
    }

}
