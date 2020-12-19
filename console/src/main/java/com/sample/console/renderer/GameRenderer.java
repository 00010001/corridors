package com.sample.console.renderer;

import com.sample.base.model.GameState;
import com.sample.base.model.Direction;
import com.sample.base.model.hero.Hero;
import com.sample.base.model.level.Level;
import com.sample.console.renderer.service.FileService;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class GameRenderer {

    private final FileService fileService = new FileService();

    public void render(GameState gameState) {
        Level level = gameState.getLevel();
        Direction direction = gameState.getPlayerDirection();
        Hero hero = gameState.getHero();

        int facingXCord = gameState.getxPos() - direction.getxDiff();
        int facingYCord = gameState.getyPos() - direction.getyDiff();
        int facingCord = level.getMap()[facingXCord][facingYCord];

        if (facingCord == 1) {
            FileService.printInputStream(fileService.getFileFromResourceAsStream(BASE_GAME_0));
        } else if (facingCord == 0) {
            FileService.printInputStream(fileService.getFileFromResourceAsStream(BASE_GAME_1));
        }
        renderHud(hero);
    }

    private void renderHud(Hero hero) {

        System.out.print(hero.getArray()[0] + HUD_STAT_BREAK_LINE + HUD_LOG_BREAK_LINE + "\n");
        System.out.print(hero.getArray()[1] + HUD_STAT_EMPTY + HUD_LOG_EMPTY + "\n");
        System.out.print(hero.getArray()[2] + HUD_STAT_HP + HUD_LOG_EMPTY + "\n");
        System.out.print(hero.getArray()[3] + HUD_STAT_XP + HUD_LOG_EMPTY + "\n");
        System.out.print(hero.getArray()[4] + HUD_STAT_EMPTY + HUD_LOG_EMPTY + "\n");
        System.out.print(hero.getArray()[5] + HUD_STAT_MENU + HUD_LOG_EMPTY + "\n");
        System.out.print(hero.getArray()[6] + HUD_STAT_EMPTY + HUD_LOG_EMPTY + "\n");
        System.out.print(hero.getArray()[7] + HUD_STAT_BREAK_LINE + HUD_LOG_BREAK_LINE + "\n");

    }
}
