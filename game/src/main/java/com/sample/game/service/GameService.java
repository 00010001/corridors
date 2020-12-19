package com.sample.game.service;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.Stage;
import com.sample.base.model.level.Level0;
import com.sample.base.service.InputProcessor;
import com.sample.base.service.Renderer;
import com.sample.console.input.service.ConsoleInputProcessor;
import com.sample.console.renderer.ConsoleRenderer;

public class GameService {

    private final Renderer renderer = new ConsoleRenderer();
    private final InputProcessor inputProcessor = new ConsoleInputProcessor();
    private final SaveGameService saveGameService = new SaveGameService();
    private final LoadGameService loadGameService = new LoadGameService();
    private final GameLogicService gameLogicService = new GameLogicService();

    private final GameState gameState = new GameState();

    public void start() {
        gameState.setStage(Stage.MENU);
        saveGameService.createSaveFileIfNotExists();
        boolean loadGameAvailable = !saveGameService.isSaveFileWasCreated();
        if (loadGameAvailable) {
            loadGameAvailable = loadGameService.isSaveFileValid();
        }
        gameState.setLoadGameAvailable(loadGameAvailable);
        gameState.setLevel(new Level0());
        gameLoop();
    }

    public void gameLoop() {

        InputCommand inputCommand = null;
        while (inputCommand != InputCommand.EXIT) {
            renderer.render(gameState);
            inputCommand = inputProcessor.getInputCommand(gameState, false);
            gameLogicService.processLogic(inputCommand, gameState);
        }

    }
}
