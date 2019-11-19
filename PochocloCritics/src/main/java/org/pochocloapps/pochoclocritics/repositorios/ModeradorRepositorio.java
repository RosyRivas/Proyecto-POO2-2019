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
import org.pochocloapps.pochoclocritics.modelos.Moderador;

/**
 *
 * @author osvaldo
 */
public class ModeradorRepositorio {
    
    private final Connection conexion;
    
    public ModeradorRepositorio(Connection conexion) throws SQLException{
        this.conexion = conexion;
        Statement consulta = conexion.createStatement();
        consulta.execute("CREATE TABLE IF NOT EXISTS moderador(idModerador SERIAL PRIMARY KEY, privilegio TEXT, nombre TEXT, apellido TEXT, fechaNac TEXT,  correo TEXT, alias TEXT, contraseña TEXT)");
        consulta.close();
    }
    
    public List<Moderador> listar() throws SQLException{
        List<Moderador> moderador = new ArrayList<>();
        Statement consulta = conexion.createStatement();
        ResultSet resultado = consulta.executeQuery("SELECT idModerador, privilegio, nombre, apellido, fechaNac, correo, alias, contraseña FROM Moderador");
        while(resultado.next()){
            moderador.add(
                    new Moderador(
                           resultado.getLong("idModerador"),
                           resultado.getString("privilegio"),
                           resultado.getString("nombre"),
                           resultado.getString("apellido"),
                           resultado.getString("fechaNac"),
                           resultado.getString("correo"),
                           resultado.getString("alias"),
                           resultado.getLong("contraseña")
                    )
            );
        }
        resultado.close();
        consulta.close();
        return moderador;
    }
    
    public void crear(String privilegios, String nombre, String apellido, String fechaNac, String correo, String alias, Long contraseña) throws SQLException{
        PreparedStatement consulta = conexion.prepareStatement("INSERT INTO Moderador (privilegios, nombre, apellido, fechaNac, correo, alias, contraseña) VALUES (?,?,?,?,?,?,?)");
        consulta.setString(1, privilegios);
        consulta.setString(2, nombre);
        consulta.setString(3, apellido);
        consulta.setString(4, fechaNac);
        consulta.setString(5, correo);
        consulta.setString(6, alias);
        consulta.setLong(7, contraseña);
        consulta.executeUpdate();
        consulta.close(); 
    }
    
    public Moderador obtener(Long idModerador) throws SQLException, ModeradorNoEncontradoException{
        PreparedStatement consulta = conexion.prepareStatement("SELECT idModerador, privilegios, nombre, apellido, fechaNac, correo, alias, contraseña FROM Moderador WHERE idModerador=?");
        consulta.setLong(1, idModerador);
        ResultSet resultado = consulta.executeQuery();
        try{
            if(resultado.next()){
                return new Moderador(
                    resultado.getLong("idModerador"),
                    resultado.getString("privilegios"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("fechanac"),
                    resultado.getString("correo"),
                    resultado.getString("alias"),
                    resultado.getLong("contrasela")
                );
            }else{
                throw new ModeradorNoEncontradoException();
            }
        }finally{
            resultado.close();
            consulta.close();
        }
    }
    
    public void borrar(Moderador moderador) throws SQLException, ModeradorNoEncontradoException{
        PreparedStatement consulta = conexion.prepareStatement("DELETE FROM Moderadores WHERE idModerador=?");
        consulta.setLong(1, moderador.getIdModerador());
        try{
            if(consulta.executeUpdate() == 0) throw new ModeradorNoEncontradoException();
        }finally{
            consulta.close();
        }
    }
    
    public void modificar(Moderador moderador) throws SQLException, ModeradorNoEncontradoException{
        PreparedStatement consulta = conexion.prepareStatement("UPDATE Moderador SET privilegios=? nombre = ?, apellido = ?, fechaNac = ?, correo = ?, alias = ?, contraseña = ? WHERE idModerador=? ");
        consulta.setString(1, moderador.getPrivilegios());
        consulta.setString(2, moderador.getNombre());
        consulta.setString(3, moderador.getApellido());
        consulta.setString(4, moderador.getFechaNac());
        consulta.setString(5, moderador.getCorreo());
        consulta.setString(6, moderador.getAlias());
        consulta.setLong(7, moderador.getContraseña());
        try{
            if(consulta.executeUpdate() == 0) throw new ModeradorNoEncontradoException();
        }finally{
            consulta.close();
        }
    }
}
