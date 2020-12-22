package com.sample.console.renderer;

import com.sample.base.model.GameState;
import com.sample.base.model.enumeration.Direction;
import com.sample.base.service.MapService;
import com.sample.console.renderer.service.FileService;
import com.sample.console.renderer.service.PrintService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sample.base.ErrorMessages.FILEPATH_IS_NULL;
import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class GameRenderer {

    private final FileService fileService = new FileService();
    private final PrintService printService = new PrintService();
    private final HudRenderer hudRenderer = new HudRenderer();

    private static final List<Integer> NON_WALL_VALUES = Arrays.asList(1, 2, 3);
    private static final List<String> SKELETON_FILEPATH_LIST = Arrays.asList(SKELETON, SKELETON_2, SKELETON_3);

    private static final Map<String, String> FACING_VALUE_FILE_PATH_MAP = Stream.of(new String[][]{
            {"100", FRONT},
            {"110", FRONT_LEFT},
            {"101", FRONT_RIGHT},
            {"010", LEFT},
            {"001", RIGHT},
            {"011", LEFT_RIGHT},
            {"111", FRONT_LEFT_RIGHT},
            {"000", WALL}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public void render(GameState gameState) {
        Direction direction = gameState.getDirection();

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

        String filePathToPrint = getFilePathToPrint(facingValue, leftFacingValue, rightFacingValue, gameState);
        if(filePathToPrint == null){
            throw new NullPointerException(FILEPATH_IS_NULL + facingValue + leftFacingValue + rightFacingValue);
        }
        printService.printInputStream(fileService
                .getFileFromResourceAsStream(filePathToPrint));
        hudRenderer.renderHud(gameState);
    }

    String getFilePathToPrint(int facingValue, int leftFacingValue, int rightFacingValue, GameState gameState) {
        switch (facingValue) {
            case 2:
                return getSkeletonFilePath(gameState);
            case 3:
                return SWORD;
            default:
                String s = isFacingValueNonWall(facingValue) +
                        isFacingValueNonWall(leftFacingValue) +
                        isFacingValueNonWall(rightFacingValue);
                return FACING_VALUE_FILE_PATH_MAP.get(s);
        }
    }

    private String getSkeletonFilePath(GameState gameState) {
        int heroLevel = gameState.getHero().getLevel();
        if(heroLevel >= 5){
            return SKELETON_FILEPATH_LIST.get(1);
        } else if(heroLevel >= 3){
            return SKELETON_FILEPATH_LIST.get(2);
        } else {
            return SKELETON_FILEPATH_LIST.get(0);
        }
    }

    private String isFacingValueNonWall(int facingValue) {
        if (NON_WALL_VALUES.contains(facingValue)) {
            return "1";
        } else {
            return "0";
        }
    }

    int getFacingMapValue(int col, int row, int[][] map, Direction direction) {
        int facingCol = col + direction.getColOffset();
        int facingRow = row + direction.getRowOffset();
        return map[facingRow][facingCol];
    }

}
