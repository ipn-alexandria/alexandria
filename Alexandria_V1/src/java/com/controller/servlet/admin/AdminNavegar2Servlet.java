package com.controller.servlet.admin;

import com.controller.servlet.prof.*;
import com.controller.servlet.*;
import com.model.dao.MaterialDAO;
import com.model.entities.Material;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminNavegar2Servlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		int idTema = Integer.parseInt(request.getParameter("IdTema"));
		Material m1 = new Material();
		MaterialDAO mdao1 = new MaterialDAO();
		m1.setIdTema(idTema);
		List<Material> materialList = mdao1.readFROMTEMA(m1);
		Iterator it = materialList.iterator();
		while (it.hasNext()) {
			if (((Material) it.next()).getVisibilidadMaterial() == 0) {
				it.remove();
			}
		}
		Logger.getLogger(AdminNavegar2Servlet.class.getName()).info("Materiales disponibles y visibles:" + mdao1.readFROMTEMA(m1));
		session.setAttribute("ListaMaterial", materialList);
		response.sendRedirect("jsp/administrador/navegar3.jsp");
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
