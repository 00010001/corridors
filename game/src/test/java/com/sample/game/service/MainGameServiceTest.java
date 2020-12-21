package com.sample.game.service;

import com.sample.base.model.Direction;
import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.Stage;
import com.sample.base.model.factory.LevelFactory;
import org.junit.Assert;
import org.junit.Test;

public class MainGameServiceTest {

    private final GameLogicService gameLogicService = new GameLogicService();

    private GameState prepareGameState() {
        GameState gameState = new GameState();
        gameState.setStage(Stage.MAIN_GAME);
        gameState.setLevel(LevelFactory.getByNumber(-1));
        return gameState;
    }

    @Test
    public void shouldMoveNorth() {
        GameState gameState = prepareGameState();
        gameState.setPos(gameState.getLevel().getStartingRow(), gameState.getLevel().getStartingCol());
        gameState.direction(Direction.NORTH);
        gameLogicService.processLogic(InputCommand.MOVE_AHEAD, gameState);
        Assert.assertEquals(gameState.getCol(), 2);
        Assert.assertEquals(gameState.getRow(), 1);
    }

    @Test
    public void shouldMoveSouth() {
        GameState gameState = prepareGameState();
        gameState.setPos(gameState.getLevel().getStartingRow(), gameState.getLevel().getStartingCol());
        gameState.direction(Direction.SOUTH);
        gameLogicService.processLogic(InputCommand.MOVE_AHEAD, gameState);
        Assert.assertEquals(gameState.getCol(), 2);
        Assert.assertEquals(gameState.getRow(), 3);
    }

    @Test
    public void shouldMoveWest() {
        GameState gameState = prepareGameState();
        gameState.setPos(gameState.getLevel().getStartingRow(), gameState.getLevel().getStartingCol());
        gameState.direction(Direction.WEST);
        gameLogicService.processLogic(InputCommand.MOVE_AHEAD, gameState);
        Assert.assertEquals(gameState.getCol(), 1);
        Assert.assertEquals(gameState.getRow(), 2);
    }

    @Test
    public void shouldMoveEast() {
        GameState gameState = prepareGameState();
        gameState.setPos(gameState.getLevel().getStartingRow(), gameState.getLevel().getStartingCol());
        gameState.direction(Direction.EAST);
        gameLogicService.processLogic(InputCommand.MOVE_AHEAD, gameState);
        Assert.assertEquals(gameState.getCol(), 3);
        Assert.assertEquals(gameState.getRow(), 2);
    }
}