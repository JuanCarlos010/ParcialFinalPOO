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


public class ClienteController { // 00211723 define la clase controladora del cliente
    @FXML private TextField clienteIdField; // 00211723 campo de texto para el ID del cliente
    @FXML private TextField startDateField; // 00211723 campo de texto para la fecha de inicio
    @FXML private TextField endDateField; // 00211723 campo de texto para la fecha final
    @FXML private TextField nombreField; // 00211723 campo de texto para el nombre
    @FXML private TextField direccionField; // 00211723 campo de texto para la direccion
    @FXML private TextField telefonoField; // 00211723 campo de texto para el telefono
    @FXML private TableView<Cliente> clienteTable; // 00211723 tabla para mostrar clientes
    @FXML private TableColumn<Cliente, Integer> idColumn; // 00211723 columna para el ID del cliente
    @FXML private TableColumn<Cliente, String> nombreColumn; // 00211723 columna para el nombre del cliente
    @FXML private TableColumn<Cliente, String> direccionColumn; // 00211723 columna para la direccion del cliente
    @FXML private TableColumn<Cliente, String> telefonoColumn; // 00211723 columna para el telefono del cliente
    @FXML private TextField facilitadorField; // 00211723 campo de texto para el facilitador
    @FXML private TableView<Transaccion> transaccionTable; // 00211723 tabla para mostrar transacciones
    @FXML private TableColumn<Transaccion, Integer> transaccionIdColumn; // 00211723 columna para el ID de la transaccion
    @FXML private TableColumn<Transaccion, String> fechaColumn; // 00211723 columna para la fecha de la transaccion
    @FXML private TableColumn<Transaccion, Double> montoColumn; // 00211723 columna para el monto de la transaccion
    @FXML private TableColumn<Transaccion, String> descripcionColumn; // 00211723 columna para la descripcion de la transaccion
    @FXML private TableColumn<Transaccion, Integer> tarjetaIdColumn; // 00211723 columna para el ID de la tarjeta
    @FXML private Label tarjetasLabel; // 00211723 etiqueta para mostrar tarjetas

    private ClienteDAO clienteDAO = new ClienteDAO(); // 00211723 instancia de ClienteDAO

    @FXML private void initialize() { // 00211723 inicializa la interfaz
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject()); // 00211723 establece la propiedad ID
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty()); // 00211723 establece la propiedad nombre
        direccionColumn.setCellValueFactory(cellData -> cellData.getValue().direccionProperty()); // 00211723 establece la propiedad direccion
        telefonoColumn.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty()); // 00211723 establece la propiedad telefono
        loadClientes(); // 00211723 carga los clientes en la tabla
        transaccionIdColumn.setCellValueFactory(new PropertyValueFactory<>("id")); // 00211723 establece la propiedad ID de transaccion
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha")); // 00211723establece la propiedad fecha
        montoColumn.setCellValueFactory(new PropertyValueFactory<>("monto")); // 00211723 establece la propiedad monto
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcion")); // 00211723 establece la propiedad descripcion
        tarjetaIdColumn.setCellValueFactory(new PropertyValueFactory<>("tarjetaId")); // 00211723 establece la propiedad ID de tarjeta
    }

    private void loadClientes() { //  00211723 carga los clientes en la tabla
        clienteTable.getItems().setAll(clienteDAO.getAllClientes()); //  00211723obtiene y establece todos los clientes
    }

    @FXML private void handleAgregarCliente() { //  00211723 maneja la accion de agregar cliente
        String nombre = nombreField.getText(); //  00211723 obtiene el nombre del campo de texto
        String direccion = direccionField.getText(); //  00211723 obtiene la direccion del campo de texto
        String telefono = telefonoField.getText(); //  00211723 obtiene el telefono del campo de texto
        clienteDAO.addCliente(new Cliente(nombre, direccion, telefono)); // 00211723agrega un nuevo cliente
        loadClientes(); //  00211723 recarga la tabla de clientes
    }

    @FXML private void handleBuscarTransacciones() { //  00211723 maneja la busqueda de transacciones
        try {
            if (clienteIdField.getText().isEmpty() || startDateField.getText().isEmpty() || endDateField.getText().isEmpty()) { //  00211723 verifica campos vacios
                showAlert("Error", "Todos los campos deben ser llenados", AlertType.ERROR); //  00211723 muestra alerta de error
                return;
            }
            int clienteId = Integer.parseInt(clienteIdField.getText()); //  00211723 obtiene y convierte el ID del cliente
            Date startDate = Date.valueOf(startDateField.getText()); //  00211723 obtiene y convierte la fecha de inicio
            Date endDate = Date.valueOf(endDateField.getText()); //  00211723 obtiene y convierte la fecha final
            TransaccionDAO transaccionDAO = new TransaccionDAO(); //  00211723 instancia TransaccionDAO
            List<Transaccion> transacciones = transaccionDAO.getTransaccionesByClienteIdAndDateRange(clienteId, startDate, endDate); //  00211723 obtiene las transacciones
            ObservableList<Transaccion> transaccionList = FXCollections.observableArrayList(transacciones); //  00211723 crea lista observable
            transaccionTable.setItems(transaccionList); //  00211723 establece items en la tabla de transacciones
        } catch (NumberFormatException e) { //  00211723maneja excepcion de formato de numero
            showAlert("Error", "El ID del cliente debe ser un numero valido", AlertType.ERROR); //  00211723 muestra alerta de error
        } catch (IllegalArgumentException e) { //  00211723 maneja excepcion de argumento ilegal
            showAlert("Error", "Las fechas deben estar en el formato YYYY-MM-DD", AlertType.ERROR); //  00211723 muestra alerta de error
        }
    }

    @FXML private void handleMostrarTarjetas() { //  00211723maneja la muestra de tarjetas
        try {
            if (clienteIdField.getText().isEmpty()) { //  00211723 verifica campo de ID vacio
                showAlert("Error", "El campo de ID del cliente debe ser llenado", AlertType.ERROR); //  00211723 muestra alerta de error
                return;
            }
            int clienteId = Integer.parseInt(clienteIdField.getText()); //  00211723 obtiene y convierte el ID del cliente
            TransaccionDAO transaccionDAO = new TransaccionDAO(); //  00211723 instancia TransaccionDAO
            List<Tarjeta> tarjetas = TarjetaDAO.getTarjetasByClienteId(clienteId); //  00211723 obtiene tarjetas por ID de cliente
            StringBuilder sb = new StringBuilder(); //  00211723 crea un StringBuilder
            for (Tarjeta tarjeta : tarjetas) { //  00211723 itera sobre las tarjetas
                String numeroCensurado = censurarNumeroTarjeta(tarjeta.getNumero()); //  00211723 censura el numero de la tarjeta
                sb.append("Tarjeta ID: ").append(tarjeta.getId()).append(", Numero: ").append(numeroCensurado).append("\n"); //  00211723 agrega informacion de la tarjeta al StringBuilder
            }
            tarjetasLabel.setText(sb.toString()); //  00211723 establece el texto de la etiqueta con las tarjetas
        } catch (NumberFormatException e) { //  00211723 maneja excepcion de formato de numero
            showAlert("Error", "El ID del cliente debe ser un numero valido", AlertType.ERROR); //  00211723 muestra alerta de error
        }
    }

    private String censurarNumeroTarjeta(String numero) { //  00211723censura el numero de la tarjeta
        if (numero.length() < 4) { //  00211723 verifica si el numero es menor a 4 caracteres
            return "**"; //  00211723 retorna asteriscos
        }
        StringBuilder sb = new StringBuilder(); //  00211723crea un StringBuilder
        for (int i = 0; i < numero.length() - 4; i++) { //  00211723 itera sobre los caracteres del numero
            sb.append("*"); //  00211723agrega un asterisco por cada caracter
        }
        sb.append(numero.substring(numero.length() - 4)); //  00211723 agrega los ultimos 4 caracteres del numero
        return sb.toString(); //  00211723retorna el numero censurado
    }

    @FXML private void handleGenerarReporte() { // 00056122 maneja la generacion de reportes
        try {
            if (facilitadorField.getText().isEmpty()) { // 00056122 verifica campo de facilitador vacio
                showAlert("Error", "El campo de facilitador debe ser llenado", AlertType.ERROR); // 00056122 muestra alerta de error
                return;
            }
            String facilitador = facilitadorField.getText(); // 00056122 obtiene el facilitador del campo de texto
            TransaccionDAO transaccionDAO = new TransaccionDAO(); // 00056122 instancia TransaccionDAO
            List<ClienteReporte> reportes = transaccionDAO.getClientesPorFacilitador(facilitador); // 00056122 obtiene reportes por facilitador
            String reporteContenido = generarReporteContenido(reportes); // 00056122 genera el contenido del reporte
            guardarReporte(reporteContenido); // 00056122 guarda el reporte
            showAlert("Exito", "Reporte generado correctamente", AlertType.INFORMATION); // 00056122 muestra alerta de exito
        } catch (IOException e) { // 00056122 maneja excepcion de IO
            showAlert("Error", "Hubo un error al generar el reporte", AlertType.ERROR); // 00056122 muestra alerta de error
            e.printStackTrace(); // 00056122 imprime la pila de excepciones
        }
    }

    private String generarReporteContenido(List<ClienteReporte> reportes) { // 00056122 genera el contenido del reporte
        StringBuilder sb = new StringBuilder(); // 00056122 crea un StringBuilder
        sb.append("Reporte de Clientes por Facilitador de Tarjeta\n"); // 00056122 agrega el titulo del reporte
        sb.append("===========================================\n"); // 00056122 agrega una linea separadora
        for (ClienteReporte reporte : reportes) { // 00056122 itera sobre los reportes
            sb.append("Cliente ID: ").append(reporte.getClienteId()) // 00056122 agrega informacion del cliente al StringBuilder
                    .append(", Nombre: ").append(reporte.getNombre())
                    .append(", Compras: ").append(reporte.getCantidadCompras())
                    .append(", Total Gastado: ").append(reporte.getTotalGastado())
                    .append("\n");
        }
        return sb.toString(); // 00056122 retorna el contenido del reporte
    }

    private void guardarReporte(String contenido) throws IOException { // 00056122 guarda el reporte en un archivo
        String directorio = "Reportes"; // 00056122 define el nombre del directorio
        if (!Files.exists(Paths.get(directorio))) { // 00056122 verifica si el directorio existe
            Files.createDirectory(Paths.get(directorio)); // 00056122 crea el directorio si no existe
        }
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")); // 00056122 genera un timestamp
        String nombreArchivo = directorio + "/Reporte_" + timestamp + ".txt"; // 00056122 genera el nombre del archivo
        Files.write(Paths.get(nombreArchivo), contenido.getBytes(), StandardOpenOption.CREATE); // 00056122 escribe el contenido en el archivo
    }

    @FXML private void handleLimpiarCampos() { // 00056122 maneja la limpieza de campos
        clienteIdField.clear(); // 00056122 limpia el campo de ID del cliente
        startDateField.clear(); // 00056122 limpia el campo de fecha de inicio
        endDateField.clear(); // 00056122 limpia el campo de fecha final
    }

    private void showAlert(String title, String message, AlertType alertType) { // 00056122 muestra una alerta
        Alert alert = new Alert(alertType); // 00056122 crea una nueva alerta
        alert.setTitle(title); // 00056122 establece el titulo de la alerta
        alert.setHeaderText(null); // 00056122 establece la cabecera de la alerta como null
        alert.setContentText(message); // 00056122 establece el contenido de la alerta
        alert.showAndWait(); // 00056122 muestra la alerta y espera
    }
}


