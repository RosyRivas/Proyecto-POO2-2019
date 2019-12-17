//<<<<<<< HEAD:PochocloCritics/src/main/java/org/pochocloapps/pochoclocritics/server/server.java
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
import org.pochocloapps.pochoclocritics.controladores.GenerosControlador;
import org.pochocloapps.pochoclocritics.controladores.PeliculaControlador;
import org.pochocloapps.pochoclocritics.controladores.ActoresControlador;
import org.pochocloapps.pochoclocritics.controladores.DirectoresControlador;
import org.pochocloapps.pochoclocritics.controladores.ModeradoresControlador;
import org.pochocloapps.pochoclocritics.controladores.PreferenciasControlador;
import org.pochocloapps.pochoclocritics.controladores.ReseñasControlador;
import org.pochocloapps.pochoclocritics.controladores.UsuariosControlador;
import org.pochocloapps.pochoclocritics.repositorios.PeliculasRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.ActorNoEncontradoExcepcion;
import org.pochocloapps.pochoclocritics.repositorios.ActoresRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.DirectorNoEncontradoException;
import org.pochocloapps.pochoclocritics.repositorios.DirectoresRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.ModeradorNoEncontradoException;
import org.pochocloapps.pochoclocritics.repositorios.ModeradorRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.PreferenciasRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.ReseñasRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.UsuariosRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.PreferenciaNoEncontradaExcepcion;
import org.pochocloapps.pochoclocritics.repositorios.GenerosRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.GeneroNoEncontradoException;

/**
 *
 * @author DELL-PC
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        String driver = "org.postgresql.Driver";
        String connectString = "jdbc:postgresql://localhost:5433/PochocloBD";
        String user = "postgres";
        String password = "1234";
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
            ReseñasRepositorio reseñaRepositorio = new ReseñasRepositorio(conn);
            ReseñasControlador reseñaControlador = new ReseñasControlador(reseñaRepositorio);
            ActoresRepositorio actoresRepositorio = new ActoresRepositorio(conn);
            ActoresControlador actorControlador = new ActoresControlador(actoresRepositorio);
            DirectoresRepositorio directoresRepositorio = new DirectoresRepositorio(conn);
            DirectoresControlador directoresControlador = new DirectoresControlador(directoresRepositorio);
            ModeradorRepositorio moderadorRepositorio = new ModeradorRepositorio(conn);
            ModeradoresControlador moderadoresControlador = new ModeradoresControlador(moderadorRepositorio);
            GenerosRepositorio generosRepositorio = new GenerosRepositorio(conn);
            GenerosControlador generosControlador = new GenerosControlador(generosRepositorio);

            Javalin.create(config -> {
            //config.defaultContentType = "application/json";
            config.addStaticFiles("/publico");
            //config.enableCorsForAllOrigins();
            //config.addSinglePageRoot("/", "/public/index.html");
             })    
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
                    })
                    .exception(UsuarioNoEncontradoExcepcion.class, (e, ctx) -> {
                        ctx.status(404);
                    })
                    .routes(() -> {
                        path("reseña", () -> {
                            get(reseñaControlador::listar);
                            post(reseñaControlador::crear);
                            path(":idReseña", () -> {
                                delete(reseñaControlador::borrar);
                                put(reseñaControlador::modificar);
                            });
                        });
                    })
                    .exception(ReseñaNoEncontradoExcepcion.class, (e, ctx) -> {
                        ctx.status(404);
                    })
                    .routes(() -> {
                        path("preferencias", () -> {
                            get(preferenciasControlador::listar);
                            post(preferenciasControlador::crear);
                            path(":idUsuario", () -> {
                             //   delete(preferenciasControlador::borrar);
                                put(preferenciasControlador::modificar); 
                                get(preferenciasControlador::obtener);
                            });
                        });
                    })
                    .routes(() -> {
                        path("generos", () -> {
                            get(generosControlador::listar);
                            post(generosControlador::crear);
                            path(":idGenero", () -> {
                                get(generosControlador::obtener);
                                delete(generosControlador::borrar);
                                put(generosControlador::modificar); 
                            });
                        });
                    })
                    .exception(GeneroNoEncontradoException.class, (e, ctx) -> {
                        ctx.status(404);
                    })
                    .routes(() -> {
                        path("peliculas", () -> {
                            get(peliculaControlador::listar);
                            post(peliculaControlador::crear);
                            path(":idPelicula", () -> {
                                 get(peliculaControlador::obtenerGenero);
                                delete(peliculaControlador::borrar);
                                put(peliculaControlador::modificar);
                            });
                        });
                    })
                    .exception(PreferenciaNoEncontradaExcepcion.class, (e, ctx) -> {
                        ctx.status(404);
                    })
                    .routes(() -> {
                        path("actor", () -> {
                            get(actorControlador::listar);
                            post(actorControlador::crear);
                            path(":idActor", () -> {
                                get(actorControlador::obtener);
                                delete(actorControlador::borrar);
                                put(actorControlador::modificar);
                            });
                        });
                    })
                    .exception(ActorNoEncontradoExcepcion.class, (e, ctx) -> {
                        ctx.status(404);
                    })
                    
                    .routes(() -> {
                        path("director", () -> {
                            get(directoresControlador::listar);
                            post(directoresControlador::crear);
                            path(":idDirector", () -> {
                                get(directoresControlador::obtener);
                                delete(directoresControlador::borrar);
                                put(directoresControlador::modificar);
                            });
                        });
                    })
                    .exception(DirectorNoEncontradoException.class, (e, ctx) -> {
                        ctx.status(404);
                    })
                    .routes(() -> {
                        path("moderador", () -> {
                            get(moderadoresControlador::listar);
                            post(moderadoresControlador::crear);
                            path(":idModerador", () -> {
                                delete(moderadoresControlador::borrar);
                                put(moderadoresControlador::modificar);
                            });
                        });
                    })
                    .exception(ModeradorNoEncontradoException.class, (e, ctx) -> {
                        ctx.status(404);
                    })
                    .start(7000);

            //Si la conexion fue realizada con exito, muestra el sgte mensaje.
            System.out.println("Conexion exitosa!");
        } //Si se produce una Excepcion y no nos podemos conectar, muestra el sgte. mensaje.
        catch (SQLException e) {
            System.out.println("Problema con la conexion: " + e);
        }

    }
}
