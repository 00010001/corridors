package com.sample.console.renderer;

import com.sample.base.model.hero.Hero;
import com.sample.console.renderer.service.PrintService;
import com.sample.console.renderer.service.StringService;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class CharacterCreationRenderer {

    private final PrintService printService = new PrintService();

    public void render(Hero hero) {
        printService.printBreakLine();
        printService.printEmptyLine(7);
        printService.printHeroFullWidth(hero);
        printService.printEmptyLine(3);
        printService.printFormattedLine(NEXT);
        printService.printFormattedLine(SELECT);
        printService.printEmptyLine(8);
        printService.printBreakLine();
    }

}
