package com.sample.console.input.service;

import com.sample.base.model.InputCommand;
import com.sample.base.service.InputProcessor;
import com.sample.console.input.converter.ConsoleInputConverter;

import java.util.Scanner;

public class ConsoleInputProcessor implements InputProcessor {

    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleInputConverter converter = new ConsoleInputConverter();

    @Override
    public InputCommand getInputCommand() {
        System.out.print("Command: ");
        String command = scanner.nextLine();
        return converter.convert(command);
    }
}
