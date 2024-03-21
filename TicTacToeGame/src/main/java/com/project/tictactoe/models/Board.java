package com.project.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Board {
    List<List<Cell>> Cells;
    int boardSize;
}
