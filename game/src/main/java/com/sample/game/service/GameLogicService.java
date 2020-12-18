package com.sample.game.service;

import com.sample.base.model.GameParameters;
import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.PlayerDirection;
import com.sample.base.model.factory.LevelFactory;
import com.sample.base.model.level.Level;

import static com.sample.base.model.Stage.*;

public class GameLogicService {

    private final SaveGameService saveGameService = new SaveGameService();
    private final LevelFactory levelFactory = new LevelFactory();


    public void processLogic(InputCommand inputCommand, GameState gameState, GameParameters gameParameters) {

        switch (inputCommand) {
            case NEW_GAME:
                gameState.setStage(CHARACTER_CREATION);
                gameState.setPlayerDirection(PlayerDirection.NORTH);
                gameState.setLevelId(gameParameters.getLevel().getNumber());
                gameState.setHeroId(0);
                Level level = levelFactory.getByNumber(1);
                gameParameters.setLevel(level);
                gameState.setxPos(level.getxStartingPos());
                gameState.setyPos(level.getyStartingPos());
                break;
            case CHARACTER_NEXT:
                int nextId;
                int currentHeroId = gameState.getHeroId();
                if (currentHeroId == 4) {
                    nextId = 0;
                } else {
                    nextId = currentHeroId + 1;
                }
                gameState.setHeroId(nextId);
                break;
            case CHARACTER_SELECT:
                gameState.setStage(GAME);

                gameParameters.setPlayerStartedGame(true);
                break;
            case MENU:
                gameState.setStage(MENU);
                break;
            case RESUME:
                gameState.setStage(GAME);
                break;
            case SAVE_GAME:
                saveGameService.saveGame(gameState);
                gameState.setStage(GAME_SAVED);
                gameParameters.setLoadGameAvailable(true);
                break;
            case LOAD_GAME:
                //TODO
                break;
        }

    }

}
