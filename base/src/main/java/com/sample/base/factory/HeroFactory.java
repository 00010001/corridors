package com.sample.base.factory;

import com.sample.base.model.Hero;
import com.sample.base.model.enumeration.HeroClass;

import java.math.BigDecimal;

import static com.sample.base.BaseProperties.HERO_STARTING_HP;
import static com.sample.base.ErrorMessages.HERO_CLASS_NOT_PRESENT;

public class HeroFactory {

    public static Hero getByClass(HeroClass heroClass) {

        switch (heroClass) {
            case CAT:
                return new Hero()
                        .heroClass(HeroClass.CAT)
                        .level(1)
                        .hp(HERO_STARTING_HP)
                        .experience(0)
                        .attack(25)
                        .defence(25);
            case COW:
                return new Hero()
                        .heroClass(HeroClass.COW)
                        .level(1)
                        .hp(HERO_STARTING_HP.add(BigDecimal.valueOf(20)))
                        .experience(0)
                        .attack(15)
                        .defence(40);
            case DOG:
                return new Hero()
                        .heroClass(HeroClass.DOG)
                        .level(1)
                        .hp(HERO_STARTING_HP.add(BigDecimal.valueOf(10)))
                        .experience(0)
                        .attack(15)
                        .defence(25);
            case OTHER_CAT:
                return new Hero()
                        .heroClass(HeroClass.OTHER_CAT)
                        .level(1)
                        .hp(HERO_STARTING_HP.subtract(BigDecimal.valueOf(10)))
                        .experience(0)
                        .attack(35)
                        .defence(5);
            case OWL:
                return new Hero()
                        .heroClass(HeroClass.OWL)
                        .level(1)
                        .hp(HERO_STARTING_HP.subtract(BigDecimal.valueOf(20)))
                        .experience(0)
                        .attack(100)
                        .defence(10);
            default:
                throw new IllegalArgumentException(HERO_CLASS_NOT_PRESENT);
        }
    }

}
