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
public class Actor {
    private int idActor;
    private String nombre;
    private String apellido;
    private String fechaNac;
    private String biografia;
   // private List<Peliculas> peliculasActuadas;

    /**
    * Crea un nuevo Actor en el sistema
    * @param idActor, identificador del actor.
    * @param nombre, nombre del actor.
    * @param apellido, apellido del actor.
    * @param fechaNac, fecha de nacimiento del actor.
    * @param biografia, biografía del actor.
    */
    public Actor(int idActor, String nombre, String apellido, String fechaNac,String biografia) {
        this.idActor = idActor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.biografia = biografia;
    }
    //Constructor para adaptar a solicitudes JSON.
    public Actor() {
    }
    /**
     * Método que devuelve el nombre del actor.
     * @return, nombre del actor.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo que crea el nombre de un actor.
     * @param nombre, nombre del actor. 
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Metodo que devuelve el apellido del actor.
     * @return apellido, apellido del actor.
     */

    public String getApellido() {
        return apellido;
    }
    /**
     * Metodo que crea el apellido del actor.
     * @param apellido, apellido del actor.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Método que devuelve la fecha de nacimiento del actor.
     * @return fechaNac, fecha de nacimiento del actor.
     */

    public String getFechaNac() {
        return fechaNac;
    }
    /**
     * Método que crea la fecha de nacimiento del actor.
     * @param fechaNac, fecha de nacimiento del actor.
     */

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
 
    /** 
    * Método que develve el identificador de un actor
    * @return idActor, identificador del actor.
    */
    public int  getIdActor() {
        return idActor;
    }
    /**
    * Método que devuelve la biografía de un actor
    * @return biografía, breve descripción del actor.
    */
    public String getBiografia() {
        return biografia;
    }
    /**
    * Método que crea la biografía de un actor
    * @param biografia, que indica una breve descripción del actor.
    */
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    /**
     * Metodo que devuelve información del actor
     * @return idActor, biografia - Identificador del actor y su biografía.
    */
    @Override
    public String toString() {
        return "Actor{" + "idActor=" + idActor + ", biografia=" + biografia + '}';
    }
    
}
