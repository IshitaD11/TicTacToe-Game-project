package com.project.tictactoe.controllers;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Game;
import com.project.tictactoe.models.enums.GameState;
import com.project.tictactoe.models.players.Player;
import com.project.tictactoe.strategies.winningStrategies.WinningStrategy;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        return Game.builder()
                .board(new Board(dimension))
                .players(players)
                .winningStrategies(winningStrategies)
                .nextPlayerIdx(0)
                .gameState(GameState.ONGOING)
                .moves(new ArrayList<>())
                .build();
    }

    public void displayBoard(Game game){
        game.display();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public GameState checkGameState(Game game){
        return game.getGameState();
    }
}
