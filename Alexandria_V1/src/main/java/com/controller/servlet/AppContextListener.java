/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.servlet;

import com.youtube.apiv3.YoutubeManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 *
 * @author abril.gonzalez
 */
@WebListener
public class AppContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			InputStream is = sce.getServletContext().getResourceAsStream("/resources/client_secrets.json");
			Logger.getLogger(AppContextListener.class.getName()).log(Level.INFO, "####################### Iniciando aplicación #######################");
			YoutubeManager.getLoginUrl(is);
		} catch (IOException ex) {
			Logger.getLogger(AppContextListener.class.getName()).log(Level.SEVERE, null, ex);
			throw new RuntimeException("Se necesitan los secretos de la cuenta.");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
