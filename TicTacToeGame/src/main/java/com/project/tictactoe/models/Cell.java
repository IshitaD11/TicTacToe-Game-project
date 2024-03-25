package com.project.tictactoe.models;

import com.project.tictactoe.models.enums.CellStatus;
import com.project.tictactoe.models.players.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    int row;
    int col;
    Player player;
    CellStatus cellStatus;

    public Cell(int row,int col){
        this.row = row;
        this.col = col;
        this.player = null ;
        this.cellStatus = CellStatus.EMPTY;
    }
}
