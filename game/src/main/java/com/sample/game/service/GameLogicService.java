package com.sample.game.service;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.game.service.logic.*;

public class GameLogicService {

    private final MenuService menuService = new MenuService();
    private final CharacterCreationService characterCreationService = new CharacterCreationService();
    private final MainGameService mainGameService = new MainGameService();
    private final SavedGameService savedGameService = new SavedGameService();
    private final FightService fightService = new FightService();
    private final TakeItemService takeItemService = new TakeItemService();

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

        }

    }

}
