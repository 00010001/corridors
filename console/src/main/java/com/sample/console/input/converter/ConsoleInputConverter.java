package com.sample.console.input.converter;

import com.sample.base.model.GameState;
import com.sample.base.model.InputCommand;
import com.sample.base.model.Stage;

public class ConsoleInputConverter {

    public InputCommand convert(GameState gameState, String userInput) {
        Stage currentStage = gameState.getStage();
        userInput = userInput.toLowerCase().trim();
        switch (currentStage) {
            case MENU:
                return convertForMenu(gameState, userInput);
            case CHARACTER_CREATION:
                return convertForCharacterCreation(userInput);
            case MAIN_GAME:
                return convertForGame(userInput);
            case GAME_SAVED:
                return convertForGameSaved(userInput);
            case ITEM:
                return convertForItem(userInput);
            case FIGHT:
                return convertForFight(userInput);
            case FIGHT_SUMMARY:
                return convertForFightSummary(userInput);
        }
        throw new RuntimeException();
    }

    private InputCommand convertForFightSummary(String userInput) {
        if ("c".equals(userInput)) {
            return InputCommand.CONTINUE;
        }
        throw new IllegalArgumentException();
    }

    private InputCommand convertForFight(String userInput) {
        switch (userInput) {
            case "a":
                return InputCommand.ATTACK;
            case "m":
                return InputCommand.MENU;
            default:
                throw new IllegalArgumentException();
        }
    }

    private InputCommand convertForItem(String userInput) {
        switch (userInput) {
            case "e":
                return InputCommand.TAKE_ITEM;
            case "m":
                return InputCommand.MENU;
            default:
                throw new IllegalArgumentException();
        }
    }

    private InputCommand convertForGameSaved(String userInput) {
        if ("r".equals(userInput)) {
            return InputCommand.RESUME;
        }
        throw new IllegalArgumentException();
    }

    private InputCommand convertForMenu(GameState gameState, String userInput) {
        switch (userInput) {
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
        switch (userInput) {
            case "n":
                return InputCommand.CHARACTER_NEXT;
            case "s":
                return InputCommand.CHARACTER_SELECT;
            default:
                throw new IllegalArgumentException();
        }
    }

    private InputCommand convertForGame(String userInput) {
        switch (userInput) {
            case "w":
                return InputCommand.MOVE_AHEAD;
            case "a":
                return InputCommand.TURN_LEFT;
            case "d":
                return InputCommand.TURN_RIGHT;
            case "m":
                return InputCommand.MENU;
            default:
                throw new IllegalArgumentException();
        }
    }
}
