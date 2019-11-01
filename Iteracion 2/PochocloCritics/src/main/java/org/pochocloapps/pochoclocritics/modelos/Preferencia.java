/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.modelos;
/**
 *
 * @author Rosi-PC
 */
public class Preferencia {
    private Long idPreferencia;
    //private List<Actor> actor;
    //private List<Director> director;
    //private List<Genero> genero;
    /**
     * Crea una nueva Preferencia del usuario.
     * @param idPreferencia, identificador de la preferencia del usuario.
    */
    public Preferencia(Long idPreferencia) {
        this.idPreferencia = idPreferencia;
        
    }
    /**
     * Método que permite obtener el identificador de la preferencia del usuario.
     * @return idPreferencia, identificador de la preferencia del usuario.
    */
    public Long getIdPreferencia() {
        return idPreferencia;
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
