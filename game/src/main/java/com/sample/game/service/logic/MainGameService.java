package com.sample.game.service.logic;

import com.sample.base.model.Direction;
import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.enemy.EnemyClass;
import com.sample.base.model.factory.EnemyFactory;
import com.sample.base.service.MapService;
import com.sample.game.AppMessages;

import static com.sample.base.model.Stage.*;
import static com.sample.game.AppMessages.*;

public class MainGameService {

    EnemyFactory enemyFactory = new EnemyFactory();

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
        }

    }

    void changeStateIfNeeded(GameState gameState) {
        int nextMapValue = MapService.getNextMapValue(gameState);
        if (nextMapValue == 3) {
            gameState.setStage(ITEM);
        } else if (nextMapValue == 2) {
            gameState.setLastEnemy(enemyFactory.getByEnemyClass(EnemyClass.SKELETON));
            gameState.setStage(FIGHT);
        }
    }

}
