/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.servlet;

import com.google.api.client.auth.oauth2.Credential;
import com.youtube.apiv3.YoutubeManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abril.gonzalez
 */
public class YoutubeLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	try {
	    InputStream is = getServletContext().getResourceAsStream("/resources/client_secrets.json");
	    if (request.getSession().getAttribute("user") != null) {
		String user = request.getSession().getAttribute("user").toString();
		System.out.println("Usuario logeado: " + user);
		Credential credential = YoutubeManager.authorize("uploadvideo", is, "user");
		credential.refreshToken();
		Logger.getLogger(YoutubeLogin.class.getName()).log(Level.INFO, "Access: {0}", credential.getAccessToken());
		Logger.getLogger(YoutubeLogin.class.getName()).log(Level.INFO, "Refresh: {0}", credential.getRefreshToken());
		response.getWriter().print(credential.getAccessToken());
	    } else {
		System.out.println("Por favor logearse.");
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		response.getWriter().print("LOGIN-ERROR");
	    }
	} catch (IOException ex) {
	    Logger.getLogger(YoutubeLogin.class.getName()).log(Level.SEVERE, null, ex);
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
