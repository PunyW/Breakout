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

public class Breakout extends Timer implements ActionListener {

    private Brick[][] bricks;
    private Ball ball;
    private Paddle paddle;
    private Updatable updatable;
    private CollisionDetectionManager cd;
    private Player player;
    private BrickCreator bc;
    private boolean running;
    private GameStateManager gsm;

    public Breakout(int width, int height) {
        super(1000, null);
        init(width, height, 60);
    }

    // Constructor for custom paddle size
    public Breakout(int width, int height, int paddleWidth) {
        super(1000, null);
        init(width, height, paddleWidth);
    }

    private void init(int width, int height, int paddleWidth) {
        this.running = true;
        this.paddle = new Paddle(width / 2 - 30, height - 85, 20, paddleWidth, width);
        this.ball = new Ball(paddle);
        ball.launchBall();
        this.cd = new CollisionDetectionManager(width, height, paddle);
        this.player = new Player(3);
        bc = new BrickCreator(width, height);
        bricks = bc.createBricks(10, 15);
        gsm = new GameStateManager();
        gsm.changeState(GameStates.PLAYSTATE);
        
        addActionListener(this);
        setInitialDelay(10);
    }

    public boolean running() {
        return running;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!running) {
            return;
        }
        
        if (gsm.getState() == GameStates.PLAYSTATE) {
            ball.move();

            // Check for collisions, returns true if player has 0 lives left
            if (cd.collisions(bricks, ball, player)) {
                gsm.changeState(GameStates.ENDSCREEN);
            }
        }

        this.updatable.update();
        setDelay(1000 / 20);
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
}
