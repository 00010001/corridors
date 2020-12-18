package com.sample.console.renderer;

import com.sample.base.model.GameParameters;
import com.sample.console.renderer.service.FileService;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class MenuRenderer {

    private final FileService fileService = new FileService();

    public void render(GameParameters gameParameters) {
        FileService.printInputStream(fileService.getFileFromResourceAsStream(MENU_TOP_FILEPATH));
        if (gameParameters.isPlayerStartedGame()) {
            System.out.println(RESUME);
        }
        System.out.println(NEW_GAME);
        if (gameParameters.isPlayerStartedGame()) {
            System.out.println(SAVE_GAME);
        }
        if (gameParameters.isLoadGameAvailable()) {
            System.out.println(LOAD_GAME);
        }
        System.out.println(EXIT);
        FileService.printInputStream(fileService.getFileFromResourceAsStream(MENU_BOT_FILEPATH));
    }
}
