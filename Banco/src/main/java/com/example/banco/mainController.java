package com.example.banco;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Objects;
import java.util.Random;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class mainController {
    //Label
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblNumCuenta;
    @FXML
    private Label lblConfirma;
    //Textfield
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfConstraseña;
    @FXML
    private TextField tfCodigo;
    //Boton
    @FXML
    private Button btnRegistro;
    @FXML
    private Button btnLogin;

    @FXML
    protected void setNombre(String nombre) {
        lblNombre.setText(nombre);
    }

    @FXML
    protected void NumeroCuenta() {
        String numCuenta = "", guion = "-";
        Random x = new Random();

        for (int i = 0; i < 4; i++) {
            numCuenta += x.nextInt(10);
        }
        numCuenta += guion;
        for (int i = 0; i < 4; i++) {
            numCuenta += x.nextInt(10);
        }
        numCuenta += guion;
        for (int i = 0; i < 4; i++) {
            numCuenta += x.nextInt(10);
        }

        lblNumCuenta.setText(numCuenta);
    }

    @FXML
    protected void confirmaRegistro() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) btnRegistro.getScene().getWindow();
        currentStage.close();

        Stage newStage = new Stage();
        Scene scene = new Scene(root, 600, 400); // Establecer las dimensiones
        newStage.setScene(scene);
        newStage.setTitle("Login");
        newStage.show();
    }

    @FXML
    protected void confirmarLogin() throws IOException {
        String adminNombre = "Chory";
        String adminClave = "123";

        String nombre = "", apellido = "", direccion = "", clave = ""; //00128023 iniciamos las variables tipo String para la clase cliente
        int telefono = 0; //00128023 iniciamos las variables tipo int para la clase cliente
        Cliente cliente = new Cliente(nombre, apellido, direccion, clave, telefono); //00128023 creamos a nuestro cliente

        if ((Objects.equals(tfNombre.getText(), "")) &&
                (Objects.equals(tfConstraseña.getText(), "")) &&
                (Objects.equals(tfCodigo.getText(), ""))) {
            lblConfirma.setText("No puede dejar espacios vacios");
        } else if (Objects.equals(tfNombre.getText(), adminNombre) && Objects.equals(tfConstraseña.getText(), adminClave) && (Objects.equals(tfCodigo.getText(), "0935"))) {
            menuAdmin();
        } else if (Objects.equals(tfNombre.getText(), cliente.getNombre()) && Objects.equals(tfConstraseña.getText(), cliente.getClave()) && Objects.equals(tfCodigo.getText(), "0115")) {
            menuCliente();
        }  else {
            lblConfirma.setText("Ningún usuario con esas credenciales");
        }
    }


    @FXML
    protected void menuCliente() throws IOException {
        String nombre = tfNombre.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) btnLogin.getScene().getWindow();
        currentStage.close();

        mainController mainController = loader.getController();
        mainController.setNombre(nombre);
        mainController.NumeroCuenta();

        Stage newStage = new Stage();
        Scene scene = new Scene(root, 600, 400); // Establecer las dimensiones
        newStage.setScene(scene);
        newStage.setTitle("Main View");
        newStage.show();
    }

    @FXML
    protected void menuAdmin() throws IOException {
        String nombre = tfNombre.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin-view.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) btnLogin.getScene().getWindow();
        currentStage.close();

        AdminController adminController = loader.getController();
        adminController.setNombre(nombre);

        Stage newStage = new Stage();
        Scene scene = new Scene(root, 600, 400); // Establecer las dimensiones
        newStage.setScene(scene);
        newStage.setTitle("Admin View");
        newStage.show();
    }
}
