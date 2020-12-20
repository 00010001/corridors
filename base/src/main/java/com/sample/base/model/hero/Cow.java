package com.sample.base.model.hero;

public class Cow extends Hero {

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
    public String[] getArray() {
        return array;
    }
}
