/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rosi-PC
 */
public class Pelicula {
    private int idPelicula;
    private String titulo ;
    private String portada;
    //private Date duracion;
    private String duracion;
    private String sinopsis;
    private List <Actor> actores;
    private List <Director> directores;
    private List <Genero> generos;
    //private List <Reseña> reseña;
     

   //Constructor para aceptar solicitudes JSON. 
    public Pelicula() {
    }
    
    /**
     * Crea una nueva Película en el sistema
     * @param idPelicula, identificador de una película
     * @param titulo, titulo de la película
     * @param portada, portada de la pelicula
     * @param duracion, tiempo de reproducción de la pelicula
     * @param sinopsis, descripción breve de la pelicula
    */
    public Pelicula(int idPelicula, String titulo,String portada, String duracion, String sinopsis) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.portada = portada;
    }
    
    /**
     * Crea una nueva Película en el sistema
     * @param idPelicula, identificador de una película
     * @param titulo, titulo de la película
     * @param portada, portada de la pelicula
     * @param duracion, tiempo de reproducción de la pelicula
     * @param sinopsis, descripción breve de la pelicula
     * @param actores, lista de actores de la pelicula.
     * @param directores, lista de directores de la pelicula.
     * @param generos, lista de generos de la pelicula.
    */
    
    public Pelicula(int idPelicula, String titulo,String portada, String duracion, String sinopsis, List<Actor> actores, List<Director> directores, List<Genero> generos) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.actores = new ArrayList(actores);
        this.directores = new ArrayList(directores);
        this.generos = new ArrayList(generos);
        
    }
    /**
     * Método que permite obtener el identificador de la película
     * @return idPelicula, identificador de la película
    */
    public int getIdPelicula() {
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
     * Método que permite obtener la portada de la película
     * @return portada, portada de la pelicula
    */
    public String getPortada() {
        return portada;
    }
     /**
     * Método que permite crear la portada de la película
     * @param portada, portada de la película
    */
    public void setPortada(String portada) {
        this.portada = portada;
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
     * Método que permite obtener la lista de actores de una película
     * @return actores, retorna la lista de actores de la pelicula.
    */
    public List<Actor> getActores() {
        return actores;
    }
    
    /**
     * Método que permite crear la lista de actores de la pelicula.
     * @param actores, lista de actores para añadir a la pelicula.
    */
    
    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }
    
    /**
     * Método que permite obtener la lista de directores de una película.
     * @return directores, retorna la lista de directores de la pelicula.
     */

    public List<Director> getDirectores() {
        return directores;
    }
     /**
     * Método que permite crear la lista de directores de la pelicula.
     *  @param directores, lista de directores para añadir a la pelicula.
    */

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }
    /**
     * Método que permite obtener la lista de generos de una pelicula.
     * @return generos, retorna la lista de generos de una pelicula.
     */
    
    public List<Genero> getGeneros() {
        return generos;
    }
    /**
     * Método que permite crear la lista de generos de una pelicula.
     * @param generos, lista de generos para añadir a la pelicula.
     */

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
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
