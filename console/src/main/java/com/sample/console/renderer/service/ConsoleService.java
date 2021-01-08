package com.sample.console.renderer.service;

import java.io.IOException;

public class ConsoleService {

    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

}
