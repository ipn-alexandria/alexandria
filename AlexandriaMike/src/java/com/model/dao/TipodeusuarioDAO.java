package com.model.dao;

import com.model.entities.Tipodeusuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipodeusuarioDAO {
    
    private static final String SQL_INSERT
            = "INSERT INTO Tipodeusuario ( nombreTipodeusuario) "
               + "VALUES (?) ";
    private static final String SQL_UPDATE
            = "UPDATE Tipodeusuario SET nombretipodeusuario = ? "
               + "WHERE (idTipodeusuario = ? ) ";
    private static final String SQL_DELETE
            = "DELETE FROM Tipodeusuario WHERE (idTipodeusuario = ? ) ";
    private static final String SQL_SELECT
            = "SELECT * FROM Tipodeusuario WHERE (idTipodeusuario = ? ) "; 
    private static final String SQL_SELECT_ALL
            = "SELECT * FROM Tipodeusuario"; 
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
            Logger.getLogger(TipodeusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
    public void create(Tipodeusuario a) {
        try {
            obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, a.getNombreTipodeusuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipodeusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void update(Tipodeusuario a) {
        try {
            obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, a.getNombreTipodeusuario());
            ps.setInt(2, a.getIdTipodeusuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipodeusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void delete(Tipodeusuario a) {
        try {
            obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, a.getIdTipodeusuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipodeusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Tipodeusuario read(Tipodeusuario a) {
        try {
            obtenerConexion();
            ResultSet rs;
            PreparedStatement ps = conexion.prepareStatement(SQL_SELECT);
            ps.setInt(1, a.getIdTipodeusuario());
            rs = ps.executeQuery();
            List<Tipodeusuario> tipodeusuarioList = obtenerLista(rs);
            if(tipodeusuarioList.size() >0){
                a = (Tipodeusuario) tipodeusuarioList.get(0);
            }else {
                a = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipodeusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return a;
    }
    
    public List readAll() {
         List<Tipodeusuario> tipodeusuarioList = null;
        try {
            obtenerConexion();
            ResultSet rs;
            PreparedStatement ps = conexion.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            tipodeusuarioList = obtenerLista(rs);
        } catch (SQLException ex) {
            Logger.getLogger(TipodeusuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        }
        return tipodeusuarioList;
    }
    
    private List<Tipodeusuario> obtenerLista(ResultSet rs) {
        List<Tipodeusuario> tipodeusuarioList= new ArrayList<>();
        try {
            while(rs.next()){
                Tipodeusuario a = new Tipodeusuario();
                a.setIdTipodeusuario(rs.getInt("idTipodeusuario"));
                a.setNombreTipodeusuario(rs.getString("nombreTipodeusuario"));
                tipodeusuarioList.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tipodeusuarioList;
    }
    
        public static void main(String[] args) {
        Tipodeusuario c = new Tipodeusuario();
//        c.setIdCarrera(23);
        c.setNombreTipodeusuario("Alumno");

        TipodeusuarioDAO d = new TipodeusuarioDAO();
        d.create(c);
//        d.update(c);
//        d.delete(c);
//        System.out.println(d.read(u));
//        System.out.println(d.readAll());
    }
    
    
    
}
