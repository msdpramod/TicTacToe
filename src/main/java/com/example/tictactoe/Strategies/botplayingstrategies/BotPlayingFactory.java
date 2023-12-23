package com.example.tictactoe.Strategies.botplayingstrategies;

import com.example.tictactoe.Models.BotDifficultyLevel;

public class BotPlayingFactory {
    public BotPlayingStrategies getBotPlayingStrategy(BotDifficultyLevel  botDifficultyLevel){
        return switch (botDifficultyLevel){
            case EASY -> new EasyBotPlayingStrategies();
            case MEDIUM -> new MediumBotPlayingStrategies();
            case HARD -> new HardBotPlayingStrategies();
        };
    }
}
