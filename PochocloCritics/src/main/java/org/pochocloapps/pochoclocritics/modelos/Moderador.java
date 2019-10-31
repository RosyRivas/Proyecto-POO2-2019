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
public class Moderador extends Persona{
    private Long idModerador;
    private String privilegios; //explica lo que puede hacer un moderador, está predefinido
    private String correo;
    private String alias;
    private Long contraseña; //indica una clave de moderador, habilita acciónes de moderador

    /**
     * Crea un nuevo moderador del sistema
     * @param idModerador, identificador del moderador
     * @param nombre,nombre del moderador
     * @param apellido, apellido del moderador
     * @param fechaNac, fecha de nacimiento del moderador
     * @param privilegios, indica si el usuario es un moderador
     * @param correo, correo del moderador 
     * @param alias, alias del moderador
     * @param contraseña, contraseña del moderador
    */
    public Moderador(Long idModerador,String nombre, String apellido,Date fechaNac , String privilegios, String correo, String alias, Long contraseña) {
        super(nombre,apellido,fechaNac);
        this.idModerador = idModerador;
        this.privilegios = privilegios;
        this.correo = correo;
        this.alias = alias;
        this.contraseña = contraseña;
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
    public Long getContraseña() {    
        return contraseña;
    }

    /**
     * Método que permite crear una contraseña a moderador
     * @param contraseña, contraseña nueva parla el moderador
     */
    public void setContraseña(Long contraseña) {
        this.contraseña = contraseña;
    }
    /**
     * Metodo que devuelve el identificador del moderador
     * @return idModerador, identificador del moderador
     */
    public Long getIdModerador() {
        return idModerador;
    }
    
/**
     * Metodo que devuelve el correo del moredador
     * @return idModerador, identificador del moderador
     */
    public String getCorreo() {
        return correo;
    }
/**
     * Método que permite crear un correo al moderador
     * @param correo, correo nuevo para el moderador
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
/**
     * Metodo que devuelve el alias del moderador
     * @return idModerador, identificador del moderador
     */
    public String getAlias() {
        return alias;
    }
/**
     * Método que permite crear un nuevo alias al moderador
     * @param alias, alias nuevo para el moderador
     */
    public void setAlias(String alias) {
        this.alias = alias;
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
