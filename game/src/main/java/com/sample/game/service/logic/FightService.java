package com.sample.game.service.logic;

import com.sample.base.model.Enemy;
import com.sample.base.model.GameState;
import com.sample.base.model.Hero;
import com.sample.base.model.enumeration.InputCommand;
import com.sample.base.service.MapService;

import java.math.BigDecimal;

import static com.sample.base.ErrorMessages.INPUT_COMMAND_NOT_SUPPORTED;
import static com.sample.base.model.enumeration.Stage.*;
import static com.sample.game.AppMessages.*;

public class FightService {

    DamageService damageService = new DamageService();

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        switch (inputCommand) {
            case MENU:
                gameState.setStage(MENU);
                break;
            case ATTACK:
                Hero hero = gameState.getHero();
                Enemy enemy = gameState.getLastEnemy();
                BigDecimal heroDamage = damageService.calculateDamage(hero, enemy);
                BigDecimal enemyDamage = damageService.calculateDamage(hero, enemy);
                gameState.getGameLog().add(HERO + CAUSED + heroDamage + DAMAGE);
                gameState.getGameLog().add(enemy.getEnemyClass().name() + CAUSED + enemyDamage + DAMAGE);
                hero.setHp(hero.getHp().subtract(enemyDamage));
                enemy.setHp(enemy.getHp().subtract(heroDamage));
                if (hero.getHp().compareTo(BigDecimal.ZERO) <= 0) {
                    gameState.setStage(YOU_DIED);
                } else if (enemy.getHp().compareTo(BigDecimal.ZERO) <= 0) {
                    gameState.setStage(FIGHT_SUMMARY);
                    MapService.setNextMapValue(gameState, 1);
                }
                break;
            default:
                throw new IllegalArgumentException(INPUT_COMMAND_NOT_SUPPORTED);
        }

    }
}
