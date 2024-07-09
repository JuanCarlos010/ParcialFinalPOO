package com.example.banco;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Random;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class mainController {
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblNumCuenta;

    @FXML
    protected void setNombre(String nombre) {
        lblNombre.setText(nombre);
    }

    @FXML
    protected void NumeroCuenta(){
        String numCuenta = "", guion = "-";
        Random x = new Random();

        for (int i = 0; i < 4; i++){
            numCuenta += x.nextInt(10);
        }
        numCuenta += guion;
        for (int i = 0; i < 4; i++){
            numCuenta += x.nextInt(10);
        }
        numCuenta += guion;
        for (int i = 0; i < 4; i++){
            numCuenta += x.nextInt(10);
        }

        lblNumCuenta.setText(numCuenta);
    }
}
