/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import sprites.Brick;

/**
 *
 * @author Joel
 */
public class BrickCreator {

    public BrickCreator() {
    }

    public Brick[][] createBrickLayout() {
        /* 
         * Here we will create the brick layout, bricks[i][j] tells the life of the brick
         * Later add feature to read the brick layout from a file
         */

        int[][] bricks = new int[10][10];

        int n;
        for (int i = 0; i < bricks.length; i++) {
            if (i % 2 == 0) {
                n = 1;
            } else {
                n = 2;
            }
            for (int j = 0; j < bricks.length; j++) {
                bricks[i][j] = n;
            }

        }

        return createBricks(bricks);
    }

    private Brick[][] createBricks(int[][] bricks) {
        // Convert the integers into bricks with health
        Brick[][] brickLayout = new Brick[bricks.length][bricks[0].length];

        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                brickLayout[i][j] = new Brick(bricks[i][j]);
            }
        }

        return brickLayout;
    }

}
