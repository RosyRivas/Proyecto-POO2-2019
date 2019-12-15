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
import org.pochocloapps.pochoclocritics.modelos.Genero;


/**
 *
 * @author DELL-PC
 */
public class GenerosRepositorio {
     private final Connection conexion;
    
    public GenerosRepositorio(Connection conn) throws SQLException{
        this.conexion = conn;
    }
    
    public List<Genero> listar() throws SQLException{
       List<Genero> generos = new ArrayList<>();
       Statement consulta = conexion.createStatement();
       ResultSet resultado = consulta.executeQuery("SELECT idGenero, descripcion FROM genero");
       while(resultado.next()){
           generos.add(
                   new Genero(
                           resultado.getInt("idGenero"),
                           resultado.getString("descripcion")  
                   )
           );
       }
       resultado.close();
       consulta.close();
       return generos;
    }
    
    public void crear(String descripcion) throws SQLException{
        PreparedStatement consulta = conexion.prepareStatement("INSERT INTO generos(descripcion) VALUES (?)");
        consulta.setString(1, descripcion);
        consulta.executeUpdate();
        consulta.close();
    }
    
    public Genero obtener(int idGenero) throws SQLException, GeneroNoEncontradoException {
        PreparedStatement consulta = conexion.prepareStatement("SELECT idGenero, descripcion FROM genero WHERE idGenero = ?");
        consulta.setInt(1, idGenero);
        ResultSet resultado = consulta.executeQuery();
        try{
            if(resultado.next()){
                return new Genero(
                    resultado.getInt("idGenero"),
                    resultado.getString("descripcion")
                );
            }else{
                throw new GeneroNoEncontradoException();
            }
        }finally{
            consulta.close();
            resultado.close();
        } 
    }
    
    public void borrar(Genero genero) throws SQLException, GeneroNoEncontradoException{
        PreparedStatement consulta = conexion.prepareStatement("DELETE FROM generos WHERE idGenero=?");
        consulta.setInt(1,genero.getIdGenero());
        try{
            if(consulta.executeUpdate()== 0) throw new GeneroNoEncontradoException();
        }finally{
            consulta.close();
        }
    }
    
    public void modificar(Genero genero) throws SQLException, GeneroNoEncontradoException{
        PreparedStatement consulta = conexion.prepareStatement("UPDATE generos SET descripcion=? WHERE idGenero=?");
        consulta.setString(1, genero.getDescripcion());
        consulta.setInt(2, genero.getIdGenero());
        
        try{
            if(consulta.executeUpdate() == 0) throw new GeneroNoEncontradoException();
        }finally{
            consulta.close();
        }
    }
}
