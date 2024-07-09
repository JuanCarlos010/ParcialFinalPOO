package com.example.banco;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cliente { // 00056122 Declaracion de la clase Cliente
    private final SimpleIntegerProperty id; // 00056122 Propiedad para el id del cliente
    private final SimpleStringProperty nombre; // 00056122 Propiedad para el nombre del cliente
    private final SimpleStringProperty direccion; // 00056122 Propiedad para la direccion del cliente
    private final SimpleStringProperty telefono; // 00056122 Propiedad para el telefono del cliente

    public Cliente() { // 00056122 Constructor por defecto
        this.id = new SimpleIntegerProperty(); // 00056122 Inicializa la propiedad id
        this.nombre = new SimpleStringProperty(); // 00056122 Inicializa la propiedad nombre
        this.direccion = new SimpleStringProperty(); // 00056122 Inicializa la propiedad direccion
        this.telefono = new SimpleStringProperty(); // 00056122 Inicializa la propiedad telefono
    }

    public Cliente(String nombre, String direccion, String telefono) { // 00056122 Constructor con parametros
        this(); // 00056122 Llama al constructor por defecto para inicializar propiedades
        this.nombre.set(nombre); // 00056122 Asigna el valor nombre a la propiedad
        this.direccion.set(direccion); // 00056122 Asigna el valor direccion a la propiedad
        this.telefono.set(telefono); // 00056122 Asigna el valor telefono a la propiedad
    }

    public int getId() { // 00056122 Metodo para obtener el id del cliente
        return id.get(); // 00056122 Retorna el valor de la propiedad id
    }

    public SimpleIntegerProperty idProperty() { // 00056122 Metodo para obtener la propiedad id
        return id; // 00056122 Retorna la propiedad id
    }

    public void setId(int id) { // 00056122 Metodo para establecer el id del cliente
        this.id.set(id); // 00056122 Asigna el valor a la propiedad id
    }

    public String getNombre() { // 00056122 Metodo para obtener el nombre del cliente
        return nombre.get(); // 00056122 Retorna el valor de la propiedad nombre
    }

    public SimpleStringProperty nombreProperty() { // 00056122 Metodo para obtener la propiedad nombre
        return nombre; // 00056122 Retorna la propiedad nombre
    }

    public void setNombre(String nombre) { // 00056122 Metodo para establecer el nombre del cliente
        this.nombre.set(nombre); // 00056122 Asigna el valor a la propiedad nombre
    }

    public String getDireccion() { // 00056122 Metodo para obtener la dirección del cliente
        return direccion.get(); // 00056122 Retorna el valor de la propiedad dirección
    }

    public SimpleStringProperty direccionProperty() { // 00056122 Metodo para obtener la propiedad direccien
        return direccion; // 00056122 Retorna la propiedad dirección
    }

    public void setDireccion(String direccion) { // 00056122 Metodo para establecer la direccien del cliente
        this.direccion.set(direccion); // 00056122 Asigna el valor a la propiedad direccien
    }

    public String getTelefono() { // 00056122 Metodo para obtener el telefono del cliente
        return telefono.get(); // 00056122 Retorna el valor de la propiedad teléfono
    }

    public SimpleStringProperty telefonoProperty() { // 00056122 Metodo para obtener la propiedad telefono
        return telefono; // 00056122 Retorna la propiedad telefono
    }

    public void setTelefono(String telefono) { // 00056122 Metodo para establecer el telefono del cliente
        this.telefono.set(telefono); // 00056122 Asigna el valor a la propiedad telefono
    }
}
