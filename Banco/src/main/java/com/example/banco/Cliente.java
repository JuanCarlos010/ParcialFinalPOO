package com.example.banco;

import javafx.beans.property.SimpleIntegerProperty;//00211723 importamos librerias property para poder estar moritoriando los cmabios que tenga los datos

import javafx.beans.property.SimpleStringProperty;//00211723 importamos librerias property para poder estar moritoriando los cmabios que tenga los datos



public class Cliente { //00211723 Es la clase publica de clientes

    private final SimpleIntegerProperty id; //00211723 En la declaracion de variables id,utilizamos property para poder alamacenar datos cada cuando cambian
    private final SimpleStringProperty nombre; //00211723 En la declaracion de variables nombre,utilizamos property para poder alamacenar datos cada cuando cambian
    private final SimpleStringProperty direccion; //00211723 En la declaracion de variables direccion, utilizamos property para poder alamacenar datos cada cuando cambian
    private final SimpleStringProperty telefono; //00211723 En la declaracion de variables telefono, utilizamos property para poder alamacenar datos cada cuando cambian

    public Cliente() { //00211723 Constructor Cliente

        this.id = new SimpleIntegerProperty();//00211723 Se crea una nueva instancia para el id

        this.nombre = new SimpleStringProperty();//00211723 Se crea una nueva instancia para el nombre

        this.direccion = new SimpleStringProperty();//00211723 Se crea una nueva instancia para el direccion

        this.telefono = new SimpleStringProperty();//00211723 Se crea una nueva instancia para telefono
    }

    public Cliente(String nombre, String direccion, String telefono) { //00211723 firma del constructor
        this();//00211723 invocacion del constructor sin parametros
        this.nombre.set(nombre);//00211723 inicializa las propiedades nombre
        this.direccion.set(direccion);//00211723 inicializa las propiedades direccion
        this.telefono.set(telefono);//00211723 inicializa las propiedades telefono
    }

    public int getId() { //00211723 Devuelve el valor del ID del cliente como un entero.

        return id.get();//00211723Devuelve el nombre del cliente como una cadena.
    }

    public SimpleIntegerProperty idProperty() { //00211723 Devuelve la propiedad ID que es un SimpleIntegerProperty.

        return id;//00211723Devuelve el nombre del cliente como una cadena.
    }

    public void setId(int id) {//00211723Establece el valor del ID del cliente.

        this.id.set(id);
    }

    public String getNombre() { //00211723Devuelve el nombre del cliente como una cadena.

        return nombre.get();//000211723 Devuelve la propiedad nombre que es un SimpleStringProperty.
    }

    public SimpleStringProperty nombreProperty() {//000211723 Devuelve la propiedad nombre que es un SimpleStringProperty.

        return nombre;//00211723 funcion retornar
    }

    public void setNombre(String nombre) {

        this.nombre.set(nombre);//00211723 Establece el nombre del cliente.
    }

    public String getDireccion() {
        //  00211723Devuelve la dirección del cliente como una cadena.
        return direccion.get();//00211723 funcion retornar
    }

    public SimpleStringProperty direccionProperty() {//  00211723 Devuelve la propiedad dirección que es un SimpleStringProperty.
        return direccion;//00211723 funcion retornar
    }

    public void setDireccion(String direccion) {
        // 00211723Establece la dirección del cliente.
        this.direccion.set(direccion);
    }

    public String getTelefono() {
        // 000211723Devuelve el teléfono del cliente como una cadena.
        return telefono.get();//00211723 funcion retornar
    }

    public SimpleStringProperty telefonoProperty() {
        // 00211723Devuelve la propiedad teléfono que es un SimpleStringProperty.
        return telefono;//00211723 funcion retornar
    }

    public void setTelefono(String telefono) {
        // 00211723Establece el teléfono del cliente.
        this.telefono.set(telefono);
    }

}
