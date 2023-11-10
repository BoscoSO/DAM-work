/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioTableView.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author a19boscoso
 */
public class Alumno {
    private StringProperty nombre;
    private StringProperty apellido;
    private StringProperty correo;

    public Alumno(String nombre, String apellido, String correo) {
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
    }


    
    
    public StringProperty nombreProperty() {
        if (nombre == null) {
            nombre = new SimpleStringProperty(this, "nombre");
        }
            return nombre;
    }
    public void setNombre(String value) {
        nombreProperty().set(value);
    }
    public String getNombre() {
        return nombreProperty().get();
    }
    
    public StringProperty apellidoProperty() {
        if (apellido == null) {
            apellido = new SimpleStringProperty(this, "apellido");
        }
            return apellido;
    }
    public void setApellido(String value) {
        apellidoProperty().set(value);
    }
    public String getApellido() {
        return apellidoProperty().get();
    }
    
      public StringProperty correoProperty() {
        if (correo == null) {
            correo = new SimpleStringProperty(this, "correo");
        }
            return correo;
    }
    public void setCorreo(String value) {
        correoProperty().set(value);
    }
    public String getCorreo() {
        return correoProperty().get();
    }

}