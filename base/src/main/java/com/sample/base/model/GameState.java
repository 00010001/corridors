package com.sample.base.model;

import com.sample.base.model.hero.Hero;
import com.sample.base.model.level.Level;

public class GameState {

    private Stage stage;
    private int xPos;
    private int yPos;
    private Direction direction;
    private Hero hero;
    private Level level;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Direction getPlayerDirection() {
        return direction;
    }

    public void setPlayerDirection(Direction direction) {
        this.direction = direction;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public GameState stage(final Stage stage) {
        this.stage = stage;
        return this;
    }

    public GameState xPos(final int xPos) {
        this.xPos = xPos;
        return this;
    }

    public GameState yPos(final int yPos) {
        this.yPos = yPos;
        return this;
    }

    public GameState playerDirection(final Direction direction) {
        this.direction = direction;
        return this;
    }

    public GameState hero(final Hero hero) {
        this.hero = hero;
        return this;
    }

    public GameState level(final Level level) {
        this.level = level;
        return this;
    }

}
