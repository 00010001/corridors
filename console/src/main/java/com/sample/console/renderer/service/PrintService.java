package com.sample.console.renderer.service;

import com.sample.base.model.GameState;
import com.sample.base.model.hero.Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class PrintService {

    private final StringService stringService = new StringService();
    private final LogService logService = new LogService();

    public void printFormattedLineFullWidth(String string){
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
        if(nextLine){
            System.out.println(generateBreakLine(length));
        } else {
            System.out.print(generateBreakLine(length));
        }
    }

    private String generateBreakLine(int length){
        return new String(new char[length]).replace("\0", "x");
    }

    public void printHeroFullWidth(Hero hero) {
        for (int i = 0; i < 8; i++) {
            printFormattedLineFullWidth(hero.getArray()[i]);
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
            throw new RuntimeException("IOException when trying to print inputStream");
        }

    }

    public void printHud(Hero hero, GameState gameState) {

        System.out.println(hero.getArray()[0] + generateBreakLine(HUD_WIDTH + LOG_WIDTH)
                + " row" + gameState.getRow() + " col" + gameState.getRow() + " dir " + gameState.getDirection());
        System.out.println(hero.getArray()[1] + HUD_STAT_EMPTY + logService.getLogEntry(gameState, 0));
        System.out.println(hero.getArray()[2] + HUD_STAT_HP + logService.getLogEntry(gameState, 1));
        System.out.println(hero.getArray()[3] + stringService.formatStringForConsole(HUD_XP + gameState.getHero().getExperience(), HUD_WIDTH_WITHOUT_RIGHT_BORDER) + "x" + logService.getLogEntry(gameState, 2));
        System.out.println(hero.getArray()[4] + HUD_STAT_EMPTY + logService.getLogEntry(gameState, 3));
        System.out.println(hero.getArray()[5] + stringService.formatStringForConsole(HUD_MENU, HUD_WIDTH_WITHOUT_RIGHT_BORDER) + "x" + logService.getLogEntry(gameState, 4));
        System.out.println(hero.getArray()[6] + HUD_STAT_EMPTY + logService.getLogEntry(gameState, 5));
        System.out.println(hero.getArray()[7] + generateBreakLine(HUD_WIDTH + LOG_WIDTH));

    }

    public void print(String s) {
        System.out.print(s);
    }
}
