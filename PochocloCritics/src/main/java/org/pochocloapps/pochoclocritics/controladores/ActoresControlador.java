/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import org.pochocloapps.pochoclocritics.modelos.Actor;
import org.pochocloapps.pochoclocritics.repositorios.ActorNoEncontradoExcepcion;
import org.pochocloapps.pochoclocritics.repositorios.ActoresRepositorio;

/**
 *
 * @author Rosi-PC
 */
public class ActoresControlador {
        private final ActoresRepositorio actoresRepositorio;
    
    public ActoresControlador(ActoresRepositorio actoresRepositorio) {
        this.actoresRepositorio = actoresRepositorio;
    }
     public void listar(Context ctx) throws SQLException {
        ctx.json(actoresRepositorio.listar());
    }
     
     
     public void crear(Context ctx) throws SQLException {
        // Usando un formulario
        actoresRepositorio.crear(ctx.formParam("nombre", String.class).get(),ctx.formParam("apellido", String.class).get(),ctx.formParam("fechanac", String.class).get(), ctx.formParam("biografia", String.class).get());        
        // Usando JSON        
        /*
        var a = ctx.bodyAsClass(Persona.class);            
        actorRepositorio.crear(a.getNombres(), a.getApellidos());
        */
        ctx.status(201);
    }
        public void borrar(Context ctx) throws SQLException, ActorNoEncontradoExcepcion {
        actoresRepositorio.borrar(actoresRepositorio.obtener(ctx.pathParam("idActor", Integer.class).get()));
        ctx.status(204);
    }
        public void modificar(Context ctx) throws SQLException, ActorNoEncontradoExcepcion {
        Actor actor= actoresRepositorio.obtener(ctx.pathParam("idActor", Integer.class).get());
        // usando un formulario
          actor.setBiografia(ctx.formParam("biografia", String.class).get());
        actor.setNombre(ctx.formParam("nombre", String.class).get());
        actor.setApellido(ctx.formParam("apellido", String.class).get());
        actor.setFechaNac(ctx.formParam("fechanac", String.class).get());
      
        actoresRepositorio.modificar(actor);
        ctx.status(204); 
    } 
        public void obtener(Context ctx) throws SQLException, ActorNoEncontradoExcepcion {       
        ctx.json(actoresRepositorio.obtener(ctx.pathParam("idActor", Integer.class).get()));
    }
        
}
