package com.sample.game.service;

import com.sample.base.model.*;
import com.sample.base.model.factory.HeroFactory;
import com.sample.base.model.factory.LevelFactory;
import com.sample.base.model.level.Level;

import static com.sample.base.model.Stage.*;
import static com.sample.game.AppParameters.FIRST_LEVEL_NUMBER;

public class GameLogicService {

    private final SaveGameService saveGameService = new SaveGameService();
    private final LoadGameService loadGameService = new LoadGameService();
    private final LevelFactory levelFactory = new LevelFactory();
    private final HeroFactory heroFactory = new HeroFactory();

    public void processLogic(InputCommand inputCommand, GameState gameState, GameParameters gameParameters) {

        switch (inputCommand) {
            case NEW_GAME:
                gameState.setStage(CHARACTER_CREATION);
                gameState.setDirection(Direction.NORTH);
                gameState.setLevel(gameParameters.getLevel());
                gameState.setHero(heroFactory.getById(0));
                Level level = levelFactory.getByNumber(FIRST_LEVEL_NUMBER);
                gameParameters.setLevel(level);
                gameState.setCol(level.getStartingCol());
                gameState.setRow(level.getStartingRow());
                break;
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
                SaveData saveData = loadGameService.loadSaveData();
                loadGameService.overwriteGameState(saveData, gameState);
                gameParameters.setPlayerStartedGame(true);
                gameState.setStage(GAME);
                break;
            case TURN_LEFT:
                gameState.setDirection(gameState.getDirection().turnLeft());
                break;
            case MOVE_AHEAD:
                gameState.setCol(gameState.getCol() + gameState.getDirection().getColOffset());
                gameState.setRow(gameState.getRow() + gameState.getDirection().getRowOffset());
                break;
            case TURN_RIGHT:
                gameState.setDirection(gameState.getDirection().turnRight());
                break;
        }

    }

}
