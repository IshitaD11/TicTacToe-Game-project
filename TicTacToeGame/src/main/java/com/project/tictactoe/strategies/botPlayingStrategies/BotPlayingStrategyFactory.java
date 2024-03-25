package com.project.tictactoe.strategies.botPlayingStrategies;

import com.project.tictactoe.models.enums.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        return switch (botDifficultyLevel) {
            case EASY -> new EasyBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStrategy();
            case HARD -> new HardBotPlayingStrategy();
        };
    }
}
