module com.example.jeudelavie {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jeudelavie to javafx.fxml;
    exports com.example.jeudelavie;
}