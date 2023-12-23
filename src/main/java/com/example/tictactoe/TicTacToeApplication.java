package com.example.tictactoe;

import com.example.tictactoe.Controllers.GameController;
import com.example.tictactoe.Models.*;
import com.example.tictactoe.Strategies.winingstrategies.OrderOneColoumnWinningStrategy;
import com.example.tictactoe.Strategies.winingstrategies.OrderOneDiagonalWinningStrategy;
import com.example.tictactoe.Strategies.winingstrategies.OrderOneRowWinningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {

    public static void main(String[] args) {
        //SpringApplication.run(TicTacToeApplication.class, args);
        // create a game
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        Game game = null;
        List<Player> players = List.of(
                new Player(new Symbol('X'), "Pramod", PlayerType.HUMAN),
                new Bot(new Symbol('O'), "sid", BotDifficultyLevel.EASY)
        );
        int dimensions = 3;
        try {
            game = gameController.createGame(
                    dimensions,
                    players,
                   List.of(
                           new OrderOneDiagonalWinningStrategy(players),
                           new OrderOneColoumnWinningStrategy(dimensions,players),
                           new OrderOneRowWinningStrategy(dimensions,players)
                   )
            );
        }
        catch (Exception e) {
            System.out.println("something went wrong");
        }
        //Game.Builder builder = new Game.Builder();
        while (gameController.gameStatus(game) .equals(GameStatus.IN_PROGRESS)) {
            gameController.DisplayBoard(game);
            System.out.println("Do you want to undo? (y/n)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                gameController.Undo(game);
            }
            else{
                gameController.makeMove(game);
            }
            //check status of game
            GameStatus gameStatus = gameController.gameStatus(game);
            gameController.printResult(game);

        }
    }


}
