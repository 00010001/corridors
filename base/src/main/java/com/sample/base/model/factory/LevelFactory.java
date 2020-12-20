package com.sample.base.model.factory;

import com.sample.base.model.level.Level;
import com.sample.base.model.level.Level0;

public class LevelFactory {

    public Level getByNumber(int levelNumber) {

        switch (levelNumber) {
            case 0:
                return new Level0();
            default:
                throw new IllegalArgumentException();
        }

    }

}
