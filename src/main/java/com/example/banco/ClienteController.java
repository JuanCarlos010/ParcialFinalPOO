package com.example.banco;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClienteController {

    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidoField;
    @FXML
    private TextField usuarioField;
    @FXML
    private TextField direccionField;
    @FXML
    private TextField claveField;
    @FXML
    private TextField telefonoField;
    @FXML
    private TableView<Cliente> clienteTable;

    @FXML
    private void agregarCliente() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String usuario = usuarioField.getText();
        String direccion = direccionField.getText();
        String clave = claveField.getText();
        int telefono = Integer.parseInt(telefonoField.getText());

        Cliente cliente = new Cliente(nombre, apellido, usuario, direccion, clave, telefono);
        // Lógica para agregar el cliente a la base de datos
        // clienteTable.getItems().add(cliente); // Para agregar a la tabla en la UI
    }

    @FXML
    private void cargarClientes() {
        // Lógica para cargar los clientes desde la base de datos
    }
}
