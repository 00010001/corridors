package com.sample.console.input.converter;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.Stage;

public class ConsoleInputConverter {

    public InputCommand convert(GameState gameState, String userInput) {
        Stage currentStage = gameState.getStage();
        if (currentStage == Stage.MENU) {
            return convertForMenu(gameState, userInput);
        } else if (currentStage == Stage.CHARACTER_CREATION) {
            return convertForCharacterCreation(userInput);
        } else if (currentStage == Stage.GAME) {
            return convertForGame(userInput);
        } else if (currentStage == Stage.GAME_SAVED) {
            return convertForGameSaved(userInput);
        }
        throw new RuntimeException();
    }

    private InputCommand convertForGameSaved(String userInput) {
        if ("r".equals(userInput.toLowerCase())) {
            return InputCommand.RESUME;
        }
        throw new IllegalArgumentException();
    }

    private InputCommand convertForMenu(GameState gameState, String userInput) {
        switch (userInput.toLowerCase()) {
            case "n":
                return InputCommand.NEW_GAME;
            case "e":
                return InputCommand.EXIT;
            case "l":
                if (gameState.isLoadGameAvailable()) {
                    return InputCommand.LOAD_GAME;
                }
                throw new IllegalArgumentException();
            case "r":
                if (gameState.isPlayerStartedGame()) {
                    return InputCommand.RESUME;
                }
                throw new IllegalArgumentException();
            case "s":
                if (gameState.isPlayerStartedGame()) {
                    return InputCommand.SAVE_GAME;
                }
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException();
        }
    }

    private InputCommand convertForCharacterCreation(String userInput) {
        switch (userInput.toLowerCase()) {
            case "n":
                return InputCommand.CHARACTER_NEXT;
            case "s":
                return InputCommand.CHARACTER_SELECT;
            default:
                throw new IllegalArgumentException();
        }
    }

    private InputCommand convertForGame(String userInput) {
        switch (userInput.toLowerCase()) {
            case "w":
                return InputCommand.MOVE_AHEAD;
            case "a":
                return InputCommand.TURN_LEFT;
            case "d":
                return InputCommand.TURN_RIGHT;
            case "e":
                return InputCommand.EXIT;
            case "m":
                return InputCommand.MENU;
            default:
                throw new IllegalArgumentException();
        }
    }
}
