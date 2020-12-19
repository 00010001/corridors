package com.sample.game.service;

import com.sample.base.model.Direction;
import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.SaveData;
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

    public void processLogic(InputCommand inputCommand, GameState gameState) {
        Direction direction = gameState.getDirection();

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
                gameState.setPlayerStartedGame(true);
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
                gameState.setLoadGameAvailable(true);
                break;
            case LOAD_GAME:
                SaveData saveData = loadGameService.loadSaveData();
                loadGameService.overwriteGameState(saveData, gameState);
                gameState.setPlayerStartedGame(true);
                gameState.setStage(GAME);
                break;
            case TURN_LEFT:
                gameState.setDirection(direction.turnLeft());
                break;
            case MOVE_AHEAD:
                //TODO check if can move?
                //TODO can:
                gameState.setCol(gameState.getCol() + direction.getColOffset());
                gameState.setRow(gameState.getRow() + direction.getRowOffset());
                gameState.getGameLog().add("Moved " + direction);
                int mapValue = gameState.getLevel().getMap()[gameState.getRow()][gameState.getCol()];
                if (mapValue == 3) {
                    gameState.setStage(ITEM);
                } else if (mapValue == 2) {
                    gameState.setStage(FIGHT);
                }
                break;
            case TURN_RIGHT:
                gameState.setDirection(direction.turnRight());
                break;
        }

    }

}
