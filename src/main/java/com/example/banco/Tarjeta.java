package com.example.banco;

public class Tarjeta {
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String tipo;
    private String facilitador;
    private String clienteUsuario;

    public Tarjeta(String numeroTarjeta, String fechaExpiracion, String tipo, String facilitador, String clienteUsuario) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.tipo = tipo;
        this.facilitador = facilitador;
        this.clienteUsuario = clienteUsuario;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFacilitador() {
        return facilitador;
    }

    public void setFacilitador(String facilitador) {
        this.facilitador = facilitador;
    }

    public String getClienteUsuario() {
        return clienteUsuario;
    }

    public void setClienteUsuario(String clienteUsuario) {
        this.clienteUsuario = clienteUsuario;
    }
}
