package com.sample.base.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SaveData implements Serializable {

    private LocalDateTime localDateTime;
    private int xPos;
    private int yPos;
    private Direction direction;
    private int heroId;
    private int levelId;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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

    public SaveData xPos(final int xPos) {
        this.xPos = xPos;
        return this;
    }

    public SaveData yPos(final int yPos) {
        this.yPos = yPos;
        return this;
    }

    public SaveData playerDirection(final Direction direction) {
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
