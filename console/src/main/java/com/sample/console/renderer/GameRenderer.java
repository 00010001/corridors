package com.sample.console.renderer;

import com.sample.base.model.GameState;
import com.sample.base.model.Hero;
import com.sample.base.model.enumeration.Direction;
import com.sample.base.service.MapService;
import com.sample.console.renderer.service.FileService;
import com.sample.console.renderer.service.PrintService;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class GameRenderer {

    private final FileService fileService = new FileService();
    private final PrintService printService = new PrintService();

    public void render(GameState gameState) {
        Direction direction = gameState.getDirection();
        Hero hero = gameState.getHero();

        int facingValue = MapService.getNextMapValue(gameState);

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


        printService.printInputStream(fileService.getFileFromResourceAsStream(getFilePathToPrint(facingValue, leftFacingValue, rightFacingValue)));
        printService.printHud(hero, gameState);
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
        } else if (facingValue == 1 && leftFacingValue == 0 && (rightFacingValue == 1 || rightFacingValue == 2)) {
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

}
