package com.example.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Board {
    private int Size;
    private List<List<Cell>>Board;

    public Board(int size) {
        Size = size;
        Board = new ArrayList<>();
        for (int i=0;i<size;++i){
            Board.add(new ArrayList<>());
            for (int j=0;j<size;++j){
                Board.get(i).add(new Cell(i,j));
            }
        }
    }
    public void print(){
        for (List<Cell> row:Board){
            System.out.println("|");
            for (Cell cell:row){
                cell.display();
            }
            System.out.println();
        }
    }
}
