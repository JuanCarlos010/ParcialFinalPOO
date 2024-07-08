package com.example.banco;

public class Transaccion {
    private String fecha;
    private double monto;
    private String descripcion;
    private String tarjetaNumero;

    public Transaccion(String fecha, double monto, String descripcion, String tarjetaNumero) {
        this.fecha = fecha;
        this.monto = monto;
        this.descripcion = descripcion;
        this.tarjetaNumero = tarjetaNumero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTarjetaNumero() {
        return tarjetaNumero;
    }

    public void setTarjetaNumero(String tarjetaNumero) {
        this.tarjetaNumero = tarjetaNumero;
    }
}
