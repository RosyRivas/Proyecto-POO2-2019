/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.server;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;
import io.javalin.core.event.EventListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.pochocloapps.pochoclocritics.controladores.PeliculaControlador;
import org.pochocloapps.pochoclocritics.controladores.PreferenciasControlador;
import org.pochocloapps.pochoclocritics.controladores.UsuariosControlador;
import org.pochocloapps.pochoclocritics.repositorios.PeliculasRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.PreferenciasRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.UsuariosRepositorio;

/**
 *
 * @author DELL-PC
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        String driver = "org.postgresql.Driver";
        String connectString = "jdbc:postgresql://localhost:5432/ejemplo";
        String user = "postgres";
        String password = "admin";

        try {
            Class.forName(driver);
            //Hacemos la coneccion.
            Connection conn = DriverManager.getConnection(connectString, user, password);
            UsuariosRepositorio usuariosRepositorio = new UsuariosRepositorio(conn);
            UsuariosControlador usuariosControlador = new UsuariosControlador(usuariosRepositorio);
            PreferenciasRepositorio preferenciasRepositorio = new PreferenciasRepositorio(conn);
            PreferenciasControlador preferenciasControlador = new PreferenciasControlador(preferenciasRepositorio);
            PeliculasRepositorio peliculasRepositorio = new PeliculasRepositorio(conn);
            PeliculaControlador peliculaControlador = new PeliculaControlador(peliculasRepositorio);
            Javalin.create()
                    .events((EventListener event) -> {
                        event.serverStopped(() -> {
                            conn.close();
                        });
                    })
                    .routes(() -> {
                        path("usuarios", () -> {
                            get(usuariosControlador::listar);
                            post(usuariosControlador::crear);
                            path(":idUsuario", () -> {
                                delete(usuariosControlador::borrar);
                                put(usuariosControlador::modificar);
                            });
                        });
                        path("preferencias", () -> {
                            get(preferenciasControlador::listar);
                            post(preferenciasControlador::crear);
                            path(":idPreferecia", () -> {
                                delete(preferenciasControlador::borrar);
                                // put(preferenciasControlador::modificar); 
                            });
                        });
                        path("peliculas", () -> {
                            get(peliculaControlador::listar);
                            post(peliculaControlador::crear);
                            path(":idPelicula", () ->{
                                delete(peliculaControlador::borrar);
                                put(peliculaControlador::modificar);
                            });
                        });

                    })
                    .exception(UsuarioNoEncontradoExcepcion.class, (e, ctx) -> {
                        ctx.status(404);
                    })
                    .start(7000);
            //Si la conexion fue realizada con exito, muestra el sgte mensaje.
            System.out.println("Conexion exitosa!");
        } //Si se produce una Excepcion y no nos podemos conectar, muestra el sgte. mensaje.
        catch (SQLException e) {
            System.out.println("Problema con la conexion");
        }

    }
}
