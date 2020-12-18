package com.sample.console.input.service;

import com.sample.base.model.GameParameters;
import com.sample.base.model.InputCommand;
import com.sample.base.model.Stage;
import com.sample.base.service.InputProcessor;
import com.sample.console.input.converter.ConsoleInputConverter;

import java.util.Scanner;

public class ConsoleInputProcessor implements InputProcessor {

    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleInputConverter converter = new ConsoleInputConverter();

    @Override
    public InputCommand getInputCommand(GameParameters gameParameters, Stage currentStage, boolean error) {
        if (error) {
            System.out.print("wrong input try again. ");
        }
        System.out.print("Command: ");
        String command = scanner.nextLine();
        try {
            return converter.convert(gameParameters, currentStage, command);
        } catch (IllegalArgumentException e) {
            return getInputCommand(gameParameters, currentStage, true);
        }
    }
}
