package com.project.tictactoe.strategies.winningStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Cell;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.Symbol;
import com.project.tictactoe.models.players.Player;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy{
    // for diagonal row and column number is same, check if it is a cell of a diagonal. use row/col as key
    // diaNumber,Symbol,count
    // forward diagonal 0, backward diagonal 2
    private final HashMap<Integer, HashMap<Symbol,Integer>> symbolMap ;

    public DiagonalWinningStrategy(){
        symbolMap = new HashMap<>();
    }

    @Override
    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getCol();
        int row = move.getCell().getRow();
        Symbol sym = move.getPlayer().getSymbol();
        boolean isDia1Winner = false;
        boolean isDia2Winner = false;

        // forward diagonal
        if(row == col ) {
            isDia1Winner = diagonalMove(0,sym, board.getBoardSize());
        }
        // backward diagonal
        if(row == board.getBoardSize()-col-1){
            isDia2Winner = diagonalMove(1, sym, board.getBoardSize());
        }

        return isDia1Winner || isDia2Winner;
    }

    public boolean diagonalMove(int diaNum, Symbol sym, int boardSize){

        if (!symbolMap.containsKey(diaNum)) {
            symbolMap.put(diaNum, new HashMap<>() {{
                put(sym, 1);
            }});
        } else if (!symbolMap.get(diaNum).containsKey(sym)) {
            symbolMap.get(diaNum).put(sym, 1);
        } else {
            int currentDiaSymCnt = symbolMap.get(diaNum).get(sym);
            symbolMap.get(diaNum).put(sym, currentDiaSymCnt + 1);
            System.out.println("dia symbolMap for sym " + sym.getSymbol() + " count " + symbolMap.get(diaNum).get(sym));
            return symbolMap.get(diaNum).get(sym).equals(boardSize);
        }
        return false;
    }

    @Override
    public Cell checkPossibleMove(Player player, Board board) {
        return null;
    }
}
