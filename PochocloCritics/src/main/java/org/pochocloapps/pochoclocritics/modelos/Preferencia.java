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
public class Preferencia {
    private int idPreferencia;
    private List<Actor> actor;
    private List<Director> director;
    private List<Genero> genero;
    
    
    //Constructor para solicitudes JSON.
    public Preferencia() {
        this.actor = new ArrayList();
        this.director = new ArrayList();
        this.genero = new ArrayList();
    }

     /**
     * Crea una nueva Preferencia del usuario.
     * @param idPreferencia, identificador de la preferencia del usuario.
     * @param actor, lista de actores preferidos del usuario.
     * @param director, lista de directores preferidos del usuario.
     * @param genero, lista de generos preferidos del usuario.
    */
        
    public Preferencia(int idPreferencia, List<Actor> actor, List<Director> director, List<Genero> genero) {
        this.idPreferencia = idPreferencia;
        this.actor = actor;
        this.director = director;
        this.genero = genero;
    }
    
    /**
     * Método que permite obtener el identificador de la preferencia del usuario.
     * @return idPreferencia, identificador de la preferencia del usuario.
    */
    public int getIdPreferencia() {
        return idPreferencia;
    }
    /**
     * Metodo que retorna la lista de preferencia de actores del usuario.
     * @return actor, lista de actores.
     */
    public List<Actor> getActor() {
        return actor;
    }
    /**
     * Metodo crea la lista de preferencias del usuario de actores.
     * @param actor, lista de actores.
     */

    public void setActor(List<Actor> actor) {
        this.actor = actor;
    }
    /**
     * Metodo que devuelve la lista de preferencias de directores del usuario.
     * @return director, lista de directores.
     */

    public List<Director> getDirector() {
        return director;
    }
    
    /**
     * Metodo que crea la lista de preferencias de directores del usuario.
     * @param director, lista de directores.
     */

    public void setDirector(List<Director> director) {
        this.director = director;
    }
    
    /**
     * Metodo que devuelve la lista de generos preferidas del usuario. 
     * @return genero, lista de generos.
     */
    public List<Genero> getGenero() {
        return genero;
    }
    /**
     * Metodo que crea la lista de preferencias de generos del usuario.
     * @param genero, lista de generos.
     */

    public void setGenero(List<Genero> genero) {
        this.genero = genero;
    }
 
    /**
     * Método que devuelve información de la preferencia
     * @return idPreferencia, genero - Identifcador de la preferencia de usuario.
    */
    @Override
    public String toString() {
        return "Preferencia{" + "idPreferencia=" + idPreferencia +'}';
    }
}
