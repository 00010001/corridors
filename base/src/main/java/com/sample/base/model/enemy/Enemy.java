package com.sample.base.model.enemy;

import com.sample.base.model.BaseEntity;

import java.math.BigDecimal;

public class Enemy implements BaseEntity {

    private int attack;
    private int defence;
    private BigDecimal hp;
    private int level;
    private int experienceValue;
    private EnemyClass enemyClass;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public BigDecimal getHp() {
        return hp;
    }

    public void setHp(BigDecimal hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(int experienceValue) {
        this.experienceValue = experienceValue;
    }

    public EnemyClass getEnemyClass() {
        return enemyClass;
    }

    public void setEnemyClass(EnemyClass enemyClass) {
        this.enemyClass = enemyClass;
    }

    public Enemy attack(final int attack) {
        this.attack = attack;
        return this;
    }

    public Enemy defence(final int defence) {
        this.defence = defence;
        return this;
    }

    public Enemy hp(final BigDecimal hp) {
        this.hp = hp;
        return this;
    }

    public Enemy level(final int level) {
        this.level = level;
        return this;
    }

    public Enemy experienceValue(final int experienceValue) {
        this.experienceValue = experienceValue;
        return this;
    }

    public Enemy enemyClass(final EnemyClass enemyClass) {
        this.enemyClass = enemyClass;
        return this;
    }


}
