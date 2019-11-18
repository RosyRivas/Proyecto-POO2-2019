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
import org.pochocloapps.pochoclocritics.controladores.PreferenciasControlador;
import org.pochocloapps.pochoclocritics.controladores.ReseñasControlador;
import org.pochocloapps.pochoclocritics.controladores.UsuariosControlador;
import org.pochocloapps.pochoclocritics.repositorios.PreferenciasRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.ReseñasRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.UsuariosRepositorio;
import org.pochocloapps.pochoclocritics.repositorios.PreferenciaNoEncontradaExcepcion;
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
        String connectString = "jdbc:postgresql://localhost:5433/ejemplo";
        String user = "postgres";
        String password = "1234";

        try {
            Class.forName(driver);
            //Hacemos la coneccion.
            Connection conn = DriverManager.getConnection(connectString, user, password);
            UsuariosRepositorio usuariosRepositorio = new UsuariosRepositorio(conn);
            UsuariosControlador usuariosControlador = new UsuariosControlador(usuariosRepositorio);
            var preferenciasRepositorio = new PreferenciasRepositorio(conn);
            var preferenciasControlador = new PreferenciasControlador(preferenciasRepositorio);
            ReseñasRepositorio reseñaRepositorio =new ReseñasRepositorio(conn);
             ReseñasControlador reseñaControlador = new ReseñasControlador (reseñaRepositorio);
            
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
                            path(":idPreferecia", () -> {
                                delete(preferenciasControlador::borrar);
                                // put(preferenciasControlador::modificar); 
                            });
                        });
                    })
               .exception(PreferenciaNoEncontradaExcepcion.class, (e, ctx) -> {
                        ctx.status(404);
                    })
                    .start(7000);
            //Si la conexion fue realizada con exito, muestra el sgte mensaje.
            System.out.println("Conexion exitosa!");
        } //Si se produce una Excepcion y no nos podemos conectar, muestra el sgte. mensaje.
        catch (SQLException e) {
            System.out.println("Problema con la conexion");
        }

    }}
//>>>>>>> b6982fff1395316a51c4bce0e1f1be031ab2717e:PochocloCritics/src/main/java/org/pochocloapps/pochoclocritics/server/Servidor.java
