package com.example.banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO { // 00211723 clase que maneja operaciones CRUD para Cliente
    public List<Cliente> getAllClientes() { // 00211723 obtiene una lista de todos los clientes
        List<Cliente> clientes = new ArrayList<>(); // 00211723 crea una lista para almacenar clientes
        try (Connection conn = DatabaseConnection.getConnection(); // 00211723obtiene una conexion a la BD
             Statement stmt = conn.createStatement(); // 00211723 crea una declaracion SQL
             ResultSet rs = stmt.executeQuery("SELECT * FROM clientes")) { // 00211723 ejecuta la consulta SQL
            while (rs.next()) { // 00211723 itera sobre los resultados de la consulta
                Cliente cliente = new Cliente(); // 00211723 crea una nueva instancia de Cliente
                cliente.setId(rs.getInt("id")); // 00211723 asigna el id del cliente
                cliente.setNombre(rs.getString("nombre")); // 00211723 asigna el nombre del cliente
                cliente.setDireccion(rs.getString("direccion")); // 00211723 asigna la direccion del cliente
                cliente.setTelefono(rs.getString("telefono")); // 00211723 asigna el telefono del cliente
                clientes.add(cliente); // 00211723 añade el cliente a la lista
            }
        } catch (SQLException e) { // 00211723 captura excepciones SQL
            e.printStackTrace(); // 00211723imprime el stack trace de la excepcion
        }
        return clientes; // 00211723 retorna la lista de clientes
    }

    public void addCliente(Cliente cliente) { // 00211723 añade un nuevo cliente a la BD
        String query = "INSERT INTO clientes (nombre, direccion, telefono) VALUES (?, ?, ?)"; // 00211723 consulta SQL para insertar un cliente
        try (Connection conn = DatabaseConnection.getConnection(); // 00211723 obtiene una conexion a la BD
             PreparedStatement pstmt = conn.prepareStatement(query)) { // 00211723 prepara la consulta SQL
            pstmt.setString(1, cliente.getNombre()); // 00211723 asigna el nombre del cliente
            pstmt.setString(2, cliente.getDireccion()); // 00211723 asigna la direccion del cliente
            pstmt.setString(3, cliente.getTelefono()); // 00211723 asigna el telefono del cliente
            pstmt.executeUpdate(); // 00211723 ejecuta la actualizacion de la BD
        } catch (SQLException e) { // 00211723 captura excepciones SQL
            e.printStackTrace(); // 00211723 imprime el stack trace de la excepcion
        }
    }
}

