package com.example.banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDAO {
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
                tarjeta.setFechaExpiracion(rs.getDate("fecha_expiracion").toString());
                tarjeta.setTipo(rs.getString("tipo"));
                tarjeta.setFacilitador(rs.getString("facilitador"));
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
