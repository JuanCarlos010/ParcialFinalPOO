package com.example.banco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application { // 00056122 define la clase principal de la aplicacion
    @Override
    public void start(Stage stage) throws IOException { // 00056122 inicia la aplicacion JavaFX
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cliente-view.fxml")); // 00056122 carga el archivo FXML
        Scene scene = new Scene(fxmlLoader.load(), 890, 500); // 00056122 crea una nueva escena
        stage.setTitle("Hello!"); // 00056122 establece el titulo de la ventana
        stage.setScene(scene); // 00056122 asigna la escena a la ventana
        stage.show(); // 00056122 muestra la ventana
    }

    public static void main(String[] args) { // 00056122 metodo principal que lanza la aplicacion
        launch(); // 00056122 lanza la aplicacion JavaFX

    }
}
