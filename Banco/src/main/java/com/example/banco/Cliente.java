package com.example.banco;

public class Cliente {
    private String nombre, apellido, usuario;
    private String clave;
    private String direccion;
    private int telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Cliente(String nombre, String apellido, String usuario, String direccion, String clave, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.direccion = direccion;
        this.clave = clave;
        this.telefono = telefono;
    }
}
