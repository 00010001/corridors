package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.enumeration.InputCommand;
import com.sample.base.service.MapService;
import com.sample.game.AppMessages;

import static com.sample.base.model.enumeration.Stage.MAIN_GAME;
import static com.sample.base.ErrorMessages.INPUT_COMMAND_NOT_SUPPORTED;
import static com.sample.base.model.enumeration.Stage.MENU;

public class TakeItemService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        if (inputCommand == InputCommand.TAKE_ITEM || inputCommand == InputCommand.MENU) {
            gameState.setStage(MENU);
            gameState.setPlayerStartedGame(false);
        } else {
            throw new IllegalArgumentException(INPUT_COMMAND_NOT_SUPPORTED);
        }
    }

}
