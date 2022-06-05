package com.example.jeudelavie;

import Modele.Board;

public class ModelTest {
    public static void main(String[] args) {
        Board board = new Board(10,10);
        System.out.println(board);

        //creation d'un modele
        for (int i = 0; i < 3; i++) {
            board.setGrid(i+5,5,true);
        }
        System.out.println(board);

        //test de la methode simulant un eiteration
        board.evolve();
        System.out.println(board);

        board.evolve();
        System.out.println(board);
    }
}
