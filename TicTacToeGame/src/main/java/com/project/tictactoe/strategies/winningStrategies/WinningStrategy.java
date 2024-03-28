package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Cell;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.players.Player;

public interface WinningStrategy {

    boolean checkWinner(Move move, Board board);

    Cell checkPossibleMove(Player player, Board board);
}
