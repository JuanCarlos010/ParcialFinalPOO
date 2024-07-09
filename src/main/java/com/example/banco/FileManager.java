package com.example.banco;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    public static void guardarReporte(String nombreReporte, List<String> contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Reportes/" + nombreReporte + ".txt"))) {
            for (String linea : contenido) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
