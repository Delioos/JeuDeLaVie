package com.example.jeudelavie.Controller;

import com.example.jeudelavie.Modele.Board;
import com.example.jeudelavie.View.View;
import com.example.jeudelavie.Constantes;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseCTRL implements EventHandler<MouseEvent> {
    Board board;
    View view;

    public MouseCTRL(Board b, View v){
        this.board = b;
        this.view = v;
    }

    @Override
    public void handle(MouseEvent event) {
        int x =  (int) Math.floor(event.getX()/ Constantes.CASE_SIZE_X);
        int y =  (int) Math.floor(event.getY()/ Constantes.CASE_SIZE_Y);
        this.board.setGrid(x,y,!this.board.getGrid(x,y));
        this.view.update();
    }
}
