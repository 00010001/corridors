package com.sample.base.model.hero;

import com.sample.base.model.BaseEntity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Hero implements Serializable, BaseEntity {

    private int attack;
    private int defence;
    private BigDecimal hp;
    private int level;
    private int experience;
    private HeroClass heroClass;

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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
    }

    public Hero attack(final int attack) {
        this.attack = attack;
        return this;
    }

    public Hero defence(final int defence) {
        this.defence = defence;
        return this;
    }

    public Hero hp(final BigDecimal hp) {
        this.hp = hp;
        return this;
    }

    public Hero level(final int level) {
        this.level = level;
        return this;
    }

    public Hero experience(final int experience) {
        this.experience = experience;
        return this;
    }

    public Hero heroClass(final HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }


}
