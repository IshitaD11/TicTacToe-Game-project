package com.project.tictactoe.models;

import com.project.tictactoe.models.enums.CellStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private List<List<Cell>> cells;
    private int boardSize;

    public Board(int boardSize){
        this.boardSize = boardSize;
        List<List<Cell>> cells = new ArrayList<>();

        //initialize the board
        for(int i=0;i<boardSize;i++){
            cells.add(new ArrayList<>());
            for(int j=0;j<boardSize;j++){
                cells.get(i).add(new Cell(i,j));
            }
        }
    }

    public void setCell(int row, int col, CellStatus cellStatus){
        Cell currentCell = cells.get(row).get(col);
        currentCell.setCellStatus(cellStatus);
    }

    public void displayBoard(){
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                cells.get(i).get(j).printCell();
            }
            System.out.println();
        }
    }
}
