package com.example.tictactoe.Strategies.winingstrategies;

import com.example.tictactoe.Models.Board;
import com.example.tictactoe.Models.Move;
import com.example.tictactoe.Models.Player;
import com.example.tictactoe.Models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneColoumnWinningStrategy implements WiningStrategies{
    private List<Map<Symbol, Integer>> colMaps;

    public OrderOneColoumnWinningStrategy(int size, List<Player> players) {
        colMaps = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            colMaps.add(new HashMap<>());
            for (Player player: players) {
                colMaps.get(i).put(player.getSymbol(), 0);
            }
        }
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
