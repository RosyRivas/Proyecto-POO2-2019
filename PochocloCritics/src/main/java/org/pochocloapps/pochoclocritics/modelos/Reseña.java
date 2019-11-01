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
    private Long idReseña;
    private String descripcion;

    /**
    *crea una nueva Reseña en el sistema
    * @param idReseña, identificador de la reseña 
    * @param descripcion, descripción de la Reseña 
    */
    public Reseña(Long idReseña, String descripcion) {
        this.idReseña = idReseña;
        this.descripcion = descripcion;
    }

    /**
    *Metodo que devuelve la identificacion de la reseña
    * @return idReseña, identificador de la reseña
    */
    public Long getIdReseña() {
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
