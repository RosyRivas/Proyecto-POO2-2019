/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.modelos;

import java.util.Date;

/**
 *
 * @author Rosi-PC
 */
public abstract class Persona { //debe ser abstracta
    private String nombre;
    private String apellido;
    private Date fechaNac;
    
    /**
     * Crea una nueva persona, pudiendo ser usuario, moderador, actor, director
     * @param nombre, nombre de la persona
     * @param apellido, apellido de la persona
     * @param fechaNac, fecha de nacimiento de la persona
    */
     protected Persona (String nombre,String apellido, Date fechaNac){
      
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    
    }
    
     /** Método que permite obtener el nombre de una persona
     * @return nombre
    */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método que permite crear el nombre de una persona
     * @param nombre
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método que permite obtener el apellido de una persona
     * @return apellido
    */
    public String getApellido() {
        return apellido;
    }
    /**
     * Método que permite crear el apellido de una persona
     * @param apellido
    */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Método que permite obtener la fecha de nacimiento de una persona
     * @return fechaNac
    */
    public Date getFechaNac() {
        return fechaNac;
    }
    /**
     * Método que permite crear la fecha de nacimiento de una persona
     * @param fechaNac
    */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    /**
     * Método que obtiene la información de una persona
     * @return nombre, apellido, fechaNac
    */
    @Override
    public String toString() {
        return "Persona{nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + '}';
    }
}
