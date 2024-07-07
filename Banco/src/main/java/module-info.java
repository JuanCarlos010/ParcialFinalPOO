module com.example.banco {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.swing;
    requires javafx.media;

    opens com.example.banco to javafx.fxml;
    exports com.example.banco;
}