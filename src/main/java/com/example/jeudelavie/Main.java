package com.example.jeudelavie;

import com.example.jeudelavie.Controller.KeyCTRL;
import com.example.jeudelavie.Controller.MouseCTRL;
import com.example.jeudelavie.Modele.Board;
import com.example.jeudelavie.View.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Board model = new Board(Constantes.NB_CASES_X,Constantes.NB_CASES_Y);
        View root = new View(model);

        Scene scene = new Scene(root,Constantes.WIDTH,Constantes.HEIGHT+Constantes.BUTTON_SIZE);
        scene.setOnKeyPressed(new KeyCTRL(model,root));
        scene.setOnMousePressed(new MouseCTRL(model,root));
        stage.setScene(scene);
        stage.setTitle("Jeu de la vie - Conway");
        stage.show();
    }
}
