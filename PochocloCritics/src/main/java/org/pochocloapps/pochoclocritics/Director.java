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
public class Director {
    
    private Long idDirector;
    private String biografia;
   // private List<Peliculas> peliculasDirigidas;

    public Director(Long idDirector, String biografia) {
        this.idDirector = idDirector;
        this.biografia = biografia;
    }

    public Long getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Long idDirector) {
        this.idDirector = idDirector;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    
    
    
    
    
}
