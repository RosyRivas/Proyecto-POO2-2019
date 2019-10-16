/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics;

/**
 *
 * @author Rosi-PC
 */
public class Reseña {
    private Long idReseña;
    private String descripcion;
  //  private Pelicula pelicula;

    public Reseña(Long idReseña, String descripcion) {
        this.idReseña = idReseña;
        this.descripcion = descripcion;
    }

    public Long getIdReseña() {
        return idReseña;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
          
    
    
}
