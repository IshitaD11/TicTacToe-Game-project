package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Move;

public interface WinningStrategy {

    boolean checkWinner(Move move, Board board);
}
