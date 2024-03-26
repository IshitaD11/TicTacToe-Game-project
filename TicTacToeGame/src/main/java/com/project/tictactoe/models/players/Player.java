package com.project.tictactoe.models.players;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.Symbol;
import com.project.tictactoe.models.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {
    private String name;
    private int id;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(String Name, int id, Symbol symbol, PlayerType playerType){
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public abstract Move makeMove(Board board);

}
