package com.example.banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDAO {
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

    public static List<Tarjeta> getTarjetasByClienteId(int clienteId) {
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

    // Métodos CRUD adicionales (create, update, delete)
}
