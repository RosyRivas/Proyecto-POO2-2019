/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.modelos;

/**
 *
 * @author osvaldo
 */
public interface Operaciones {
    
    /**
     * Método abstracto que permitirá realizar una reseña
    */
    public abstract void realizarReseña();
    
    /**
     * Método abstracto que permitirá realizar el repost de una película
    */
    public abstract void repostearPelícula();
    
    /**
     * Método abstracto que permitirá registrar preferencias
    */
    public abstract void registrarPreferencias();
    
    /**
     * Método abstracto que permitirá explorar el catálogo de películas
    */
    public abstract void explorarCatalogo();
    
    /**
     * Método abstracto que permitirá recomendar una película
    */
    public abstract void recomendarPelícula();
}
