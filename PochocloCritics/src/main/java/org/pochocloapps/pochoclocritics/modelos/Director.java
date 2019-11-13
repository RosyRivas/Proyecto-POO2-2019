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
public class Director extends Persona{
    
    private Long idDirector;
    private String biografia;
   // private List<Peliculas> peliculasDirigidas;
   //@param peliculaDirigida lista de las peliculas que dirigidas 
    /**
     *Crea un nuevo Director en el sistema
     * @param idDirector, identificador del director
     * @param nombre, nombre del director
     * @param apellido, apellido del director
     * @param fechaNac, fecha de nacimiento del director
     * @param biografia, biografia del director
     */
    public Director(Long idDirector, String nombre, String apellido, String fechaNac, String biografia){
        super(nombre, apellido, fechaNac);
        this.idDirector = idDirector;
        this.biografia = biografia;
    }

    /**
     * Metodo que devuelve el identificador del director
     * @return idDirector, identificador del director 
     */
    public Long getIdDirector() {
        return idDirector;
    }

    /**
    *Metodo que devuelve la biografia del Director 
    * @return biografia, breve descripción del director
    */
    public String getBiografia() {
        return biografia;
    }
    /**
    *Metodo que permite modificar la biografia del director
    * @param biografia, breve descripción del director
    */
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    /**
     * Metodo que devuelve la información de un director
     * @return idDirector, biografía - Identificador del director y su biografía.
    */
    @Override
    public String toString() {
        return "Director{" + "idDirector=" + idDirector + ", biografia=" + biografia + '}';
    }
      
}
