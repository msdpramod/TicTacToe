package com.example.tictactoe.Controllers;

import com.example.tictactoe.Models.Game;
import com.example.tictactoe.Models.GameStatus;
import com.example.tictactoe.Models.Player;
import com.example.tictactoe.Strategies.winingstrategies.WiningStrategies;

import java.util.List;

public class GameController {
    public Game createGame (int dimensions, List<Player> players,
                          List<WiningStrategies> winingStrategies) {
        return Game.getBuilder()
                .setDimensions(dimensions)
                .setPlayers(players)
                .setWiningStrategies(winingStrategies)
                .build();

    }
    public void DisplayBoard(Game game){

    }
    public void Undo(Game game){

    }
    public void makeMove(Game game) {

    }
    public GameStatus gameStatus(Game game) {
        return game.getGameStatus();
    }
    public void printResult(Game game) {

    }


}   
