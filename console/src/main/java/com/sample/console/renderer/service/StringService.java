package com.sample.console.renderer.service;

public class StringService {

    public String formatStringForConsole(String string, int length) {
        if (string.length() > length) {
            throw new IllegalArgumentException("given string is too long for console window: " + string);
        }
        int lengthOfEmptySpace = length - string.length();
        if (string.length() % 2 == 0) {
            return getEmptyString(lengthOfEmptySpace / 2) + string + getEmptyString((lengthOfEmptySpace / 2) + 1);
        }
        return getEmptyString(lengthOfEmptySpace / 2) + string + getEmptyString((lengthOfEmptySpace / 2));
    }

    private String getEmptyString(int length) {
        return new String(new char[length]).replace("\0", " ");
    }

}
