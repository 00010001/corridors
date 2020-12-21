package com.sample.console.renderer.service;

import static com.sample.base.ErrorMessages.STRING_TOO_LONG_FOR_CONSOLE;

public class StringService {

    public String formatStringForConsole(String string, int length) {
        if (string.length() > length) {
            throw new IllegalArgumentException(STRING_TOO_LONG_FOR_CONSOLE + string);
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
