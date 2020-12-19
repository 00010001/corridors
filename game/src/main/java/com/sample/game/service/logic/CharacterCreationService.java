package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.factory.HeroFactory;

import static com.sample.base.model.Stage.MAIN_GAME;

public class CharacterCreationService {

    private final HeroFactory heroFactory = new HeroFactory();

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        switch (inputCommand) {
            case CHARACTER_NEXT:
                int nextId;
                int currentHeroId = gameState.getHero().getId();
                if (currentHeroId == 4) {
                    nextId = 0;
                } else {
                    nextId = currentHeroId + 1;
                }
                gameState.setHero(heroFactory.getById(nextId));
                break;
            case CHARACTER_SELECT:
                gameState.setStage(MAIN_GAME);
                gameState.setPlayerStartedGame(true);
                break;
        }
    }
}
