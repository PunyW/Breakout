package gamestate;

import breakout.Breakout;
import java.util.ArrayList;
import util.menus.MainMenu;
import util.menus.Menu;

/**
 *
 * @author Joel
 */
public class GameStateManager {

    private GameStates currentState;
    private ArrayList<Menu> menus;

    /**
     * GameStateManger, which handles the current game states and menus
     *
     * @param breakout
     */
    public GameStateManager(Breakout breakout) {
        currentState = GameStates.MENUSTATE;
        menus = new ArrayList<>();
        menus.add(new MainMenu(breakout, this));
    }

    public void setState(GameStates newState) {
        currentState = newState;
    }

    public GameStates getState() {
        return currentState;
    }
    
    public Menu currentMenu(int i) {
        return menus.get(i);
    }
}
