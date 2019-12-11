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
import org.pochocloapps.pochoclocritics.modelos.Usuario;

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
                    new Preferencia(
                            resultado.getInt("idPreferencia")
                    )
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
          Preferencia preferencia = new Preferencia();
          /*PreparedStatement consultita = conexion.prepareStatement("SELECT idpreferencia FROM preferencias where idusuario = ?");
          consultita.setInt(1, idUsuario);*/  //En caso de ser necesario, lo utilizamos y modificamos la clase Preferencia habilitando un setId para el id obtenido si existe.
          
          PreparedStatement consulta = conexion.prepareStatement("SELECT *FROM listar_preferencia_usuario_actor (?)");
          consulta.setInt(1, idUsuario);
          PreparedStatement consulta2 = conexion.prepareStatement("SELECT *FROM listar_preferencia_usuario_director (?)");
          consulta2.setInt(1, idUsuario);
          PreparedStatement consulta3 = conexion.prepareStatement("SELECT *FROM listar_preferencia_usuario_genero (?)");
          consulta3.setInt(1, idUsuario);
          
          ResultSet resultado = consulta.executeQuery(); //Puntero que apunta al primer registro de una tabla. Inicialmente esta antes de la primer fila.
             while (resultado.next()) {
                actores.add(
                    new Actor(
                            resultado.getInt("idactor"),
                            resultado.getString("biografia"),
                            resultado.getString("nombre"),
                            resultado.getString("apellido"),
                            resultado.getString("fechanac")
                    )
            );
        }
             resultado.close();
             consulta.close();
             preferencia.setActor(actores);
             
          ResultSet resultado2 = consulta2.executeQuery(); //Puntero que apunta al primer registro de una tabla. Inicialmente esta antes de la primer fila.
            while (resultado2.next()) {
                directores.add(
                    new Director(
                            resultado2.getInt("iddirector"),
                            resultado2.getString("biografia"),
                            resultado2.getString("nombre"),
                            resultado2.getString("apellido"),
                            resultado2.getString("fechanac")
                    )
            );
        }
            resultado2.close();
            consulta2.close();
            preferencia.setDirector(directores);
             
            ResultSet resultado3 = consulta3.executeQuery(); //Puntero que apunta al primer registro de una tabla. Inicialmente esta antes de la primer fila.
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
             preferencia.setGenero(generos);
     
        return preferencia;
    }

    public void crear(int idPreferencia) throws SQLException {
        PreparedStatement consulta = conexion.prepareStatement("INSERT INTO preferencias (idPreferencia) VALUES (?)"); //Ver que parametros utilizar para ingresar una preferencia como ser lista de objetos de actores, directores y generos.
        consulta.setInt(1, idPreferencia);
        consulta.executeUpdate();  //Metodo de prepareStatement (a la vez de Statement "interface padre") que realiza una consulta. Utilizado para create, drop, insert, update, delete etc.
        consulta.close();
    }

    public Preferencia obtener(int idPreferencia) throws SQLException, PreferenciaNoEncontradaExcepcion {                           
        PreparedStatement consulta = conexion.prepareStatement("SELECT idPreferencia FROM preferencias WHERE idPreferencia = ?"); //PreparedStatement utilizado para realizar consultas parametrizadas. Subinterface de Statement.                                                                                                                                       //Se utiliza prepareStatement (Metodo de Conection) para obtener el objeto PreparedStatement.
        consulta.setInt(1, idPreferencia);            //Ajusta el valor entero al parametro dado. Este caso el 1 (idPreferencia).                                                                                                  
        ResultSet resultado = consulta.executeQuery(); //Puntero que apunta al primer registro de una tabla. Inicialmente esta antes de la primer fila.
        try {
            if (resultado.next()) { //.next es un metodo de Resulset que permite avanzar el puntero a la siguiente posicion.
                return new Preferencia(
                        resultado.getInt("idPreferencia") //Metodos get de ResulSet para obtener el contenido de la fila donde esta parado.                    
                );
            } else {
                throw new PreferenciaNoEncontradaExcepcion();
            }
        } finally {
            consulta.close();
            resultado.close();
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

    public void modificar(Preferencia preferencia) throws SQLException, UsuarioNoEncontradoExcepcion { 
                                                                                                       
        PreparedStatement consulta = conexion.prepareStatement("UPDATE preferencias SET .... WHERE idPreferencia = ?"); //Puede que sea innecesario un UPDATE, como alternativa, utilizar a los metodos de crear y borrar preferencia (como alta y baja). 
        consulta.setInt(1, preferencia.getIdPreferencia());                                                            
        

        try {
            if (consulta.executeUpdate() == 0) {
                throw new UsuarioNoEncontradoExcepcion();
            }
        } finally {
            consulta.close();
        }
    }
}
