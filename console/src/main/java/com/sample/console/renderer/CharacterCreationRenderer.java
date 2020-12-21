package com.sample.console.renderer;

import com.sample.base.model.Hero;
import com.sample.console.renderer.service.PrintService;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class CharacterCreationRenderer {

    private final PrintService printService = new PrintService();

    public void render(Hero hero) {
        printService.printBreakLine(CONSOLE_MAX_WIDTH, true);
        printService.printEmptyLine(7);
        printService.printHeroFullWidth(hero);
        printService.printEmptyLine(3);
        printService.printFormattedLineFullWidth(NEXT);
        printService.printFormattedLineFullWidth(SELECT);
        printService.printEmptyLine(8);
        printService.printBreakLine(CONSOLE_MAX_WIDTH, true);
    }

}
