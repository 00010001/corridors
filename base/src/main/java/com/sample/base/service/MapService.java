package com.sample.base.service;

import com.sample.base.model.GameState;

public class MapService {

    public static int getNextMapValue(GameState gameState) {
        return gameState.getLevel().getMap()
                [gameState.getRow() + gameState.getDirection().getRowOffset()]
                [gameState.getCol() + gameState.getDirection().getColOffset()];
    }

    public static void setNextMapValue(GameState gameState, int value) {
        gameState.getLevel().getMap()
                [gameState.getRow() + gameState.getDirection().getRowOffset()]
                [gameState.getCol() + gameState.getDirection().getColOffset()] = value;
    }
}
