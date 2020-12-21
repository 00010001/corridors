package com.sample.game.service.logic;

import com.sample.base.factory.HeroFactory;
import com.sample.base.model.GameState;
import com.sample.base.model.SaveData;
import com.sample.base.model.enumeration.HeroClass;
import com.sample.base.model.enumeration.InputCommand;
import com.sample.game.service.SaveGameService;

import static com.sample.base.ErrorMessages.INPUT_COMMAND_NOT_SUPPORTED;
import static com.sample.base.model.enumeration.Stage.*;

public class MenuService {

    private final SaveGameService saveGameService = new SaveGameService();
    private final LoadGameService loadGameService = new LoadGameService();
    private final NewGameService newGameService = new NewGameService();

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        switch (inputCommand) {
            case NEW_GAME:
                gameState.setHero(HeroFactory.getByClass(HeroClass.findByIndex(0)));
                newGameService.newGame(gameState, CHARACTER_CREATION);
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
