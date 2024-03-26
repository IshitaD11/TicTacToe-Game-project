package com.project.tictactoe.models;

import com.project.tictactoe.models.enums.CellStatus;
import com.project.tictactoe.models.enums.GameState;
import com.project.tictactoe.models.enums.PlayerType;
import com.project.tictactoe.models.players.Player;
import com.project.tictactoe.strategies.winningStrategies.WinningStrategy;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@Builder
public class Game {
    private Board board;
    private List<Player> players;

    // for undo feature
    private List<Move> moves;

    private Player winner;
    private int nextPlayerIdx = 0;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;

    // adding validation
    public static class Builder{
        Board board;
        List<Player> players;
        List<WinningStrategy> winningStrategies;

        public Builder addSinglePlayer(Player player) {
            this.players.add(player);
            validatePlayers();
            return this;
        }

        public Builder addSingleStrategy(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        public Builder players(List<Player> players) {
            this.players = players;
            validatePlayers();
            return this;
        }

        void validatePlayers(){
            validatePlayersCount();
            validatePlayersSymbols();
            validateBotCount();
        }

        void validateBotCount(){
            int botCnt = 0;
            for(Player player:players){
                if(player.getPlayerType().equals(PlayerType.BOT))
                    botCnt++;
                if(botCnt>1)
                    throw new RuntimeException("More than 1 bot not allowed");
            }
        }

        void validatePlayersCount(){
            if(players.size()!=board.getBoardSize()-1)
                throw new RuntimeException("Player count is higher than allowed, as per board size!");
        }

        void validatePlayersSymbols(){
            HashSet<Symbol> playerSymbols = new HashSet<>();
            for (Player player : players) {
                if (!playerSymbols.contains(player.getSymbol()))
                    playerSymbols.add(player.getSymbol());
                else
                    throw new RuntimeException("Symbol already in use");
            }
        }


    }

    public void display(){
        board.displayBoard();
    }

    public boolean isValidMove(Move currentMove){
        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getCol();

        if(row<0 || row>=board.getBoardSize())
            return false;
        if(col<0 || col>=board.getBoardSize())
            return false;

        return board.getCells().get(row).get(col).getCellStatus().equals(CellStatus.EMPTY);
    }

    public void makeMove(){
        Player currentPlayer = players.get(nextPlayerIdx);
        System.out.println("This is " + currentPlayer.getName() + "'s turn");
        Move currentMove = currentPlayer.makeMove(board);
        if(!isValidMove(currentMove)){
            System.out.println("Invalid Move please retry");
            return;
        }
        else{
            Cell cellToChange = board.getCells().get(currentMove.getCell().getRow()).get(currentMove.getCell().getCol());
            cellToChange.setCellStatus(CellStatus.FILLED);
            cellToChange.setPlayer(currentPlayer);

            moves.add(currentMove);

            nextPlayerIdx = (nextPlayerIdx+1)%(players.size());

            if(checkWinner(currentPlayer,board)){
                winner = currentPlayer;
                gameState = GameState.COMPLETE;
            }
            //logic to get DRAW
            else if(moves.size() > board.getBoardSize()* board.getBoardSize()){
                gameState = GameState.DRAW;
            }
        }
    }

    public boolean checkWinner(Player currentPlayer,Board board){
        for(WinningStrategy winningStrategy:winningStrategies){
            if(winningStrategy.checkWinner(currentPlayer,board))
                return true;
        }
        return false;
    }

    // below code is for builder design pattern. Using @Builder instead
//    public Game(Builder builder){
//        this.board = builder.board;
//        this.players = builder.players;
//        this.moves = builder.moves;
//        this.winner = builder.winner;
//        this.nextPlayerIdx = builder.nextPlayerIdx;
//        this.gameState = builder.gameState;
//        this.winningStrategies = builder.winningStrategies;
//    }
//
//    public static Builder builder(){
//        return new Builder();
//    }
//
//    @Getter
//    public static class Builder{
//
//        Board board;
//        List<Player> players;
//
//        // for undo feature
//        List<Move> moves;
//
//        Player winner;
//        int nextPlayerIdx;
//        GameState gameState;
//        List<WinningStrategy> winningStrategies;
//
//
//        public Builder setBoard(Board board) {
//            this.board = board;
//            return this;
//        }
//
//        public Builder setPlayers(List<Player> players) {
//            this.players = players;
//            return this;
//        }
//
//        public Builder setMoves(List<Move> moves) {
//            this.moves = moves;
//            return this;
//        }
//
//        public Builder setWinner(Player winner) {
//            this.winner = winner;
//            return this;
//        }
//
//        public Builder setNextPlayerIdx(int nextPlayerIdx) {
//            this.nextPlayerIdx = nextPlayerIdx;
//            return this;
//        }
//
//        public Builder setGameState(GameState gameState) {
//            this.gameState = gameState;
//            return this;
//        }
//
//        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
//            this.winningStrategies = winningStrategies;
//            return this;
//        }
//
//        public Game build(){
//            return new Game(this);
//        }
//    }
}
