package com.sample.base.model.factory;

import com.sample.base.model.enemy.Enemy;
import com.sample.base.model.enemy.EnemyClass;

public class EnemyFactory {

    public Enemy getByEnemyClass(EnemyClass enemyClass){
        switch (enemyClass){
            case SKELETON:
                return new Enemy()
                        .enemyClass(EnemyClass.SKELETON)
                        .hp(100)
                        .damage(10)
                        .experienceValue(10);
            default:
                throw new IllegalArgumentException();
        }
    }
}
