package com.project.tictactoe.models;

import com.project.tictactoe.models.enums.CellStatus;
import com.project.tictactoe.models.players.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private Cell cell;
    private Player player;

    public Move(Cell cell, Player player ){

        this.cell=cell;
        this.player=player;
    }
}
