package com.project.tictactoe.models.players;

import com.project.tictactoe.models.*;
import com.project.tictactoe.models.enums.CellStatus;
import com.project.tictactoe.models.enums.PlayerType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Human extends Player implements UndoFunctionality {

    private Scanner sc;

    public Human(String Name, int id, Symbol symbol, PlayerType playerType) {
        super(Name, id, symbol, playerType);
        sc = new Scanner(System.in);
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

    @Override
    public Move makeMove(Board board) {
        System.out.println("where you want to play?");
        System.out.println("give row");
        int row = sc.nextInt();
        System.out.println("give column");
        int col = sc.nextInt();
        return new Move(new Cell(row,col),this);
    }
}
