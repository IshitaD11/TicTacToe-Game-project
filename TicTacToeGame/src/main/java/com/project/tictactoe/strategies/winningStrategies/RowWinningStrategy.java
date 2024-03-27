package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.Symbol;
import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{

    // rowNumber,Symbol,count
    private final HashMap<Integer,HashMap<Symbol,Integer>> rowSymbolMap ;

    public RowWinningStrategy(){
        rowSymbolMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol sym = move.getPlayer().getSymbol();
        if(!rowSymbolMap.containsKey(row)){
            rowSymbolMap.put(row, new HashMap<>(){{put(sym,1);}});
        }
        else{
            int currentRowSymCnt = rowSymbolMap.get(row).get(sym);
            rowSymbolMap.get(row).put(sym,currentRowSymCnt+1);
            return rowSymbolMap.get(row).get(sym).equals(board.getBoardSize());
        }
        return false;
    }
}
