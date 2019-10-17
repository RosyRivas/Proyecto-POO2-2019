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
public class Actor {
    private Long idActor;
    private String biografia;
   // private List<Peliculas> peliculasActuadas;

    /**
    * Crea un nuevo actor
    * @param id del actor
    * @param biografia del actor
    */
    public Actor(Long idActor, String biografia) {
        this.idActor = idActor;
        this.biografia = biografia;
    }
    /** 
    * Método que develve el identificador (id) de un actor
    * @return id del actor
    */
    public Long getIdActor() {
        return idActor;
    }
    /**
    * Método que devuelve la biografía de un actor
    * @return biografía del actor
    */
    public String getBiografia() {
        return biografia;
    }
    /**
    * Método que crea la biografía de un actor
    * @param biografia del actor, que incluye una descripción breve de el actor.
    */
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    
}
