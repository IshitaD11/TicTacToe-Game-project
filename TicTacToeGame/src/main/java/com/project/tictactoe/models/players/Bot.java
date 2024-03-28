package com.project.tictactoe.models.players;

import com.project.tictactoe.models.Game;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.Symbol;
import com.project.tictactoe.models.enums.BotDifficultyLevel;
import com.project.tictactoe.models.enums.PlayerType;
import com.project.tictactoe.strategies.botPlayingStrategies.BotPlayingStrategy;
import com.project.tictactoe.strategies.botPlayingStrategies.BotPlayingStrategyFactory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String Name, int id, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(Name, id, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Game game) {

        return botPlayingStrategy.makeMove(game,this);
    }
}
