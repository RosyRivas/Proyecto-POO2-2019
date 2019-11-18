/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import org.pochocloapps.pochoclocritics.modelos.Director;
import org.pochocloapps.pochoclocritics.repositorios.DirectorNoEncontradoException;
import org.pochocloapps.pochoclocritics.repositorios.DirectoresRepositorio;

/**
 *
 * @author osvaldo
 */
public class DirectoresControlador {
    
    private final DirectoresRepositorio directoresRepositorio;
    
    public DirectoresControlador(DirectoresRepositorio directoresRepositorio){
        this.directoresRepositorio = directoresRepositorio;
    }
    
    public void listar(Context ctx) throws SQLException{
        ctx.json(directoresRepositorio.listar());
    }
    
    public void crear(Context ctx) throws SQLException{
        Director director = ctx.bodyAsClass(Director.class);
        directoresRepositorio.crear(director.getBiografia(), director.getNombre(), director.getApellido(), director.getFechaNac());
        ctx.status(201);
    }
    
    public void borrar(Context ctx) throws SQLException, DirectorNoEncontradoException{
        directoresRepositorio.borrar(directoresRepositorio.obtener(ctx.pathParam("idDirector", Long.class).get()));
        ctx.status(204);
        
    }
    
    public void modificar(Context ctx) throws SQLException, DirectorNoEncontradoException{
        Director director = ctx.bodyAsClass(Director.class);
        directoresRepositorio.modificar(director);
        ctx.status(204);
    }
}
