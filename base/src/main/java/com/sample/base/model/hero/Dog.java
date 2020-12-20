package com.sample.base.model.hero;

public class Dog extends Hero {

    private final String[] array = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "x               x",
            "x   ,-.___,-.   x",
            "x   \\_/_ _\\_/   x",
            "x     )O_O(     x",
            "x    { (_) }    x",
            "x               x",
            "xxxxxxxxxxxxxxxxx"
    };

    @Override
    public String[] getArray() {
        return array;
    }
}
