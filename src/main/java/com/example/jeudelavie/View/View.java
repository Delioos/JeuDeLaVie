package com.example.jeudelavie.View;

import com.example.jeudelavie.Controller.BtnCanonCTRL;
import com.example.jeudelavie.Controller.BtnRndmCTRL;
import com.example.jeudelavie.Modele.Board;
import com.example.jeudelavie.Constantes;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class View extends BorderPane {
    private final Board board;
    private Rectangle[][] cases;
    private Label lbl;
    private GridPane gp;
    private HBox hb;

    public View(Board b){
        this.board = b;
        initGrid();
        initInfoBox();
    }

    public void initGrid(){
        this.gp = new GridPane();
        this.setCenter(gp);
        cases = new Rectangle[Constantes.NB_CASES_X][Constantes.NB_CASES_Y];
        for (int i = 0; i < this.board.getXlength(); i++) {
            for (int j = 0; j < this.board.getYlength(); j++) {
                Rectangle r = new Rectangle(Constantes.CASE_SIZE_X,Constantes.CASE_SIZE_Y);
                r.setFill(Color.WHITE);
                this.gp.add(r,i,j);
                cases[i][j] = r;
            }
        }
    }

    public void initInfoBox(){
        lbl = new Label("nb evol: 0");
        lbl.setAlignment(Pos.CENTER_LEFT);
        hb = new HBox();
        hb.setSpacing(10);
        this.setBottom(hb);

        Button random = new Button("randomize");
        random.setOnAction(new BtnRndmCTRL(this.board,this));
        random.setMinHeight(Constantes.BUTTON_SIZE);
        Button gosperGliderGun = new Button("Gosper Glider Gun");
        gosperGliderGun.setOnAction(new BtnCanonCTRL(this.board,this, "D:\\Users\\Utilisateur\\Documents\\GitHub\\JeuDeLaVie\\resources\\canonGosper.txt"));
        gosperGliderGun.setMinHeight(Constantes.BUTTON_SIZE);
        Button simkinGliderGun = new Button("Simkin Glider Gun");
        simkinGliderGun.setOnAction(new BtnCanonCTRL(this.board,this, "D:\\Users\\Utilisateur\\Documents\\GitHub\\JeuDeLaVie\\resources\\SimkinGliderGun.txt"));
        simkinGliderGun.setMinHeight(Constantes.BUTTON_SIZE);
        hb.getChildren().addAll(lbl,random,gosperGliderGun,simkinGliderGun);

    }
    public void update(){
        for (int i = 0; i < this.board.getXlength(); i++) {
            for (int j = 0; j < this.board.getYlength(); j++) {
                if(this.board.getGrid(i,j))
                    cases[i][j].setFill(Color.BLACK);
                else
                    cases[i][j].setFill(Color.WHITE);
            }
        }
        this.lbl.setText("nb evol: " + this.board.getNbIter());
    this.requestFocus();
    }
}
