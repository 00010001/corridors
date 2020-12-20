package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.factory.HeroFactory;
import com.sample.base.model.hero.HeroClass;

import static com.sample.base.model.Stage.MAIN_GAME;

public class CharacterCreationService {

    private final HeroFactory heroFactory = new HeroFactory();

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
                gameState.setHero(heroFactory.getByClass(HeroClass.findByIndex(nextIndex)));
                break;
            case CHARACTER_SELECT:
                gameState.setStage(MAIN_GAME);
                gameState.setPlayerStartedGame(true);
                break;
        }
    }
}
