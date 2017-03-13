package com.controller.servlet;

import com.model.dao.MaterialDAO;
import com.model.entities.Material;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alan
 */
public class Navegar3Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	try (OutputStream out = response.getOutputStream()) {
	    HttpSession session = request.getSession();
	    String idtip;
            
            String idusu = (String)request.getSession().getAttribute("id");
            //response.getWriter().print("<p> La variable vale " + idusu + "</p>");
            
	    int idMaterial = Integer.parseInt(request.getParameter("IdMaterial"));
	    System.out.println("\n\t" + idMaterial + " ");
	    Material m1 = new Material();
	    Material m2 = new Material();
	    MaterialDAO mdao1 = new MaterialDAO();
	    int idtipom;
	    m1.setIdMaterial(idMaterial);
	    m2 = mdao1.read(m1);
	    idtipom = m2.getTipoMaterial();
	    if (idtipom == 1) {
		idtip = Integer.toString(idMaterial);
		System.out.println("Dato enviado ID: " + idtip);
		session.setAttribute("idMaterial", idtip);
		response.sendRedirect("jsp/alumno/vervideo.jsp");
	    } else if (idtipom == 0) {
		idtip = Integer.toString(idMaterial);
                System.out.println("Dato enviado ID: " + idtip);
//                session.setAttribute("idMaterial", idtip);
//                response.sendRedirect("jsp/alumno/verpdf.jsp");
                
                
                
                
                
            System.out.println("El directorio temporal del sistema es " + System.getProperty("java.io.tmpdir"));
            //int idPdf = 17;
            String temporal = System.getProperty("java.io.tmpdir");

            Blob pdfview = null;
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            PreparedStatement pstmt = null;
            InputStream inst = null;
            OutputStream outputStream = null;
            String tempadd = temporal + idusu + ".pdf";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aldb1", "root", "mike");
            } catch (Exception e) {
                System.out.println(e);
                System.exit(0);
            }
            try {
                pstmt = con.prepareStatement("SELECT Pdf FROM Material WHERE (idMaterial = ?) ");
                pstmt.setInt(1, idMaterial);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    pdfview = rs.getBlob(1);
                } 

                inst = pdfview.getBinaryStream();

                
                outputStream = new FileOutputStream(new File(tempadd));

                int read = 0;
                byte[] bytes = new byte[1024];

                while ((read = inst.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }

                System.out.println("Done!");

                outputStream.flush();
                outputStream.close();

                rs.close();
                stmt.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
                
            
            session.setAttribute("temadd", tempadd);
            response.sendRedirect("jsp/alumno/verpdf.jsp");
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
	    }
	}
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}