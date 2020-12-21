package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.Hero;
import com.sample.base.model.enumeration.InputCommand;
import com.sample.base.service.MapService;

import static com.sample.base.model.enumeration.Stage.MAIN_GAME;
import static com.sample.game.AppMessages.ENEMY_DEAD;
import static com.sample.base.ErrorMessages.INPUT_COMMAND_NOT_SUPPORTED;

public class FightSummaryService {

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        if (inputCommand == InputCommand.CONTINUE) {
            MapService.setNextMapValue(gameState, 1);
            gameState.setStage(MAIN_GAME);
            gameState.getGameLog().add(ENEMY_DEAD);
            Hero hero = gameState.getHero();
            hero.setExperience(hero.getExperience() + gameState.getLastEnemy().getExperienceValue());
        } else {
            throw new IllegalArgumentException(INPUT_COMMAND_NOT_SUPPORTED);
        }

    }

}
