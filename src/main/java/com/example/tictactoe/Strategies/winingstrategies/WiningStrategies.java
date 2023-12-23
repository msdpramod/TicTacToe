package com.example.tictactoe.Strategies.winingstrategies;

import com.example.tictactoe.Models.Board;
import com.example.tictactoe.Models.Move;

public interface WiningStrategies {
    boolean checkWinner(Board board, Move move);
}
