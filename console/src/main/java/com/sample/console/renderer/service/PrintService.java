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

    public void printFormattedLine(String string){
        System.out.println(stringService.formatStringForConsole(string));
    }

    public void printEmptyLine() {
        printFormattedLine("");
    }

    public void printEmptyLine(int numberOfLines) {
        for (int i = 0; i < numberOfLines; i++) {
            printEmptyLine();
        }
    }

    public void printBreakLine() {
        System.out.println(new String(new char[CONSOLE_MAX_WIDTH]).replace("\0", "x"));
    }

    public void printHeroFullWidth(Hero hero) {
        for (int i = 0; i < 8; i++) {
            printFormattedLine(hero.getArray()[i]);
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

        System.out.print(hero.getArray()[0] + HUD_STAT_BREAK_LINE + HUD_LOG_BREAK_LINE
                + " row" + gameState.getRow() + " col" + gameState.getRow() + " dir " + gameState.getDirection() + "\n");
        System.out.print(hero.getArray()[1] + HUD_STAT_EMPTY + " " + logService.getLogEntry(gameState, 0) + "\n");
        System.out.print(hero.getArray()[2] + HUD_STAT_HP + " " + logService.getLogEntry(gameState, 1) + "\n");
        System.out.print(hero.getArray()[3] + HUD_STAT_XP + " " + logService.getLogEntry(gameState, 2) + "\n");
        System.out.print(hero.getArray()[4] + HUD_STAT_EMPTY + " " + logService.getLogEntry(gameState, 3) + "\n");
        System.out.print(hero.getArray()[5] + HUD_STAT_MENU + " " + logService.getLogEntry(gameState, 4) + "\n");
        System.out.print(hero.getArray()[6] + HUD_STAT_EMPTY + " " + logService.getLogEntry(gameState, 5) + "\n");
        System.out.print(hero.getArray()[7] + HUD_STAT_BREAK_LINE + HUD_LOG_BREAK_LINE + "\n");

    }

    public void print(String s) {
        System.out.print(s);
    }
}
