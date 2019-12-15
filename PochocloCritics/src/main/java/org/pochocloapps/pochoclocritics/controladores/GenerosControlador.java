/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import org.pochocloapps.pochoclocritics.modelos.Genero;
import org.pochocloapps.pochoclocritics.repositorios.DirectorNoEncontradoException;
import org.pochocloapps.pochoclocritics.repositorios.GeneroNoEncontradoException;
import org.pochocloapps.pochoclocritics.repositorios.GenerosRepositorio;

/**
 *
 * @author DELL-PC
 */
public class GenerosControlador {

        private final GenerosRepositorio generosRepositorio;

        public GenerosControlador(GenerosRepositorio generosRepositorio) {
            this.generosRepositorio = generosRepositorio;
        }

        public void listar(Context ctx) throws SQLException {
            ctx.json(generosRepositorio.listar());
        }

        public void crear(Context ctx) throws SQLException {
            Genero genero = ctx.bodyAsClass(Genero.class);
            generosRepositorio.crear(genero.getDescripcion());
            ctx.status(201);
        }

        public void borrar(Context ctx) throws SQLException, GeneroNoEncontradoException {
            generosRepositorio.borrar(generosRepositorio.obtener(ctx.pathParam("idGenero", Integer.class).get()));
            ctx.status(204);

        }

        public void modificar(Context ctx) throws SQLException, GeneroNoEncontradoException {
            Genero genero = ctx.bodyAsClass(Genero.class);
            generosRepositorio.modificar(genero);
            ctx.status(204);
        }
        public void obtener(Context ctx) throws SQLException, GeneroNoEncontradoException {       
        ctx.json(generosRepositorio.obtener(ctx.pathParam("idGenero", Integer.class).get()));
    }

    }

