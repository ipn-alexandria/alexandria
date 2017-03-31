package com.controller.servlet.admin;

import com.controller.servlet.prof.*;
import com.model.dao.UsuarioDAO;
import com.model.db.Jemail;
import com.model.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminNombrarProfServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfNombrarModServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminNombrarModServlet at " + request.getContextPath() + "</h1>");
            
            
            HttpSession session = request.getSession();
            String stridprofesor =  session.getAttribute("idProfesor").toString();
            int idprofesor = Integer.parseInt(stridprofesor);
//            int idalumno = 7;
            
            Usuario u1 = new Usuario();
            Usuario u2 = new Usuario();
            Usuario u3 = new Usuario();
            UsuarioDAO udao1 = new UsuarioDAO();
            UsuarioDAO udao2 = new UsuarioDAO();
            
            
            u1.setIdUsuario(idprofesor);
            u2 = udao1.read(u1);
            u2.setEstado(1);
            udao2.update(u2);
            
            out.println("<h1>Actualizado " + udao2.read(u2) + "</h1>");
            
            Jemail je = new Jemail();;
            String msj = "\nEstimad@ " + u2.getNombreUsuario() + " has sido nombrad@ Profesor.";
            je.enviarEmail(u2.getEmail(), msj);
            
            response.sendRedirect("jsp/administrador/successprof.jsp");
            
            
            
            
            
            
            
            
            
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
