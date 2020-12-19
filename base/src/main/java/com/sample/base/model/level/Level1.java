package com.sample.base.model.level;

public class Level1 implements Level {

    private static final int ID = 1;

    private static final int STARTING_X_POS = 2;
    private static final int STARTING_Y_POS = 6;

    private static final int[][] MAP = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0}
    };

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public int[][] getMap() {
        return MAP;
    }

    @Override
    public int getStartingXPos() {
        return STARTING_X_POS;
    }

    @Override
    public int getStartingYPos() {
        return STARTING_Y_POS;
    }
}
