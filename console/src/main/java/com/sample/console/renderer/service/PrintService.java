package com.sample.console.renderer.service;

import com.sample.base.model.Hero;
import com.sample.console.renderer.HeroArrayProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static com.sample.console.renderer.ConsoleRendererProperties.CONSOLE_MAX_WIDTH_WITHOUT_BORDERS;
import static com.sample.console.renderer.ConsoleRendererProperties.SKELETON;

public class PrintService {

    private final StringService stringService = new StringService();

    public void printFormattedLineFullWidth(String string) {
        System.out.println("x" + stringService.formatStringForConsole(string, CONSOLE_MAX_WIDTH_WITHOUT_BORDERS) + "x");
    }

    public void printEmptyLine() {
        printFormattedLineFullWidth("");
    }

    public void printEmptyLine(int numberOfLines) {
        for (int i = 0; i < numberOfLines; i++) {
            printEmptyLine();
        }
    }

    public void printBreakLine(int length, boolean nextLine) {
        if (nextLine) {
            System.out.println(generateBreakLine(length));
        } else {
            System.out.print(generateBreakLine(length));
        }
    }

    public String generateBreakLine(int length) {
        return new String(new char[length]).replace("\0", "x");
    }

    public void printHeroFullWidth(Hero hero) {
        for (int i = 0; i < 8; i++) {
            printFormattedLineFullWidth(HeroArrayProperties.getByIndex(hero.getHeroClass().getIndex())[i]);
        }
    }

    public void printInputStream(InputStream is) {

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void print(String s) {
        System.out.print(s);
    }
}
