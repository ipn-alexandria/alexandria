/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.servlet;

import com.model.dao.MaterialDAO;
import com.model.entities.Material;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletContext;
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
		ServletContext servletContext = session.getServletContext();
		String contextPath = servletContext.getContextPath();
		System.out.println("ContextPath: " + contextPath);
		idtip = Integer.toString(idMaterial);
		System.out.println("Dato enviado ID: " + idtip);
		System.out.println("contextpath: " + contextPath);
		session.setAttribute("rutaMaterial", contextPath + "/PDFServlet?idMaterial=" + idtip);
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
