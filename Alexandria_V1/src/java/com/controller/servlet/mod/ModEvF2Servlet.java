package com.controller.servlet.mod;

import com.model.dao.MaterialDAO;
import com.model.entities.Material;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModEvF2Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModEvF2Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModEvF2Servlet at " + request.getContextPath() + "</h1>");
            
            
            
            
            
            HttpSession session = request.getSession();
            
            int idautor = (int) session.getAttribute("id");
            
            
            
            int rfiltro2 = Integer.parseInt(request.getParameter("filtro2"));
            int rnivel = Integer.parseInt(request.getParameter("nivel"));
            String robs = (String)request.getParameter("obs");
            
            
            Material m1 = new Material();
            MaterialDAO mdao1 = new MaterialDAO();
            
            
            
            
            if (rfiltro2 == 1) {
                m1.setFiltroUno(rfiltro2);
                m1.setNivelMaterial(rnivel);
                mdao1.updateFILTRO2(m1);
                //Enviar correo de confirmacion a la direccion de idautor
                response.sendRedirect("jsp/moderador/evaluarFiltro2.jsp");
            }
            else {
                mdao1.delete(m1);
                //Enviar correo de rechazo a la direccion de idautor
                //con las observaciones.
                response.sendRedirect("jsp/moderador/evaluarFiltro2.jsp");
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