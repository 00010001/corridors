package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;

import static com.sample.base.model.Stage.MAIN_GAME;

public class SavedGameService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        switch (inputCommand) {
            case RESUME:
                gameState.setStage(MAIN_GAME);
                break;
        }
    }
}
