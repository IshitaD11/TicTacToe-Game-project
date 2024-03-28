package com.project.tictactoe.strategies.botPlayingStrategies;

import com.project.tictactoe.models.Game;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.players.Bot;

public interface BotPlayingStrategy {

    Move makeMove(Game game, Bot bot);
}
