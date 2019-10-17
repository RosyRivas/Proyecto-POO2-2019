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
public class Moderador {
    private Long idModerador;
    private String privilegios; //explica lo que puede hacer un moderador, está predefinido
    private Long contraseñaModerador; //indica una clave de moderador, habilita acciónes de moderador

    /**
     * Crea un nuevo moderador del sistema
     * @param idModerador identificador del moderador
     * @param contraseñaModerador contraseña 
    */
    public Moderador(Long idModerador, Long contraseñaModerador) {
        this.idModerador = idModerador;
        this.contraseñaModerador = contraseñaModerador;
    }
    /**
     * Método que permite obtener los privilegios de un moderador
     * @return privilegios
    */
    public String getPrivilegios() {
        return privilegios;
    }
    /**
     * Método que permite obtener la contraseña del moderador
     * @return contraseñaModerador;
    */
    public Long getContraseñaModerador() {
        return contraseñaModerador;
    }
    /**
     * Método que permite crear una contraseña del moderador
     * @param contraseñaModerador
    */
    public void setContraseñaModerador(Long contraseñaModerador) {
        this.contraseñaModerador = contraseñaModerador;
    }
    
    public void administrarPelicula(){
    
    }
    public void añadirElenco(){
    
    }
    /**
     * Método que devuelve información del moderador
     * @return idModerador, privilegios
    */
    @Override
    public String toString() {
        return "Moderador{" + "idModerador=" + idModerador + ", privilegios=" + privilegios + '}';
    }
    
}
