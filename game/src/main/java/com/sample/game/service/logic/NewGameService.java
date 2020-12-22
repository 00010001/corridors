package com.sample.game.service.logic;

import com.sample.base.factory.HeroFactory;
import com.sample.base.factory.LevelFactory;
import com.sample.base.model.GameState;
import com.sample.base.model.Level;
import com.sample.base.model.enumeration.Direction;
import com.sample.base.model.enumeration.Stage;

import static com.sample.game.AppParameters.FIRST_LEVEL_NUMBER;

public class NewGameService {

    public void newGame(GameState gameState, Stage stage) {
        Level level = LevelFactory.getByNumber(FIRST_LEVEL_NUMBER);
        gameState.setDirection(Direction.NORTH);
        gameState.setLevel(level);
        gameState.setCol(level.getStartingCol());
        gameState.setRow(level.getStartingRow());
        gameState.getGameLog().clear();
        gameState.getHero().setHp(HeroFactory.getByClass(gameState.getHero().getHeroClass()).getHp());
        gameState.setStage(stage);
    }
}
