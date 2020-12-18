package com.sample;


import com.sample.game.service.GameService;

public class App {

    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.start();
    }

}
