package com.model.dao;

import com.model.entities.Material;
import com.model.db.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaterialDAO {
    
    private static final String SQL_INSERT
            = "INSERT INTO Material ( nombreMaterial, idTema, nivelMaterial, direccionMaterial, filtroUno, filtroDos, visibilidadMaterial, tipoMaterial, idUsuario, idUa) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String SQL_UPDATE
            = "UPDATE Material SET nombreMaterial = ?, idTema = ?, nivelMaterial = ?, direccionMaterial = ?, filtroUno = ?, filtroDos = ?, visibilidadMaterial = ?, tipoMaterial = ?, idUsuario = ?, idUa = ? "
               + "WHERE (idMaterial = ? ) ";
    private static final String SQL_DELETE
            = "DELETE FROM Material WHERE (idMaterial = ? ) ";
    private static final String SQL_SELECT
            = "SELECT * FROM Material WHERE (idMaterial = ? ) "; 
    private static final String SQL_SELECT_ALL
            = "SELECT * FROM Material"; 
    public Connection conexion;
    
    Conexion con = new Conexion();
    
    public void create(Material a) {
        try {
            PreparedStatement ps = con.obtenerConexion().prepareStatement(SQL_INSERT);
            ps.setString(1, a.getNombreMaterial());
            ps.setInt(2, a.getIdTema());
            ps.setInt(3, a.getNivelMaterial());
            ps.setString(4, a.getDireccionMaterial());
            ps.setInt(5, a.getFiltroUno());
            ps.setInt(6, a.getFiltroDos());
            ps.setInt(7, a.getVisibilidadMaterial());
            ps.setInt(8, a.getTipoMaterial());
            ps.setInt(9, a.getIdUsuario());
            ps.setInt(10, a.getIdUa());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void update(Material a) {
        try {
            PreparedStatement ps = con.obtenerConexion().prepareStatement(SQL_UPDATE);
            ps.setString(1, a.getNombreMaterial());
            ps.setInt(2, a.getIdTema());
            ps.setInt(3, a.getNivelMaterial());
            ps.setString(4, a.getDireccionMaterial());
            ps.setInt(5, a.getFiltroUno());
            ps.setInt(6, a.getFiltroDos());
            ps.setInt(7, a.getVisibilidadMaterial());
            ps.setInt(8, a.getTipoMaterial());
            ps.setInt(9, a.getIdUsuario());
            ps.setInt(10, a.getIdUa());
            ps.setInt(11, a.getIdMaterial());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void delete(Material a) {
        try {
            PreparedStatement ps = con.obtenerConexion().prepareStatement(SQL_DELETE);
            ps.setInt(1, a.getIdMaterial());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Material read(Material a) {
        try {
            ResultSet rs;
            PreparedStatement ps = con.obtenerConexion().prepareStatement(SQL_SELECT);
            ps.setInt(1, a.getIdMaterial());
            rs = ps.executeQuery();
            List<Material> materialList = obtenerLista(rs);
            if(materialList.size() >0){
                a = (Material) materialList.get(0);
            }else {
                a = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return a;
    }
    
    public List readAll() {
         List<Material> materialList = null;
        try {
            ResultSet rs;
            PreparedStatement ps = con.obtenerConexion().prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            materialList = obtenerLista(rs);
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        }
        return materialList;
    }
    
    private List<Material> obtenerLista(ResultSet rs) {
        List<Material> materialList= new ArrayList<>();
        try {
            while(rs.next()){
                Material a = new Material();
                a.setIdMaterial(rs.getInt("idMaterial"));
                a.setNombreMaterial(rs.getString("nombreMaterial"));
                a.setIdTema(rs.getInt("idTema"));
                a.setNivelMaterial(rs.getInt("nivelMaterial"));
                a.setDireccionMaterial(rs.getString("direccionMaterial"));
                a.setFiltroUno(rs.getInt("filtroUno"));
                a.setFiltroDos(rs.getInt("filtroDos"));
                a.setVisibilidadMaterial(rs.getInt("visibilidadMaterial"));
                a.setTipoMaterial(rs.getInt("tipoMaterial"));
                a.setIdUsuario(rs.getInt("idUsuario"));
                a.setIdUa(rs.getInt("idUa"));
                materialList.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materialList;
    }
    
    
    public static void main(String[] args) {
        Material c = new Material();
        
        c.setNombreMaterial("Arrays unidimensionales, introduccion");
        c.setIdTema(1);
        c.setNivelMaterial(1);
        c.setDireccionMaterial("https://www.youtube.com/watch?v=Us-TVg40ExM");
        c.setFiltroUno(0);
        c.setFiltroDos(0);
        c.setVisibilidadMaterial(0);
        c.setTipoMaterial(1);
        c.setIdUsuario(1);
        c.setIdUa(1);

        MaterialDAO d = new MaterialDAO();
        d.create(c);
//        d.update(c);
//        d.delete(c);
//        System.out.println(d.read(u));
//        System.out.println(d.readAll());
    }
    
}
