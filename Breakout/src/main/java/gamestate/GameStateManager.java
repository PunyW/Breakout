package gamestate;

import breakout.Breakout;

/**
 *
 * @author Joel
 */
public class GameStateManager {

    private GameStates currentState;

    /**
     * Game State Manager for the game, simple functionality you can set new
     * state, and get the current state.
     *
     */
    public GameStateManager() {
        currentState = GameStates.MENUSTATE;
    }

    public void setState(GameStates newState) {
        currentState = newState;
    }

    public GameStates getState() {
        return currentState;
    }
}
