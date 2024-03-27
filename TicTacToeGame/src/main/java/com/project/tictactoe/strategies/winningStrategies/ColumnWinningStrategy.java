package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.Symbol;

import java.util.HashMap;

public class ColumnWinningStrategy implements WinningStrategy{

    // colNumber,Symbol,count
    private final HashMap<Integer, HashMap<Symbol,Integer>> colSymbolMap ;

    public ColumnWinningStrategy(){
        colSymbolMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol sym = move.getPlayer().getSymbol();
        if(!colSymbolMap.containsKey(col)){
            colSymbolMap.put(col, new HashMap<>(){{put(sym,1);}});
        }
        else{
            int currentRowSymCnt = colSymbolMap.get(col).get(sym);
            colSymbolMap.get(col).put(sym,currentRowSymCnt+1);
            return colSymbolMap.get(col).get(sym).equals(board.getBoardSize());
        }
        return false;
    }

}
