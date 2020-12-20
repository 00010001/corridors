package com.sample.console.renderer;

import com.sample.base.model.GameState;
import com.sample.console.renderer.service.FileService;
import com.sample.console.renderer.service.PrintService;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class FightSummaryRenderer {

    private final FileService fileService = new FileService();
    private final PrintService printService = new PrintService();

    public void render(GameState gameState) {
        printService.printInputStream(fileService.getFileFromResourceAsStream(FIGHT_SUMMARY_TOP));
        printService.printFormattedLineFullWidth(gameState.getLastEnemy().getEnemyClass().name() + DIED_YOU_GAINED
                + gameState.getLastEnemy().getExperienceValue() + XP);
        printService.printInputStream(fileService.getFileFromResourceAsStream(FIGHT_SUMMARY_BOT));
    }

}
