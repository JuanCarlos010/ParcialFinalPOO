package com.example.banco;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AdminController {
    @FXML
    private Label lblNombre;
    @FXML
    protected void setNombre(String nombre) {
        lblNombre.setText(nombre);
    }


}
