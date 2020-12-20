package com.sample.base.model.hero;

public enum HeroClass {

    CAT(0),
    COW(1),
    DOG(2),
    OTHER_CAT(3),
    OWL(4);

    private int index;

    HeroClass(int index) {
        this.index = index;
    }

    public static HeroClass findByIndex(int index) {
        for (HeroClass v : values()) {
            if (v.getIndex() == index) {
                return v;
            }
        }
        throw new IllegalArgumentException("hero index not present");
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
