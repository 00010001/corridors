package com.sample.game.service.logic;

import com.sample.base.model.Direction;
import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.SaveData;
import com.sample.base.model.factory.HeroFactory;
import com.sample.base.model.factory.LevelFactory;
import com.sample.base.model.level.Level;
import com.sample.game.service.LoadGameService;
import com.sample.game.service.SaveGameService;

import static com.sample.base.model.Stage.*;
import static com.sample.game.AppParameters.FIRST_LEVEL_NUMBER;

public class MenuService {

    private final SaveGameService saveGameService = new SaveGameService();
    private final LoadGameService loadGameService = new LoadGameService();
    private final LevelFactory levelFactory = new LevelFactory();
    private final HeroFactory heroFactory = new HeroFactory();

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        switch (inputCommand) {
            case NEW_GAME:
                gameState.setStage(CHARACTER_CREATION);
                gameState.setDirection(Direction.NORTH);
                gameState.setHero(heroFactory.getById(0));
                Level level = levelFactory.getByNumber(FIRST_LEVEL_NUMBER);
                gameState.setLevel(level);
                gameState.setCol(level.getStartingCol());
                gameState.setRow(level.getStartingRow());
                break;
            case RESUME:
                gameState.setStage(MAIN_GAME);
                break;
            case SAVE_GAME:
                saveGameService.saveGame(gameState);
                gameState.setStage(GAME_SAVED);
                gameState.setLoadGameAvailable(true);
                break;
            case LOAD_GAME:
                SaveData saveData = loadGameService.loadSaveData();
                loadGameService.overwriteGameState(saveData, gameState);
                gameState.getGameLog().clear();
                gameState.setPlayerStartedGame(true);
                gameState.setStage(MAIN_GAME);
                break;
        }
    }

}
