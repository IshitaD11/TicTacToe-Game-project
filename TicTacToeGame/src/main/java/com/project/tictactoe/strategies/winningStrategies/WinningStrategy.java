package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.players.Player;

public interface WinningStrategy {

    public boolean checkWinner(Player player, Board board);
}
