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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.pochocloapps.pochoclocritics.modelos.Usuario;

/**
 *
 * @author DELL-PC
 */
public class UsuariosRepositorio {
    private final Connection conexion;
    public UsuariosRepositorio(Connection conn) throws SQLException {
        this.conexion = conn;
        Statement consulta = conexion.createStatement();
        consulta.execute("CREATE TABLE IF NOT EXISTS usuarios (idUsuario SERIAL PRIMARY KEY,nombre TEXT, apellido TEXT, fechanac TEXT,  correo TEXT, alias TEXT, contraseña TEXT)");
        consulta.close();
    }
   public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        Statement consulta = conexion.createStatement(); //createStatement utilizado para crear declaraciones (Statement). Statement se utiliza para crear consultas en la BD.
        ResultSet resultado = consulta.executeQuery("SELECT idUsuario,nombre, apellido, fechanac, correo, alias, contraseña FROM usuarios"); //executeQuery, método de Statement que es utilizado para crear consultas a la BD tipo SELECT. Retorna un Resulset que se puede utilizar para obtener todos los registros de una tabla.
        while (resultado.next()) {
            usuarios.add(
                new Usuario(
                    resultado.getInt("idUsuario"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("fechanac"),
                    resultado.getString("correo"),
                    resultado.getString("alias"),
                    resultado.getString("contraseña")
                    
                )
            );
        }
        resultado.close(); //Método de Conection para cerrar la coneccion del objeto y del Resultset.
        consulta.close();
        return usuarios;
    } 
   public void crear(String nombre, String apellido, String fechanac, String correo, String alias, String contraseña) throws SQLException {
        PreparedStatement consulta = conexion.prepareStatement("INSERT INTO usuarios (nombre, apellido, fechanac, correo, alias, contraseña) VALUES (?, ?, ?, ?, ?, ?)");
        consulta.setString(1, nombre);
        consulta.setString(2, apellido);
        consulta.setString(3, fechanac);
        consulta.setString(4, correo);
        consulta.setString(5, alias);
        consulta.setString(6, contraseña);
        consulta.executeUpdate();  //Metodo de prepareStatement (a la vez de Statement "interface padre") que realiza una consulta. Utilizado para create, drop, insert, update, delete etc.
        consulta.close();
    }
   
   public Usuario obtener(int idUsuario) throws SQLException, UsuarioNoEncontradoExcepcion {
        PreparedStatement consulta = conexion.prepareStatement("SELECT idUsuario, nombre, apellido, fechanac, correo, alias, contraseña FROM usuarios WHERE idUsuario = ?"); //PreparedStatement utilizado para realizar consultas parametrizadas. Subinterface de Statement.                                                                                                                                       //Se utiliza prepareStatement (Metodo de Conection) para obtener el objeto PreparedStatement.
        consulta.setInt(1, idUsuario);            //Ajusta el valor entero al parametro dado. Este caso el 1 (identificador).                                                                                                  
        ResultSet resultado = consulta.executeQuery(); //Puntero que apunta al primer registro de una tabla. Inicialmente esta antes de la primer fila.
        try {
            if (resultado.next()) { //.next es un metodo de Resulset que permite avanzar el puntero a la siguiente posicion.
                return new Usuario(
                        resultado.getInt("idUsuario"), //Metodos get de ResulSet para obtener el contenido de la fila donde esta parado.
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("fechanac"),
                        resultado.getString("correo"),
                        resultado.getString("alias"),
                        resultado.getString("contraseña")
                );
            } else {
                throw new UsuarioNoEncontradoExcepcion();
            }
        }
        finally {
            consulta.close();
            resultado.close();
        }
    }
   
   public void borrar(Usuario usuario) throws SQLException, UsuarioNoEncontradoExcepcion {
        PreparedStatement consulta = conexion.prepareStatement("DELETE FROM usuarios WHERE idUsuario = ?");
        consulta.setInt(1, usuario.getIdUsuario());
        try {
            if (consulta.executeUpdate() == 0) throw new UsuarioNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }
   
   public void modificar(Usuario usuario) throws SQLException, UsuarioNoEncontradoExcepcion {
        PreparedStatement consulta = conexion.prepareStatement("UPDATE usuarios SET nombre = ?, apellido = ?, fechanac = ?, correo = ?, alias = ?, contraseña = ? WHERE idUsuario = ?");
        consulta.setString(1, usuario.getNombre());                  
        consulta.setString(2, usuario.getApellido());
        consulta.setString(3, usuario.getFechaNac());
        consulta.setString(4, usuario.getCorreo());
        consulta.setString(5, usuario.getAlias());
        consulta.setString(6, usuario.getContraseña());
        consulta.setInt(7, usuario.getIdUsuario());
       
        try {
            if (consulta.executeUpdate() == 0) throw new UsuarioNoEncontradoExcepcion();
        }
        finally {
            consulta.close();
        }
    }
}
