package com.sample.base.model.hero;

public class Cow extends Hero {

    private static final int ID = 1;

    private final String[] array = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "x               x",
            "x    ((...))    x",
            "x    ( o o )    x",
            "x     \\   /     x",
            "x      ^_^      x",
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
