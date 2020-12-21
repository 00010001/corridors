package com.sample.console.renderer;

import com.sample.base.model.Direction;
import com.sample.base.model.GameState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameRendererTest {

    private static final int[][] MAP = {
            {0, 0, 0},
            {0, 1, 0},
            {4, 5, 2},
            {0, 3, 0}
    };
    private final GameRenderer gameRenderer = new GameRenderer();

    @Test
    public void shouldGetValidFacingValuesWhenDirectionWest() {
        Direction direction = Direction.WEST;
        int col = 1;
        int row = 2;
        int frontFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction);
        int leftFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction.turnLeft());
        int rightFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction.turnRight());

        assertEquals(4, frontFacingValue);
        assertEquals(3, leftFacingValue);
        assertEquals(1, rightFacingValue);
    }

    @Test
    public void shouldGetValidFacingValuesWhenDirectionEast() {
        Direction direction = Direction.EAST;
        int col = 1;
        int row = 2;
        int frontFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction);
        int leftFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction.turnLeft());
        int rightFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction.turnRight());

        assertEquals(2, frontFacingValue);
        assertEquals(1, leftFacingValue);
        assertEquals(3, rightFacingValue);
    }

    @Test
    public void shouldGetValidFacingValuesWhenDirectionSouth() {
        Direction direction = Direction.SOUTH;
        int col = 1;
        int row = 2;
        int frontFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction);
        int leftFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction.turnLeft());
        int rightFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction.turnRight());

        assertEquals(3, frontFacingValue);
        assertEquals(2, leftFacingValue);
        assertEquals(4, rightFacingValue);
    }

    @Test
    public void shouldGetValidFacingValuesWhenDirectionNorth() {
        Direction direction = Direction.NORTH;
        int col = 1;
        int row = 2;
        int frontFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction);
        int leftFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction.turnLeft());
        int rightFacingValue = gameRenderer.getFacingMapValue(col, row, MAP, direction.turnRight());

        assertEquals(1, frontFacingValue);
        assertEquals(4, leftFacingValue);
        assertEquals(2, rightFacingValue);
    }

    @Test
    public void shouldGetValidMapValues() {
        GameState gameState = new GameState();
        gameState.setPos(2, 1);
        assertEquals(5, MAP[gameState.getRow()][gameState.getCol()]);

        gameState.setPos(2, 0);
        assertEquals(4, MAP[gameState.getRow()][gameState.getCol()]);

        gameState.setPos(2, 2);
        assertEquals(2, MAP[gameState.getRow()][gameState.getCol()]);

        gameState.setPos(3, 1);
        assertEquals(3, MAP[gameState.getRow()][gameState.getCol()]);

        gameState.setPos(1, 1);
        assertEquals(1, MAP[gameState.getRow()][gameState.getCol()]);

        gameState.setPos(0, 0);
        assertEquals(0, MAP[gameState.getRow()][gameState.getCol()]);

        gameState.setPos(0, 1);
        assertEquals(0, MAP[gameState.getRow()][gameState.getCol()]);

        gameState.setPos(0, 2);
        assertEquals(0, MAP[gameState.getRow()][gameState.getCol()]);
    }

}