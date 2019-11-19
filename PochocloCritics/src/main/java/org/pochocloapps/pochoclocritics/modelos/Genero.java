/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.modelos;

/**
 *
 * @author DELL-PC
 */
public class Genero {
    private int idGenero;
    private String descripcion;

    public Genero() {
    }

    public Genero(int idGenero, String descripcion) {
        this.idGenero = idGenero;
        this.descripcion = descripcion;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
