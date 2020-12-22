package com.sample.console.renderer;

import com.sample.base.model.GameState;
import com.sample.base.model.Hero;
import com.sample.base.model.enumeration.Stage;
import com.sample.console.renderer.service.LogService;
import com.sample.console.renderer.service.PrintService;
import com.sample.console.renderer.service.StringService;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class HudRenderer {

    private final PrintService printService = new PrintService();
    private final StringService stringService = new StringService();
    private final LogService logService = new LogService();

    public void renderHud(GameState gameState) {
        Hero hero = gameState.getHero();
        String[] heroArray = HeroArrayProperties.getByIndex(hero.getHeroClass().getIndex());
        System.out.println(heroArray[0] + printService.generateBreakLine(HUD_WIDTH + LOG_WIDTH));
//                + " row" + gameState.getRow() + " col" + gameState.getRow() + " dir " + gameState.getDirection());
        System.out.println(heroArray[1] + stringService.formatStringForConsole(HUD_LEVEL + hero.getLevel(), HUD_WIDTH_WITHOUT_RIGHT_BORDER) + "x" + logService.getLogEntry(gameState, 0));
        System.out.println(heroArray[2] + stringService.formatStringForConsole(HUD_HP + hero.getHp(), HUD_WIDTH_WITHOUT_RIGHT_BORDER) + "x" + logService.getLogEntry(gameState, 1));
        System.out.println(heroArray[3] + stringService.formatStringForConsole(HUD_XP + hero.getExperience(), HUD_WIDTH_WITHOUT_RIGHT_BORDER) + "x" + logService.getLogEntry(gameState, 2));
        System.out.println(heroArray[4] + HUD_STAT_EMPTY + logService.getLogEntry(gameState, 3));
        if(gameState.getStage() == Stage.FIGHT){
            System.out.println(heroArray[5] + HUD_STAT_EMPTY + logService.getLogEntry(gameState, 4));
        } else {
            System.out.println(heroArray[5] + stringService.formatStringForConsole(HUD_MENU, HUD_WIDTH_WITHOUT_RIGHT_BORDER) + "x" + logService.getLogEntry(gameState, 4));
        }
        System.out.println(heroArray[6] + HUD_STAT_EMPTY + logService.getLogEntry(gameState, 5));
        System.out.println(heroArray[7] + printService.generateBreakLine(HUD_WIDTH + LOG_WIDTH));

    }

}
