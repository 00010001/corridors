package com.sample.console.renderer;

public class HeroArrayProperties {

    private static final String[] CAT_ARRAY = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "                 ",
            "      /\\_/\\      ",
            "     ( o o )     ",
            "     ==_Y_==     ",
            "       `-'       ",
            "                 ",
            "xxxxxxxxxxxxxxxxx"
    };
    private static final String[] COW_ARRAY = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "                 ",
            "     ((...))     ",
            "     ( o o )     ",
            "      \\   /      ",
            "       ^_^       ",
            "                 ",
            "xxxxxxxxxxxxxxxxx"
    };
    private static final String[] DOG_ARRAY = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "                 ",
            "    ,-.___,-.    ",
            "    \\_/_ _\\_/    ",
            "      )O_O(      ",
            "     { (_) }     ",
            "                 ",
            "xxxxxxxxxxxxxxxxx"
    };
    private static final String[] OTHER_CAT_ARRAY = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "                 ",
            "    /\\___/\\ ((   ",
            "    \\`@_@'/  ))  ",
            "    {_:Y:.}_//   ",
            "    {_}^-'{_}    ",
            "                 ",
            "xxxxxxxxxxxxxxxxx"
    };
    private static final String[] OWL_ARRAY = new String[]{
            "xxxxxxxxxxxxxxxxx",
            "                 ",
            "      /\\_/\\      ",
            "     ((@v@))     ",
            "     ():::()     ",
            "      VV-VV      ",
            "                 ",
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
