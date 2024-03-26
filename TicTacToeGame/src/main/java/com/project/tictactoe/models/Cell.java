package com.project.tictactoe.models;

import com.project.tictactoe.models.enums.CellStatus;
import com.project.tictactoe.models.players.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellStatus cellStatus;

    public Cell(int row,int col){
        this.row = row;
        this.col = col;
        this.player = null ;
        this.cellStatus = CellStatus.EMPTY;
    }

    public void printCell(){
        if(cellStatus.equals(CellStatus.EMPTY))
            System.out.print("| |");
        else{
            System.out.print("|" + player.getSymbol().symbol + "|");
        }
    }
}
