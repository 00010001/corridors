package com.sample.console.renderer.service;

import com.sample.base.model.GameState;

import java.util.List;

public class LogService {

    String getLogEntry(GameState gameState, int index) {
        List<String> gameLog = gameState.getGameLog();
        if (gameLog.isEmpty()) {
            return " ";
        } else if (index >= gameLog.size()) {
            return " ";
        } else {
            return " " + gameLog.get(gameLog.size() - index - 1);
        }
    }

}
