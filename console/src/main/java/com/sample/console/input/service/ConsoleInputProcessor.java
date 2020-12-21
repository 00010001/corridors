package com.sample.console.input.service;

import com.sample.base.model.GameState;
import com.sample.base.model.enumeration.InputCommand;
import com.sample.base.service.InputProcessor;
import com.sample.console.input.converter.ConsoleInputConverter;
import com.sample.console.renderer.service.PrintService;

import java.util.Scanner;

public class ConsoleInputProcessor implements InputProcessor {

    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleInputConverter converter = new ConsoleInputConverter();
    private final PrintService printService = new PrintService();

    @Override
    public InputCommand getInputCommand(GameState gameState, boolean error) {
        if (error) {
            printService.print("wrong input try again. ");
        }
        printService.print("Command: ");
        String command = scanner.nextLine();
        try {
            return converter.convert(gameState, command);
        } catch (IllegalArgumentException e) {
            return getInputCommand(gameState, true);
        }
    }
}
