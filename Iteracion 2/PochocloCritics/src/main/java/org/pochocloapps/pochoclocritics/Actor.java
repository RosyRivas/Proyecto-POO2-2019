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
    * Crea un nuevo Actor en el sistema
    * @param idActor, identificador del actor.
    * @param biografia, biografía del actor.
    */
    public Actor(Long idActor, String biografia) {
        this.idActor = idActor;
        this.biografia = biografia;
    }
    /** 
    * Método que develve el identificador de un actor
    * @return idActor, identificador del actor.
    */
    public Long getIdActor() {
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
