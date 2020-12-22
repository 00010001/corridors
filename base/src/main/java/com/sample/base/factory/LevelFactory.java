package com.sample.base.factory;

import com.sample.base.model.Level;
import com.sample.base.model.MapData;

import java.util.Arrays;

import static com.sample.base.ErrorMessages.LEVEL_NUMBER_NOT_PRESENT;

public class LevelFactory {

    public static Level getByNumber(int levelNumber) {

        switch (levelNumber) {
            case -1:
                return new Level()
                        .id(-1)
                        .startingRow(2)
                        .startingCol(2)
                        .map(cloneMapMatrix(MapData.TEST_MAP));
            case 0:
                return new Level()
                        .id(0)
                        .startingRow(5)
                        .startingCol(2)
                        .map(cloneMapMatrix(MapData.MAP_0));
            default:
                throw new IllegalArgumentException(LEVEL_NUMBER_NOT_PRESENT);
        }

    }

    private static int[][] cloneMapMatrix(int[][] matrix) {
        return Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
    }

}
