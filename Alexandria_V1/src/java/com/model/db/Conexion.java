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
        String userName = "root";
        String userPassword = "root";
        String urlBd = "jdbc:mysql://127.0.0.1:3306/aldb1";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(urlBd, userName, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
