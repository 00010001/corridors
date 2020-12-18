package com.sample.console.input.converter;

import com.sample.base.model.InputCommand;

public class ConsoleInputConverter {

    public InputCommand convert(String userInput) {
        switch (userInput.toLowerCase()){
            case "w":
                return InputCommand.MOVE_UP;
            case "a":
                return InputCommand.ROTATE_LEFT;
            case "d":
                return InputCommand.ROTATE_RIGHT;
            case"e":
                return InputCommand.EXIT;
            default:
                throw new IllegalArgumentException();
        }
    }
}
