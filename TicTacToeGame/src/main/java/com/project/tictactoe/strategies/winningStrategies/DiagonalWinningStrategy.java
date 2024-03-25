package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.players.Player;

public class DiagonalWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWinner(Player player, Board board) {
        return false;
    }
}
