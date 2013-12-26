package gamestate;

/**
 *
 * @author Joel
 */
public class GameStateManager {
    private GameStates currentState;

    /**
     *
     */
    public GameStateManager() {
        currentState = GameStates.MENUSTATE;
    }
    
    /**
     *
     * @param newState
     */
    public void changeState(GameStates newState) {
        currentState = newState;
    }
    
    public GameStates getState() {
        return currentState;
    }
    
    
}
