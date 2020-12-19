package com.sample.base.model.level;

public class Level0 implements Level {

    private static final int ID = 0;

    private static final int STARTING_ROW = 1;
    private static final int STARTING_COL = 1;

    private static final int[][] MAP = {
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0}
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
    public int getStartingRow() {
        return STARTING_ROW;
    }

    @Override
    public int getStartingCol() {
        return STARTING_COL;
    }
}
