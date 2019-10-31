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
public class Moderador {
    private Long idModerador;
    private String privilegios; //explica lo que puede hacer un moderador, está predefinido
    private Long contraseñaModerador; //indica una clave de moderador, habilita acciónes de moderador

    /**
     * Crea un nuevo moderador del sistema
     * @param idModerador, identificador del moderador
     * @param contraseñaModerador, contraseña del moderador
    */
    public Moderador(Long idModerador, Long contraseñaModerador) {
        this.idModerador = idModerador;
        this.contraseñaModerador = contraseñaModerador;
    }
    /**
     * Método que permite obtener los privilegios de un moderador
     * @return privilegios, permisos del moderador en el sistema
    */
    public String getPrivilegios() {
        return privilegios;
    }
    /**
     * Método que permite obtener la contraseña del moderador
     * @return contraseñaModerador, devuelve la contraseña del moderador.
    */
    public Long getContraseñaModerador() { //refinar en la siguiente iteración, o mantener como privado de la clase
        return contraseñaModerador;
    }
    /**
     * Método que permite crear una contraseña al moderador
     * @param contraseñaModerador, contraseña nueva para el moderador
    */
    public void setContraseñaModerador(Long contraseñaModerador) {
        this.contraseñaModerador = contraseñaModerador;
    }
    
    /*public void administrarPelicula(){
    
    }
    public void añadirElenco(){
    
    }*/
    
    /**
     * Método que devuelve información del moderador
     * @return idModerador, privilegios - Identificador del moderador y sus privilegios.
    */
    @Override
    public String toString() {
        return "Moderador{" + "idModerador=" + idModerador + ", privilegios=" + privilegios + '}';
    }
    
}
