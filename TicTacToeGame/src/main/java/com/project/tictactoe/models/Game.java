package com.project.tictactoe.models;

import com.project.tictactoe.models.enums.GameState;

import java.util.List;

public class Game {
    Board board;
    List<Player> players;

    // for undo feature
    List<Move> moves;

    Player winner;
    int nextPlayerIdx;
    GameState gameState;
}
