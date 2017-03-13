package com.model.dao;

import com.model.entities.Material;
import com.model.db.Conexion;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

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
    
    private static final String SQL_SELECT_FROMTEMA
            = "SELECT * FROM Material WHERE (idTema = ?)";
    
    private static final String SQL_UPDATE_PDF
            = "UPDATE material SET pdf = ? WHERE (idMaterial = ?) ";
    
    private static final String SQL_READ_PDF = "SELECT pdf FROM Material WHERE (idMaterial = ? )";

    
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
    
    public List readFROMTEMA(Material a) {
         List<Material> materialList = null;
        try {
            ResultSet rs;
            PreparedStatement ps = con.obtenerConexion().prepareStatement(SQL_SELECT_FROMTEMA);
            ps.setInt(1, a.getIdTema());
            rs = ps.executeQuery();
            materialList = obtenerLista(rs);
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        }
        return materialList;
    }
    
    private List<Material> obtenerListaFROMTEMA(ResultSet rs) {
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
    
    public void updatePDF(Material a) throws IOException {
        
       Part pf1;
       InputStream inputStream = null; // input stream of the upload file
       
       pf1 = a.getPdf();
       
       if (pf1 != null) {
            // prints out some information for debugging
            System.out.println(pf1.getName());
            System.out.println(pf1.getSize());
            System.out.println(pf1.getContentType());
             
            // obtains input stream of the upload file
            inputStream = pf1.getInputStream();
        }
       
        try {
            PreparedStatement ps = con.obtenerConexion().prepareStatement(SQL_UPDATE_PDF);
            
            
            ps.setBinaryStream(1, inputStream, pf1.getSize());
            ps.setInt(2, a.getIdMaterial());

            int row = ps.executeUpdate();
            
            if (row > 0) {
                System.out.println("File uploaded and saved into database");
            }
            
            
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
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
    
    public byte[] getPDF(Material m) {
	try {
	    ResultSet rs;
	    PreparedStatement ps = con.obtenerConexion().prepareStatement(SQL_READ_PDF);
	    ps.setInt(1, m.getIdMaterial());
	    rs = ps.executeQuery();
	    if (rs.next()) {
		return rs.getBytes(1);
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
	} finally {

	}
	return null;
}
    
    public static void main(String[] args) {
        Material c = new Material();
        
//        c.setNombreMaterial("Arrays unidimensionales, introduccion");
        c.setIdTema(1);
//        c.setNivelMaterial(1);
//        c.setDireccionMaterial("https://www.youtube.com/watch?v=Us-TVg40ExM");
//        c.setFiltroUno(0);
//        c.setFiltroDos(0);
//        c.setVisibilidadMaterial(0);
//        c.setTipoMaterial(1);
//        c.setIdUsuario(1);
//        c.setIdUa(1);

        MaterialDAO d = new MaterialDAO();
        d.readFROMTEMA(c);
//        d.create(c);
//        d.update(c);
//        d.delete(c);
//        System.out.println(d.read(u));
        System.out.println(d.readFROMTEMA(c));
    }
    
}