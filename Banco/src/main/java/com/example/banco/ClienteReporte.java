package com.example.banco;

public class ClienteReporte {  // 00056122 Define la clase ClienteReporte.
    private int clienteId;  // 00056122 Declara la variable clienteId.
    private String nombre;  // 00056122 Declara la variable nombre.
    private int cantidadCompras;  // 00056122 Declara la variable cantidadCompras.
    private double totalGastado;  // 00056122 Declara la variable totalGastado.

    public int getClienteId() {  // 00056122 Devuelve el ID del cliente.
        return clienteId;  // 00056122 Retorna clienteId.
    }

    public void setClienteId(int clienteId) {  // 00056122 Asigna un valor a clienteId.
        this.clienteId = clienteId;  // 00056122 Actualiza clienteId.
    }

    public String getNombre() {  // 00056122 Devuelve el nombre del cliente.
        return nombre;  // 00056122 Retorna nombre.
    }

    public void setNombre(String nombre) {  // 00056122 Asigna un valor a nombre.
        this.nombre = nombre;  // 00056122 Actualiza nombre.
    }

    public int getCantidadCompras() {  // 00056122 Devuelve la cantidad de compras.
        return cantidadCompras;  // 00056122 Retorna cantidadCompras.
    }

    public void setCantidadCompras(int cantidadCompras) {  // 00056122 Asigna un valor a cantidadCompras.
        this.cantidadCompras = cantidadCompras;  // 00056122 Actualiza cantidadCompras.
    }

    public double getTotalGastado() {  // 00056122 Devuelve el total gastado.
        return totalGastado;  // 00056122 Retorna totalGastado.
    }

    public void setTotalGastado(double totalGastado) {  // 00056122 Asigna un valor a totalGastado.
        this.totalGastado = totalGastado;  // 00056122 Actualiza totalGastado.
    }
}
