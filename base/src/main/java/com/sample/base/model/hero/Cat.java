package com.sample.base.model.hero;

public class Cat extends Hero {

    private final String[] array = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "x               x",
            "x     /\\_/\\     x",
            "x    ( o o )    x",
            "x    ==_Y_==    x",
            "x      `-'      x",
            "x               x",
            "xxxxxxxxxxxxxxxxx"
    };

    @Override
    public String[] getArray() {
        return array;
    }
}
