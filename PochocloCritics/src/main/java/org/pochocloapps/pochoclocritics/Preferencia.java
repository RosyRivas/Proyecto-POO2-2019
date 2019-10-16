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

    public Preferencia(Long idPreferencia) {
        this.idPreferencia = idPreferencia;
        this.genero = new ArrayList<String>();
        
    }

    public Long getIdPreferencia() {
        return idPreferencia;
    }

    public List<String> getGenero() {
        return genero;
    }

    public void setGenero(List<String> genero) {
        this.genero = genero;
    }

    
    
}
