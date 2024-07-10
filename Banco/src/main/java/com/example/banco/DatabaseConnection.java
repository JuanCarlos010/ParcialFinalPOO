package com.example.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {  // 00056122 Define la clase DatabaseConnection.
    private static final String URL = "jdbc:mysql://localhost:3306/banco";  // 00056122 Declara la URL de la BD.
    private static final String USER = "root";  // 00056122 Declara el usuario de la BD.
    private static final String PASSWORD = "";  // 00056122 Declara la contraseña de la BD.

    public static Connection getConnection() throws SQLException {  // 00056122 Obtiene una conexión a la BD.
        return DriverManager.getConnection(URL, USER, PASSWORD);  // 00056122 Conecta a la BD y devuelve la conexion.
    }
}
