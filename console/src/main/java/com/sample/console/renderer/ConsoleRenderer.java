package com.sample.console.renderer;

import com.sample.base.model.Stage;
import com.sample.base.service.Renderer;

import java.io.InputStream;

public class ConsoleRenderer implements Renderer {

    private final MenuRenderer menuRenderer = new MenuRenderer();
    private final ConsoleService consoleService = new ConsoleService();
    private final FileService fileService = new FileService();

    @Override
    public void render(Stage currentStage) {
        String fileName = "";
        consoleService.clearScreen();
            if(currentStage == Stage.MENU){

                fileName = "txt/menu.txt";
            }

            InputStream is = fileService.getFileFromResourceAsStream(fileName);
            FileService.printInputStream(is);

    }
}
