package com.example.banco;

public class Transaccion { // 00056122 Declaracion de la clase Transaccion
    private int id; // 00056122 Campo para el ID de la transaccion
    private String fecha; // 00056122 Campo para la fecha de la transaccion
    private double monto; // 00056122 Campo para el monto de la transaccion
    private String descripcion; // 00056122 Campo para la descripcion de la transaccion
    private int tarjetaId; // 00056122 Campo para el ID de la tarjeta asociada

    public int getId() { // 00056122 Metodo para obtener el ID de la transaccion
        return id; // 00056122 Retorna el ID de la transaccion
    }

    public void setId(int id) { // 00056122 Metodo para establecer el ID de la transaccion
        this.id = id; // 00056122 Asigna el valor al campo id
    }

    public String getFecha() { // 00056122 Metodo para obtener la fecha de la transaccion
        return fecha; // 00056122 Retorna la fecha de la transaccion
    }

    public void setFecha(String fecha) { // 00056122 Metodo para establecer la fecha de la transaccion
        this.fecha = fecha; // 00056122 Asigna el valor al campo fecha
    }

    public double getMonto() { // 00056122 Metodo para obtener el monto de la transaccion
        return monto; // 00056122 Retorna el monto de la transaccion
    }

    public void setMonto(double monto) { // 00056122 Metodo para establecer el monto de la transaccion
        this.monto = monto; // 00056122 Asigna el valor al campo monto
    }

    public String getDescripcion() { // 00056122 Metodo para obtener la descripcion de la transaccion
        return descripcion; // 00056122 Retorna la descripcion de la transaccion
    }

    public void setDescripcion(String descripcion) { // 00056122 Metodo para establecer la descripcion de la transaccion
        this.descripcion = descripcion; // 00056122 Asigna el valor al campo descripcion
    }

    public int getTarjetaId() { // 00056122 Metodo para obtener el ID de la tarjeta asociada
        return tarjetaId; // 00056122 Retorna el ID de la tarjeta asociada
    }

    public void setTarjetaId(int tarjetaId) { // 00056122 Metodo para establecer el ID de la tarjeta asociada
        this.tarjetaId = tarjetaId; // 00056122 Asigna el valor al campo tarjetaId
    }
}
