package entities;

import sprites.Brick;

public class BrickCreator {

    private final int frameWidth, frameHeight;

    public BrickCreator(int width, int height) {
        frameWidth = width;
        frameHeight = height;
    }

    public Brick[][] createBrickLayout() {
        /* 
         * Here we will create the brick layout, bricks[i][j] tells the life of the brick
         * Later add feature to read the brick layout from a file
         */

        int[][] bricks = new int[10][15];

        int n;
        for (int i = 0; i < bricks.length; i++) {
            if (i % 2 == 0) {
                n = 1;
            } else {
                n = 2;
            }
            for (int j = 0; j < bricks[0].length; j++) {
                bricks[i][j] = n;
            }

        }

        return createBricks(bricks);
    }

    private Brick[][] createBricks(int[][] bricks) {
        // Convert the integers into bricks with health
        Brick[][] brickLayout = new Brick[bricks.length][bricks[0].length];
        Brick template = new Brick(0, 0, 0);

        int x = 50;
        int y = 50;

        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                Brick brick = new Brick(bricks[i][j], x, y);
                brickLayout[i][j] = brick;
                x += template.getWidth() + 5;
            }
            y += template.getHeight() + 5;
            x = 50;
        }

        return brickLayout;
    }

}
