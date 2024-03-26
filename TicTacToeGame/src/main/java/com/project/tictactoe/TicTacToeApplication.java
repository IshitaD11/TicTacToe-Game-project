package com.project.tictactoe;

import com.project.tictactoe.controllers.GameController;
import com.project.tictactoe.models.Game;
import com.project.tictactoe.models.Symbol;
import com.project.tictactoe.models.enums.BotDifficultyLevel;
import com.project.tictactoe.models.enums.GameState;
import com.project.tictactoe.models.enums.PlayerType;
import com.project.tictactoe.models.enums.WinningStrategyTypes;
import com.project.tictactoe.models.players.Bot;
import com.project.tictactoe.models.players.Human;
import com.project.tictactoe.models.players.Player;
import com.project.tictactoe.strategies.winningStrategies.WinningStrategy;
import com.project.tictactoe.strategies.winningStrategies.WinningStrategyFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {

    public static void main(String[] args) {

//        SpringApplication.run(TicTacToeApplication.class, args);

        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        List<WinningStrategy> winningStrategyList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Give no of players");
        int playerCnt = sc.nextInt();

        for(int i=0;i<playerCnt;i++){
            System.out.println("Give Player" + (i+1) + "type: (Human/Bot)");
            String playerType = sc.next();
            if(playerType.equals("Bot")){
                System.out.println("Give Bot Symbol");
                char symbol = sc.next().charAt(0);
                System.out.println("Select Bot Difficulty Level: (EASY/MEDIUM/HARD)");
                String botDifficultyLevel = sc.next();
                players.add(new Bot("BOT", (i+1), new Symbol(symbol), PlayerType.BOT , BotDifficultyLevel.valueOf(botDifficultyLevel) ));
            }
            else if(playerType.equals("Human")){
                System.out.println("Give player Symbol");
                char symbol = sc.next().charAt(0);
                System.out.println("Select player name");
                String name = sc.next();
                players.add(new Human(name, (i+1) , new Symbol(symbol), PlayerType.HUMAN));
            }
            else
                throw new RuntimeException("Invalid Player type");
        }

        System.out.println("Select count of allowed winning strategies: (ROW/ COLUMN/ DIAGONAL/ CORNER)");
        int strategyCnt = sc.nextInt();

        System.out.println("Input the allowed winning strategies: (ROW/ COLUMN/ DIAGONAL/ CORNER)");
        for(int i=0;i<strategyCnt;i++){
            String strategy = sc.next();
            WinningStrategy winningStrategy = WinningStrategyFactory.getWinningStrategy(WinningStrategyTypes.valueOf(strategy));
            winningStrategyList.add(winningStrategy);
        }

        Game game = gameController.startGame(playerCnt+1 ,players, winningStrategyList );

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
