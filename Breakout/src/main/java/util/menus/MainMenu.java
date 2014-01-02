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

    private void newGame() {
        breakout.newGame();
        gsm.setState(GameStates.PLAYSTATE);
    }

    private void quitGame() {
        System.exit(0);
    }

    private void help() {
        gsm.setState(GameStates.HELP);
    }

    @Override
    public void start(int choice) {
        if(choice == 0) {
            newGame();
        } else if(choice == 1) {
            help();
        } else if(choice == 2) {
            quitGame();
        }
    }

}
