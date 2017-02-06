package com.example.pierre.sudoku;

public class ListGrid {
    private int number, level, percentage;
    private String grid;

    public ListGrid(int number, int level, int percentage, String grid){
        this.number = number;
        this.level = level;
        this.percentage = percentage;
        this.grid = grid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
