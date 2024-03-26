package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.enums.WinningStrategyTypes;

public class WinningStrategyFactory {

    public static WinningStrategy getWinningStrategy(WinningStrategyTypes winningStrategyTypes){

        switch (winningStrategyTypes){
            case ROW -> {
                return new RowWinningStrategy();
            }
            case COLUMN -> {
                return new ColumnWinningStrategy();
            }
            case DIAGONAL -> {
                return new DiagonalWinningStrategy();
            }
            case CORNER -> {
                return new CornerWinningStrategy();
            }
        }
        return null;
    }
}
