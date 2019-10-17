/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rosi-PC
 */
public class Pelicula {
    private Long idPelicula;
    private String titulo ;
    private Date duracion;
    private String sinopsis;
     private List<String> genero;
//private Imagen portada;
   
    // private Actor actor;
    //private Director director;

    public Pelicula(Long idPelicula, String titulo, Date duracion, String sinopsis, List<String> genero) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.genero = genero;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setGenero(List<String> genero) {
        this.genero = genero;
    }

    public List<String> getGenero() {
        return genero;
    }
    
}
