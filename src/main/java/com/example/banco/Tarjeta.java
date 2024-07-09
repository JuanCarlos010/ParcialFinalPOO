package com.example.banco;

public class Tarjeta { // 00056122 Declaracion de la clase Tarjeta
    private int id; // 00056122 Campo para el ID de la tarjeta
    private String numero; // 00056122 Campo para el numero de la tarjeta
    private String fechaExpiracion; // 00056122 Campo para la fecha de expiracion de la tarjeta
    private String tipo; // 00056122 Campo para el tipo de tarjeta
    private String facilitador; // 00056122 Campo para el facilitador de la tarjeta
    private int clienteId; // 00056122 Campo para el ID del cliente asociado

    public int getId() { // 00056122 Metodo para obtener el ID de la tarjeta
        return id; // 00056122 Retorna el ID de la tarjeta
    }

    public void setId(int id) { // 00056122 Metodo para establecer el ID de la tarjeta
        this.id = id; // 00056122 Asigna el valor al campo id
    }

    public String getNumero() { // 00056122 Metodo para obtener el numero de la tarjeta
        return numero; // 00056122 Retorna el numero de la tarjeta
    }

    public void setNumero(String numero) { // 00056122 Metodo para establecer el numero de la tarjeta
        this.numero = numero; // 00056122 Asigna el valor al campo numero
    }

    public String getFechaExpiracion() { // 00056122 Metodo para obtener la fecha de expiracion de la tarjeta
        return fechaExpiracion; // 00056122 Retorna la fecha de expiracion de la tarjeta
    }

    public void setFechaExpiracion(String fechaExpiracion) { // 00056122 Metodo para establecer la fecha de expiracion de la tarjeta
        this.fechaExpiracion = fechaExpiracion; // 00056122 Asigna el valor al campo fechaExpiracion
    }

    public String getTipo() { // 00056122 Metodo para obtener el tipo de tarjeta
        return tipo; // 00056122 Retorna el tipo de tarjeta
    }

    public void setTipo(String tipo) { // 00056122 Metodo para establecer el tipo de tarjeta
        this.tipo = tipo; // 00056122 Asigna el valor al campo tipo
    }

    public String getFacilitador() { // 00056122 Metodo para obtener el facilitador de la tarjeta
        return facilitador; // 00056122 Retorna el facilitador de la tarjeta
    }

    public void setFacilitador(String facilitador) { // 00056122 Metodo para establecer el facilitador de la tarjeta
        this.facilitador = facilitador; // 00056122 Asigna el valor al campo facilitador
    }

    public int getClienteId() { // 00056122 Metodo para obtener el ID del cliente asociado
        return clienteId; // 00056122 Retorna el ID del cliente asociado
    }

    public void setClienteId(int clienteId) { // 00056122 Metodo para establecer el ID del cliente asociado
        this.clienteId = clienteId; // 00056122 Asigna el valor al campo clienteId
    }
}
