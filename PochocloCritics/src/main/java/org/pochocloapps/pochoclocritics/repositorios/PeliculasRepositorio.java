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
    }
    
    public List<Pelicula> listar() throws SQLException{
       List<Pelicula> peliculas = new ArrayList<>();
       Statement consulta = conexion.createStatement();
       ResultSet resultado = consulta.executeQuery("SELECT idPelicula, titulo, portada, duracion, sinopsis FROM pelicula");
       while(resultado.next()){
           peliculas.add(
                   new Pelicula(
                           resultado.getInt("idPelicula"),
                           resultado.getString("titulo"),
                           resultado.getString("portada"),
                           resultado.getString("duracion"),
                           resultado.getString("sinopsis")   
                   )
           );
       }
       resultado.close();
       consulta.close();
       return peliculas;
    }
    
    public void crear(int idPelicula, String titulo,String portada, String duracion, String sinopsis, List<Actor> actores, List<Director> directores, List<Genero> generos) throws SQLException{
        List<Actor> tomarActores = actores;
        List<Director> tomarDirectores = directores;
        List<Genero> tomarGeneros = generos;
         
        PreparedStatement consulta = conexion.prepareStatement("insert into pelicula (titulo, portada, duracion, sinopsis) values (?,?,?,?)"); //Ver que parametros utilizar para ingresar una preferencia como ser lista de objetos de actores, directores y generos.
        consulta.setString(1, titulo);
        consulta.setString(2, portada);
        consulta.setString(3, duracion);
        consulta.setString(4, sinopsis);    
        consulta.execute();
        consulta.close();
        
        for (int i = 0; i < tomarActores.size(); i++) {
            if (actores.contains(tomarActores.get(i))) {
                PreparedStatement consulta2 = conexion.prepareStatement("select from actor_pelicula((select p.idPelicula from pelicula p  where p.titulo = ?), ?)"); //Ver que parametros utilizar para ingresar una preferencia como ser lista de objetos de actores, directores y generos.
                consulta2.setString(1, titulo);
                consulta2.setInt(2, tomarActores.get(i).getIdActor());
                consulta2.execute();
                consulta2.close();
            }
        }
        
        for (int i = 0; i < tomarDirectores.size(); i++) {
            if (tomarDirectores.contains(tomarDirectores.get(i))) {
                PreparedStatement consulta3 = conexion.prepareStatement("select from director_pelicula((select p.idPelicula from pelicula p  where p.titulo = ?), ?)"); //Ver que parametros utilizar para ingresar una preferencia como ser lista de objetos de actores, directores y generos.
                consulta3.setString(1, titulo);
                consulta3.setInt(2, tomarDirectores.get(i).getIdDirector());
                consulta3.execute();
                consulta3.close();
            }   
    }
        for (int i = 0; i < tomarGeneros.size(); i++) {
            if (generos.contains(tomarGeneros.get(i))) {
                PreparedStatement consulta4 = conexion.prepareStatement("select from genero_pelicula((select p.idPelicula from pelicula p  where p.titulo = ?),?)"); //Ver que parametros utilizar para ingresar una preferencia como ser lista de objetos de actores, directores y generos.
                consulta4.setString(1, titulo);
                consulta4.setInt(2, tomarGeneros.get(i).getIdGenero());
                consulta4.execute();
                consulta4.close();
            }
    }
    }
    
    public Pelicula obtener(int idPelicula) throws SQLException, PeliculaNoEncontradaException {
        PreparedStatement consulta = conexion.prepareStatement("SELECT idPelicula, titulo,portada, duracion, sinopsis FROM Peliculas WHERE idPelicula = ?");
        consulta.setInt(1, idPelicula);
        ResultSet resultado = consulta.executeQuery();
        try{
            if(resultado.next()){
                return new Pelicula(
                    resultado.getInt("idPelicula"),
                    resultado.getString("titulo"),
                    resultado.getString("portada"),
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
