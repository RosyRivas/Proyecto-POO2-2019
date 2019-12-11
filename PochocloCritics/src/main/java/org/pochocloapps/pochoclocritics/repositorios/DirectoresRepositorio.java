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
import org.pochocloapps.pochoclocritics.modelos.Director;

/**
 *
 * @author osvaldo
 */
public class DirectoresRepositorio {
    
    private Connection conexion;
    
    public DirectoresRepositorio(Connection conn) throws SQLException{
        this.conexion = conn;
    }
    
    public List<Director> listar() throws SQLException{
        List<Director> director = new ArrayList<>();
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("SELECT idDirector, biografia, nombre, apellido, fechaNac FROM director");
        while(resultado.next()){
            director.add(
                    new Director(
                       resultado.getInt("idDirector"),
                       resultado.getString("biografia"),
                       resultado.getString("nombre"),
                       resultado.getString("apellido"),
                       resultado.getString("fechaNac")
                    )
            );
        }
        resultado.close();
        consulta.close();
        return director;
    }
    
    public void crear( String biografia, String nombre, String apellido, String fechaNac)throws SQLException{
        PreparedStatement consulta = conexion.prepareStatement("INSERT INTO director (biografia, nombre, apellido, fechaNac) VALUES(?,?,?,?) VALUES");
        consulta.setString(1, biografia);
        consulta.setString(2, nombre);
        consulta.setString(3, apellido);
        consulta.setString(4, fechaNac);
        consulta.executeUpdate();
        consulta.close();
    }
    
    public Director obtener(int idDirector) throws SQLException, DirectorNoEncontradoException{
        PreparedStatement consulta = conexion.prepareStatement("SELECT idDirector, biografia, nombre, apellido, fechaNac FROM Director WHERE idDirector=?");
        consulta.setInt(1, idDirector);
        ResultSet resultado = consulta.executeQuery();
        try{
            if(resultado.next()){
                return new Director(
                        resultado.getInt("idDirector"),
                        resultado.getString("biografia"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("fechaNac")
                );
            }else{
                throw new DirectorNoEncontradoException();
            }         
        }finally{
            consulta.close();
            resultado.close();
        }
    }
    
    public void borrar(Director director) throws SQLException, DirectorNoEncontradoException{
        PreparedStatement consulta = conexion.prepareStatement("DELETE FROM Directores WHERE idDirector=?");
        consulta.setLong(1, director.getIdDirector());
        try{
            if(consulta.executeUpdate() == 0) throw new DirectorNoEncontradoException();
        }finally{
            consulta.close();
        }
    }
    
    public void modificar(Director director) throws SQLException, DirectorNoEncontradoException{
        PreparedStatement consulta = conexion.prepareStatement("UPDATE Director SET biografia=?, nombre=?, apellido=?, fechaNac=? WHERE idDirector=?");
        consulta.setString(1, director.getBiografia());
        consulta.setString(2, director.getNombre());
        consulta.setString(3, director.getApellido());
        consulta.setString(4, director.getFechaNac());
        consulta.setLong(5, director.getIdDirector());
        try{
            if(consulta.executeUpdate() == 0) throw new DirectorNoEncontradoException();
        }finally{
            consulta.close();
        }
    }
    
}
