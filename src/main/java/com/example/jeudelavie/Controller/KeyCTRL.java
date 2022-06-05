package com.example.jeudelavie.Controller;

import com.example.jeudelavie.Modele.Board;
import com.example.jeudelavie.View.View;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyCTRL implements EventHandler<KeyEvent> {
    Board board;
    View view;

    public KeyCTRL(Board b, View v){
        this.board = b;
        this.view = v;
    }
    @Override
    public void handle(KeyEvent event) {
        switch(event.getCode()){
            case SPACE,ENTER -> this.board.evolve();
            case R -> this.board.clear();
        }
        this.view.update();
    }
}
