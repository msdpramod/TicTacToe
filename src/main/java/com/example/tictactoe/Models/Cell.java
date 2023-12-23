package com.example.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cell {
    private CellState state;
    private int row;
    private int col;
    private Player player;

    public Cell( int row, int col) {
        this.state = CellState.EMPTY;
        this.row = row;
        this.col = col;
    }
    public void display() {
        if (getState() == CellState.EMPTY) {
            System.out.print(" - |");
        } else {
            System.out.println(" " + getPlayer().getSymbol().getAChar() + " |");
        }
    }
}
