package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.enumeration.InputCommand;

import static com.sample.base.model.enumeration.Stage.MAIN_GAME;
import static com.sample.base.ErrorMessages.INPUT_COMMAND_NOT_SUPPORTED;

public class SavedGameService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        if (inputCommand == InputCommand.RESUME) {
            gameState.setStage(MAIN_GAME);
        } else {
            throw new IllegalArgumentException(INPUT_COMMAND_NOT_SUPPORTED);
        }
    }
}
