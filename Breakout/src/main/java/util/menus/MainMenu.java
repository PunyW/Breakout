package util.menus;

import breakout.Breakout;
import gamestate.GameStateManager;
import gamestate.GameStates;

/**
 *
 * @author Joel
 */
public class MainMenu extends Menu {

    private final Breakout breakout;
    private final GameStateManager gsm;

    public MainMenu(Breakout breakout, GameStateManager gsm) {
        this.breakout = breakout;
        this.gsm = gsm;
        initChoices();
    }

    private void initChoices() {
        choices.add("New Game");
        choices.add("Help");
        choices.add("Quit Game");
    }

    public void newGame() {
        breakout.newGame();
        gsm.setState(GameStates.PLAYSTATE);
    }

    public void quitGame() {
        System.exit(0);
    }

    public void help() {
        gsm.setState(GameStates.HELP);
    }

}
