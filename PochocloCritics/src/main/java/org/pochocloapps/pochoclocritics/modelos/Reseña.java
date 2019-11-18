/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.modelos;

/**
 *
 * @author Rosi-PC
 */
public class Reseña {
    private int idReseña;// cambie a in por que el controlador no permitia long 
    private String descripcion;

    /**
    *crea una nueva Reseña en el sistema
    * @param idReseña, identificador de la reseña 
    * @param descripcion, descripción de la Reseña 
    */
    public Reseña(int idReseña, String descripcion) {
        this.idReseña = idReseña;
        this.descripcion = descripcion;
    }

    /**
    *Metodo que devuelve la identificacion de la reseña
    * @return idReseña, identificador de la reseña
    */
    public int getIdReseña() {
        return idReseña;
    }
/**
    *Metodo que obtiene la descripcion de reseña 
    * @return descripcion, breve descripción de la reseña 
    */
    public String getDescripcion() {
        return descripcion;
    }
/**
    *Metodo que permite modificar la descripcion de la reseña 
    * @param descripcion, breve descripción de la reseña 
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
          
    
    
}
