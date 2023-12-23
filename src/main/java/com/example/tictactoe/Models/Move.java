package com.example.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Move {
    private Player player;
    private Cell cell;

    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }
}
