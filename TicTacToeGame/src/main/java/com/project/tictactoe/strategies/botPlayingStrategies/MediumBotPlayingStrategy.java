package com.project.tictactoe.strategies.botPlayingStrategies;

import com.project.tictactoe.models.Cell;
import com.project.tictactoe.models.Game;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.players.Bot;
import com.project.tictactoe.models.players.Player;
import com.project.tictactoe.strategies.winningStrategies.WinningStrategy;

import java.util.List;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Game game, Bot bot) {
        List<Player> players = game.getPlayers();
        for(Player player:players){
            if(!player.equals(bot)){
                List<WinningStrategy> strategies = game.getWinningStrategies();
                for(WinningStrategy strategy:strategies){
                    Cell possibleCellToPlay = strategy.checkPossibleMove(player,game.getBoard());
                    if(possibleCellToPlay!=null)
                        return new Move(possibleCellToPlay,bot);
                }
            }
        }
        EasyBotPlayingStrategy easyPlay = new EasyBotPlayingStrategy();
        return easyPlay.makeMove(game,bot);
    }
}
