package com.project.tictactoe.models;

import java.util.List;

public interface UndoFunctionality {

    public void undo(List<Move> moves, Board board);
}
