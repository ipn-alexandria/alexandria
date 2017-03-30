/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.servlet;

import com.model.dao.UsuarioDAO;
import com.model.db.Jemail;
import com.model.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mike3
 */
public class RecuperarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RecuperarServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RecuperarServlet at " + request.getContextPath() + "</h1>");
            
            
            
            
            String email = request.getParameter("Email");
            int idu = 0;
            
            Usuario u1 = new Usuario();
            Usuario u2 = new Usuario();
            UsuarioDAO udao1 = new UsuarioDAO();
            
            u1.setEmail(email);
            u2 = udao1.readEmail(u1);
            
            if(u2 != null) {
                Jemail je = new Jemail();;
                String msj = "\nSus datos de acceso son: \n\nUsuario: " + u2.getNombreUsuario() + "\nContraseña: " + u2.getContrasena();
                je.enviarEmail(u2.getEmail(), msj);
                response.sendRedirect("successrec.jsp");
            } else {
                response.sendRedirect("failrec.jsp");
            }
            
            
            
            
            
            
            
            out.println("</body>");
            out.println("</html>");
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
