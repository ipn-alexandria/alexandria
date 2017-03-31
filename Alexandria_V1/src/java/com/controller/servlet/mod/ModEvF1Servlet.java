package com.controller.servlet.mod;

import com.model.dao.MaterialDAO;
import com.model.dao.UsuarioDAO;
import com.model.db.Jemail;
import com.model.entities.Material;
import com.model.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModEvF1Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModEvF1Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModEvF1Servlet at " + request.getContextPath() + "</h1>");
            
            
            HttpSession session = request.getSession();
            
            String intidmat =  session.getAttribute("idMaterial").toString();
            
            int idmat = Integer.parseInt(intidmat);
            
            
            
            int rfiltro1 = Integer.parseInt(request.getParameter("filtro1"));
            int rnivel = Integer.parseInt(request.getParameter("nivel"));
            String robs = (String)request.getParameter("obs");
            
            out.println("<h1>" + idmat + " " + rfiltro1 + " " + rnivel + " " + robs + " " + "</h1>");
            
            
            Material m1 = new Material();
            Material m2 = new Material();
            MaterialDAO mdao1 = new MaterialDAO();
            MaterialDAO mdao2 = new MaterialDAO();
            
            Usuario u1 = new Usuario();
            Usuario u2 = new Usuario();
            UsuarioDAO udao1 = new UsuarioDAO();
            
            Jemail je = new Jemail();
            
            int idu = 0;
            String msj = "";
            
            m1.setIdMaterial(idmat);
            m2 = mdao2.read(m1);
            idu = m2.getIdUsuario();
            out.println("<h1>IdUsuario: " + idu + "</h1>");
            
            u1.setIdUsuario(idu);
            u2 = udao1.read(u1);
            out.println("<h1>test: " + udao1.read(u1) + "</h1>");
            String email = u2.getEmail();
            
            out.println("<h1>Email: " + email + "</h1>");
            
            
            
            if (rfiltro1 == 1) {
                m1.setIdMaterial(idmat);
                m1.setFiltroUno(rfiltro1);
                m1.setNivelMaterial(rnivel);
                mdao1.updateFILTRO1(m1);
                
                msj = "\nSu material: " + m2.getNombreMaterial() + "\n\nMaterial aprobado en: Filtro 1" + "\n\nComentarios: " + robs;
                je.enviarEmail(email, msj);
                
                response.sendRedirect("jsp/moderador/evaluarFiltro1.jsp");
            }
            else {
                m1.setIdMaterial(idmat);
                mdao1.delete(m1);
                
                msj = "\nSu material: " + m2.getNombreMaterial() + "\nMaterial rechazado en: Filtro 1" + "\n\nComentarios: " + robs;
                je.enviarEmail(email, msj);
                
                response.sendRedirect("jsp/moderador/evaluarFiltro1.jsp");
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