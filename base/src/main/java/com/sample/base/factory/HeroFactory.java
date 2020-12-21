package com.sample.base.factory;

import com.sample.base.model.Hero;
import com.sample.base.model.enumeration.HeroClass;

import static com.sample.base.BaseProperties.HERO_STARTING_HP;

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
                        .defence(10);
            case COW:
                return new Hero()
                        .heroClass(HeroClass.COW)
                        .level(1)
                        .hp(HERO_STARTING_HP)
                        .experience(0)
                        .attack(10)
                        .defence(40);
            case DOG:
                return new Hero()
                        .heroClass(HeroClass.DOG)
                        .level(1)
                        .hp(HERO_STARTING_HP)
                        .experience(0)
                        .attack(15)
                        .defence(25);
            case OTHER_CAT:
                return new Hero()
                        .heroClass(HeroClass.OTHER_CAT)
                        .level(1)
                        .hp(HERO_STARTING_HP)
                        .experience(0)
                        .attack(30)
                        .defence(5);
            case OWL:
                return new Hero()
                        .heroClass(HeroClass.OWL)
                        .level(1)
                        .hp(HERO_STARTING_HP)
                        .experience(0)
                        .attack(50)
                        .defence(1);
            default:
                throw new IllegalArgumentException("hero class not present");
        }
    }

}
