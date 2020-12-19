package com.sample.base.model;

import com.sample.base.model.hero.Hero;
import com.sample.base.model.level.Level;

public class GameState {

    private Stage stage;
    private int row;
    private int col;
    private Direction direction;
    private Hero hero;
    private Level level;

    public void setPos(int row, int col){
        this.setRow(row);
        this.setCol(col);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
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

    public GameState row(final int row) {
        this.row = row;
        return this;
    }

    public GameState col(final int col) {
        this.col = col;
        return this;
    }

    public GameState direction(final Direction direction) {
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
