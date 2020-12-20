package com.sample.base.model.hero;

public class Owl extends Hero {

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
    public String[] getArray() {
        return array;
    }
}
