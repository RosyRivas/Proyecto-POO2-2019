/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.pochocloapps.pochoclocritics.modelos.Actor;
import org.pochocloapps.pochoclocritics.modelos.Director;
import org.pochocloapps.pochoclocritics.modelos.Genero;
import org.pochocloapps.pochoclocritics.modelos.Preferencia;

/**
 *
 * @author DELL-PC
 */
public class PreferenciasRepositorio {

    private final Connection conexion;

    public PreferenciasRepositorio(Connection conn) throws SQLException {
        this.conexion = conn;
    }

    public List<Preferencia> listar() throws SQLException {
        List<Preferencia> preferencias = new ArrayList<>();
        Statement consulta = conexion.createStatement(); //createStatement utilizado para crear declaraciones (Statement). Statement se utiliza para crear consultas en la BD.
        ResultSet resultado = consulta.executeQuery("SELECT * FROM preferencia"); //executeQuery, método de Statement que es utilizado para crear consultas a la BD tipo SELECT. Retorna un Resulset que se puede utilizar para obtener todos los registros de una tabla.
        while (resultado.next()) {
            preferencias.add(
                    new Preferencia()
            );
        }
        resultado.close(); //Método de Conection para cerrar la coneccion del objeto y del Resultset.
        consulta.close();
        return preferencias;
    }

    public Preferencia obtenerPreferenciaUsuario(int idUsuario) throws SQLException, PreferenciaNoEncontradaExcepcion {
        List<Actor> actores = new ArrayList<>();
        List<Director> directores = new ArrayList<>();
        List<Genero> generos = new ArrayList<>();

        PreparedStatement consulta = conexion.prepareStatement("SELECT *FROM listar_preferencia_usuario_actor (?)");
        consulta.setInt(1, idUsuario);
        PreparedStatement consulta2 = conexion.prepareStatement("SELECT *FROM listar_preferencia_usuario_director (?)");
        consulta2.setInt(1, idUsuario);
        PreparedStatement consulta3 = conexion.prepareStatement("SELECT *FROM listar_preferencia_usuario_genero (?)");
        consulta3.setInt(1, idUsuario);

        ResultSet resultado = consulta.executeQuery();
        while (resultado.next()) {
            actores.add(
                    new Actor(
                            resultado.getInt("idactor"),
                            resultado.getString("nombre"),
                            resultado.getString("apellido"),
                            resultado.getString("fechanac"),
                            resultado.getString("biografia")
                    )
            );
        }
        resultado.close();
        consulta.close();

        ResultSet resultado2 = consulta2.executeQuery();
        while (resultado2.next()) {
            directores.add(
                    new Director(
                            resultado2.getInt("iddirector"),
                            resultado2.getString("nombre"),
                            resultado2.getString("apellido"),
                            resultado2.getString("fechanac"),
                            resultado2.getString("biografia")
                    )
            );
        }
        resultado2.close();
        consulta2.close();

        ResultSet resultado3 = consulta3.executeQuery();
        while (resultado3.next()) {
            generos.add(
                    new Genero(
                            resultado3.getInt("idgenero"),
                            resultado3.getString("descripcion")
                    )
            );
        }
        resultado3.close();
        consulta3.close();

        PreparedStatement consultaid = conexion.prepareStatement("SELECT p.idPreferencia FROM preferencia p WHERE p.idusuario = ?");                                                                                                                                       //Se utiliza prepareStatement (Metodo de Conection) para obtener el objeto PreparedStatement.
        consultaid.setInt(1, idUsuario);
        ResultSet resultadoid = consultaid.executeQuery();
        try {
            if (resultadoid.next()) {
                return new Preferencia(
                        resultadoid.getInt("idpreferencia"),
                        actores,
                        directores,
                        generos
                );

            } else {
                throw new PreferenciaNoEncontradaExcepcion();
            }
        } finally {
            consultaid.close();
            resultadoid.close();
        }

    }

    public void crear(int idPreferencia, List<Actor> actor, List<Director> director, List<Genero> genero) throws SQLException {
        List<Actor> actores = new ArrayList(actor);
        List<Director> directores = director;
        List<Genero> generos = genero;
        int idPref = idPreferencia;

        for (int i = 0; i < actores.size(); i++) {
            if (actores.contains(actores.get(i))) {
                PreparedStatement consulta = conexion.prepareStatement("select from crear_preferencia_usuario_actor((select p.idusuario from preferencia p where p.idpreferencia = ?),?)"); //Ver que parametros utilizar para ingresar una preferencia como ser lista de objetos de actores, directores y generos.
                consulta.setInt(1, idPref);
                consulta.setInt(2, actores.get(i).getIdActor());
                consulta.execute();
                consulta.close();
            }
        }
        for (int i = 0; i < directores.size(); i++) {
            if (directores.contains(directores.get(i))) {
                PreparedStatement consulta2 = conexion.prepareStatement("select from crear_preferencia_usuario_director((select p.idusuario from preferencia p where p.idpreferencia = ?),?)"); //Ver que parametros utilizar para ingresar una preferencia como ser lista de objetos de actores, directores y generos.
                consulta2.setInt(1, idPref);
                consulta2.setInt(2, directores.get(i).getIdDirector());
                consulta2.execute();
                consulta2.close();
            }

        }

        for (int i = 0; i < generos.size(); i++) {
            if (generos.contains(generos.get(i))) {
                PreparedStatement consulta3 = conexion.prepareStatement("select from crear_preferencia_usuario_genero((select p.idusuario from preferencia p where p.idpreferencia = ?),?)"); //Ver que parametros utilizar para ingresar una preferencia como ser lista de objetos de actores, directores y generos.
                consulta3.setInt(1, idPref);
                consulta3.setInt(2, generos.get(i).getIdGenero());
                consulta3.execute();
                consulta3.close();
            }

        }
    }

    public void borrar(Preferencia preferencia) throws SQLException, PreferenciaNoEncontradaExcepcion {
        PreparedStatement consulta = conexion.prepareStatement("DELETE FROM preferencias WHERE idPreferencia = ?"); // Tambien se puede indicar que preferencia se desea eliminar (idPreferencia)
        consulta.setInt(1, preferencia.getIdPreferencia());
        try {
            if (consulta.executeUpdate() == 0) {
                throw new PreferenciaNoEncontradaExcepcion();
            }
        } finally {
            consulta.close();
        }
    }

    public void modificar(int idPreferencia, List<Actor> actor, List<Director> director, List<Genero> genero) throws SQLException {
        List<Actor> actores = new ArrayList(actor);
        List<Director> directores = director;
        List<Genero> generos = genero;

        if (actores.size() == 1) {
            PreparedStatement consulta = conexion.prepareStatement("select from eliminar_preferencia_usuario_actor((select p.idusuario from preferencia p where p.idpreferencia = ?),?)"); //Ver que parametros utilizar para ingresar una preferencia como ser lista de objetos de actores, directores y generos.
            consulta.setInt(1, idPreferencia);
            consulta.setInt(2, actores.get(0).getIdActor());
            consulta.execute();
            consulta.close();
        }
        if (directores.size() == 1) {
            PreparedStatement consulta2 = conexion.prepareStatement("select from eliminar_preferencia_usuario_director((select p.idusuario from preferencia p where p.idpreferencia = ?),?)"); //Ver que parametros utilizar para ingresar una preferencia como ser lista de objetos de actores, directores y generos.
            consulta2.setInt(1, idPreferencia);
            consulta2.setInt(2, directores.get(0).getIdDirector());
            consulta2.execute();
            consulta2.close();
        }
        if (generos.size() == 1) {
            PreparedStatement consulta3 = conexion.prepareStatement("select from eliminar_preferencia_usuario_genero((select p.idusuario from preferencia p where p.idpreferencia = ?),?)"); //Ver que parametros utilizar para ingresar una preferencia como ser lista de objetos de actores, directores y generos.
            consulta3.setInt(1, idPreferencia);
            consulta3.setInt(2, generos.get(0).getIdGenero());
            consulta3.execute();
            consulta3.close();
        }

    }
}
