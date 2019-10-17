/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Rosi-PC
 */
public class Preferencia {
    private Long idPreferencia;
    private List<String> genero;
    //private List<Actor> actor;
    //private List<Director> director;

    /**
     * Crea una nueva Preferencia del usuario.
     * @param idPreferencia, identificador de la preferencia del usuario.
    */
    public Preferencia(Long idPreferencia) {
        this.idPreferencia = idPreferencia;
        this.genero = new ArrayList<String>();
        
    }
    /**
     * Método que permite obtener el identificador de la preferencia del usuario.
     * @return idPreferencia, identificador de la preferencia del usuario.
    */
    public Long getIdPreferencia() {
        return idPreferencia;
    }
    /**
     * Método que permite obtener una lista de géneros preferidos por el usuario
     * @return genero, retorna un listado de géneros preferidos por el usuario.
    */
    public List<String> getGenero() {
        return genero;
    }
    /**
     * Método que permite cargar un nuevo genero en la lista de generos preferidos por el usuario
     * @param genero, indica un genero para el usuario.
    */
    public void setGenero(List<String> genero) {
        this.genero = genero;
    }  
    /**
     * Método que devuelve información de la preferencia
     * @return idPreferencia, genero - Identifcador de la preferencia de usuario y lista de generos preferidos.
    */
    @Override
    public String toString() {
        return "Preferencia{" + "idPreferencia=" + idPreferencia + ", genero=" + genero + '}';
    }
}
