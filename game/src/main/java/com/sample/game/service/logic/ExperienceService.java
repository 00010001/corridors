package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.Hero;

import static com.sample.game.AppMessages.LEVEL_UP;
import static com.sample.game.AppParameters.BASE_XP;
import static com.sample.game.AppParameters.EXPONENT;

public class ExperienceService {

    public void process(GameState gameState) {
        increaseHeroXp(gameState);
        increaseHeroLevelIfApplicable(gameState);
    }

    private void increaseHeroLevelIfApplicable(GameState gameState) {
        Hero hero = gameState.getHero();
        int xpNeededForLevel = getXpNeededForLevel(hero.getLevel() + 1);
        int experience = hero.getExperience();
        if (experience > xpNeededForLevel) {
            hero.setLevel(hero.getLevel() + 1);
            gameState.getGameLog().add(LEVEL_UP);
        }
    }

    private void increaseHeroXp(GameState gameState) {
        Hero hero = gameState.getHero();
        hero.setExperience(hero.getExperience() + gameState.getLastEnemy().getExperienceValue());
    }

    private int getXpNeededForLevel(double nextLevel) {
        double floor = Math.floor(BASE_XP * (Math.pow(nextLevel, EXPONENT)));
        return (int) floor;
    }
}
