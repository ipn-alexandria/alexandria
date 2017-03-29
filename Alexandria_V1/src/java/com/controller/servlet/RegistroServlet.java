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

public class RegistroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistroServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroServlet at " + request.getContextPath() + "</h1>");
            
            
            String nusu = request.getParameter("Usuario");
            String cusu = request.getParameter("Pass");
            String nombre = request.getParameter("Nombre");
            String paterno = request.getParameter("Paterno");
            String materno = request.getParameter("Materno");
            String matricula = request.getParameter("Matricula");
            String email = request.getParameter("Email");
            int tusu = Integer.parseInt(request.getParameter("Tipo"));
            
             out.println("<br/><br/>" + nusu + " " + cusu + " " + nombre + " "+ paterno + " " + materno + " " + matricula + " " + email + " " + tusu + "<br/>");
            
            Usuario u1 = new Usuario();
            Usuario u2 = new Usuario();
            UsuarioDAO udao1 = new UsuarioDAO();
            
            
            u1.setNombreUsuario(nusu);
            u1.setContrasena(cusu);
            u1.setNombre(nombre);
            u1.setApellidoPaterno(paterno);
            u1.setApellidoMaterno(materno);
            u1.setMatricula(matricula);
            u1.setIdTipodeusuario(tusu);
            
            if (tusu == 2) {
                u1.setEstado(0);
            }
            else {
                u1.setEstado(1);
            }
            
            udao1.create(u1);
            
            Jemail je = new Jemail();;
            String msj = "\nUsuario: " + nusu + "\nContraseña: " + cusu;
            je.enviarEmail(email, msj);
            
                    
            response.sendRedirect("jsp/misc/successreg.jsp");
            
            
            
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
