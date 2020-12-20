package com.sample.console.renderer;

import com.sample.base.model.GameState;
import com.sample.console.renderer.service.FileService;
import com.sample.console.renderer.service.StringService;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class FightSummaryRenderer {

    public static final String FIGHT_SUMMARY = "Enemy Died you gained ";

    private final FileService fileService = new FileService();
    private final StringService stringService = new StringService();

    public void render(GameState gameState) {
        int gainedXp = 10;
        FileService.printInputStream(fileService.getFileFromResourceAsStream(FIGHT_SUMMARY_TOP));
        System.out.println(stringService.formatStringForConsole(FIGHT_SUMMARY + gainedXp + "xp"));
        FileService.printInputStream(fileService.getFileFromResourceAsStream(FIGHT_SUMMARY_BOT));
    }

}
