package util.menus;

import java.util.ArrayList;

/**
 *
 * @author Joel
 */
public abstract class Menu {

    protected int currentChoice;
    protected ArrayList<String> choices;

    public Menu() {
        choices = new ArrayList<>();
    }

    /**
     * When player presses down key add 1 to the current choice, and wrap around
     * to the beginning if player presses down at the last option
     */
    public void increaseChoice() {
        currentChoice++;
        if(currentChoice > choices.size()) {
            currentChoice = 0;
        }
    }

    /**
     * When player presses up key reduce 1 from the current choice, and wrap around
     * to the end if player presses up at the first option
     */
    public void decreaseChoice() {
        currentChoice--;
        if(currentChoice < 0) {
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
}
