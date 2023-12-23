package com.example.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Player( Symbol symbol,String name, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }


}
