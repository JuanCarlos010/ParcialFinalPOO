package com.example.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection { // 00056122 Declaracion de la clase DatabaseConnection
    private static final String URL = "jdbc:mysql://localhost:3306/banco"; // 00056122 URL de la base de datos
    private static final String USER = "root"; // 00056122 Usuario de la base de datos
    private static final String PASSWORD = ""; // 00056122 Contraseña de la base de datos

    public static Connection getConnection() throws SQLException { // 00056122 Metodo para obtener la conexion a la base de datos
        return DriverManager.getConnection(URL, USER, PASSWORD); // 00056122 Retorna la conexion a la base de datos
    }
}
