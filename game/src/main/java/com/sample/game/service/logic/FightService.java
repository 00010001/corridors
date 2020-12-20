package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.service.MapService;

import static com.sample.base.model.Stage.*;
import static com.sample.game.AppMessages.ENEMY_DEAD;

public class FightService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {
        if (gameState.getStage() == FIGHT_SUMMARY) {
            if (inputCommand == InputCommand.CONTINUE) {
                MapService.setNextMapValue(gameState, 1);
                gameState.setStage(MAIN_GAME);
                gameState.getGameLog().add(ENEMY_DEAD);
            }
        } else {
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
}
