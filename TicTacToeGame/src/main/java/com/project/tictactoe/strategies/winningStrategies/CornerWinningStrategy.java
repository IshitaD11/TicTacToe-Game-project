package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.Symbol;

public class CornerWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Move move, Board board) {

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        int sz = board.getBoardSize();
        Symbol sym = move.getPlayer().getSymbol();
        int cnt = 0;

        if((row==0 && col==0) || (row==0 && col==sz-1) || (row==sz-1 && col==0) || (row==sz-1 && col==sz-1)){
            if(board.getCells().get(0).get(0).getPlayer().getSymbol().equals(sym))
                cnt++;
            if(board.getCells().get(0).get(sz-1).getPlayer().getSymbol().equals(sym))
                cnt++;
            if(board.getCells().get(sz-1).get(0).getPlayer().getSymbol().equals(sym))
                cnt++;
            if(board.getCells().get(sz-1).get(sz-1).getPlayer().getSymbol().equals(sym))
                cnt++;
            return cnt == 4;
        }
        return false;
    }
}
