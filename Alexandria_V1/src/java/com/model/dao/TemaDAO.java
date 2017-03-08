package com.model.dao;

import com.model.db.Conexion;
import com.model.entities.Tema;
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

public class TemaDAO {
    
    private static final String SQL_INSERT
            = "INSERT INTO Tema ( idUA, nombretema) "
               + "VALUES (?, ?) ";
    private static final String SQL_UPDATE
            = "UPDATE Tema SET idUA = ?, nombretema = ? "
               + "WHERE (idTema = ? ) ";
    private static final String SQL_DELETE
            = "DELETE FROM Tema WHERE (idTema = ? ) ";
    private static final String SQL_SELECT
            = "SELECT * FROM Tema WHERE (idTema = ? ) "; 
    private static final String SQL_SELECT_ALL
            = "SELECT * FROM Tema"; 
    public Connection conexion;
    
    Conexion con = new Conexion();
    
    public void create(Tema a) {
        try {
            con.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_INSERT);
            ps.setInt(1, a.getIdUA());
            ps.setString(2, a.getNombretema());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void update(Tema a) {
        try {
            con.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setInt(1, a.getIdUA());
            ps.setString(2, a.getNombretema());
            ps.setInt(3, a.getIdTema());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void delete(Tema a) {
        try {
            con.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, a.getIdTema());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Tema read(Tema a) {
        try {
            con.obtenerConexion();
            ResultSet rs;
            PreparedStatement ps = conexion.prepareStatement(SQL_SELECT);
            ps.setInt(1, a.getIdTema());
            rs = ps.executeQuery();
            List<Tema> temaList = obtenerLista(rs);
            if(temaList.size() >0){
                a = (Tema) temaList.get(0);
            }else {
                a = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return a;
    }
    
    public List readAll() {
         List<Tema> temaList = null;
        try {
            con.obtenerConexion();
            ResultSet rs;
            PreparedStatement ps = conexion.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            temaList = obtenerLista(rs);
        } catch (SQLException ex) {
            Logger.getLogger(TemaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        }
        return temaList;
    }
    
    private List<Tema> obtenerLista(ResultSet rs) {
        List<Tema> temaList= new ArrayList<>();
        try {
            while(rs.next()){
                Tema a = new Tema();
                a.setIdTema(rs.getInt("idTema"));
                a.setIdUA(rs.getInt("idUA"));
                a.setNombretema(rs.getString("nombreTema"));
                temaList.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return temaList;
    }
    
        public static void main(String[] args) {
        Tema c = new Tema();
//        c.setIdCarrera(23);
        c.setIdUA(1);
        c.setNombretema("Arrays unidimensionales");

        TemaDAO d = new TemaDAO();
        d.create(c);
//        d.update(c);
//        d.delete(c);
//        System.out.println(d.read(u));
//        System.out.println(d.readAll());
    }
    
    
    
    
}
