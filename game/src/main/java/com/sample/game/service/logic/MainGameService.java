package com.sample.game.service.logic;

import com.sample.base.model.Enemy;
import com.sample.base.model.GameState;
import com.sample.base.model.enumeration.Direction;
import com.sample.base.model.enumeration.EnemyClass;
import com.sample.base.model.enumeration.InputCommand;
import com.sample.base.factory.EnemyFactory;
import com.sample.base.service.MapService;
import com.sample.game.AppMessages;

import static com.sample.base.ErrorMessages.ARRAY_INDEX_OUT_OF_BOUND;
import static com.sample.base.model.enumeration.Stage.*;
import static com.sample.game.AppMessages.*;
import static com.sample.base.ErrorMessages.INPUT_COMMAND_NOT_SUPPORTED;

public class MainGameService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        Direction direction = gameState.getDirection();

        switch (inputCommand) {
            case MENU:
                gameState.setStage(MENU);
                break;
            case TURN_LEFT:
                gameState.setDirection(direction.turnLeft());
                changeStateIfNeeded(gameState);
                gameState.getGameLog().add(TURNED_LEFT);
                break;
            case TURN_RIGHT:
                gameState.setDirection(direction.turnRight());
                changeStateIfNeeded(gameState);
                gameState.getGameLog().add(TURNED_RIGHT);
                break;
            case MOVE_AHEAD:
                if (MapService.getNextMapValue(gameState) == 1) {
                    gameState.setCol(gameState.getCol() + direction.getColOffset());
                    gameState.setRow(gameState.getRow() + direction.getRowOffset());
                    gameState.getGameLog().add(AppMessages.MOVED + direction);
                    changeStateIfNeeded(gameState);
                } else {
                    gameState.getGameLog().add(CANT_MOVE);
                }
                break;
            default:
                throw new IllegalArgumentException(INPUT_COMMAND_NOT_SUPPORTED);
        }

    }

    void changeStateIfNeeded(GameState gameState) {
        int nextMapValue = 0;
        try {
            nextMapValue = MapService.getNextMapValue(gameState);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException(ARRAY_INDEX_OUT_OF_BOUND + gameState.getRow() + ", col " + gameState.getCol());
        }
        if (nextMapValue == 3) {
            gameState.setStage(ITEM);
        } else if (nextMapValue == 2) {
            Enemy enemy = EnemyFactory.getByEnemyClass(EnemyClass.SKELETON);
            gameState.setLastEnemy(enemy);
            gameState.getGameLog().add(ENCOUNTERED + enemy.getEnemyClass().name());
            gameState.setStage(FIGHT);
        }
    }

}
