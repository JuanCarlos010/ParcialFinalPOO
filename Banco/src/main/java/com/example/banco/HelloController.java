package com.example.banco;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    //TEXTFIELD
    @FXML //00128023 etiqueta del fxml
    private TextField tfNombre; //00128023 declaramos el texfield del nombre
    @FXML //00128023 etiqueta del fxml
    private TextField tfApellido; //00128023 declaramos el texfield del apellido
    @FXML //00128023 etiqueta del fxml
    private TextField tfClave; //00128023 declaramos el texfield de la clave
    @FXML //00128023 etiqueta del fxml
    private TextField tfClaveConfirma; //00128023 declaramos el texfield de la confirma de la clave
    @FXML //00128023 etiqueta del fxml
    private TextField tfDireccion; //00128023 declaramos el texfield de la direccion
    @FXML //00128023 etiqueta del fxml
    private TextField tfTelefono; //00128023 declaramos el texfield del telefono

    //LABEL
    @FXML //00128023 etiqueta del fxml
    private Label lblConfirma; //00128023 declaramos el label de la confirmacion de datos
    @FXML //00128023 etiqueta del fxml
    private Label lblConfirmaClave; //00128023 declaramos el label de la confirmacion de datos de la clave
    @FXML //00128023 etiqueta del fxml
    private Label lblConfirmaTelefono; //00128023 declaramos el label de la confirmacion de datos del numero telefonico
    @FXML //00128023 etiqueta del fxml
    private Label lblConfirmaNombre; //00128023 declaramos el label de la confirmacion de datos del nombre
    @FXML //00128023 etiqueta del fxml
    private Label lblConfirmaApellido; //00128023 declaramos el label de la confirmacion de datos del apellido

    //Botones
    @FXML //00128023 etiqueta del fxml
    private Button btnConfirma; //00128023 Boton para confirmar los datos ingresados del registro
    @FXML //00128023 etiqueta del fxml
    private Button btnContinuar; //00128023 Boton para que podamos continuar al siguiente fxml

    @FXML //00128023 etiqueta del fxml
    protected boolean confirmaInicio() { //00128023 Confirmaremos que ningun Textfield quede en blanco
        boolean confirma; //00128023 generaremos un booleano que nos confirme eso
        confirma = !tfClave.getText().isEmpty() &&
                !tfClaveConfirma.getText().isEmpty() &&
                !tfTelefono.getText().isEmpty() &&
                !tfNombre.getText().isEmpty() &&
                !tfDireccion.getText().isEmpty() &&
                !tfApellido.getText().isEmpty(); //00128023 Asignamos que la variable  "confirma" guarde si los texfield esten vacios
        return confirma; //00128023 Devolvemos el valor de confirma, ya sea true o false
    }

    @FXML //00128023 etiqueta del fxml
    protected boolean soloNumeros() { //00128023 Esta funcion revise si el dato ingresado es un dato numerico o no
        boolean confirma = true; //00128023 creamos nuestra variable confirma
        String text = tfTelefono.getText().trim(); //00128023 usaremos a text para guardar los datos del texfield y sin espacios gracias al .trim()
        try { //00128023 iniciamos el try
            int key = Integer.parseInt(text); //00128023 lo que hara key sera convertir la cadena en un valor numerico
            lblConfirmaTelefono.setVisible(false); //00128023 apagamos el label que contiene la confirma del numero telefonico
        } catch (NumberFormatException e) { //00128023 iniciamos el catch con unua excepcion numerica
            confirma = false; //00128023 asignamos false a la variable confirma
        }
        return confirma; //00128023 devolvemos el valor de confirma
    }

    @FXML //00128023 etiqueta del fxml
    protected boolean soloLetras(String text) { //00128023 Creamos nuestra funcion para que solo acepte letras con un parameto de tipo string
        boolean soloLetras = true; //00128023 generamos la variable booleana que inicie en true
        for (int i = 0; i < text.length(); i++) { //00128023 recorrera la longitud del parametro
            char character = text.charAt(i); //00128023 lo que hara character será obtener el caracter en la posición i de la cadena de texto
            boolean letra = Character.isLetter(character); //00128023 revisara si Character es una letra
            boolean espacio = character == ' '; //00128023 revisara si el character es un espacio
            if (!(letra || espacio)) { //00128023 hacemos la condicion de que no sea una letra o un espacio
                soloLetras = false; //00128023 si cumple la condicion entonces pondremos falso
                break; //00128023 detenemos la busqueda
            }
        }
        return soloLetras; //00128023 devolvemos el valor conseguido
    }

    @FXML //00128023 etiqueta del fxml
    protected void confirma() { //00128023 Creamos nuestra funcion que revisara los datos obtenidos
        String nombre = "", apellido = "", direccion = "", clave = ""; //00128023 iniciamos las variables tipo String para la clase cliente
        int telefono = 0; //00128023 iniciamos las variables tipo int para la clase cliente
        Cliente cliente = new Cliente(nombre, apellido,  direccion, clave, telefono); //00128023 creamos a nuestro cliente
        if (!confirmaInicio()) { //00128023 creamos la condicion por si faltan datos
            lblConfirmaClave.setVisible(false); //00128023 apagamos el label donde confirmamos la contraseña
            lblConfirma.setVisible(true); //00128023 encendemos el label para indicar el mensaje de error
            lblConfirma.setText("*Faltan datos"); //00128023 mostramos el mensaje de error
        } else { //00128023 si no se cumple el if
            if (!soloLetras(tfNombre.getText().trim())) { //00128023 revisamos que solo esten letras y espacios
                lblConfirma.setVisible(false); //00128023 apagamos el label de confirma general
                lblConfirmaClave.setVisible(false); //00128023 apagamos el label de confirma de contraseña
                lblConfirmaApellido.setVisible(false); //00128023 apagamos el label de confirma del apellido
                lblConfirmaTelefono.setVisible(false); //00128023 apagamos el label de confirma del telefono

                lblConfirmaNombre.setVisible(true); //00128023 encendemos el label de confirma de nombre para mostrar su error
            } else if (!soloLetras(tfApellido.getText().trim())) {  //00128023 revisamos que solo esten letras y espacios
                lblConfirma.setVisible(false); //00128023 apagamos el label de confirma general
                lblConfirmaClave.setVisible(false);  //00128023 apagamos el label de confirma de contraseña
                lblConfirmaNombre.setVisible(false); //00128023 apagamos el label de confirma del nombre
                lblConfirmaTelefono.setVisible(false); //00128023 apagamos el label de confirma del telefono

                lblConfirmaApellido.setVisible(true); //00128023 endencemos el label de confirma de apellido para mostrar su error
            } else if (!tfClave.getText().equals(tfClaveConfirma.getText())) { //00128023 revisamos que las contraseñas sean iguales
                lblConfirma.setVisible(false); //00128023 apagamos el label de confirma general
                lblConfirmaNombre.setVisible(false); //00128023 apagamos el label de confirma del nombre
                lblConfirmaApellido.setVisible(false); //00128023 apagamos el label de confirma del apellido
                lblConfirmaTelefono.setVisible(false); //00128023 apagamos el label de confirma del telefono

                lblConfirmaClave.setVisible(true); //00128023 encendemos el label de confirma de clave para mostrar su error
            } else if ((tfTelefono.getText().length() > 8) || (tfTelefono.getText().length() < 8) || (!soloNumeros())) { //00128023 revisamos que el texfield de telefono cumple con lo establecido
                lblConfirma.setVisible(false); //00128023 apagamos el label de confirma general
                lblConfirmaClave.setVisible(false); //00128023 apagamos el label de confirma de contraseña
                lblConfirmaNombre.setVisible(false); //00128023 apagamos el label de confirma del nombre
                lblConfirmaApellido.setVisible(false); //00128023 apagamos el label de confirma del apellido

                lblConfirmaTelefono.setVisible(true); //00128023 encendemos el label de confirma de telefono para mostrar su error
            } else { //00128023 si todo lo anterior se cumple sin errores
                lblConfirmaClave.setVisible(false); //00128023 apagamos el label de confirma de contraseña
                lblConfirmaNombre.setVisible(false); //00128023 apagamos el label de confirma del nombre
                lblConfirmaApellido.setVisible(false); //00128023 apagamos el label de confirma del apellido
                lblConfirmaTelefono.setVisible(false); //00128023 apagamos el label de confirma de telefono

                lblConfirma.setVisible(true); //00128023 encendemos el label de confirma para demostrar que todo salio bien
                nombre = tfNombre.getText();//00128023 asignamos a nombre el textfield de nombre
                clave = tfClave.getText(); //00128023 asignamos a clave el textfield de clave
                cliente.setNombre(nombre); //00128023 le asignamos el nombre a la clase de cliente
                cliente.setClave(clave); //00128023 le asignamos la clave a la clase de cliente
            }
        }
    }

    @FXML //00128023 etiqueta del fxml
    protected void continuar() throws IOException { //00128023 boton para pasar al stage de
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml")); //00128023 cargamos el fxml a donde nos pasaremos
        Parent root = loader.load(); //00128023 cargamos el contenido del fxml

        Stage currentStage = (Stage) btnContinuar.getScene().getWindow(); //00128023 obtenemos el stage actual usando el boton
        currentStage.close(); //00128023 cerramos el stage actual

        Stage newStage = new Stage(); //00128023 creamos un nuevo stage
        Scene scene = new Scene(root, 600, 400); //00128023 asignamos los tamaños de la nueva escena
        newStage.setScene(scene); //00128023 asignamos la escena al nuevo stage
        newStage.setTitle("Login"); //00128023 le asignamos el titulo
        newStage.show(); //00128023 lo mostramos
    }

    @FXML //00128023 etiqueta del fxml
    protected void limpiar() { //00128023 Una funcion que permitira limpiar los campos del registro
        tfDireccion.setText(""); //00128023 limpiamos el textfield de la direccion
        tfNombre.setText(""); //00128023 limpiamos el textfield del nombre
        tfApellido.setText(""); //00128023 limpiamos el textfield del apellido
        tfTelefono.setText(""); //00128023 limpiamos el textfield del telefono
        tfClave.setText(""); //00128023 limpiamos el textfield de la clave
        tfClaveConfirma.setText(""); //00128023 limpiamos el textfield de la confirma de la clave
        lblConfirma.setVisible(false); //00128023 apagamos el label de la confirma de datos
        lblConfirmaClave.setVisible(false); //00128023 apagamos el label de la confirma de clave
    }
}