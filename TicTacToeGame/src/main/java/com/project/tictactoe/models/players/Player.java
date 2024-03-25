package com.project.tictactoe.models.players;

import com.project.tictactoe.models.Symbol;
import com.project.tictactoe.models.enums.PlayerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {
    String name;
    int id;
    Symbol symbol;
    PlayerType playerType;

    public Player(String Name, int id, Symbol symbol, PlayerType playerType){
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType;
    }

}