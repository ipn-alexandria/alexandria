package com.controller.servlet;

import com.model.dao.MaterialDAO;
import com.model.entities.Material;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB

public class SubirPDF1Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SubirPDF1Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubirPDF1Servlet at " + request.getContextPath() + "</h1>");
            
            System.out.println("Llegamos a servletpdf1");
            
            HttpSession session = request.getSession();
            
            String idmatup = (String) session.getAttribute("idmatup");
//            String idmatup = (String) request.getSession().getAttribute("idmatup");
            int idmat = Integer.parseInt(idmatup);
            response.getWriter().print("<p> La variable vale " + idmat + "</p>");
            
            System.out.println("Idmatrec = " + idmat);
            out.println("<h1>Idmatrec = " + idmat + "</h1>");
            
            Material m1 = new Material();
            MaterialDAO mdao = new MaterialDAO();
//            
            Part filePart = request.getPart("pdf");
//            
            out.println("<h1>" + idmat + " " + filePart.getName() + " " + filePart.getSize()/1024 + " " + filePart.getContentType()+ "</h1>");
            
            m1.setPdf(filePart);
            m1.setIdMaterial(idmat);
            
            mdao.updatePDF(m1);
            
            response.sendRedirect("jsp/misc/successupload.jsp");
            
            
            
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
