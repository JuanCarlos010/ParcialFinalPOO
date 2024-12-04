package com.example.banco; // 00128023 Paquete que contiene la clase Transaccion

public class Transaccion {

    private int id; // 00128023 Variable para almacenar el ID de la transaccion
    private String fecha; // 00128023 Variable para almacenar la fecha de la transaccion
    private double monto; // 00128023 Variable para almacenar el monto de la transaccion
    private String descripcion; // 00128023 Variable para almacenar la descripcion de la transaccion
    private int tarjetaId; // 00128023 Variable para almacenar el ID de la tarjeta asociada a la transaccion

    public Transaccion() { // 00128023 Constructor por defecto de la clase Transaccion
        this.id = id; // 00128023 Inicializa el ID de la transaccion
        this.fecha = fecha; // 00128023 Inicializa la fecha de la transaccion
        this.monto = monto; // 00128023 Inicializa el monto de la transaccion
        this.descripcion = descripcion; // 00128023 Inicializa la descripcion de la transaccion
        this.tarjetaId = tarjetaId; // 00128023 Inicializa el ID de la tarjeta asociada a la transaccion
    }

    public int getId() { // 00128023 Método para obtener el ID de la transaccion
        return id; // 00128023 Devuelve el ID de la transaccion
    }

    public void setId(int id) { // 00128023 Método para establecer el ID de la transaccion
        this.id = id; // 00128023 Asigna el ID de la transaccion
    }

    public String getFecha() { // 00128023 Método para obtener la fecha de la transaccion
        return fecha; // 00128023 Devuelve la fecha de la transaccion
    }

    public void setFecha(String fecha) { // 00128023 Método para establecer la fecha de la transaccion
        this.fecha = fecha; // 00128023 Asigna la fecha de la transaccion
    }

    public double getMonto() { // 00128023 Método para obtener el monto de la transaccion
        return monto; // 00128023 Devuelve el monto de la transaccion
    }

    public void setMonto(double monto) { // 00128023 Método para establecer el monto de la transaccion
        this.monto = monto; // 00128023 Asigna el monto de la transaccion
    }

    public String getDescripcion() { // 00128023 Método para obtener la descripcion de la transaccion
        return descripcion; // 00128023 Devuelve la descripcion de la transaccion
    }

    public void setDescripcion(String descripcion) { // 00128023 Método para establecer la descripcion de la transaccion
        this.descripcion = descripcion; // 00128023 Asigna la descripcion de la transaccion
    }

    public int getTarjetaId() { // 00128023 Método para obtener el ID de la tarjeta asociada a la transaccion
        return tarjetaId; // 00128023 Devuelve el ID de la tarjeta asociada a la transaccion
    }

    public void setTarjetaId(int tarjetaId) { // 00128023 Método para establecer el ID de la tarjeta asociada a la transaccion
        this.tarjetaId = tarjetaId; // 00128023 Asigna el ID de la tarjeta asociada a la transaccion
    }
}
