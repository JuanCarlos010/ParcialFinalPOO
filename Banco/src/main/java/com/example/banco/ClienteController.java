package com.example.banco;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ClienteController {
    @FXML
    private TextField clienteIdField;
    @FXML
    private TextField startDateField;
    @FXML
    private TextField endDateField;

    @FXML private TextField nombreField;
    @FXML private TextField direccionField;
    @FXML private TextField telefonoField;
    @FXML private TableView<Cliente> clienteTable;
    @FXML private TableColumn<Cliente, Integer> idColumn;
    @FXML private TableColumn<Cliente, String> nombreColumn;
    @FXML private TableColumn<Cliente, String> direccionColumn;
    @FXML private TableColumn<Cliente, String> telefonoColumn;
    @FXML
    private TextField facilitadorField;

    @FXML
    private TableView<Transaccion> transaccionTable;
    @FXML
    private TableColumn<Transaccion, Integer> transaccionIdColumn;
    @FXML
    private TableColumn<Transaccion, String> fechaColumn;
    @FXML
    private TableColumn<Transaccion, Double> montoColumn;
    @FXML
    private TableColumn<Transaccion, String> descripcionColumn;
    @FXML
    private TableColumn<Transaccion, Integer> tarjetaIdColumn;
    @FXML
    private Label tarjetasLabel;

    private ClienteDAO clienteDAO = new ClienteDAO();

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        direccionColumn.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
        telefonoColumn.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
        loadClientes();
        transaccionIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        montoColumn.setCellValueFactory(new PropertyValueFactory<>("monto"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tarjetaIdColumn.setCellValueFactory(new PropertyValueFactory<>("tarjetaId"));
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
    @FXML
    private void handleBuscarTransacciones() {
        try {
            if (clienteIdField.getText().isEmpty() || startDateField.getText().isEmpty() || endDateField.getText().isEmpty()) {
                showAlert("Error", "Todos los campos deben ser llenados", AlertType.ERROR);
                return;
            }

            int clienteId = Integer.parseInt(clienteIdField.getText());
            Date startDate = Date.valueOf(startDateField.getText());
            Date endDate = Date.valueOf(endDateField.getText());

            TransaccionDAO transaccionDAO = new TransaccionDAO();
            List<Transaccion> transacciones = transaccionDAO.getTransaccionesByClienteIdAndDateRange(clienteId, startDate, endDate);

            ObservableList<Transaccion> transaccionList = FXCollections.observableArrayList(transacciones);
            transaccionTable.setItems(transaccionList);

        } catch (NumberFormatException e) {
            showAlert("Error", "El ID del cliente debe ser un número válido", AlertType.ERROR);
        } catch (IllegalArgumentException e) {
            showAlert("Error", "Las fechas deben estar en el formato YYYY-MM-DD", AlertType.ERROR);
        }
    }
    @FXML
    private void handleMostrarTarjetas() {
        try {
            if (clienteIdField.getText().isEmpty()) {
                showAlert("Error", "El campo de ID del cliente debe ser llenado", AlertType.ERROR);
                return;
            }

            int clienteId = Integer.parseInt(clienteIdField.getText());

            TransaccionDAO transaccionDAO = new TransaccionDAO();
            List<Tarjeta> tarjetas = TarjetaDAO.getTarjetasByClienteId(clienteId);

            StringBuilder sb = new StringBuilder();
            for (Tarjeta tarjeta : tarjetas) {
                String numeroCensurado = censurarNumeroTarjeta(tarjeta.getNumero());
                sb.append("Tarjeta ID: ").append(tarjeta.getId())
                        .append(", Número: ").append(numeroCensurado).append("\n");
            }
            tarjetasLabel.setText(sb.toString());

        } catch (NumberFormatException e) {
            showAlert("Error", "El ID del cliente debe ser un número válido", AlertType.ERROR);
        }
    }

    private String censurarNumeroTarjeta(String numero) {
        if (numero.length() < 4) {
            return "****";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numero.length() - 4; i++) {
            sb.append("*");
        }
        sb.append(numero.substring(numero.length() - 4));
        return sb.toString();
    }

    @FXML
    private void handleGenerarReporte() {
        try {
            if (facilitadorField.getText().isEmpty()) {
                showAlert("Error", "El campo de facilitador debe ser llenado", AlertType.ERROR);
                return;
            }

            String facilitador = facilitadorField.getText();
            TransaccionDAO transaccionDAO = new TransaccionDAO();
            List<ClienteReporte> reportes = transaccionDAO.getClientesPorFacilitador(facilitador);

            String reporteContenido = generarReporteContenido(reportes);
            guardarReporte(reporteContenido);

            showAlert("Éxito", "Reporte generado correctamente", AlertType.INFORMATION);

        } catch (IOException e) {
            showAlert("Error", "Hubo un error al generar el reporte", AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private String generarReporteContenido(List<ClienteReporte> reportes) {
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte de Clientes por Facilitador de Tarjeta\n");
        sb.append("===========================================\n");
        for (ClienteReporte reporte : reportes) {
            sb.append("Cliente ID: ").append(reporte.getClienteId())
                    .append(", Nombre: ").append(reporte.getNombre())
                    .append(", Compras: ").append(reporte.getCantidadCompras())
                    .append(", Total Gastado: ").append(reporte.getTotalGastado())
                    .append("\n");
        }
        return sb.toString();
    }

    private void guardarReporte(String contenido) throws IOException {
        String directorio = "Reportes";
        if (!Files.exists(Paths.get(directorio))) {
            Files.createDirectory(Paths.get(directorio));
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String nombreArchivo = directorio + "/Reporte_" + timestamp + ".txt";
        Files.write(Paths.get(nombreArchivo), contenido.getBytes(), StandardOpenOption.CREATE);
    }

    @FXML
    private void handleLimpiarCampos() {
        clienteIdField.clear();
        startDateField.clear();
        endDateField.clear();
    }
    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


