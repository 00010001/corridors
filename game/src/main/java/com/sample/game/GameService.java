package com.sample.game;

import com.sample.base.model.InputCommand;
import com.sample.base.model.Player;
import com.sample.base.model.Stage;
import com.sample.base.service.InputProcessor;
import com.sample.base.service.Renderer;
import com.sample.console.input.service.ConsoleInputProcessor;
import com.sample.console.renderer.ConsoleRenderer;

public class GameService {

    private Stage currentStage;

    private final Renderer renderer = new ConsoleRenderer();
    private final InputProcessor inputProcessor = new ConsoleInputProcessor();

    public void start() {
        currentStage = Stage.MENU;
        gameLoop();
    }


    public void gameLoop() {
        InputCommand inputCommand = null;
        while (inputCommand != InputCommand.EXIT) {
            renderer.render(currentStage);
            inputCommand = inputProcessor.getInputCommand();
        }


        Player player = new Player();
        int x = 0;
        int y = 0;


    }

    private void printHud() {

    }


}
