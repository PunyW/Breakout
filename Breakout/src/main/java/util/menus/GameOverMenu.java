package util.menus;

import breakout.Breakout;
import gamestate.GameStateManager;
import gamestate.GameStates;

/**
 * Menu that handles the Game Over options
 * 
 * @author Joel
 */
public final class GameOverMenu extends Menu {

    public GameOverMenu(Breakout breakout, GameStateManager gsm) {
        super(breakout, gsm);
        initChoices();
    }

    private void newGame() {
        breakout.newGame();
        gsm.setState(GameStates.PLAYSTATE);
    }

    private void quitGame() {
        System.exit(0);
    }
    
    private void highscores() {
        gsm.setState(GameStates.HIGHSCORE);
    }

    @Override
    public void start(int choice) {
        switch (choice) {
            case 0:
                newGame();
                break;
            case 1:
                highscores();
                break;
            case 2:
                quitGame();
                break;
        }
        resetMenu();
    }

    @Override
    protected void initChoices() {
        choices.add("New Game");
        choices.add("High Scores");
        choices.add("Quit Game");
    }

}
