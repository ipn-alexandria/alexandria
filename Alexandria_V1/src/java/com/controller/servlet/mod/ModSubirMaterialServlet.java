package com.controller.servlet.mod;

import com.controller.servlet.*;
import com.model.dao.MaterialDAO;
import com.model.entities.Material;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModSubirMaterialServlet extends HttpServlet {

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
            
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            
            String nomat = request.getParameter("NombreMaterial");
            int idtema = Integer.parseInt(request.getParameter("IdTema"));
            int nimat = Integer.parseInt(request.getParameter("NivelMaterial"));
            int idua = Integer.parseInt(request.getParameter("IdUa"));
            int timat = Integer.parseInt(request.getParameter("TipoMaterial"));
            
            String idusu = (String)request.getSession().getAttribute("id");
            response.getWriter().print("<p> La variable vale " + idusu + "</p>");
            
            int sidusu = Integer.parseInt(idusu);
            
            
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
            m1.setIdUsuario(sidusu);
            
            mdao1.create(m1);
            
            System.out.println("LLEGmos AQUI");
            
            
            Material m3 = new Material();
            MaterialDAO mdao2 = new MaterialDAO();
            int currentIdMaterial = 0;
            int idmatup;
            
            
            List matList = mdao2.readAll();
 
            Iterator<Material> MIt = matList.iterator();
            while (MIt.hasNext()) {
                Material Maux = MIt.next();
                currentIdMaterial = Maux.getIdMaterial();
                
            }
            
            idmatup = currentIdMaterial;
  
            
            String idactual;
            
            
            if (timat == 1) {
                idactual=Integer.toString(idmatup);
                System.out.println("Dato enviado ID a subirvideo: " + idactual);
                session.setAttribute("idmatup", idactual); 
                response.sendRedirect("jsp/moderador/subirvideo.jsp");
            }
            else {
                idactual=Integer.toString(idmatup);
                System.out.println("Dato enviado ID a subirpdf: " + idactual);
                session.setAttribute("idmatup", idactual); 
                response.sendRedirect("jsp/moderador/subirpdf.jsp");
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
