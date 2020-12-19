package com.sample.base.model;

import java.io.Serializable;

public enum Direction implements Serializable {

    NORTH(0, 1),
    WEST(1, 0),
    SOUTH(0, -1),
    EAST(-1, 0);

    private final int xDiff;
    private final int yDiff;

    Direction(int xDiff, int yDiff) {
        this.xDiff = xDiff;
        this.yDiff = yDiff;
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

    public int getxDiff() {
        return xDiff;
    }

    public int getyDiff() {
        return yDiff;
    }
}
