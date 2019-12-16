/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.modelos;

/**
 *
 * @author DELL-PC
 */
public class Genero {

    private int idGenero;
    private String descripcion;
    
    //Constructor para solicitudes JSON.
    public Genero() {
    }
    
    /**
    * Crea un nuevo Genero en el sistema
    * @param idGenero, identificador del actor.
    * @param descripcion, nombre del actor.

    */
    public Genero(int idGenero, String descripcion) {
        this.idGenero = idGenero;
        this.descripcion = descripcion;
    }
    /**
     * Metodo que devuelve el id del genero.
     * @return idGenero, id del genero.
     */

    public int getIdGenero() {
        return idGenero;
    }
    /**
     * Metodo que devuelve la descripcion del genero.
     * @return descripcion, descripcion del genero.
     */

    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Metodo que crea la descripcion del genero
     * @param descripcion, descripcion del genero.
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
