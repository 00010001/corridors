package com.sample.game.service.logic;

import com.sample.base.model.GameState;
import com.sample.base.model.SaveData;
import com.sample.base.model.Level;
import com.sample.base.model.enumeration.Direction;
import com.sample.base.model.enumeration.HeroClass;
import com.sample.base.model.enumeration.InputCommand;
import com.sample.base.factory.HeroFactory;
import com.sample.base.factory.LevelFactory;
import com.sample.game.service.SaveGameService;

import static com.sample.base.model.enumeration.Stage.*;
import static com.sample.game.AppParameters.FIRST_LEVEL_NUMBER;
import static com.sample.base.ErrorMessages.INPUT_COMMAND_NOT_SUPPORTED;

public class MenuService {

    private final SaveGameService saveGameService = new SaveGameService();
    private final LoadGameService loadGameService = new LoadGameService();

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        switch (inputCommand) {
            case NEW_GAME:
                gameState.setStage(CHARACTER_CREATION);
                gameState.setDirection(Direction.NORTH);
                gameState.setHero(HeroFactory.getByClass(HeroClass.findByIndex(0)));
                Level level = LevelFactory.getByNumber(FIRST_LEVEL_NUMBER);
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
                SaveData saveData = loadGameService.loadSaveData(false);
                loadGameService.overwriteGameState(saveData, gameState);
                gameState.getGameLog().clear();
                gameState.setPlayerStartedGame(true);
                gameState.setStage(MAIN_GAME);
                break;
            case EXIT:
                break;
            default:
                throw new IllegalArgumentException(INPUT_COMMAND_NOT_SUPPORTED);
        }
    }

}
