package entities;

public class Player {
    private int lives;
    private int score;
    
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
    
    public void loseLives() {
        lives--;
    }
    
    public void increaseLives() {
        lives++;
    }
    
    public void increaseScore(int i) {
        score += i;
    }
}
