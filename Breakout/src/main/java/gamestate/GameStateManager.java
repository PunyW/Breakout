package gamestate;


public class GameStateManager {
    private GameState currentState;

    public GameStateManager() {
        currentState = GameState.MENUSTATE;
    }
    
    public void changeState(GameState newState) {
        currentState = newState;
    }
    
    
}
