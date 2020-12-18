package com.sample.base.model;

import com.sample.base.model.level.Level;

public class GameParameters {

    private Level level;

    private boolean loadGameAvailable = false;
    private boolean playerStartedGame = false;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean isLoadGameAvailable() {
        return loadGameAvailable;
    }

    public void setLoadGameAvailable(boolean loadGameAvailable) {
        this.loadGameAvailable = loadGameAvailable;
    }

    public boolean isPlayerStartedGame() {
        return playerStartedGame;
    }

    public void setPlayerStartedGame(boolean playerStartedGame) {
        this.playerStartedGame = playerStartedGame;
    }
}
