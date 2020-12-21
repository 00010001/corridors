package com.sample.base.model;

import java.io.Serializable;

public class Level implements Serializable {

    private int id;
    private int startingRow;
    private int startingCol;
    private int[][] map;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartingRow() {
        return startingRow;
    }

    public void setStartingRow(int startingRow) {
        this.startingRow = startingRow;
    }

    public int getStartingCol() {
        return startingCol;
    }

    public void setStartingCol(int startingCol) {
        this.startingCol = startingCol;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public Level id(final int id) {
        this.id = id;
        return this;
    }

    public Level startingRow(final int startingRow) {
        this.startingRow = startingRow;
        return this;
    }

    public Level startingCol(final int startingCol) {
        this.startingCol = startingCol;
        return this;
    }

    public Level map(final int[][] map) {
        this.map = map;
        return this;
    }


}
