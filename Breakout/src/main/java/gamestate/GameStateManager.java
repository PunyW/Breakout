package gamestate;

/**
 *
 * @author Joel
 */
public class GameStateManager {
    private GameState currentState;

    /**
     *
     */
    public GameStateManager() {
        currentState = GameState.MENUSTATE;
    }
    
    /**
     *
     * @param newState
     */
    public void changeState(GameState newState) {
        currentState = newState;
    }
    
    
}
