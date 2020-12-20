package com.sample.base.model.factory;

import com.sample.base.model.hero.*;

public class HeroFactory {

    public Hero getByClass(HeroClass heroClass) {

        switch (heroClass) {
            case CAT:
                return new Cat();
            case COW:
                return new Cow();
            case DOG:
                return new Dog();
            case OTHER_CAT:
                return new OtherCat();
            case OWL:
                return new Owl();
            default:
                throw new IllegalArgumentException("hero class not present");
        }
    }

}
