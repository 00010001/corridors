package com.sample.base.model.factory;

import com.sample.base.model.level.Level;
import com.sample.base.model.level.Level1;

public class LevelFactory {

    public Level getByNumber(int levelNumber) {

        switch (levelNumber) {
            case 1:
                return new Level1();
            default:
                return null;
        }

    }

}
