package com.sample;


import com.sample.game.GameService;

public class App {

    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.start();
    }

}
