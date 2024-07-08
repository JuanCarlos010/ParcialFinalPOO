package com.example.banco;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainTTController {

    @FXML
    private TextField numeroTarjetaField;
    @FXML
    private TextField fechaExpiracionField;
    @FXML
    private TextField tipoField;
    @FXML
    private TextField facilitadorField;
    @FXML
    private TextField clienteUsuarioField;
    @FXML
    private TableView<Tarjeta> tarjetaTable;

    @FXML
    private TextField fechaField;
    @FXML
    private TextField montoField;
    @FXML
    private TextField descripcionField;
    @FXML
    private TextField tarjetaNumeroField;
    @FXML
    private TableView<Transaccion> transaccionTable;

    @FXML
    private void agregarTarjeta() {
        String numeroTarjeta = numeroTarjetaField.getText();
        String fechaExpiracion = fechaExpiracionField.getText();
        String tipo = tipoField.getText();
        String facilitador = facilitadorField.getText();
        String clienteUsuario = clienteUsuarioField.getText();

        Tarjeta tarjeta = new Tarjeta(numeroTarjeta, fechaExpiracion, tipo, facilitador, clienteUsuario);
    }

    @FXML
    private void cargarTarjetas() {
        // Lógica para cargar las tarjetas desde la base de datos
    }

    @FXML
    private void agregarTransaccion() {
        String fecha = fechaField.getText();
        double monto = Double.parseDouble(montoField.getText());
        String descripcion = descripcionField.getText();
        String tarjetaNumero = tarjetaNumeroField.getText();

        Transaccion transaccion = new Transaccion(fecha, monto, descripcion, tarjetaNumero);
        // Lógica para agregar la transacción a la base de datos
        // transaccionTable.getItems().add(transaccion); // Para agregar a la tabla en la UI
    }

    @FXML
    private void cargarTransacciones() {
        // Lógica para cargar las transacciones desde la base de datos
    }
}
