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

    public Usuario(Long idUsuario, String correo, String alias, String contraseña) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.alias = alias;
        this.contraseña = contraseña;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getAlias() {
        return alias;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
