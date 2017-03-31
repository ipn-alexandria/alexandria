<%-- 
    Document   : nombrar
    Created on : 29/03/2017, 06:10:15 PM
    Author     : Alan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if ((session.getAttribute("idTipo") == null) || (session.getAttribute("IdTipo") == "")) {
        System.out.print("Acceso denegado Principal");
	response.sendRedirect("../../index.jsp");
        return;
        
    }
    
  try{
    
    String cTipo;
    cTipo = session.getAttribute("idTipo").toString();
    
    
    
    
    if ((!cTipo.equals("1"))) {
        System.out.print("Acceso denegado del try");
        System.out.print(cTipo+"if");
        session.invalidate();
	response.sendRedirect("../../index.jsp");
        return;
    }
    
    
    
    System.out.print("Validado con exito");
    System.out.print(cTipo);
    
    
    }catch(Exception e){
         System.out.print("Acceso denegado del Catch");
        response.sendRedirect("../../index.jsp");
       
        return;
    
    }
    
    %>
<!DOCTYPE html>

	<html lang="es">
    <head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="./img/resources/logo.ico" sizes="16x16 32x32 48x48 64x64 110x110 114x114" type="image/vnd.microsoft.icon">
	<link rel="stylesheet" type="text/css" href="../../css/grades.css" media="screen" />
	<title>Alexandria</title>
    </head>
    <%
		String sid = request.getParameter("id");
                    int id = Integer.parseInt(sid);
                    session.setAttribute("idProfesor", sid);
                        
			
		    %>
	<body class="backgroundimg">
            
		<div class="content">
			<div class="cap">
				<div class="title">
				 	<img src="./img/resources/logo.png" width="25%">
				</div>
			</div>
			<form>
				<p> ¿Seguro que quiere aceptar al Profesor con id <%= id %> ? </p>
				
				<a href="../../AdminNombrarProfServlet" > <input type="button" value="Continuar"> </a>
                                <a href="admin.jsp" > <input type="button" value="Regresar"> </a>
			</form>
		</div>
		
	</body>
</html>
