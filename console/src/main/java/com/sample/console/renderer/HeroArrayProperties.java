package com.sample.console.renderer;

public class HeroArrayProperties {

    private static final String[] CAT_ARRAY = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "x               x",
            "x     /\\_/\\     x",
            "x    ( o o )    x",
            "x    ==_Y_==    x",
            "x      `-'      x",
            "x               x",
            "xxxxxxxxxxxxxxxxx"
    };
    private static final String[] COW_ARRAY = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "x               x",
            "x    ((...))    x",
            "x    ( o o )    x",
            "x     \\   /     x",
            "x      ^_^      x",
            "x               x",
            "xxxxxxxxxxxxxxxxx"
    };
    private static final String[] DOG_ARRAY = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "x               x",
            "x   ,-.___,-.   x",
            "x   \\_/_ _\\_/   x",
            "x     )O_O(     x",
            "x    { (_) }    x",
            "x               x",
            "xxxxxxxxxxxxxxxxx"
    };
    private static final String[] OTHER_CAT_ARRAY = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "x               x",
            "x   /\\___/\\ ((  x",
            "x   \\`@_@'/  )) x",
            "x   {_:Y:.}_//  x",
            "x   {_}^-'{_}   x",
            "x               x",
            "xxxxxxxxxxxxxxxxx"
    };
    private static final String[] OWL_ARRAY = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "x               x",
            "x     /\\_/\\     x",
            "x    ((@v@))    x",
            "x    ():::()    x",
            "x     VV-VV     x",
            "x               x",
            "xxxxxxxxxxxxxxxxx"
    };

    public static String[] getByIndex(int index) {

        switch (index) {
            case 0:
                return CAT_ARRAY;
            case 1:
                return COW_ARRAY;
            case 2:
                return DOG_ARRAY;
            case 3:
                return OTHER_CAT_ARRAY;
            case 4:
                return OWL_ARRAY;
            default:
                throw new IllegalArgumentException("hero index not supported");
        }

    }

}
