package com.controller.servlet.mod;

import com.controller.servlet.*;
import com.model.dao.MaterialDAO;
import com.model.entities.Material;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModPDFServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	try (OutputStream out = response.getOutputStream()) {
	    byte[] bytes;
	    int idMaterial = Integer.parseInt(request.getParameter("idMaterial"));
	    Material m1 = new Material();
	    m1.setIdMaterial(idMaterial);
	    MaterialDAO mdao1 = new MaterialDAO();
	    if ((bytes = mdao1.getPDF(m1)) != null) {
		String pdfFileName = idMaterial + ".pdf";
		response.setContentType("application/pdf");
		//response.addHeader("Content-Disposition", "attachment; filename=" + pdfFileName);
		response.setContentLength(bytes.length);
		out.write(bytes);
	    } else {
		System.out.println("PDF es nulo.");
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

    private byte[] getFromDatabase() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
