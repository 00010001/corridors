package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;

import static com.sample.base.model.Stage.FIGHT_SUMMARY;
import static com.sample.base.model.Stage.MENU;

public class FightService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        switch (inputCommand) {
            case MENU:
                gameState.setStage(MENU);
                break;
            case ATTACK:
                gameState.setStage(FIGHT_SUMMARY);
                break;
        }

    }
}
