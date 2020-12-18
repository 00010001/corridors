package com.sample.base.model.level;

public abstract class Level {

    private int number;

    private int xStartingPos;
    private int yStartingPos;

    public int getNumber() {
        return number;
    }

    public int getxStartingPos() {
        return xStartingPos;
    }

    public void setxStartingPos(int xStartingPos) {
        this.xStartingPos = xStartingPos;
    }

    public int getyStartingPos() {
        return yStartingPos;
    }

    public void setyStartingPos(int yStartingPos) {
        this.yStartingPos = yStartingPos;
    }
}
