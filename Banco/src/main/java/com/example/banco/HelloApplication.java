package com.example.banco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application { //00128023 Clase principal que extiende de application para una aplicación con JavaFX

    @Override
    public void start(Stage stage) throws IOException { //00128023 Metodo que inicia la aplicación JavaFX
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cliente-view.fxml")); // 00128023 Carga el archivo cliente-view.fxml usando FXMLLoader
        Scene scene = new Scene(fxmlLoader.load(), 890, 500); //00128023 Crea una nueva escena con el contenido cargado desde el archivo FXML
        stage.setTitle("Hello!"); //00128023 Establece el título de la ventana
        stage.setScene(scene); //  00128023 Establece la escena en el escenario (stage)
        stage.show(); // 00128023 Muestra la ventana
    }

    public static void main(String[] args) { //00128023 metodo principal que inicia la aplicación JavaFX
        launch(); //00128023 Lanza la aplicación JavaFX
    }
}
