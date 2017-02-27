package com.model.dao;

import com.model.entities.Ua;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UaDAO {
    
    private static final String SQL_INSERT
            = "INSERT INTO Ua ( nombreUa, nivel) "
               + "VALUES (?, ?) ";
    private static final String SQL_UPDATE
            = "UPDATE Ua SET nombreUa = ?, nivel = ? "
               + "WHERE (idUa = ? ) ";
    private static final String SQL_DELETE
            = "DELETE FROM Ua WHERE (idUa = ? ) ";
    private static final String SQL_SELECT
            = "SELECT * FROM Ua WHERE (idUa = ? ) "; 
    private static final String SQL_SELECT_ALL
            = "SELECT * FROM Ua"; 
    public Connection conexion;
    
    public Connection obtenerConexion() {
        String userName = "root";
        String userPassword = "mike";
        String urlBd = "jdbc:mysql://127.0.0.1:3306/aldb1";
        String driverBd = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverBd);
            conexion = DriverManager.getConnection(urlBd, userName, userPassword);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(UaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
    public void create(Ua a) {
        try {
            obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, a.getNombreUA());
            ps.setInt(2, a.getNivel());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void update(Ua a) {
        try {
            obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, a.getNombreUA());
            ps.setInt   (2, a.getNivel());
            ps.setInt   (3, a.getIdUA());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void delete(Ua a) {
        try {
            obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, a.getIdUA());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Ua read(Ua a) {
        try {
            obtenerConexion();
            ResultSet rs;
            PreparedStatement ps = conexion.prepareStatement(SQL_SELECT);
            ps.setInt(1, a.getIdUA());
            rs = ps.executeQuery();
            List<Ua> uaList = obtenerLista(rs);
            if(uaList.size() >0){
                a = (Ua) uaList.get(0);
            }else {
                a = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return a;
    }
    
    public List readAll() {
         List<Ua> uaList = null;
        try {
            obtenerConexion();
            ResultSet rs;
            PreparedStatement ps = conexion.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            uaList = obtenerLista(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        }
        return uaList;
    }
    
    private List<Ua> obtenerLista(ResultSet rs) {
        List<Ua> uaList= new ArrayList<>();
        try {
            while(rs.next()){
                Ua a = new Ua();
                a.setIdUA(rs.getInt("idUa"));
                a.setNombreUA(rs.getString("nombreUa"));
                a.setNivel(rs.getInt("nivel"));
                uaList.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return uaList;
    }
    
    
    public static void main(String[] args) {
        Ua c = new Ua();
//        c.setIdCarrera(23);
        c.setNombreUA("Algoritmia y Programación estructurada");
        c.setNivel(1);

        UaDAO d = new UaDAO();
        d.create(c);
//        d.update(c);
//        d.delete(c);
//        System.out.println(d.read(u));
//        System.out.println(d.readAll());
    }
    
    
}
