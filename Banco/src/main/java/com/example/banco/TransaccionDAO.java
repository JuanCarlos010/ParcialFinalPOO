package com.example.banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaccionDAO {
    public List<Transaccion> getTransaccionesByClienteIdAndDateRange(int clienteId, Date startDate, Date endDate) {
        List<Transaccion> transacciones = new ArrayList<>();
        String query = "SELECT t.* FROM transacciones t INNER JOIN tarjetas ta ON t.tarjeta_id = ta.id WHERE ta.cliente_id = ? AND t.fecha BETWEEN ? AND ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, clienteId);
            pstmt.setDate(2, startDate);
            pstmt.setDate(3, endDate);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Transaccion transaccion = new Transaccion();
                transaccion.setId(rs.getInt("id"));
                transaccion.setFecha(rs.getDate("fecha").toString());
                transaccion.setMonto(rs.getDouble("monto"));
                transaccion.setDescripcion(rs.getString("descripcion"));
                transaccion.setTarjetaId(rs.getInt("tarjeta_id"));
                transacciones.add(transaccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transacciones;
    }
    public List<Tarjeta> getTarjetasByClienteId(int clienteId) {
        List<Tarjeta> tarjetas = new ArrayList<>();
        String query = "SELECT * FROM tarjetas WHERE cliente_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, clienteId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setId(rs.getInt("id"));
                tarjeta.setNumero(rs.getString("numero"));
                tarjeta.setClienteId(rs.getInt("cliente_id"));
                tarjetas.add(tarjeta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarjetas;
    }

    public List<ClienteReporte> getClientesPorFacilitador(String facilitador) {
        List<ClienteReporte> reportes = new ArrayList<>();
        String query = "SELECT c.id, c.nombre, COUNT(t.id) AS cantidad_compras, SUM(t.monto) AS total_gastado " +
                "FROM clientes c " +
                "INNER JOIN tarjetas ta ON c.id = ta.cliente_id " +
                "INNER JOIN transacciones t ON ta.id = t.tarjeta_id " +
                "WHERE ta.facilitador = ? " +
                "GROUP BY c.id, c.nombre";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, facilitador);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ClienteReporte reporte = new ClienteReporte();
                reporte.setClienteId(rs.getInt("id"));
                reporte.setNombre(rs.getString("nombre"));
                reporte.setCantidadCompras(rs.getInt("cantidad_compras"));
                reporte.setTotalGastado(rs.getDouble("total_gastado"));
                reportes.add(reporte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportes;
    }
    // Métodos CRUD adicionales (create, update, delete)
}
