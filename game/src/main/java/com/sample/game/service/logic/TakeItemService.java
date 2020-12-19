package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.service.MapService;
import com.sample.game.AppMessages;

import static com.sample.base.model.Stage.MAIN_GAME;

public class TakeItemService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        if (inputCommand == InputCommand.TAKE_ITEM) {
            MapService.setNextMapValue(gameState, 1);
            gameState.getHero().setWeapon(true);
            gameState.setStage(MAIN_GAME);
            gameState.getGameLog().add(AppMessages.TAKE_ITEM);
        }
    }

}
