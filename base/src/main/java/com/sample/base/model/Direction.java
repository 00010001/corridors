package com.sample.base.model;

import java.io.Serializable;

public enum Direction implements Serializable {

    NORTH(0, -1),
    WEST(-1, 0),
    SOUTH(0, 1),
    EAST(1, 0);

    private final int colOffset;
    private final int rowOffset;

    Direction(int colOffset, int rowOffset) {
        this.colOffset = colOffset;
        this.rowOffset = rowOffset;
    }

    public Direction turnLeft() {
        int turnLeft = 1;
        return getDirectionByOrdinalMovingClockwise(turnLeft);
    }

    public Direction turnRight() {
        int turnRight = -1;
        return getDirectionByOrdinalMovingClockwise(turnRight);
    }

    public Direction turnAround() {
        int turnAround = 2;
        return getDirectionByOrdinalMovingClockwise(turnAround);
    }

    private Direction getDirectionByOrdinalMovingClockwise(int moveBy) {
        int thisDirectionOrdinal = ordinal();
        int newDirectionOrdinal = (thisDirectionOrdinal + moveBy) % enumElementsCount();
        if (newDirectionOrdinal < 0) {
            newDirectionOrdinal = enumElementsCount() + newDirectionOrdinal;
        }
        return values()[newDirectionOrdinal];
    }

    private int enumElementsCount() {
        return values().length;
    }

    public int getColOffset() {
        return colOffset;
    }

    public int getRowOffset() {
        return rowOffset;
    }
}
