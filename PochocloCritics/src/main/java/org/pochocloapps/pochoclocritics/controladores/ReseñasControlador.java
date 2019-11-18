/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.controladores;

import io.javalin.http.Context;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.pochocloapps.pochoclocritics.modelos.Preferencia;
import org.pochocloapps.pochoclocritics.modelos.Reseña;
import org.pochocloapps.pochoclocritics.repositorios.ReseñaNoEncontradoException;
import org.pochocloapps.pochoclocritics.repositorios.ReseñasRepositorio;
import org.pochocloapps.pochoclocritics.server.ReseñaNoEncontradoExcepcion;



/**
 *
 * @author Rosi-PC
 */
public class ReseñasControlador {
   
         private final ReseñasRepositorio reseñasRepositorio ;
    
    public ReseñasControlador (ReseñasRepositorio reseñasRepertorio) {
        this.reseñasRepositorio= reseñasRepertorio;
    }
    
     public void listar(Context ctx) throws SQLException {
        ctx.json(reseñasRepositorio.listar());
    }
       public void crear(Context ctx) throws SQLException {
        // Usando un JSON
         var r = ctx.bodyAsClass(Reseña.class);
        reseñasRepositorio.crear(r.getIdReseña()); 
        ctx.status(201);
      
    }
       
       
        public void borrar(Context ctx) throws SQLException, ReseñaNoEncontradoException {
        reseñasRepositorio.borrar(reseñasRepositorio.obtener(ctx.pathParam("idReseña", Integer.class).get()));
        ctx.status(204);
    }
        
        
        
       public void modificar(Context ctx) throws SQLException,ReseñaNoEncontradoExcepcion, ReseñaNoEncontradoException {
          
        // Usando JSON
        var r = ctx.bodyAsClass(Reseña.class);
        ctx.status(204);
    }
}
