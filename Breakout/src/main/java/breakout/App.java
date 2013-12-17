package breakout;

import javax.swing.SwingUtilities;
import ui.Gui;

public class App {

    public static void main(String[] args) {
        Breakout breakout = new Breakout(800, 640);
        Gui gui = new Gui(breakout);
        SwingUtilities.invokeLater(gui);

        while (gui.getUpdatable() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Canvas hasn't been created yet");
            }
        }
        breakout.setUpdatable(gui.getUpdatable());
        breakout.start();
    }
}
