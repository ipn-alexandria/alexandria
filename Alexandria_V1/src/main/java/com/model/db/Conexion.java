/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.db;

import com.model.dao.MaterialDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mike3
 */
public class Conexion {
    
    public Connection conexion;
    
    public Connection obtenerConexion() {
        String userName = "bbcbf83ff54e87";
        String userPassword = "920a7937";
        String urlBd = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net:3306/heroku_30b5e63d5933f61";
        String driverBd = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverBd);
            conexion = DriverManager.getConnection(urlBd, userName, userPassword);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
}
