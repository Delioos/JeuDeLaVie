package com.example.jeudelavie.Controller;

import com.example.jeudelavie.Modele.Board;
import com.example.jeudelavie.View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;

public class BtnCanonCTRL implements EventHandler<ActionEvent> {
    Board board;
    View view;
    String path;

    public BtnCanonCTRL(Board b, View v,String s){
        this.board = b;
        this.view = v;
        this.path = s;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            this.board.chargerCanon(this.path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.view.update();
    }
}
