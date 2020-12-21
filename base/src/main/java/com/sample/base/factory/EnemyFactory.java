package com.sample.base.factory;

import com.sample.base.model.Enemy;
import com.sample.base.model.enumeration.EnemyClass;

import java.math.BigDecimal;

public class EnemyFactory {

    public static Enemy getByEnemyClass(EnemyClass enemyClass) {

        switch (enemyClass) {
            case SKELETON:
                return new Enemy()
                        .enemyClass(EnemyClass.SKELETON)
                        .hp(BigDecimal.valueOf(20))
                        .attack(35)
                        .defence(15)
                        .level(1)
                        .experienceValue(10);
            default:
                throw new IllegalArgumentException("player class not present");
        }
    }
}
