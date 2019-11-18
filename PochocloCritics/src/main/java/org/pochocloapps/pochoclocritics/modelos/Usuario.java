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
 * @author DELL-PC
 */
public class Usuario extends Persona {
    private int idUsuario;
    private String correo;
    private String alias;
    private String contraseña;
    //private Preferencia preferencia;
    //private List<Reseña> reseñas;

    /**
    *Crea un nuevo Usuario en el sistema
        *@param idUsuario,  identificador del usuario
     * @param nombre, nombre del usuario 
     * @param apellido, apellido del usuario
     * @param fechaNac, fecha de nacimiento del usuario
        *@param correo, correo electrónico del usuario 
        *@param  alias, alias que el usuario utilizara publicamente 
        *@param  contraseña,  contraseña que el usuario asigne para su cuenta 
    */
    
    public Usuario(int idUsuario,String nombre, String apellido, String fechaNac, String correo, String alias, String contraseña) {
        super(nombre,apellido,fechaNac);
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.alias = alias;
        this.contraseña = contraseña;
    }

    /**
     * Metodo que devuelve el identificador del usuario
     * @return idUsuario, identificador del usuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }
    /**
     *Metodo que devuelve el correo electrónico del usuario 
     * @return correo, correo electrónico del usuario
     */
    public String getCorreo() {
        return correo;
    }
/**
 *Metodo que devuelve el alias del usuario
 * @return alias, alias del usuario
 */
    public String getAlias() {
        return alias;
    }
    /**
     * Método que permite obtener  la contraseña del usuario
     * @return contraseña, devuelve la contraseña del usuario
    */
    public String getContraseña() { //refinar en la siguiente iteración, o mantener como privado de la clase
        return contraseña;
    }
  
    /**
     * Metodo que permite crear un nuevo correo electrónico al usuario
     * @param correo, correo electrónico del usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *Metodo que permite crear un nuevo alias al usuario 
     * @param  alias, alias del usuario 
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
    /**
     *Metodo que permite crear una nueva contraseña al usuario 
     *@param contraseña, contraseña del usuario 
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    /*
    public void realizarReseña(){
    
    }
    
    public void repostearPelicula(){
    
    }
    
    public void registrarPreferencias(){
    
    }
    
    public void explorarCatalogo(){
    
    }
    
    public void recomendarPelicula(){
    
    }
    */
    
}
