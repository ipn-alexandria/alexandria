package com.controller.servlet;

import com.model.dao.UsuarioDAO;
import com.model.entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            
            
            Usuario u1 = new Usuario();
            Usuario u2 = new Usuario();
            UsuarioDAO udao = new UsuarioDAO();
            int id,idtipo;
            String nu,cu;
            String idactual="";
             
            String nusu = request.getParameter("uname");
            String cusu = request.getParameter("pass");
//            String nusu = request.getParameter("txtNombreU");
//            String cusu = request.getParameter("txtClaveU");
            out.println("<br/><br/>" + nusu + " " + cusu + "<br/>");
            HttpSession session = request.getSession();
            
            u1.setNombreUsuario(nusu);
            u1.setContrasena(cusu);
            
            if(udao.readLogin(u1) != null) {
                u2 = udao.readLogin(u1);
                idtipo = u2.getIdTipodeusuario();
                switch(idtipo) {
                    case 1: System.out.println("LISTO REDIRIGIR ----Administrador----");
                            id = u2.getIdUsuario();
                            idactual=Integer.toString(id);
                            System.out.println("Dato enviado ID: " + idactual);
                            session.setAttribute("id", idactual);
                            //getServletConfig().getServletContext().getRequestDispatcher("/principalpaciente.jsp").forward(request,response);
                            break;
                    case 2: System.out.println("LISTO REDIRIGIR ----Profesor----");
                            id = u2.getIdUsuario();
                            idactual=Integer.toString(id);
                            System.out.println("Dato enviado ID: " + idactual);
                            session.setAttribute("id", idactual);
                            //getServletConfig().getServletContext().getRequestDispatcher("/principalpaciente.jsp").forward(request,response);
                            break;
                    case 3: System.out.println("LISTO REDIRIGIR ----Moderador----");
                            id = u2.getIdUsuario();
                            idactual=Integer.toString(id);
                            System.out.println("Dato enviado ID: " + idactual);
                            session.setAttribute("id", idactual);
                            //getServletConfig().getServletContext().getRequestDispatcher("/principalpaciente.jsp").forward(request,response);
                            break;
                    case 4: System.out.println("LISTO REDIRIGIR ----Alumno----");
                            id = u2.getIdUsuario();
                            idactual=Integer.toString(id);
                            System.out.println("Dato enviado ID: " + idactual);
                            session.setAttribute("id", idactual);
                            //getServletConfig().getServletContext().getRequestDispatcher("/principalpaciente.jsp").forward(request,response);
                            break;

                    default: 
                            break;
                    
                }
            }
            else {
                System.out.println("ERROR DE USUARIO");
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
