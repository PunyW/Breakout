package breakout;

import entities.BrickCreator;
import entities.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import sprites.Ball;
import sprites.Brick;
import sprites.Paddle;
import ui.Updatable;
import collisiondetection.CollisionDetectionManager;
import gamestate.*;
import java.util.ArrayList;
import util.highscore.HighScore;
import util.highscore.Score;

public class Breakout extends Timer implements ActionListener {

    private final int width, height;
    private Brick[][] bricks;
    private Ball ball;
    private Paddle paddle;
    private Updatable updatable;
    private CollisionDetectionManager cd;
    private Player player;
    private BrickCreator bc;
    private boolean running;
    private GameStateManager gsm;
    private HighScore hs;

    /**
     * Constructor for the breakout game., paddle width set to 60 px.
     *
     * @param width frame width
     * @param height frame height
     */
    public Breakout(int width, int height) {
        super(1000, null);
        this.width = width;
        this.height = height;
        createGameObjects(60);
        init(width, height);
    }

    /**
     * Constructor for the breakout game, with custom paddle width.
     *
     * @param width frame width
     * @param height frame height
     * @param paddleWidth paddle width
     */
    public Breakout(int width, int height, int paddleWidth) {
        super(1000, null);
        this.width = width;
        this.height = height;
        createGameObjects(paddleWidth);
        init(width, height);
    }

    /**
     * Initialize the breakout game.
     *
     * <p>
     * Create new paddle with given width and create new ball and place it atop
     * the paddle, create new bricks. Initialize the game state manager and the
     * collision detection manager.
     *
     * @param width frame width
     * @param height frame height
     */
    private void init(int width, int height) {
        this.running = true;
        bc = new BrickCreator(width, height);
        bricks = bc.createBricks(10, 15);
        gsm = new GameStateManager(this);
        this.cd = new CollisionDetectionManager(width, height, paddle);
        this.hs = new HighScore("/resources/highscores.txt");
        addActionListener(this);
        setDelay(17);
    }

    public boolean running() {
        return running;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    // Game Loop
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!running) {
            return;
        }

        if (gsm.getState() == GameStates.PLAYSTATE) {
            ball.move();

            // If ball isn't moving keep it on top of the paddle
            if (!ball.moving()) {
                ball.resetBall();
            }

            // Check for collisions, returns true if player has 0 lives left
            if (cd.collisions(bricks, ball, player)) {
                hs.checkForNewHighScore(player.getScore());
                gsm.setState(GameStates.GAME_OVER);
                paddle.undockPaddle();
                hs.writeNewHighScores();
            }
        }

        if (bricksDestroyed()) {
            ball.disableBall();
            newLevel();
            gsm.setState(GameStates.LEVEL_CLEARED);
        }

        updatable.update();
    }

    /**
     *
     * @param paddleWidth Initial width of the game paddle
     */
    private void createGameObjects(int paddleWidth) {
        this.paddle = new Paddle(width / 2 - 30, height - 85, 20, paddleWidth, width);
        this.ball = new Ball(paddle);
        this.player = new Player(1);
    }

    /**
     * Create new game, by resetting all the game objects and creating new
     * bricks
     */
    public void newGame() {
        paddle.reset();
        ball.resetBall();
        player.reset();
        bricks = bc.createBricks(10, 15);
    }

    public void newLevel() {
        paddle.reset();
        ball.resetBall();
        bricks = bc.createBricks(10, 20);
    }

    /**
     * Check if all the bricks have been destroyed
     *
     * @return returns false if some of the bricks still alive, true if all the
     * bricks have been destroyed
     */
    public boolean bricksDestroyed() {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                if (bricks[i][j].alive()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public Ball getBall() {
        return ball;
    }

    public Brick[][] getBricks() {
        return bricks;
    }

    public Player getPlayer() {
        return player;
    }

    public GameStateManager getGameStateManager() {
        return gsm;
    }

    public ArrayList<Score> getHighScores() {
        return hs.getHighScores();
    }
}
