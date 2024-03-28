package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Cell;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.Symbol;
import com.project.tictactoe.models.enums.CellStatus;
import com.project.tictactoe.models.players.Player;

import java.util.HashMap;
import java.util.List;

public class ColumnWinningStrategy implements WinningStrategy{

    // colNumber,Symbol,count
    private final HashMap<Integer, HashMap<Symbol,Integer>> symbolMap ;

    public ColumnWinningStrategy(){
        symbolMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol sym = move.getPlayer().getSymbol();
        if(!symbolMap.containsKey(col)){
            symbolMap.put(col, new HashMap<>(){{put(sym,1);}});
        }
        else if(!symbolMap.get(col).containsKey(sym)){
            symbolMap.get(col).put(sym,1);
        }
        else{
            int currentRowSymCnt = symbolMap.get(col).get(sym);
            symbolMap.get(col).put(sym,currentRowSymCnt+1);
            return symbolMap.get(col).get(sym).equals(board.getBoardSize());
        }
        return false;
    }

    @Override
    public Cell checkPossibleMove(Player player, Board board) {
        Symbol sym = player.getSymbol();
        for(int colNum:symbolMap.keySet()){
            if(symbolMap.get(colNum).containsKey(sym) && symbolMap.get(colNum).get(sym)==(board.getBoardSize()-1)){
                for(List<Cell> cellRow : board.getCells()){
                    if(cellRow.get(colNum).getCellStatus().equals(CellStatus.EMPTY))
                    {
                        return cellRow.get(colNum);
                    }
                }
            }
        }
        return null;
    }

}
