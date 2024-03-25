package com.project.tictactoe.controllers;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Game;
import com.project.tictactoe.models.enums.GameState;
import com.project.tictactoe.models.players.Player;
import com.project.tictactoe.strategies.winningStrategies.WinningStrategy;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        return Game.getBuilder()
                .setBoard(new Board(dimension))
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void displayBoard(Game game){

    }

    public void makeMove(Game game){

    }

    public Player getWinner(Game game){
        return null;
    }

    public GameState checkGameState(Game game){
        return null;
    }
}
