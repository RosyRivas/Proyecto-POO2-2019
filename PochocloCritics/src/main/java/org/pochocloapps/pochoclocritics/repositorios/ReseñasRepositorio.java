/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pochocloapps.pochoclocritics.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.pochocloapps.pochoclocritics.modelos.Reseña;
   import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.pochocloapps.pochoclocritics.modelos.Reseña;
/**
 *
 * @author Rosi-PC
 */
public class ReseñasRepositorio {
     private final Connection conexion;
  
       public ReseñasRepositorio(Connection conn) throws SQLException{
        
        this.conexion= conn;
    }
       
        public void crear(String descripcion) throws SQLException {
        PreparedStatement consulta = conexion.prepareStatement("INSERT INTO Reseña (descripcion) VALUES (?)");
        consulta.setString(1, descripcion);
        consulta.executeUpdate();  //Metodo de prepareStatement (a la vez de Statement "interface padre") que realiza una consulta. Utilizado para create, drop, insert, update, delete etc.
        consulta.close();
    }
   
    public void borrar(Reseña reseña )throws SQLException, ReseñaNoEncontradoException{
        PreparedStatement consulta = conexion.prepareStatement("");
        consulta.setInt(1, reseña.getIdReseña());
        try{    
            if (consulta.executeUpdate() == 0) throw new ReseñaNoEncontradoException() ;
        }finally{
                consulta.close();
                
                }
    
    }
    public List<Reseña> listar()  throws SQLException{
        List<Reseña> reseña = new ArrayList< >() ;
          Statement consulta = conexion.createStatement(); //createStatement utilizado para crear declaraciones (Statement). Statement se utiliza para crear consultas en la BD.
        ResultSet resultado = consulta.executeQuery("SELECT idReseña,descripcion FROM Reseña"); //executeQuery, método de Statement que es utilizado para crear consultas a la BD tipo SELECT. Retorna un Resulset que se puede utilizar para obtener todos los registros de una tabla.
        while (resultado.next()) {
            reseña.add(
                new Reseña(
                    resultado.getInt("idReseña"),
                    resultado.getString("descripcion") 
                   
                    )
            );
        }
               resultado.close(); //Método de Conection para cerrar la coneccion del objeto y del Resultset.
        consulta.close();
        return reseña;
    }
    public void crear(int idReseña ,String descripcion) throws SQLException {
        PreparedStatement consulta = conexion.prepareStatement("INSERT INTO Reseña (idReseña,descripcion ) VALUES (?,?)");
        consulta.setInt(1, idReseña);
        consulta.setString(2, descripcion);
       // consulta.setInt(2, idPelicula);
        consulta.executeUpdate();  //Metodo de prepareStatement (a la vez de Statement "interface padre") que realiza una consulta. Utilizado para create, drop, insert, update, delete etc.
        consulta.close();
    }
   
public void modificar (Reseña reseña ) throws SQLException,ReseñaNoEncontradoException  {
    PreparedStatement consulta = conexion.prepareStatement("UPDATE Reseña SET descripcion = ?");
        consulta.setString(1, reseña.getDescripcion());
      //  consulta.setInt(2, reseña.getidpelicula);
       
        try {
            if (consulta.executeUpdate() == 0) throw new ReseñaNoEncontradoException();
        }
        finally {
            consulta.close();
        }
    }
public Reseña  obtener(int idReseña) throws SQLException, ReseñaNoEncontradoException {
        PreparedStatement consulta = conexion.prepareStatement("SELECT idReseña, descripcion FROM reseña WHERE idReseña = ?"); //PreparedStatement utilizado para realizar consultas parametrizadas. Subinterface de Statement.                                                                                                                                       //Se utiliza prepareStatement (Metodo de Conection) para obtener el objeto PreparedStatement.
        consulta.setInt(1, idReseña);            //Ajusta el valor entero al parametro dado. Este caso el 1 (identificador).                                                                                                  
        ResultSet resultado = consulta.executeQuery(); //Puntero que apunta al primer registro de una tabla. Inicialmente esta antes de la primer fila.
        try {
            if (resultado.next()) { //.next es un metodo de Resulset que permite avanzar el puntero a la siguiente posicion.
                return new Reseña(
                        resultado.getInt("idReseña"), //Metodos get de ResulSet para obtener el contenido de la fila donde esta parado.
                        resultado.getString("descripcion")
                        
                );
            } else {
                throw new ReseñaNoEncontradoException();
            }
        }
        finally {
            consulta.close();
            resultado.close();
        }
    }
}  