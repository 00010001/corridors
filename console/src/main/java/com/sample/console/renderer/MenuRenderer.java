package com.sample.console.renderer;

import com.sample.base.model.GameState;
import com.sample.console.renderer.service.FileService;
import com.sample.console.renderer.service.PrintService;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class MenuRenderer {

    private final FileService fileService = new FileService();
    private final PrintService printService = new PrintService();

    public void render(GameState gameState) {
        printService.printInputStream(fileService.getFileFromResourceAsStream(MENU_TOP));
        if (gameState.isPlayerStartedGame()) {
            printService.printFormattedLineFullWidth(RESUME);
        }
        printService.printFormattedLineFullWidth(NEW_GAME);
        if (gameState.isPlayerStartedGame()) {
            printService.printFormattedLineFullWidth(SAVE_GAME);
        }
        if (gameState.isLoadGameAvailable()) {
            printService.printFormattedLineFullWidth(LOAD_GAME);
        }
        printService.printFormattedLineFullWidth(EXIT);
        printService.printInputStream(fileService.getFileFromResourceAsStream(MENU_BOT));
    }
}
