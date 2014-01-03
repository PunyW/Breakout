package util.menus;

import breakout.Breakout;
import gamestate.GameStateManager;
import java.util.ArrayList;

/**
 *
 * @author Joel
 */
public abstract class Menu {

    protected int currentChoice;
    protected final GameStateManager gsm;
    protected final Breakout breakout;
    protected ArrayList<String> choices;

    public Menu(Breakout breakout, GameStateManager gsm) {
        this.breakout = breakout;
        this.gsm = gsm;
        choices = new ArrayList<>();
    }

    /**
     * When player presses down key add 1 to the current choice, and wrap around
     * to the beginning if player presses down at the last option
     */
    public void increaseChoice() {
        currentChoice++;
        if (currentChoice >= choices.size()) {
            currentChoice = 0;
        }
    }

    /**
     * When player presses up key reduce 1 from the current choice, and wrap
     * around to the end if player presses up at the first option
     */
    public void decreaseChoice() {
        currentChoice--;
        if (currentChoice <= -1) {
            currentChoice = choices.size();
        }
    }

    /**
     * Set choice to the given option
     *
     * @param choice which option to select
     */
    public void changeChoice(int choice) {
        currentChoice = choice;
    }

    public int getCurrentChoice() {
        return currentChoice;
    }

    public void resetMenu() {
        currentChoice = 0;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    /**
     * Start the players choice
     *
     * @param choice players choice
     */
    public abstract void start(int choice);

    /**
     *
     */
    protected abstract void initChoices();
}
