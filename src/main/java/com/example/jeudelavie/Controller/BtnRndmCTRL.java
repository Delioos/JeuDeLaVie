package com.example.jeudelavie.Controller;

import com.example.jeudelavie.Modele.Board;
import com.example.jeudelavie.View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BtnRndmCTRL implements EventHandler<ActionEvent> {
    Board board;
    View view;

    public BtnRndmCTRL(Board b, View v){
        this.board = b;
        this.view = v;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.board.random();
        this.view.update();
        this.view.requestFocus();
    }
}
