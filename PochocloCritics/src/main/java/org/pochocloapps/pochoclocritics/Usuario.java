/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics;

/**
 *
 * @author Rosi-PC
 * @author DELL-PC
 */
public class Usuario {
    private Long idUsuario;
    private String correo;
    private String alias;
    private String contraseña;
    //private Preferencia preferencia;
    //private List<Reseña> reseñas;

    /**
    *Crea un nuevo usuario 
        *@param idUsuario  identificador del usuario
        *@param correo correo del usuario 
        *@param  alias Alias que el usuario utilizara publicamente 
        *@param  contraseña  contraseña que el usuario asigne para su cuenta 
    */
    public Usuario(Long idUsuario, String correo, String alias, String contraseña) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.alias = alias;
        this.contraseña = contraseña;
    }

    /**
     * Metodo que devuelve el id del usuario
     * @return id del usuario
     */
    public Long getIdUsuario() {
        return idUsuario;
    }
    /**
     *Metodo que devuelve el correo del usuario 
     * @return correo del usuario
     */
    public String getCorreo() {
        return correo;
    }
/**
 *Metodo que devuelve el alias del usuario
 * @return alias del usuario
 */
    public String getAlias() {
        return alias;
    }
/**
 *
 */
    public String getContraseña() {
        return contraseña;
    }
  
    /**
     * Metodo que asigna un nuevo valor al correo
     * @param correo asignacion del nuevo correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *Metodo que asigna un nuevo alias al usuario 
     * @param  alias 
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    /**
    *Metodo que permite al usuario realizar una reseña a una pelicula determinada 
    */
    public void realizarReseña(){
    
    }
    
    public void repostearPelicula(){
    
    }
    /**
    * Metodo que permite al usuario registrar los generos, actores y directores  
        *@Return Lista de Generos, Actores y Directores 
    */
    public void registrarPreferencias(){
    
    }
    
    /**
    * Metodo que devuelve una lista de peliculas  agrupadas por Genero 
    *@Return Lista de Peliculas
    */
    public void explorarCatalogo(){
    
    }
    
    /**
    *
    */
    
    public void recomendarPelicula(){
    
    }
    
    
}
