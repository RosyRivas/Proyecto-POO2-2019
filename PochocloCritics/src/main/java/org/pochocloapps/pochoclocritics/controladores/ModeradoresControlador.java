/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import org.pochocloapps.pochoclocritics.modelos.Moderador;
import org.pochocloapps.pochoclocritics.repositorios.ModeradorNoEncontradoException;
import org.pochocloapps.pochoclocritics.repositorios.ModeradorRepositorio;

/**
 *
 * @author osvaldo
 */
public class ModeradoresControlador {
    
    private final ModeradorRepositorio moderadorRepositorio;
    
    public ModeradoresControlador(ModeradorRepositorio moderadorRepositorio) throws SQLException{
        this.moderadorRepositorio = moderadorRepositorio;
    }
    
    public void listar(Context ctx) throws SQLException{
        ctx.json(moderadorRepositorio.listar());
    }
    
    public void crear (Context ctx) throws SQLException{
        Moderador moderador = ctx.bodyAsClass(Moderador.class);
        moderadorRepositorio.crear(moderador.getPrivilegios(), moderador.getNombre(), moderador.getApellido(), moderador.getFechaNac(), moderador.getCorreo(), moderador.getAlias(),moderador.getContraseña());
        ctx.status(201);
    }
    
    public void borrar(Context ctx) throws SQLException, ModeradorNoEncontradoException{
        moderadorRepositorio.borrar(moderadorRepositorio.obtener(ctx.pathParam("idModerador", Long.class).get()));
        ctx.status(204);
    }
    
    public void modificar(Context ctx) throws SQLException, ModeradorNoEncontradoException{
        Moderador moderador = ctx.bodyAsClass(Moderador.class);
        moderadorRepositorio.modificar(moderador);
        ctx.status(204);
        
    }
}