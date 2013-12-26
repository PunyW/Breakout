package entities;

/**
 *
 * @author Joel
 */
public class Player {
    private int lives;
    private int score;
    
    /**
     * Generate new player with score of 0, and given lives.
     * 
     * @param lives How many lives the player has.
     */
    public Player(int lives) {
        this.lives = lives;
        score = 0;
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }
    
    /**
     * Deduct 1 from lives
     */
    public void loseLife() {
        lives--;
    }
    
    /**
     * Increment lives with 1
     */
    public void increaseLives() {
        lives++;
    }
    
    /**
     * Increase the score of the player with n points.
     * 
     * @param n how many points the player gets.
     */
    public void increaseScore(int n) {
        score += n;
    }
}
