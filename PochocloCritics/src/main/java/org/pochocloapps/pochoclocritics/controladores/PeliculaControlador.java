/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import org.pochocloapps.pochoclocritics.modelos.Pelicula;
import org.pochocloapps.pochoclocritics.repositorios.GeneroNoEncontradoException;
import org.pochocloapps.pochoclocritics.repositorios.PeliculaNoEncontradaException;
import org.pochocloapps.pochoclocritics.repositorios.PeliculasRepositorio;

/**
 *
 * @author osvaldo
 */
public class PeliculaControlador {
    private final PeliculasRepositorio peliculasRepositorio;
    
    public PeliculaControlador (PeliculasRepositorio peliculasRepositorio){
        this.peliculasRepositorio = peliculasRepositorio;
    }
    
    public void listar(Context ctx) throws SQLException{
        ctx.json(peliculasRepositorio.listar());
    }
    
    public void crear(Context ctx) throws SQLException{
       //json
       Pelicula p = ctx.bodyAsClass(Pelicula.class);
       peliculasRepositorio.crear(p.getIdPelicula(), p.getTitulo(),p.getPortada(), p.getDuracion(), p.getSinopsis(), p.getActores(), p.getDirectores(), p.getGeneros());
       ctx.status(201);
    }
    
    public void borrar(Context ctx) throws SQLException, PeliculaNoEncontradaException{
        peliculasRepositorio.borrar(peliculasRepositorio.obtener(ctx.pathParam("idPelicula", Integer.class).get()));
        ctx.status(204);
    }
    
    public void modificar(Context ctx) throws SQLException, PeliculaNoEncontradaException{
        //json
        Pelicula p = ctx.bodyAsClass(Pelicula.class);
        peliculasRepositorio.modificar(p);
        ctx.status(204);
        
    }
         public void obtenerGenero(Context ctx) throws SQLException, PeliculaNoEncontradaException {       
        ctx.json(peliculasRepositorio.obtenerPeliculaGenero(ctx.pathParam("idPelicula", Integer.class).get()));
    }
      /*   public void obtenerActor(Context ctx) throws SQLException, GeneroNoEncontradoException {       
        ctx.json(peliculasRepositorio.obtenerPeliculaActor(ctx.pathParam("idActor", Integer.class).get()));
    }
         public void obtenerDirector(Context ctx) throws SQLException, GeneroNoEncontradoException {       
        ctx.json(peliculasRepositorio.obtenerPeliculaDirector(ctx.pathParam("idDirector", Integer.class).get()));
    }*/
         
         
         
}
