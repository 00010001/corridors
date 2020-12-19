package com.sample.base.model.hero;

public class Owl implements Hero {

    private static final int ID = 4;

    private final String[] array = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "x               x",
            "x     /\\_/\\     x",
            "x    ((@v@))    x",
            "x    ():::()    x",
            "x     VV-VV     x",
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