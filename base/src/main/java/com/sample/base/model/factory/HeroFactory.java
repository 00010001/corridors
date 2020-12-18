package com.sample.base.model.factory;

import com.sample.base.model.hero.*;

public class HeroFactory {

    public Hero getById(int heroId) {

        switch (heroId) {
            case 0:
                return new Cat();
            case 1:
                return new Cow();
            case 2:
                return new Dog();
            case 3:
                return new OtherCat();
            case 4:
                return new Owl();
        }

        return null;
    }

}
