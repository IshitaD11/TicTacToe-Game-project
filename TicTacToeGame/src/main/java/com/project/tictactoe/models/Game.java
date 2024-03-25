package com.project.tictactoe.models;

import com.project.tictactoe.models.enums.GameState;
import com.project.tictactoe.models.players.Player;
import com.project.tictactoe.strategies.winningStrategies.WinningStrategy;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Game {
    Board board;
    List<Player> players;

    // for undo feature
    List<Move> moves;

    Player winner;
    int nextPlayerIdx;
    GameState gameState;
    List<WinningStrategy> winningStrategies;

    public Game(Builder builder){
        this.board = builder.board;
        this.players = builder.players;
        this.moves = builder.moves;
        this.winner = builder.winner;
        this.nextPlayerIdx = builder.nextPlayerIdx;
        this.gameState = builder.gameState;
        this.winningStrategies = builder.winningStrategies;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    @Getter
    public static class Builder{

        Board board;
        List<Player> players;

        // for undo feature
        List<Move> moves;

        Player winner;
        int nextPlayerIdx;
        GameState gameState;
        List<WinningStrategy> winningStrategies;


        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public Builder setWinner(Player winner) {
            this.winner = winner;
            return this;
        }

        public Builder setNextPlayerIdx(int nextPlayerIdx) {
            this.nextPlayerIdx = nextPlayerIdx;
            return this;
        }

        public Builder setGameState(GameState gameState) {
            this.gameState = gameState;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build(){
            return new Game(this);
        }
    }
}
