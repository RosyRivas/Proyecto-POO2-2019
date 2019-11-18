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
import org.pochocloapps.pochoclocritics.modelos.Pelicula;

/**
 *
 * @author osvaldo
 */
public class PeliculasRepositorio {
    private final Connection conexion;
    
    //Se crea la tabla con un idPelicula, titulo, duracion y sinopsis
    //el campo duracion es de tipo texto
    //aún no se contempla la portada (imagen) de la pelicula
    public PeliculasRepositorio(Connection conn) throws SQLException{
        this.conexion = conn;
        Statement consulta =  conexion.createStatement();
        consulta.execute("CREATE TABLE IF NOT EXISTS peliculas(idPelicula SERIAL PRIMARY KEY, titulo TEXT, duracion TEXT, sinopsis TEXT)");
        consulta.close();
    }
    
    public List<Pelicula> listar() throws SQLException{
       List<Pelicula> peliculas = new ArrayList<>();
       Statement consulta = conexion.createStatement();
       ResultSet resultado = consulta.executeQuery("SELECT idPelicula, titulo, duracion, sinopsis FROM peliculas");
       while(resultado.next()){
           peliculas.add(
                   new Pelicula(
                           resultado.getLong("idPelicula"),
                           resultado.getString("titulo"),
                           resultado.getString("duracion"),
                           resultado.getString("sinopsis")   
                   )
           );
       }
       resultado.close();
       consulta.close();
       return peliculas;
    }
    
    public void crear(Long idPelicula, String titulo, String duracion, String sinopsis) throws SQLException{
        PreparedStatement consulta = conexion.prepareStatement("INSERT INTO peliculas(idPelicula, titulo, duracion, sinopsis) VALUES (?,?,?,?)");
        consulta.setLong(1, idPelicula);
        consulta.setString(2, titulo);
        consulta.setString(3, duracion);
        consulta.setString(4, sinopsis);
        consulta.executeUpdate();
        consulta.close();
    }
    
    public Pelicula obtener(Long idPelicula) throws SQLException, PeliculaNoEncontradaException {
        PreparedStatement consulta = conexion.prepareStatement("SELECT idPelicula, titulo, duracion, sinopsis FROM Peliculas WHERE idPelicula = ?");
        consulta.setLong(1, idPelicula);
        ResultSet resultado = consulta.executeQuery();
        try{
            if(resultado.next()){
                return new Pelicula(
                    resultado.getLong("idPelicula"),
                    resultado.getString("titulo"),
                    resultado.getString("duracion"),
                    resultado.getString("sinopsis")
                );
            }else{
                throw new PeliculaNoEncontradaException();
            }
        }finally{
            consulta.close();
            resultado.close();
        } 
    }
    
    public void borrar(Pelicula pelicula) throws SQLException, PeliculaNoEncontradaException{
        PreparedStatement consulta = conexion.prepareStatement("DELETE FROM peliculas WHERE idPelicula=?");
        consulta.setLong(1,pelicula.getIdPelicula());
        try{
            if(consulta.executeUpdate()== 0) throw new PeliculaNoEncontradaException();
        }finally{
            consulta.close();
        }
    }
    
    public void modificar(Pelicula pelicula) throws SQLException, PeliculaNoEncontradaException{
        PreparedStatement consulta = conexion.prepareStatement("UPDATE peliculas SET titulo=?, duracion=?, sinopsis=? WHERE idPelicula=?");
        consulta.setString(1, pelicula.getTitulo());
        consulta.setString(2, pelicula.getDuracion());
        consulta.setString(3, pelicula.getSinopsis());
        consulta.setLong(4, pelicula.getIdPelicula());
        
        try{
            if(consulta.executeUpdate() == 0) throw new PeliculaNoEncontradaException();
        }finally{
            consulta.close();
        }
    }
}
