package entities;

import sprites.Brick;

/**
 * Class that handles creating new bricks
 *
 * @author Joel
 */
public class BrickCreator {

    /**
     * Constructor for brick creator
     */
    public BrickCreator() {
    }

    /**
     * Generate array of Bricks
     *
     * @param h how many bricks on top of each other
     * @param w how many bricks in each row
     * @return generated Brick[][] array
     */
    public Brick[][] createBricks(int h, int w) {
        Brick[][] brickLayout = new Brick[h][w];
        Brick template = new Brick(0, 0, 0);

        int x = 50;
        int y = 50;
        int n;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i % 2 == 0) {
                    n = 1;
                } else {
                    n = 2;
                }
                Brick brick = new Brick(n, x, y);
                brickLayout[i][j] = brick;
                x += template.getWidth() + 5;
            }
            y += template.getHeight() + 5;
            x = 50;
        }

        return brickLayout;
    }
}
