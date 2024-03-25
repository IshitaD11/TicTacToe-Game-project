package com.project.tictactoe.models;

import com.project.tictactoe.models.enums.CellStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    Cell cell;

    public Move(Cell cell){
        this.cell=cell;
    }
}
