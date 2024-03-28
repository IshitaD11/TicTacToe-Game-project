package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Cell;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.Symbol;
import com.project.tictactoe.models.enums.CellStatus;
import com.project.tictactoe.models.players.Player;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{

    // rowNumber,Symbol,count
    private final HashMap<Integer,HashMap<Symbol,Integer>> symbolMap ;

    public RowWinningStrategy(){
        symbolMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol sym = move.getPlayer().getSymbol();
        if(!symbolMap.containsKey(row)){
            symbolMap.put(row, new HashMap<>(){{put(sym,1);}});
        }
        else if(!symbolMap.get(row).containsKey(sym)){
            symbolMap.get(row).put(sym,1);
        }
        else{
            int currentRowSymCnt = symbolMap.get(row).get(sym);
            symbolMap.get(row).put(sym,currentRowSymCnt+1);
            return symbolMap.get(row).get(sym).equals(board.getBoardSize());
        }
        return false;
    }

    @Override
    public Cell checkPossibleMove(Player player,  Board board) {

        Symbol sym = player.getSymbol();
        for(int rowNum:symbolMap.keySet()){
            if(symbolMap.get(rowNum).containsKey(sym) && symbolMap.get(rowNum).get(sym)==(board.getBoardSize()-1)){
                for(Cell cell : board.getCells().get(rowNum)){
                    if(cell.getCellStatus().equals(CellStatus.EMPTY))
                    {
                        return cell;
                    }
                }
            }
        }
        return null;
    }
}
