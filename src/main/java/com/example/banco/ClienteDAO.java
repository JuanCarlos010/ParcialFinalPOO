package com.example.banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO { // 00056122 Declaracion de la clase ClienteDAO
    public List<Cliente> getAllClientes() { // 00056122 Metodo para obtener todos los clientes
        List<Cliente> clientes = new ArrayList<>(); // 00056122 Lista para almacenar los clientes
        try (Connection conn = DatabaseConnection.getConnection(); // 00056122 Obtiene una conexion a la base de datos
             Statement stmt = conn.createStatement(); // 00056122 Crea una declaracion SQL
             ResultSet rs = stmt.executeQuery("SELECT * FROM clientes")) { // 00056122 Ejecuta la consulta SQL
            while (rs.next()) { // 00056122 Itera sobre el resultado de la consulta
                Cliente cliente = new Cliente(); // 00056122 Crea un nuevo objeto Cliente
                cliente.setId(rs.getInt("id")); // 00056122 Establece el ID del cliente
                cliente.setNombre(rs.getString("nombre")); // 00056122 Establece el nombre del cliente
                cliente.setDireccion(rs.getString("direccion")); // 00056122 Establece la direccion del cliente
                cliente.setTelefono(rs.getString("telefono")); // 00056122 Establece el telefono del cliente
                clientes.add(cliente); // 00056122 Añade el cliente a la lista
            }
        } catch (SQLException e) { // 00056122 Captura cualquier excepcion SQL
            e.printStackTrace(); // 00056122 Imprime la pila de la excepcion
        }
        return clientes; // 00056122 Retorna la lista de clientes
    }

    // Añadir un cliente
    public void addCliente(Cliente cliente) { // 00056122 Metodo para añadir un nuevo cliente
        String query = "INSERT INTO clientes (nombre, direccion, telefono) VALUES (?, ?, ?)"; // 00056122 Consulta SQL para insertar un nuevo cliente
        try (Connection conn = DatabaseConnection.getConnection(); // 00056122 Obtiene una conexion a la base de datos
             PreparedStatement pstmt = conn.prepareStatement(query)) { // 00056122 Prepara la consulta SQL
            pstmt.setString(1, cliente.getNombre()); // 00056122 Establece el nombre en la consulta
            pstmt.setString(2, cliente.getDireccion()); // 00056122 Establece la direccion en la consulta
            pstmt.setString(3, cliente.getTelefono()); // 00056122 Establece el telefono en la consulta
            pstmt.executeUpdate(); // 00056122 Ejecuta la consulta SQL
        } catch (SQLException e) { // 00056122 Captura cualquier excepcion SQL
            e.printStackTrace(); // 00056122 Imprime la pila de la excepcion
        }
    }

}
