package util.menus;

/**
 *
 * @author Joel
 */
public abstract class Menu {

    protected int currentChoice;

    public Menu() {
    }

    /**
     * When player presses down key add 1 to the current choice
     */
    public void increaseChoice() {
        currentChoice++;
    }

    /**
     * When player presses up key reduce 1 from the current choice
     */
    public void decreaseChoice() {
        currentChoice--;
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
}
