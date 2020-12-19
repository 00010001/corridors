package com.sample.game.service;

import com.sample.base.model.Direction;
import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogicServiceTest {

    private final GameLogicService gameLogicService = new GameLogicService();

    @Test
    public void shouldMoveNorth() {
        GameState gameState = new GameState();
        gameState.setPos(1, 1);
        gameState.direction(Direction.NORTH);
        gameLogicService.processLogic(InputCommand.MOVE_AHEAD, gameState, null);
        Assert.assertEquals(gameState.getCol(), 1);
        Assert.assertEquals(gameState.getRow(), 0);
    }

    @Test
    public void shouldMoveSouth() {
        GameState gameState = new GameState();
        gameState.setPos(1, 1);
        gameState.direction(Direction.SOUTH);
        gameLogicService.processLogic(InputCommand.MOVE_AHEAD, gameState, null);
        Assert.assertEquals(gameState.getCol(), 1);
        Assert.assertEquals(gameState.getRow(), 2);
    }

    @Test
    public void shouldMoveWest() {
        GameState gameState = new GameState();
        gameState.setPos(1, 1);
        gameState.direction(Direction.WEST);
        gameLogicService.processLogic(InputCommand.MOVE_AHEAD, gameState, null);
        Assert.assertEquals(gameState.getCol(), 0);
        Assert.assertEquals(gameState.getRow(), 1);
    }

    @Test
    public void shouldMoveEast() {
        GameState gameState = new GameState();
        gameState.setPos(1, 1);
        gameState.direction(Direction.EAST);
        gameLogicService.processLogic(InputCommand.MOVE_AHEAD, gameState, null);
        Assert.assertEquals(gameState.getCol(), 2);
        Assert.assertEquals(gameState.getRow(), 1);
    }
}