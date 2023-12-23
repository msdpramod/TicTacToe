package com.example.tictactoe.Models;

import com.example.tictactoe.Strategies.winingstrategies.WiningStrategies;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Getter
@Setter
public class Game {
    private List<Move> moves;
    private Board board;
    List<Player> players;
    List<WiningStrategies> winingStrategies;
    private int currentPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;
    public static Builder getBuilder() {
        return new Builder();
    }
    public Game( int dimensions, List<Player> players,
                List<WiningStrategies> winingStrategies) {
        this.moves = new ArrayList<>();
        this.board = new Board(dimensions);
        this.players = players;
        this.winingStrategies = winingStrategies;
        this.currentPlayerIndex = 0;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winner = null;
    }
    public void printBoard() {
        this.board.print();
    }

    public void printResult() {
        if (gameStatus.equals(GameStatus.ENDED)) {
            System.out.println("Game has ended.");
            System.out.println("Winner is: " + winner.getName());
        } else {
            System.out.println("Game is draw");
        }
    }
    public void makeMove() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn.");


        Cell proposedCell = currentPlayer.makeMove(board);

        System.out.println("Move made at row: " + proposedCell.getRow() +
                " col: " + proposedCell.getCol() + ".");

        if (!validateMove(proposedCell)) {
            System.out.println("Invalid move. Retry.");
            return;
        }

        Cell cellInBoard = board.getBoard().get(proposedCell.getRow()).get(proposedCell.getCol());
        cellInBoard.setCellState(CellState.FILLED);
        cellInBoard.setPlayer(currentPlayer);

        Move move = new Move(currentPlayer, cellInBoard);
        moves.add(move);

        if (checkGameWon(currentPlayer, move)) return;

        if (checkDraw()) return;

        currentMovePlayerIndex += 1;
        currentMovePlayerIndex %= players.size();
    }
    public static class Builder {
        private int dimensions;
        private List<Player> players;
        private List<WiningStrategies> winingStrategies;

        private Builder() {
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWiningStrategies(List<WiningStrategies> winingStrategies) {
            this.winingStrategies = winingStrategies;
            return this;
        }
        private boolean validate() {
            if (this.players.size() < 2) {
                return false;
            }

            if (this.players.size() != this.dimensions - 1) {
                return false;
            }

            int botCount = 0;

            for (Player player: this.players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount ++;
                }
            }

            if (botCount >= 2) {
                return false;
            }

            Set<Character> existingSymbols = new HashSet<>();

            for (Player player: players) {
                if (existingSymbols.contains(player.getSymbol().getAChar())) {
                    return false;
                }

                existingSymbols.add(player.getSymbol().getAChar());
            }

            return true;
        }


        public Game build() {
            if (!validate()) {
                throw new RuntimeException("Invalid params for Game");
            }
            return new Game(dimensions, players, winingStrategies);
        }
    }

}
