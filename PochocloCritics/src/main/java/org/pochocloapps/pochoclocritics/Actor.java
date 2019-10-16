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

    public Actor(Long idActor, String biografia) {
        this.idActor = idActor;
        this.biografia = biografia;
    }

    public Long getIdActor() {
        return idActor;
    }

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    
    
    
    
}
