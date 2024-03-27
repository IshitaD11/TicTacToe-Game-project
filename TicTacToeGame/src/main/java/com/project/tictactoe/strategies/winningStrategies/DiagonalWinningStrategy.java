package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.Symbol;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{
    // for diagonal row and column number is same, check if it is a cell of a diagonal. use row/col as key
    // colNumber,Symbol,count
    private final HashMap<Integer, HashMap<Symbol,Integer>> diaSymbolMap ;

    public DiagonalWinningStrategy(){
        diaSymbolMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getCol();
        int row = move.getCell().getRow();

        if(col!=row)
            return false;

        Symbol sym = move.getPlayer().getSymbol();
        if(!diaSymbolMap.containsKey(col)){
            diaSymbolMap.put(col, new HashMap<>(){{put(sym,1);}});
        }
        else{
            int currentRowSymCnt = diaSymbolMap.get(col).get(sym);
            diaSymbolMap.get(col).put(sym,currentRowSymCnt+1);
            return diaSymbolMap.get(col).get(sym).equals(board.getBoardSize());
        }
        return false;
    }
}
