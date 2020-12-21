package com.sample.base.model;

import com.sample.base.model.enumeration.Direction;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SaveData implements Serializable {

    private LocalDateTime localDateTime;
    private int col;
    private int row;
    private Direction direction;
    private Hero hero;
    private Level level;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
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

    public SaveData localDateTime(final LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public SaveData col(final int col) {
        this.col = col;
        return this;
    }

    public SaveData row(final int row) {
        this.row = row;
        return this;
    }

    public SaveData direction(final Direction direction) {
        this.direction = direction;
        return this;
    }

    public SaveData hero(final Hero hero) {
        this.hero = hero;
        return this;
    }

    public SaveData level(final Level level) {
        this.level = level;
        return this;
    }

}
