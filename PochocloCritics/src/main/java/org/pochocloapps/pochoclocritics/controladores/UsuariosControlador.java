/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.controladores;

import io.javalin.http.Context;
import java.sql.SQLException;
import java.util.Date;
import org.pochocloapps.pochoclocritics.modelos.Usuario;
import org.pochocloapps.pochoclocritics.repositorios.UsuarioNoEncontradoExcepcion;
import org.pochocloapps.pochoclocritics.repositorios.UsuariosRepositorio;

/**
 *
 * @author DELL-PC
 */
public class UsuariosControlador {
    private final UsuariosRepositorio usuariosRepositorio;
    
    public UsuariosControlador(UsuariosRepositorio usuariosRepositorio) {
        this.usuariosRepositorio = usuariosRepositorio;
    }
     public void listar(Context ctx) throws SQLException {
         ctx.json(usuariosRepositorio.listar());
    }
     public void crear(Context ctx) throws SQLException {
        // Usando un formulario
        //  usuariosRepositorio.crear(ctx.formParam("nombre", String.class).get(),ctx.formParam("apellido", String.class).get(),ctx.formParam("fechanac", String.class).get(), ctx.formParam("correo", String.class).get(), ctx.formParam("alias", String.class).get(), ctx.formParam("contraseña", String.class).get());        
        
        // Usando JSON        
        
       var p = ctx.bodyAsClass(Usuario.class);            
       // usuariosRepositorio.crear(p.getNombre(), p.getApellido(), p.getFechaNac(), p.getCorreo(), p.getAlias(), p.getContraseña());       
        ctx.status(201);
    }
        public void borrar(Context ctx) throws SQLException, UsuarioNoEncontradoExcepcion {
        usuariosRepositorio.borrar(usuariosRepositorio.obtener(ctx.pathParam("idUsuario", Integer.class).get()));
        ctx.status(204);
    }
        public void modificar(Context ctx) throws SQLException, UsuarioNoEncontradoExcepcion {
        Usuario usuario = usuariosRepositorio.obtener(ctx.pathParam("idUsuario", Integer.class).get());
        // usando un formulario
        usuario.setNombre(ctx.formParam("nombre", String.class).get());
        usuario.setApellido(ctx.formParam("apellido", String.class).get());
        usuario.setFechaNac(ctx.formParam("fechanac", String.class).get());
        usuario.setCorreo(ctx.formParam("correo", String.class).get());
        usuario.setAlias(ctx.formParam("alias", String.class).get());
        usuario.setContraseña(ctx.formParam("contraseña", String.class).get());
        usuariosRepositorio.modificar(usuario);
        ctx.status(204);
    }

}
