package com.example.banco;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClienteController { // 00056122 Declaracion de la clase ClienteController
    @FXML private TextField nombreField; // 00056122 Campo de texto para el nombre
    @FXML private TextField direccionField; // 00056122 Campo de texto para la direccion
    @FXML private TextField telefonoField; // 00056122 Campo de texto para el telefono
    @FXML private TableView<Cliente> clienteTable; // 00056122 Tabla para mostrar los clientes
    @FXML private TableColumn<Cliente, Integer> idColumn; // 00056122 Columna para el ID del cliente
    @FXML private TableColumn<Cliente, String> nombreColumn; // 00056122 Columna para el nombre del cliente
    @FXML private TableColumn<Cliente, String> direccionColumn; // 00056122 Columna para la direccion del cliente
    @FXML private TableColumn<Cliente, String> telefonoColumn; // 00056122 Columna para el telefono del cliente

    private ClienteDAO clienteDAO = new ClienteDAO(); // 00056122 Instancia de ClienteDAO para operaciones con la base de datos

    @FXML // 00056122 Metodo anotado con FXML para inicializacion
    private void initialize() { // 00056122 Metodo para inicializar la tabla y cargar datos
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject()); // 00056122 Configura la columna ID
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty()); // 00056122 Configura la columna Nombre
        direccionColumn.setCellValueFactory(cellData -> cellData.getValue().direccionProperty()); // 00056122 Configura la columna Direccion
        telefonoColumn.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty()); // 00056122 Configura la columna Telefono
        loadClientes(); // 00056122 Carga los clientes en la tabla
    }

    private void loadClientes() { // 00056122 Metodo para cargar los clientes desde la base de datos
        clienteTable.getItems().setAll(clienteDAO.getAllClientes()); // 00056122 Obtiene todos los clientes y los coloca en la tabla
    }

    @FXML // 00056122 Metodo anotado con FXML para manejar el evento de agregar cliente
    private void handleAgregarCliente() { // 00056122 Metodo para agregar un nuevo cliente
        String nombre = nombreField.getText(); // 00056122 Obtiene el nombre del campo de texto
        String direccion = direccionField.getText(); // 00056122 Obtiene la direccion del campo de texto
        String telefono = telefonoField.getText(); // 00056122 Obtiene el telefono del campo de texto
        clienteDAO.addCliente(new Cliente(nombre, direccion, telefono)); // 00056122 Agrega el nuevo cliente a la base de datos
        loadClientes(); // 00056122 Recarga los clientes en la tabla
    }
}
