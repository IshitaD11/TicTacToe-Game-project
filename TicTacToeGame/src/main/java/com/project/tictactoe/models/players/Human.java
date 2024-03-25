package com.project.tictactoe.models.players;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.Symbol;
import com.project.tictactoe.models.UndoFunctionality;
import com.project.tictactoe.models.enums.CellStatus;
import com.project.tictactoe.models.enums.PlayerType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Human extends Player implements UndoFunctionality {

    public Human(String Name, int id, Symbol symbol, PlayerType playerType) {
        super(Name, id, symbol, playerType);
    }

    @Override
    public void undo(List<Move> moves, Board board){
        // remove the last element from list of moves
        Move lastMove = moves.getLast();
        // update cell
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        board.setCell(row,col, CellStatus.EMPTY);
        moves.removeLast();
    }
}
