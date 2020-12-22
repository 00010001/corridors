package com.sample.base.factory;

import com.sample.base.model.Enemy;
import com.sample.base.model.enumeration.EnemyClass;

import java.math.BigDecimal;

import static com.sample.base.ErrorMessages.ENEMY_CLASS_NOT_PRESENT;

public class EnemyFactory {

    public static Enemy getByEnemyClass(EnemyClass enemyClass) {

        switch (enemyClass) {
            case SKELETON:
                return new Enemy()
                        .enemyClass(EnemyClass.SKELETON)
                        .hp(BigDecimal.valueOf(20))
                        .attack(30)
                        .defence(10)
                        .level(1)
                        .experienceValue(15);
            default:
                throw new IllegalArgumentException(ENEMY_CLASS_NOT_PRESENT);
        }
    }
}
