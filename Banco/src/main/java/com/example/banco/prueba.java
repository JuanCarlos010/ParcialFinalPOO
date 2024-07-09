package com.example.banco;

import java.text.SimpleDateFormat;
import java.util.Date;

public class prueba {
    public static void main(String[] args) {
        Date todayDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaActual = sdf.format(todayDate);
        System.out.println("Fecha y hora actual: " + fechaActual);
    }
}
