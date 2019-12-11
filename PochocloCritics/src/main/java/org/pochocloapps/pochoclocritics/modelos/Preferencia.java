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
    /**
     * Crea una nueva Preferencia del usuario.
     * @param idPreferencia, identificador de la preferencia del usuario.
    */
    public Preferencia() {
        this.actor = new ArrayList();
        this.director = new ArrayList();
        this.genero = new ArrayList();
    }

    public Preferencia(int idPreferencia) {
        this.idPreferencia = idPreferencia;
    }
    /**
     * Método que permite obtener el identificador de la preferencia del usuario.
     * @return idPreferencia, identificador de la preferencia del usuario.
    */
    public int getIdPreferencia() {
        return idPreferencia;
    }

    public List<Actor> getActor() {
        return actor;
    }

    public void setActor(List<Actor> actor) {
        this.actor = actor;
    }

    public List<Director> getDirector() {
        return director;
    }

    public void setDirector(List<Director> director) {
        this.director = director;
    }

    public List<Genero> getGenero() {
        return genero;
    }

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
