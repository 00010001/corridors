package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.enumeration.HeroClass;
import com.sample.base.model.enumeration.InputCommand;
import com.sample.base.factory.HeroFactory;

import static com.sample.base.model.enumeration.Stage.MAIN_GAME;
import static com.sample.base.ErrorMessages.INPUT_COMMAND_NOT_SUPPORTED;

public class CharacterCreationService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        switch (inputCommand) {
            case CHARACTER_NEXT:
                int nextIndex;
                int currentHeroId = gameState.getHero().getHeroClass().getIndex();
                if (currentHeroId == 4) {
                    nextIndex = 0;
                } else {
                    nextIndex = currentHeroId + 1;
                }
                gameState.setHero(HeroFactory.getByClass(HeroClass.findByIndex(nextIndex)));
                break;
            case CHARACTER_SELECT:
                gameState.setStage(MAIN_GAME);
                gameState.setPlayerStartedGame(true);
                break;
            default:
                throw new IllegalArgumentException(INPUT_COMMAND_NOT_SUPPORTED);
        }
    }
}
