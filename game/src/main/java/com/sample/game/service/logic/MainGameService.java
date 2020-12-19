package com.sample.game.service.logic;

import com.sample.base.model.Direction;
import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.service.MapService;
import com.sample.game.AppMessages;

import static com.sample.base.model.Stage.*;
import static com.sample.game.AppMessages.CANT_MOVE;

public class MainGameService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        Direction direction = gameState.getDirection();

        switch (inputCommand) {
            case MENU:
                gameState.setStage(MENU);
                break;
            case TURN_LEFT:
                gameState.setDirection(direction.turnLeft());
                break;
            case MOVE_AHEAD:
                if (MapService.getNextMapValue(gameState) == 1) {
                    gameState.setCol(gameState.getCol() + direction.getColOffset());
                    gameState.setRow(gameState.getRow() + direction.getRowOffset());
                    gameState.getGameLog().add(AppMessages.MOVED + direction);
                    int nextMapValue = MapService.getNextMapValue(gameState);
                    if (nextMapValue == 3) {
                        gameState.setStage(ITEM);
                    } else if (nextMapValue == 2) {
                        gameState.setStage(FIGHT);
                    }
                } else {
                    gameState.getGameLog().add(CANT_MOVE);
                }
                break;
            case TURN_RIGHT:
                gameState.setDirection(direction.turnRight());
                break;
        }

    }

}
