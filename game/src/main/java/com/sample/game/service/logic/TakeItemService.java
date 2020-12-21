package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.enumeration.InputCommand;
import com.sample.base.service.MapService;
import com.sample.game.AppMessages;

import static com.sample.base.model.enumeration.Stage.MAIN_GAME;
import static com.sample.base.ErrorMessages.INPUT_COMMAND_NOT_SUPPORTED;

public class TakeItemService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        if (inputCommand == InputCommand.TAKE_ITEM) {
            MapService.setNextMapValue(gameState, 1);
            gameState.setStage(MAIN_GAME);
            gameState.getGameLog().add(AppMessages.TAKE_ITEM);
        } else {
            throw new IllegalArgumentException(INPUT_COMMAND_NOT_SUPPORTED);
        }
    }

}
