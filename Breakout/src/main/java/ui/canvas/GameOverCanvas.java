package ui.canvas;

import breakout.Breakout;
import entities.Player;
import gamestate.GameStateManager;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import util.menus.Menu;

/**
 *
 * @author Joel
 */
public class GameOverCanvas implements Canvas {

    private final Player player;
    private final Menu menu;

    /**
     * Create the canvas for game over scenario
     *
     * @param breakout main game
     * @param gsm Game State Manager
     */
    public GameOverCanvas(Breakout breakout, GameStateManager gsm) {
        player = breakout.getPlayer();
        this.menu = gsm.getMenu(1);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(Color.BLACK);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
        g2.fill3DRect(40, 40, 720, 540, true);
        g2.dispose();

        g.setFont(new Font("Century", 1, 40));
        g.setColor(Color.WHITE);
        g.drawString("Game over", 275, 200);
        g.drawString("Score: " + player.getScore(), 285, 250);

        PaintMenu painter = new PaintMenu();
        painter.paintMenu(g, 450, 300, menu, 25);
    }

}
