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
public class Pelicula {
    private Long idPelicula;
    private String titulo ;
    //private Date duracion;
    private String duracion;
    private String sinopsis;
    //private Imagen portada;
    // private List <Actor> actor;
    //private List <Director> director;
    //private List <Generos> genero;
    //private List <Reseña> reseña;
     
    /**
     * Crea una nueva Película en el sistema
     * @param idPelicula, identificador de una película
     * @param titulo, titulo de la película
     * @param duracion, tiempo de reproducción de la pelicula
     * @param sinopsis, descripción breve de la pelicula
    */
    public Pelicula(Long idPelicula, String titulo, String duracion, String sinopsis) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
    }
    /**
     * Método que permite obtener el identificador de la película
     * @return idPelicula, identificador de la película
    */
    public Long getIdPelicula() {
        return idPelicula;
    }
    /**
     * Método que permite obtener el titulo de la película
     * @return titulo, titulo de la película
    */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Método que permite crear el título de la película
     * @param titulo, titulo de la película
    */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Método que permite obtener la duración de la película
     * @return duracion, tiempo de reproducción de la película
    */
    public String getDuracion() {
        return duracion;
    }
    /**
     * Modo que permite establecer la duración de una película
     * @param duracion, tiempo de reproducción de la película
    */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    /**
     * Método que permite obtener la sinopsis de una película
     * @return sinopsis, breve descripción de una película
    */
    public String getSinopsis() {
        return sinopsis;
    }
    /**
     * Método que permite crear la sinopsis de una pelicula
     * @param sinopsis, breve descripción de una película
    */
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    /**
     * Método que devuelve la información de una película
     * @return idPelicula, titulo, duracion, sinopsis, genero - Identificador de la película, su titulo, duración, sinopsis.
    */
    @Override
    public String toString() {
        return "Pelicula{" + "idPelicula=" + idPelicula + ", titulo=" + titulo + ", duracion=" + duracion + ", sinopsis=" + sinopsis + '}';
    }
    
}
