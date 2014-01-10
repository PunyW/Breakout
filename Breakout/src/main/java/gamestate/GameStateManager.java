package gamestate;

import breakout.Breakout;
import java.util.ArrayList;
import util.menus.GameOverMenu;
import util.menus.MainMenu;
import util.menus.Menu;

/**
 * Game State Manager is responsible for handling current game state and menu
 * 
 * @author Joel
 */
public class GameStateManager {

    private GameStates currentState;
    private final ArrayList<Menu> menus;

    /**
     * Create new Game State Manager
     * @param breakout
     */
    public GameStateManager(Breakout breakout) {
        currentState = GameStates.MENUSTATE;
        menus = new ArrayList<>();
        initMenus(breakout);
    }

    private void initMenus(Breakout breakout) {
        menus.add(new MainMenu(breakout, this));
        menus.add(new GameOverMenu(breakout, this));
    }

    public void setState(GameStates newState) {
        currentState = newState;
    }

    public GameStates getState() {
        return currentState;
    }

    public Menu getMenu(int i) {
        return menus.get(i);
    }
}
