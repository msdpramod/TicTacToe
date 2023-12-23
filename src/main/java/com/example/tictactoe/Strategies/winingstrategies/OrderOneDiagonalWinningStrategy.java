package com.example.tictactoe.Strategies.winingstrategies;

import com.example.tictactoe.Models.Board;
import com.example.tictactoe.Models.Move;
import com.example.tictactoe.Models.Player;
import com.example.tictactoe.Models.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneDiagonalWinningStrategy implements WiningStrategies{
    private final Map<Symbol, Integer> leftDiagMap;
    private final Map<Symbol, Integer> rightDiagMap;

    public OrderOneDiagonalWinningStrategy(List<Player> players) {
        leftDiagMap = new HashMap<>();
        rightDiagMap = new HashMap<>();

        for (Player player: players) {
            leftDiagMap.put(player.getSymbol(), 0);
            rightDiagMap.put(player.getSymbol(), 0);
        }
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
