package com.sample.console.renderer;

import com.sample.base.model.hero.Hero;

import static com.sample.console.renderer.ConsoleRendererProperties.*;

public class CharacterCreationRenderer {

    public void render(Hero hero) {
        System.out.println(BREAK_LINE);
        printEmptyLine(7);
        printHero(hero);
        printEmptyLine(3);
        System.out.println(NEXT);
        System.out.println(SELECT);
        printEmptyLine(8);
        System.out.println(BREAK_LINE);
    }

    private void printHero(Hero hero) {
        for (int i = 0; i < 8; i++) {
            System.out.print(CHARACTER_CREATION_LEFT);
            System.out.print(hero.getArray()[i]);
            System.out.print(CHARACTER_CREATION_RIGHT + "\n");
        }
    }

    private void printEmptyLine(int numberOfLines) {
        for (int i = 0; i < numberOfLines; i++) {
            System.out.println(EMPTY_LINE);
        }
    }
}
