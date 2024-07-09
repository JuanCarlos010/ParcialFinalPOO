package com.example.banco;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClienteController {
    @FXML private TextField nombreField;
    @FXML private TextField direccionField;
    @FXML private TextField telefonoField;
    @FXML private TableView<Cliente> clienteTable;
    @FXML private TableColumn<Cliente, Integer> idColumn;
    @FXML private TableColumn<Cliente, String> nombreColumn;
    @FXML private TableColumn<Cliente, String> direccionColumn;
    @FXML private TableColumn<Cliente, String> telefonoColumn;

    private ClienteDAO clienteDAO = new ClienteDAO();

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        direccionColumn.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
        telefonoColumn.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
        loadClientes();
    }

    private void loadClientes() {
        clienteTable.getItems().setAll(clienteDAO.getAllClientes());
    }

    @FXML
    private void handleAgregarCliente() {
        String nombre = nombreField.getText();
        String direccion = direccionField.getText();
        String telefono = telefonoField.getText();
        clienteDAO.addCliente(new Cliente(nombre, direccion, telefono));
        loadClientes();
    }
}


