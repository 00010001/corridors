package com.sample.base.model.hero;

public class OtherCat extends Hero {

    private final String[] array = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "x               x",
            "x   /\\___/\\ ((  x",
            "x   \\`@_@'/  )) x",
            "x   {_:Y:.}_//  x",
            "x   {_}^-'{_}   x",
            "x               x",
            "xxxxxxxxxxxxxxxxx"
    };

    @Override
    public String[] getArray() {
        return array;
    }
}
