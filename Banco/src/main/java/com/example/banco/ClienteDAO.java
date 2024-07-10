package com.example.banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public List<Cliente> getAllClientes() {
        // 00211723Crea una lista para almacenar los clientes recuperados de la base de datos
        List<Cliente> clientes = new ArrayList<>();
        try (
                // 00211723Obtiene una conexión a la base de datos
                Connection conn = DatabaseConnection.getConnection();
                // 00211723Crea una declaración (statement) para ejecutar la consulta SQL
                Statement stmt = conn.createStatement();
                // 00211723Ejecuta la consulta SQL y obtiene el resultado
                ResultSet rs = stmt.executeQuery("SELECT * FROM clientes")
        ) {
            // 00211723Itera a través del resultado de la consulta
            while (rs.next()) {
                // 00211723Crea un nuevo objeto Cliente
                Cliente cliente = new Cliente();
                // 00211723Establece los valores de las propiedades del cliente a partir del resultado de la consulta
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                // 00211723Añade el cliente a la lista de clientes
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            // 00211723Imprime el stack trace en caso de una excepción SQL
            e.printStackTrace();
        }
        // 00211723Devuelve la lista de clientes
        return clientes;
    }

    // 00211723Añadir un cliente
    public void addCliente(Cliente cliente) {
        // 00211723Define la consulta SQL para insertar un nuevo cliente en la base de datos
        String query = "INSERT INTO clientes (nombre, direccion, telefono) VALUES (?, ?, ?)";
        try (
                // 00211723Obtiene una conexión a la base de datos
                Connection conn = DatabaseConnection.getConnection();
                // 00211723Prepara la consulta SQL con parámetros
                PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            // 00211723Establece los valores de los parámetros de la consulta
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getDireccion());
            pstmt.setString(3, cliente.getTelefono());
            // 00211723Ejecuta la consulta de inserción
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // 00211723Imprime el stack trace en caso de una excepción SQL
            e.printStackTrace();
        }
    }

    // 00211723Métodos CRUD adicionales (create, update, delete)

}
