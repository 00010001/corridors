package com.sample.base.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SaveData implements Serializable {

    private LocalDateTime localDateTime;
    private int col;
    private int row;
    private Direction direction;
    private int heroId;
    private int levelId;

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

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
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

    public SaveData heroId(final int heroId) {
        this.heroId = heroId;
        return this;
    }

    public SaveData levelId(final int levelId) {
        this.levelId = levelId;
        return this;
    }


}
