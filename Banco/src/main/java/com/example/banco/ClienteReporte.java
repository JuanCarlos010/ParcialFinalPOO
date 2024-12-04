package com.example.banco;

public class ClienteReporte { // 00056122 define la clase ClienteReporte
    private int clienteId; // 00056122 almacena el ID del cliente
    private String nombre; // 00056122 almacena el nombre del cliente
    private int cantidadCompras; // 00056122 almacena la cantidad de compras del cliente
    private double totalGastado; // 00056122 almacena el total gastado por el cliente

    public int getClienteId() { // 00056122 retorna el ID del cliente
        return clienteId; // 00056122 devuelve el ID del cliente
    }

    public void setClienteId(int clienteId) { // 00056122 establece el ID del cliente
        this.clienteId = clienteId; // 00056122 asigna el ID del cliente
    }

    public String getNombre() { // 00056122 retorna el nombre del cliente
        return nombre; // 00056122 devuelve el nombre del cliente
    }

    public void setNombre(String nombre) { // 00056122 establece el nombre del cliente
        this.nombre = nombre; // 00056122 asigna el nombre del cliente
    }

    public int getCantidadCompras() { // 00056122 retorna la cantidad de compras
        return cantidadCompras; // 00056122 devuelve la cantidad de compras
    }

    public void setCantidadCompras(int cantidadCompras) { // 00056122 establece la cantidad de compras
        this.cantidadCompras = cantidadCompras; // 00056122 asigna la cantidad de compras
    }

    public double getTotalGastado() { // 00056122 retorna el total gastado
        return totalGastado; // 00056122 devuelve el total gastado
    }

    public void setTotalGastado(double totalGastado) { // 00056122 establece el total gastado
        this.totalGastado = totalGastado; // 00056122 asigna el total gastado
    }
}
