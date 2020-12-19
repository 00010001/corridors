package com.sample.console.renderer;

import com.sample.base.model.Direction;
import com.sample.base.model.GameState;
import com.sample.base.model.hero.Hero;
import com.sample.console.renderer.service.FileService;

import java.util.List;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class GameRenderer {

    private final FileService fileService = new FileService();

    public void render(GameState gameState) {
        Direction direction = gameState.getDirection();
        Hero hero = gameState.getHero();

        int facingValue = getFacingMapValue(
                gameState.getCol(),
                gameState.getRow(),
                gameState.getLevel().getMap(),
                direction);

        int leftFacingValue = getFacingMapValue(
                gameState.getCol(),
                gameState.getRow(),
                gameState.getLevel().getMap(),
                direction.turnLeft());

        int rightFacingValue = getFacingMapValue(
                gameState.getCol(),
                gameState.getRow(),
                gameState.getLevel().getMap(),
                direction.turnRight());


        FileService.printInputStream(fileService.getFileFromResourceAsStream(getFilePathToPrint(facingValue, leftFacingValue, rightFacingValue)));

        renderHud(hero, gameState);
    }

    String getFilePathToPrint(int facingValue, int leftFacingValue, int rightFacingValue) {
        if (facingValue == 2) {
            return SKELETON;
        } else if (facingValue == 3) {
            return SWORD;
        } else if (facingValue == 1 && leftFacingValue == 0 && rightFacingValue == 0) {
            return FRONT;
        } else if (facingValue == 1 && leftFacingValue == 1 && rightFacingValue == 0) {
            return FRONT_LEFT;
        } else if (facingValue == 1 && leftFacingValue == 0 && rightFacingValue == 1) {
            return FRONT_RIGHT;
        } else if (facingValue == 0 && leftFacingValue == 1 && rightFacingValue == 0) {
            return LEFT;
        } else if (facingValue == 0 && leftFacingValue == 0 && rightFacingValue == 1) {
            return RIGHT;
        } else if (facingValue == 0 && leftFacingValue == 1 && rightFacingValue == 1) {
            return LEFT_RIGHT;
        }
        return WALL;
    }

    int getFacingMapValue(int col, int row, int[][] map, Direction direction) {
        int facingCol = col + direction.getColOffset();
        int facingRow = row + direction.getRowOffset();
        return map[facingRow][facingCol];
    }

    private void renderHud(Hero hero, GameState gameState) {

        System.out.print(hero.getArray()[0] + HUD_STAT_BREAK_LINE + HUD_LOG_BREAK_LINE + "\n");
        System.out.print(hero.getArray()[1] + HUD_STAT_EMPTY + " Pos[" + gameState.getCol() + "," + gameState.getRow() + "] facing " + gameState.getDirection() + "\n");
        System.out.print(hero.getArray()[2] + HUD_STAT_HP + getLogEntry(gameState, 0) + "\n");
        System.out.print(hero.getArray()[3] + HUD_STAT_XP + getLogEntry(gameState, 1) + "\n");
        System.out.print(hero.getArray()[4] + HUD_STAT_EMPTY + getLogEntry(gameState, 2) + "\n");
        System.out.print(hero.getArray()[5] + HUD_STAT_MENU + getLogEntry(gameState, 3) + "\n");
        System.out.print(hero.getArray()[6] + HUD_STAT_EMPTY + getLogEntry(gameState, 4) + "\n");
        System.out.print(hero.getArray()[7] + HUD_STAT_BREAK_LINE + HUD_LOG_BREAK_LINE + "\n");

    }

    String getLogEntry(GameState gameState, int index) {
        List<String> gameLog = gameState.getGameLog();
        if (gameLog.isEmpty()) {
            return "";
        } else if (index >= gameLog.size()) {
            return "";
        } else {
            return gameLog.get(gameLog.size() - index - 1);
        }
    }
}
