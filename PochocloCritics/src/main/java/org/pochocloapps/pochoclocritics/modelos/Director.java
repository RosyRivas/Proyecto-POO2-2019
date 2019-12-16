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
public class Director {
    
    private int idDirector;
    private String biografia;
    private String nombre;
    private String apellido;
    private String fechaNac;
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
    
    
    
    public Director(int idDirector, String nombre, String apellido, String fechaNac, String biografia){
        this.idDirector = idDirector;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.biografia = biografia;
        
    }
    //Constructor para solicitudes JSON.
    public Director() {
        
    }
    /**
     * Metodo que devuelve el nombre del director.
     * @return nombre, nombre del director.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo que crea el nombre del director.
     * @param nombre, nombre del director.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Metodo que devuelve el apellido del director.
     * @return director, apellido del director.
     */

    public String getApellido() {
        return apellido;
    }
    /**
     * Metodo que crea el apellido del director.
     * @param apellido, apellido del director.
     */

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Metodo que devuelve la fecha de nacimiento del director.
     * @return fechaNac, fecha de nacimiento del director.
     */

    public String getFechaNac() {
        return fechaNac;
    }
    /**
     * Metodo que crea una fecha de nacimiento del director
     * @param fechaNac, fecha de nacimiento del director.
     */

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    /**
     * Metodo que devuelve el identificador del director
     * @return idDirector, identificador del director 
     */
    public int getIdDirector() {
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
