<%-- 
    Document   : nombrar
    Created on : 29/03/2017, 06:10:15 PM
    Author     : Alan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    session.setAttribute("idAlumno", sid);
                        
			
		    %>
	<body class="backgroundimg">
            
		<div class="content">
			<div class="cap">
				<div class="title">
				 	<img src="./img/resources/logo.png" width="25%">
				</div>
			</div>
			<form>
				<p> ¿Seguro que quiere Nombrar al alumno con id <%= id %> como moderador? </p>
				
				<a href="../../ProfNombrarModServlet" > <input type="button" value="Continuar"> </a>
                                <a href="profesor.jsp" > <input type="button" value="Regresar"> </a>
			</form>
		</div>
		
	</body>
</html>
