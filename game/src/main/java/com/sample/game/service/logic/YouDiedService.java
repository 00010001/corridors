package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.enumeration.InputCommand;
import com.sample.base.model.enumeration.Stage;

import static com.sample.base.ErrorMessages.INPUT_COMMAND_NOT_SUPPORTED;

public class YouDiedService {

    private final NewGameService newGameService = new NewGameService();

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        if (inputCommand == InputCommand.CONTINUE) {
            newGameService.newGame(gameState, Stage.MAIN_GAME);
        } else {
            throw new IllegalArgumentException(INPUT_COMMAND_NOT_SUPPORTED);
        }

    }

}
