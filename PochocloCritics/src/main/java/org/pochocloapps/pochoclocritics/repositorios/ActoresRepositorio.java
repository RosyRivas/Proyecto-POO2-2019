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

/**
 *
 * @author Rosi-PC
 */
public class ActoresRepositorio {
       
    private final Connection conexion;
       
    public ActoresRepositorio(Connection conn) throws SQLException {
        this.conexion = conn;
    }
   public List<Actor> listar() throws SQLException {
        List<Actor> actor = new ArrayList<>();
        Statement consulta = conexion.createStatement(); //createStatement utilizado para crear declaraciones (Statement). Statement se utiliza para crear consultas en la BD.
        ResultSet resultado = consulta.executeQuery("SELECT idActor,nombre, apellido,fechanac,biografia FROM actor"); //executeQuery, método de Statement que es utilizado para crear consultas a la BD tipo SELECT. Retorna un Resulset que se puede utilizar para obtener todos los registros de una tabla.
        while (resultado.next()) {
            actor.add(
                new Actor(
                    resultado.getInt("idActor"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("fechanac"),
                    resultado.getString("biografia")  
                   
                )
            );
        }
        resultado.close(); //Método de Conection para cerrar la coneccion del objeto y del Resultset.
        consulta.close();
        return actor;
    } 
   public void crear(String biografia, String nombre,String apellido, String fechanac) throws SQLException {
        PreparedStatement consulta = conexion.prepareStatement("INSERT INTO actor (biografia, nombre,apellido, fechanac) VALUES (?, ?,?,?)");
        consulta.setString(1, biografia);
        consulta.setString(2, nombre);
       consulta.setString(3, apellido);
        consulta.setString(4, fechanac);
        consulta.executeUpdate();  //Metodo de prepareStatement (a la vez de Statement "interface padre") que realiza una consulta. Utilizado para create, drop, insert, update, delete etc.
        consulta.close();
    }
   
   public Actor obtener(int idActor) throws SQLException, ActorNoEncontradoExcepcion {
        PreparedStatement consulta = conexion.prepareStatement("SELECT idActor, nombre,  apellido, fechanac, biografia FROM actor WHERE idActor = ?"); //PreparedStatement utilizado para realizar consultas parametrizadas. Subinterface de Statement.                                                                                                                                       //Se utiliza prepareStatement (Metodo de Conection) para obtener el objeto PreparedStatement.
        consulta.setInt(1, idActor);            //Ajusta el valor entero al parametro dado. Este caso el 1 (identificador).                                                                                                  
        ResultSet resultado = consulta.executeQuery(); //Puntero que apunta al primer registro de una tabla. Inicialmente esta antes de la primer fila.
        try {
            if (resultado.next()) { //.next es un metodo de Resulset que permite avanzar el puntero a la siguiente posicion.
                return new Actor(
                        resultado.getInt("idActor"), 
                        resultado.getString("nombre"),
                       resultado.getString("apellido"),
                    resultado.getString("fechanac"),
                    resultado.getString("biografia")  
                        
                );
            } else {
                throw new ActorNoEncontradoExcepcion();
            }
        }
        finally {
            consulta.close();
            resultado.close();
        }
    }
   
   public void borrar(Actor actor) throws SQLException, ActorNoEncontradoExcepcion {
        PreparedStatement consulta = conexion.prepareStatement("DELETE FROM actor WHERE idActor = ?");
        consulta.setInt(1, actor.getIdActor());
        try {
            if (consulta.executeUpdate() == 0) throw new ActorNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }
   
   public void modificar(Actor actor) throws SQLException, ActorNoEncontradoExcepcion {
        PreparedStatement consulta = conexion.prepareStatement("UPDATE actor SET biografia = ?, nombre = ?, apellido = ?, fechanac = ? WHERE idActor = ?");
             consulta .setString(1,actor.getBiografia());
              consulta.setString(2, actor.getNombre());
                consulta.setString(3, actor.getApellido());
                consulta.setString(4, actor.getFechaNac());
   
    
       
        try {
            if (consulta.executeUpdate() == 0) throw new ActorNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }  
}