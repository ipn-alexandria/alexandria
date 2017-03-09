package com.controller.servlet;

import com.model.dao.MaterialDAO;
import com.model.entities.Material;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubirMaterialServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SubirMaterialServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubirMaterialServlet at " + request.getContextPath() + "</h1>");
            
            
            String nomat = request.getParameter("NombreMaterial");
            int idtema = Integer.parseInt(request.getParameter("IdTema"));
            int nimat = Integer.parseInt(request.getParameter("NivelMaterial"));
            int idua = Integer.parseInt(request.getParameter("IdUa"));
            int timat = Integer.parseInt(request.getParameter("TipoMaterial"));
            
            Integer idusu = (Integer)request.getSession().getAttribute("id");
            response.getWriter().print("<p> La variable vale " + idusu + "</p>");
            
            
            Material m1 = new Material();
            Material m2 = new Material();
            MaterialDAO mdao1 = new MaterialDAO();
            
            
            m1.setNombreMaterial(nomat);
            m1.setIdTema(idtema);
            m1.setNivelMaterial(nimat);
            m1.setDireccionMaterial("");
            m1.setFiltroUno(0);
            m1.setFiltroDos(0);
            m1.setVisibilidadMaterial(0);
            m1.setTipoMaterial(timat);
            m1.setIdUa(idua);
            m1.setIdUsuario(idusu);
            
            mdao1.create(m1);
            
            if (timat == 1) {
                getServletConfig().getServletContext().getRequestDispatcher("/subirVideo.jsp").forward(request,response);
            }
            else {
                getServletConfig().getServletContext().getRequestDispatcher("/subirPDF.jsp").forward(request,response);
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
