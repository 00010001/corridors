package com.sample.console.renderer;

import com.sample.base.model.GameState;
import com.sample.console.renderer.service.FileService;
import com.sample.console.renderer.service.PrintService;

import static com.sample.console.renderer.ConsoleRendererProperties.FIGHT_SUMMARY_BOT;
import static com.sample.console.renderer.ConsoleRendererProperties.FIGHT_SUMMARY_TOP;

public class FightSummaryRenderer {

    public static final String FIGHT_SUMMARY = "Enemy Died you gained ";

    private final FileService fileService = new FileService();
    private final PrintService printService = new PrintService();

    public void render(GameState gameState) {
        int gainedXp = 10;
        printService.printInputStream(fileService.getFileFromResourceAsStream(FIGHT_SUMMARY_TOP));
        printService.printFormattedLine(FIGHT_SUMMARY + gainedXp + gameState.getLastEnemy().getHp());
        printService.printInputStream(fileService.getFileFromResourceAsStream(FIGHT_SUMMARY_BOT));
    }

}
