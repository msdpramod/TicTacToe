package com.example.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(Symbol symbol, String name, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
