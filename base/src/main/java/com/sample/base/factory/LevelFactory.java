package com.sample.base.factory;

import com.sample.base.model.MapData;
import com.sample.base.model.Level;

public class LevelFactory {

    public static Level getByNumber(int levelNumber) {

        switch (levelNumber) {
            case -1:
                return new Level()
                        .id(-1)
                        .startingRow(2)
                        .startingCol(2)
                        .map(MapData.TEST_MAP);
            case 0:
                return new Level()
                        .id(0)
                        .startingRow(5)
                        .startingCol(1)
                        .map(MapData.MAP_0);
            default:
                throw new IllegalArgumentException("level number not present");
        }

    }

}
