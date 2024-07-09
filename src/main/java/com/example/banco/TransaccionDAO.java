package com.example.banco;

import java.sql.*; // 00056122 Importa las clases necesarias para manejar la base de datos
import java.util.ArrayList; // 00056122 Importa la clase ArrayList
import java.util.List; // 00056122 Importa la clase List

public class TransaccionDAO { // 00056122 Declaracion de la clase TransaccionDAO
    public List<Transaccion> getTransaccionesByClienteIdAndDateRange(int clienteId, Date startDate, Date endDate) { // 00056122 Metodo para obtener transacciones por ID de cliente y rango de fechas
        List<Transaccion> transacciones = new ArrayList<>(); // 00056122 Lista para almacenar las transacciones
        String query = "SELECT t.* FROM transacciones t INNER JOIN tarjetas ta ON t.tarjeta_id = ta.id WHERE ta.cliente_id = ? AND t.fecha BETWEEN ? AND ?"; // 00056122 Consulta SQL para obtener transacciones por ID de cliente y rango de fechas
        try (Connection conn = DatabaseConnection.getConnection(); // 00056122 Obtiene una conexion a la base de datos
             PreparedStatement pstmt = conn.prepareStatement(query)) { // 00056122 Prepara la consulta SQL
            pstmt.setInt(1, clienteId); // 00056122 Establece el ID del cliente en la consulta
            pstmt.setDate(2, startDate); // 00056122 Establece la fecha de inicio en la consulta
            pstmt.setDate(3, endDate); // 00056122 Establece la fecha de fin en la consulta
            ResultSet rs = pstmt.executeQuery(); // 00056122 Ejecuta la consulta y obtiene los resultados
            while (rs.next()) { // 00056122 Itera sobre el resultado de la consulta
                Transaccion transaccion = new Transaccion(); // 00056122 Crea un nuevo objeto Transaccion
                transaccion.setId(rs.getInt("id")); // 00056122 Establece el ID de la transaccion
                transaccion.setFecha(rs.getDate("fecha").toString()); // 00056122 Establece la fecha de la transaccion
                transaccion.setMonto(rs.getDouble("monto")); // 00056122 Establece el monto de la transaccion
                transaccion.setDescripcion(rs.getString("descripcion")); // 00056122 Establece la descripcion de la transaccion
                transaccion.setTarjetaId(rs.getInt("tarjeta_id")); // 00056122 Establece el ID de la tarjeta asociada
                transacciones.add(transaccion); // 00056122 Añade la transaccion a la lista
            }
        } catch (SQLException e) { // 00056122 Captura cualquier excepcion SQL
            e.printStackTrace(); // 00056122 Imprime la pila de la excepcion
        }
        return transacciones; // 00056122 Retorna la lista de transacciones
    }

}
