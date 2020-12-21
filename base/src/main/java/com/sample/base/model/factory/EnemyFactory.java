package com.sample.base.model.factory;

import com.sample.base.model.enemy.Enemy;
import com.sample.base.model.enemy.EnemyClass;

import java.math.BigDecimal;

public class EnemyFactory {

    public static Enemy getByEnemyClass(EnemyClass enemyClass){
        switch (enemyClass){
            case SKELETON:
                return new Enemy()
                        .enemyClass(EnemyClass.SKELETON)
                        .hp(BigDecimal.valueOf(20))
                        .attack(15)
                        .defence(10)
                        .level(1)
                        .experienceValue(10);
            default:
                throw new IllegalArgumentException("player class not present");
        }
    }
}
