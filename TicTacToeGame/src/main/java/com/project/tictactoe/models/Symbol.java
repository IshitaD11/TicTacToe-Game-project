package com.project.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symbol {
    private char symbol;

    public Symbol(char sym){
        symbol = sym;
    }
}
