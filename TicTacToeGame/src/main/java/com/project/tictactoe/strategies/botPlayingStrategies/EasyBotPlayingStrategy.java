package com.project.tictactoe.strategies.botPlayingStrategies;

import com.project.tictactoe.models.Board;
import com.project.tictactoe.models.Cell;
import com.project.tictactoe.models.Game;
import com.project.tictactoe.models.Move;
import com.project.tictactoe.models.enums.CellStatus;
import com.project.tictactoe.models.players.Bot;


public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Game game, Bot bot) {
        Board board = game.getBoard();
        // check the first empty cell
        for(int i=0;i< board.getBoardSize();i++){
            for(int j=0;j< board.getBoardSize();j++){
                if(board.getCells().get(i).get(j).getCellStatus().equals(CellStatus.EMPTY)){
                    return new Move(new Cell(i,j), bot);
                }
            }
        }
        return null;
    }
}
