package com.example.banco;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    //TEXTFIELD
    @FXML //00128023 etiqueta del fxml
    private TextField tfNombre; //00128023 declaramos el texfield del nombre
    @FXML //00128023 etiqueta del fxml
    private TextField tfApellido; //00128023 declaramos el texfield del apellido
    @FXML //00128023 etiqueta del fxml
    private TextField tfClave; //00128023 declaramos el texfield de la clave
    @FXML //00128023 etiqueta del fxml
    private TextField tfClaveConfirma; //00128023 declaramos el texfield de la confirma de la clave
    @FXML //00128023 etiqueta del fxml
    private TextField tfDireccion; //00128023 declaramos el texfield de la direccion
    @FXML //00128023 etiqueta del fxml
    private TextField tfTelefono; //00128023 declaramos el texfield del telefono
    @FXML //00128023 etiqueta del fxml
    private TextField tfUsuario; //00128023 declaramos el texfield del usuario

    //LABEL
    @FXML //00128023 etiqueta del fxml
    private Label lblConfirma; //00128023 declaramos el label de la confirmacion de datos
    @FXML //00128023 etiqueta del fxml
    private Label lblConfirmaClave; //00128023 declaramos el label de la confirmacion de datos de la clave
    @FXML //00128023 etiqueta del fxml
    private Label lblConfirmaTelefono; //00128023 declaramos el label de la confirmacion de datos del numero telefonico
    @FXML //00128023 etiqueta del fxml
    private Label lblConfirmaNombre; //00128023 declaramos el label de la confirmacion de datos del nombre
    @FXML //00128023 etiqueta del fxml
    private Label lblConfirmaApellido; //00128023 declaramos el label de la confirmacion de datos del apellido

    //Botones
    @FXML
    private Button btnConfirma;
    @FXML
    private Button btnContinuar;


    @FXML //00128023 etiqueta del fxml
    protected boolean confirmaInicio() {
        boolean confirma;
        confirma = !tfClave.getText().isEmpty() &&
                !tfClaveConfirma.getText().isEmpty() &&
                !tfTelefono.getText().isEmpty() &&
                !tfNombre.getText().isEmpty() &&
                !tfDireccion.getText().isEmpty() &&
                !tfApellido.getText().isEmpty() &&
                !tfUsuario.getText().isEmpty();
        return confirma;
    }

    @FXML //00128023 etiqueta del fxml
    protected boolean soloNumeros() {
        boolean confirma = true;
        String text = tfTelefono.getText().trim();
        try {
            int key = Integer.parseInt(text);
            lblConfirmaTelefono.setVisible(false);
        } catch (NumberFormatException e) {
            confirma = false;
        }
        return confirma;
    }

    @FXML //00128023 etiqueta del fxml
    protected boolean soloLetras(String text) {
        boolean soloLetras = true;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            boolean letra = Character.isLetter(character);
            boolean espacio = character == ' ';
            if (!(letra || espacio)) {
                soloLetras = false;
                break;
            }
        }
        return soloLetras;
    }

    @FXML //00128023 etiqueta del fxml
    protected void confirma() {
        String nombre = "", apellido = "", direccion = "", clave = "", usuario = "";
        int telefono = 0;
        Cliente cliente = new Cliente(nombre, apellido, usuario, direccion, clave, telefono);
        if (!confirmaInicio()) {
            lblConfirmaClave.setVisible(false);
            lblConfirma.setVisible(true);
            lblConfirma.setText("*Faltan datos");
        } else {
            if (!soloLetras(tfNombre.getText().trim())) {
                lblConfirma.setVisible(false);
                lblConfirmaClave.setVisible(false);
                lblConfirmaApellido.setVisible(false);
                lblConfirmaTelefono.setVisible(false);

                lblConfirmaNombre.setVisible(true);
            } else if (!soloLetras(tfApellido.getText().trim())) {
                lblConfirma.setVisible(false);
                lblConfirmaClave.setVisible(false);
                lblConfirmaNombre.setVisible(false);
                lblConfirmaTelefono.setVisible(false);

                lblConfirmaApellido.setVisible(true);
            } else if (!tfClave.getText().equals(tfClaveConfirma.getText())) {
                lblConfirma.setVisible(false);
                lblConfirmaClave.setVisible(false);
                lblConfirmaNombre.setVisible(false);
                lblConfirmaApellido.setVisible(false);
                lblConfirmaTelefono.setVisible(false);

                lblConfirmaClave.setVisible(true);
            } else if ((tfTelefono.getText().length() > 8) || (tfTelefono.getText().length() < 8) || (!soloNumeros())) {
                lblConfirma.setVisible(false);
                lblConfirmaClave.setVisible(false);
                lblConfirmaNombre.setVisible(false);
                lblConfirmaApellido.setVisible(false);

                lblConfirmaTelefono.setVisible(true);
            } else {
                lblConfirmaClave.setVisible(false);
                lblConfirmaNombre.setVisible(false);
                lblConfirmaApellido.setVisible(false);
                lblConfirmaTelefono.setVisible(false);

                lblConfirma.setVisible(true);
                nombre = tfNombre.getText();
                cliente.setNombre(nombre);
                btnConfirma.setVisible(false);
                btnContinuar.setVisible(true);
            }

        }
    }

    @FXML
    protected void continuar() throws IOException {
        String nombre = tfUsuario.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) btnContinuar.getScene().getWindow();
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
    protected void limpiar() {
        tfDireccion.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        tfTelefono.setText("");
        tfClave.setText("");
        tfClaveConfirma.setText("");
        lblConfirma.setVisible(false);
        lblConfirmaClave.setVisible(false);
    }
}