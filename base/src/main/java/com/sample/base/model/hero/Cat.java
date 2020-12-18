package com.sample.base.model.hero;

public class Cat implements Hero {

    private static final int ID = 0;

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
    public int getId() {
        return ID;
    }

    @Override
    public String[] getArray() {
        return array;
    }
}
