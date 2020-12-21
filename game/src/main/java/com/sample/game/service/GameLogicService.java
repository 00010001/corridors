package com.sample.game.service;

import com.sample.base.model.GameState;
import com.sample.base.model.enumeration.InputCommand;
import com.sample.game.service.logic.*;

import static com.sample.base.ErrorMessages.STAGE_NOT_SUPPORTED;

public class GameLogicService {

    private final MenuService menuService = new MenuService();
    private final CharacterCreationService characterCreationService = new CharacterCreationService();
    private final MainGameService mainGameService = new MainGameService();
    private final SavedGameService savedGameService = new SavedGameService();
    private final FightService fightService = new FightService();
    private final FightSummaryService fightSummaryService = new FightSummaryService();
    private final TakeItemService takeItemService = new TakeItemService();
    private final YouDiedService youDiedService = new YouDiedService();

    public void processLogic(InputCommand inputCommand, GameState gameState) {

        switch (gameState.getStage()) {
            case MENU:
                menuService.processLogic(inputCommand, gameState);
                break;
            case CHARACTER_CREATION:
                characterCreationService.processLogic(inputCommand, gameState);
                break;
            case MAIN_GAME:
                mainGameService.processLogic(inputCommand, gameState);
                break;
            case GAME_SAVED:
                savedGameService.processLogic(inputCommand, gameState);
                break;
            case ITEM:
                takeItemService.processLogic(inputCommand, gameState);
                break;
            case FIGHT:
                fightService.processLogic(inputCommand, gameState);
                break;
            case FIGHT_SUMMARY:
                fightSummaryService.processLogic(inputCommand, gameState);
                break;
            case YOU_DIED:
                youDiedService.processLogic(inputCommand, gameState);
                break;
            default:
                throw new IllegalArgumentException(STAGE_NOT_SUPPORTED);
        }

    }

}
