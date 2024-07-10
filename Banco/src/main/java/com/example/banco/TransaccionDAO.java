package com.example.banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaccionDAO { // 00128023 Clase que gestiona operaciones relacionadas con transacciones en la base de datos
    public List<Transaccion> obtenerTransaccionesPorIDClienteYRangoFecha(int clienteId, Date startDate, Date endDate) { // 00128023 Obtiene una lista de transacciones para un cliente dado en un rango de fechas
        List<Transaccion> transacciones = new ArrayList<>(); // 00128023 Lista que almacenará las transacciones obtenidas
        String query = "SELECT t.* FROM transacciones t INNER JOIN tarjetas ta ON t.tarjeta_id = ta.id WHERE ta.cliente_id = ? AND t.fecha BETWEEN ? AND ?"; // 00128023 Consulta SQL para obtener las transacciones
        try (Connection conn = DatabaseConnection.getConnection(); // 00128023 Establece la conexion a la base de datos
             PreparedStatement pstmt = conn.prepareStatement(query)) { // 00128023 Prepara la consulta SQL con parametros
            pstmt.setInt(1, clienteId); // 00128023 Asigna el clienteId al primer parametro
            pstmt.setDate(2, startDate); // 00128023 Asigna la startDate al segundo parametro
            pstmt.setDate(3, endDate); // 00128023 Asigna la endDate al tercer parametro
            ResultSet rs = pstmt.executeQuery(); // 00128023 Ejecuta la consulta y obtiene el resultado
            while (rs.next()) { // 00128023 Itera sobre los resultados obtenidos
                Transaccion transaccion = new Transaccion(); // 00128023 Crea un objeto Transaccion
                transaccion.setId(rs.getInt("id")); // 00128023 Asigna el id de la transaccion desde el resultado de la consulta
                transaccion.setFecha(rs.getDate("fecha").toString()); // 00128023 Asigna la fecha de la transaccion desde el resultado de la consulta
                transaccion.setMonto(rs.getDouble("monto")); // 00128023 Asigna el monto de la transaccion desde el resultado de la consulta
                transaccion.setDescripcion(rs.getString("descripcion")); // 00128023 Asigna la descripcion de la transaccion desde el resultado de la consulta
                transaccion.setTarjetaId(rs.getInt("tarjeta_id")); // 00128023 Asigna el id de la tarjeta asociada a la transaccion desde el resultado de la consulta
                transacciones.add(transaccion); // 00128023 Agrega la transaccion a la lista de transacciones
            }
        } catch (SQLException e) { // 00128023 Captura y maneja las excepciones de SQL
            e.printStackTrace(); // 00128023 Imprime el stack trace de la excepcion
        }
        return transacciones; // 00128023 Devuelve la lista de transacciones obtenidas
    }
    public List<Tarjeta> obtenerTarjetasporID(int clienteId) { // 00128023 Obtiene una lista de tarjetas asociadas a un cliente dado
        List<Tarjeta> tarjetas = new ArrayList<>(); // 00128023 Lista que almacenará las tarjetas obtenidas
        String query = "SELECT * FROM tarjetas WHERE cliente_id = ?"; // 00128023 Consulta SQL para obtener las tarjetas
        try (Connection conn = DatabaseConnection.getConnection(); // 00128023 Establece la conexion a la base de datos
             PreparedStatement pstmt = conn.prepareStatement(query)) { // 00128023 Prepara la consulta SQL con parametros
            pstmt.setInt(1, clienteId); // 00128023 Asigna el clienteId al primer parametro
            ResultSet rs = pstmt.executeQuery(); // 00128023 Ejecuta la consulta y obtiene el resultado
            while (rs.next()) { // 00128023 Itera sobre los resultados obtenidos
                Tarjeta tarjeta = new Tarjeta(); // 00128023 Crea un objeto Tarjeta
                tarjeta.setId(rs.getInt("id")); // 00128023 Asigna el id de la tarjeta desde el resultado de la consulta
                tarjeta.setNumero(rs.getString("numero")); // 00128023 Asigna el numero de la tarjeta desde el resultado de la consulta
                tarjeta.setClienteId(rs.getInt("cliente_id")); // 00128023 Asigna el id del cliente asociado a la tarjeta desde el resultado de la consulta
                tarjetas.add(tarjeta); // 00128023 Agrega la tarjeta a la lista de tarjetas
            }
        } catch (SQLException e) { // 00128023 captura y maneja las excepciones de SQL
            e.printStackTrace(); // 00128023 Imprime el stack trace de la excepcion
        }
        return tarjetas; // 00128023 Devuelve la lista de tarjetas obtenidas
    }

    public List<ClienteReporte> obtenerClientesporFacilitador(String facilitador) { // 00128023 Obtiene un reporte de clientes basado en el facilitador proporcionado
        List<ClienteReporte> reportes = new ArrayList<>(); // 00128023 Lista que almacenará los reportes de clientes
        String query = "SELECT c.id, c.nombre, COUNT(t.id) AS cantidad_compras, SUM(t.monto) AS total_gastado " +
                "FROM clientes c " +
                "INNER JOIN tarjetas ta ON c.id = ta.cliente_id " +
                "INNER JOIN transacciones t ON ta.id = t.tarjeta_id " +
                "WHERE ta.facilitador = ? " +
                "GROUP BY c.id, c.nombre"; // 00128023 Consulta SQL para obtener el reporte de clientes
        try (Connection conn = DatabaseConnection.getConnection(); // 00128023 Establece la conexion a la base de datos
             PreparedStatement pstmt = conn.prepareStatement(query)) { // 00128023 Prepara la consulta SQL con parametros
            pstmt.setString(1, facilitador); // 00128023 Asigna el facilitador al primer parametro
            ResultSet rs = pstmt.executeQuery(); // 00128023 Ejecuta la consulta y obtiene el resultado
            while (rs.next()) { // 00128023 Itera sobre los resultados obtenidos
                ClienteReporte reporte = new ClienteReporte(); // 00128023 Crea un objeto ClienteReporte
                reporte.setClienteId(rs.getInt("id")); // 00128023 Asigna el id del cliente desde el resultado de la consulta
                reporte.setNombre(rs.getString("nombre")); // 00128023 Asigna el nombre del cliente desde el resultado de la consulta
                reporte.setCantidadCompras(rs.getInt("cantidad_compras")); // 00128023 Asigna la cantidad de compras realizadas por el cliente desde el resultado de la consulta
                reporte.setTotalGastado(rs.getDouble("total_gastado")); // 00128023 asigna el total gastado por el cliente desde el resultado de la consulta
                reportes.add(reporte); // 00128023 Agrega el reporte del cliente a la lista de reportes
            }
        } catch (SQLException e) { // 00128023 Captura y maneja las excepciones de SQL
            e.printStackTrace(); // 00128023 Imprime el stack trace de la excepcion
        }
        return reportes; // 00128023 Devuelve la lista de reportes de clientes obtenidos
    }
}