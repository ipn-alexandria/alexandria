package com.model.dao;

import com.model.db.Conexion;
import com.model.entities.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    
    private static final String SQL_INSERT
            = "INSERT INTO Usuario ( nombreUsuario, contrasena, nombre, apellidoPaterno, apellidoMaterno, matricula, estado, idTipodeusuario) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String SQL_UPDATE
            = "UPDATE Usuario SET nombreUsuario = ?, contrasena = ?, nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, matricula = ?, estado = ?, idTipodeusuario = ? "
               + "WHERE (idUsuario = ? ) ";
    private static final String SQL_DELETE
            = "DELETE FROM Usuario WHERE (idUsuario = ? ) ";
    private static final String SQL_SELECT
            = "SELECT * FROM Usuario WHERE (idUsuario = ? ) "; 
    private static final String SQL_SELECT_ALL
            = "SELECT * FROM Usuario"; 
    
    private static final String SQL_SELECT_LOGIN
            = "SELECT * FROM Usuario WHERE ( nombreUsuario = ? AND contrasena = ? ) ";
    
    public Connection conexion;
    
    Conexion con = new Conexion();
    
    public void create(Usuario a) {
        try {
            con.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, a.getNombreUsuario());
            ps.setString(2, a.getContrasena());
            ps.setString(3, a.getNombre());
            ps.setString(4, a.getApellidoPaterno());
            ps.setString(5, a.getApellidoMaterno());
            ps.setString(6, a.getMatricula());
            ps.setInt(7, a.getEstado());
            ps.setInt(8, a.getIdTipodeusuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public void update(Usuario a) {
        try {
            con.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, a.getNombreUsuario());
            ps.setString(2, a.getContrasena());
            ps.setString(3, a.getNombre());
            ps.setString(4, a.getApellidoPaterno());
            ps.setString(5, a.getApellidoMaterno());
            ps.setString(6, a.getMatricula());
            ps.setInt(7, a.getEstado());
            ps.setInt(8, a.getIdTipodeusuario());
            ps.setInt(9, a.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public void delete(Usuario a) {
        try {
            con.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, a.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public Usuario read(Usuario a) {
        try {
            con.obtenerConexion();
            ResultSet rs;
            PreparedStatement ps = conexion.prepareStatement(SQL_SELECT);
            ps.setInt(1, a.getIdUsuario());
            rs = ps.executeQuery();
            List<Usuario> usuarioList = obtenerLista(rs);
            if(usuarioList.size() >0){
                a = (Usuario) usuarioList.get(0);
            }else {
                a = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return a;
    }
    
    public Usuario readLogin(Usuario a) {
        try {
            con.obtenerConexion();
            ResultSet rs;
            PreparedStatement ps = conexion.prepareStatement(SQL_SELECT_LOGIN);
            ps.setString(1, a.getNombreUsuario());
            ps.setString(2, a.getContrasena());
            rs = ps.executeQuery();
            List<Usuario> usuarioList = obtenerLista(rs);
            if(usuarioList.size() >0){
                a = (Usuario) usuarioList.get(0);
            }else {
                a = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return a;
    }
    
    public List readAll() {
         List<Usuario> usuarioList = null;
        try {
            con.obtenerConexion();
            ResultSet rs;
            PreparedStatement ps = conexion.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            usuarioList = obtenerLista(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        }
        return usuarioList;
    }
    
    private List<Usuario> obtenerLista(ResultSet rs) {
        List<Usuario> usuarioList= new ArrayList<>();
        try {
            while(rs.next()){
                Usuario a = new Usuario();
                a.setIdUsuario(rs.getInt("idUsuario"));
                a.setNombreUsuario(rs.getString("nombreUsuario"));
                a.setContrasena(rs.getString("contrasena"));
                a.setNombre(rs.getString("nombre"));
                a.setApellidoPaterno(rs.getString("apellidoPaterno"));
                a.setApellidoMaterno(rs.getString("apellidoMaterno"));
                a.setMatricula(rs.getString("matricula"));
                a.setEstado(rs.getInt("estado"));
                a.setIdTipodeusuario(rs.getInt("idTipodeusuario"));
                usuarioList.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarioList;
    }
    
    public static void main(String[] args) {
        Usuario c = new Usuario();
        
        c.setNombreUsuario("Miguel");
        c.setContrasena("miguel");
        c.setNombre("Miguel");
        c.setApellidoPaterno("Martínez");
        c.setApellidoMaterno("García");
        c.setMatricula("2009630162");
        c.setEstado(1);
        c.setIdTipodeusuario(1);
        
        c.setIdUsuario(1);

        UsuarioDAO d = new UsuarioDAO();
//        d.create(c);
        d.update(c);
//        d.delete(c);
//        System.out.println(d.read(u));
//        System.out.println(d.readAll());
    }
    
}
