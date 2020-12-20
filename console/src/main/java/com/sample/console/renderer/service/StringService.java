package com.sample.console.renderer.service;

import com.sample.console.renderer.ConsoleRendererProperties;

public class StringService {

    public String formatStringForConsole(String string) {
        if (string.length() > ConsoleRendererProperties.CONSOLE_MAX_WIDTH_WITHOUT_BORDERS) {
            throw new IllegalArgumentException("given string is too long for console window: " + string);
        }
        int lengthOfEmptySpace = ConsoleRendererProperties.CONSOLE_MAX_WIDTH_WITHOUT_BORDERS - string.length();
        if (string.length() % 2 == 0) {
            return "x" + getEmptyString(lengthOfEmptySpace / 2) + string + getEmptyString((lengthOfEmptySpace / 2) + 1) + "x";
        }
        return "x" + getEmptyString(lengthOfEmptySpace / 2) + string + getEmptyString((lengthOfEmptySpace / 2)) + "x";
    }

    private String getEmptyString(int length) {
        return new String(new char[length]).replace("\0", " ");
    }

}
