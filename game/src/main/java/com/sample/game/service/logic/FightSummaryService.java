package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.hero.Hero;
import com.sample.base.service.MapService;

import static com.sample.base.model.Stage.MAIN_GAME;
import static com.sample.game.AppMessages.ENEMY_DEAD;

public class FightSummaryService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        if (inputCommand == InputCommand.CONTINUE) {
            MapService.setNextMapValue(gameState, 1);
            gameState.setStage(MAIN_GAME);
            gameState.getGameLog().add(ENEMY_DEAD);
            Hero hero = gameState.getHero();
            hero.setExperience(hero.getExperience() + gameState.getLastEnemy().getExperienceValue());
        }

    }

}
