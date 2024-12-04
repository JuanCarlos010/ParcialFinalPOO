package com.example.banco;

public class Tarjeta { // 00056122 define la clase Tarjeta
    private int id; // 00056122 almacena el ID de la tarjeta
    private String numero; // 00056122 almacena el numero de la tarjeta
    private int clienteId; // 00056122 almacena el ID del cliente asociado

    public int getId() { // 00056122 retorna el ID de la tarjeta
        return id; // 00056122 devuelve el ID de la tarjeta
    }

    public void setId(int id) { // 00056122 establece el ID de la tarjeta
        this.id = id; // 00056122 asigna el ID de la tarjeta
    }

    public String getNumero() { // 00056122 retorna el numero de la tarjeta
        return numero; // 00056122 devuelve el numero de la tarjeta
    }

    public void setNumero(String numero) { // 00056122 establece el numero de la tarjeta
        this.numero = numero; // 00056122 asigna el numero de la tarjeta
    }

    public int getClienteId() { // 00056122 retorna el ID del cliente asociado
        return clienteId; // 00056122 devuelve el ID del cliente asociado
    }

    public void setClienteId(int clienteId) { // 00056122 establece el ID del cliente asociado
        this.clienteId = clienteId; // 00056122 asigna el ID del cliente asociado
    }
}
