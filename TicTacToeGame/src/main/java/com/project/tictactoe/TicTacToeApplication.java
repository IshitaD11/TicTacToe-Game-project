package com.project.tictactoe;

import com.project.tictactoe.controllers.GameController;
import com.project.tictactoe.models.Game;
import com.project.tictactoe.models.enums.GameState;
import com.project.tictactoe.models.players.Player;
import com.project.tictactoe.strategies.winningStrategies.WinningStrategy;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TicTacToeApplication {

    public static void main(String[] args) {

//        SpringApplication.run(TicTacToeApplication.class, args);

        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        List<WinningStrategy> winningStrategyList = new ArrayList<>();

        Game game = gameController.startGame(2,players, winningStrategyList );

        while(!gameController.checkGameState(game).equals(GameState.COMPLETE)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }

        if(gameController.checkGameState(game).equals(GameState.DRAW)){
            System.out.println("Game is Draw");
        }
        else if(gameController.checkGameState(game).equals(GameState.COMPLETE)){
            Player player = gameController.getWinner(game);
            System.out.println(player.getName());
        }

    }

}
