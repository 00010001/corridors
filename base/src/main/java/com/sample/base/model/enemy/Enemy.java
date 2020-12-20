package com.sample.base.model.enemy;

public class Enemy {

    private EnemyClass enemyClass;
    private int hp;
    private int damage;

    public EnemyClass getEnemyClass() {
        return enemyClass;
    }

    public void setEnemyClass(EnemyClass enemyClass) {
        this.enemyClass = enemyClass;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Enemy enemyClass(final EnemyClass enemyClass) {
        this.enemyClass = enemyClass;
        return this;
    }

    public Enemy hp(final int hp) {
        this.hp = hp;
        return this;
    }

    public Enemy damage(final int damage) {
        this.damage = damage;
        return this;
    }


}
