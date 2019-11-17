/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.controladores;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import java.io.IOException;
import java.sql.SQLException;
import org.pochocloapps.pochoclocritics.modelos.Preferencia;
import org.pochocloapps.pochoclocritics.modelos.Usuario;
import org.pochocloapps.pochoclocritics.repositorios.PreferenciasRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.PreferenciaNoEncontradaExcepcion;
import org.pochocloapps.pochoclocritics.repositorios.UsuarioNoEncontradoExcepcion;

/**
 *
 * @author DELL-PC
 */
public class PreferenciasControlador {

    private final PreferenciasRepositorio preferenciasRepositorio;

    public PreferenciasControlador(PreferenciasRepositorio preferenciasRepositorio) {
        this.preferenciasRepositorio = preferenciasRepositorio;
    }

    public void listar(Context ctx) throws SQLException {
        ctx.json(preferenciasRepositorio.listar()); 
    }

    public void crear(Context ctx) throws SQLException {    
        // Usando JSON  
        var p = ctx.bodyAsClass(Preferencia.class);
        preferenciasRepositorio.crear(p.getIdPreferencia()); 
        ctx.status(201);
    }

    public void borrar(Context ctx) throws SQLException, PreferenciaNoEncontradaExcepcion {
        preferenciasRepositorio.borrar(preferenciasRepositorio.obtener(ctx.pathParam("idPreferencia", Integer.class).get()));
        ctx.status(204);
    }

        public void modificar(Context ctx) throws SQLException, PreferenciaNoEncontradaExcepcion {
        // Usando JSON
        var p = ctx.bodyAsClass(Preferencia.class);
        ctx.status(204);
    }
}
