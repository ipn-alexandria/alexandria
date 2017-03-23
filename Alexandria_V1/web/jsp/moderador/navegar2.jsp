<%@page import="java.util.Iterator"%>
<%@page import="com.model.entities.Tema"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="favicon.ico">
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="stylesheet" type="text/css" href="../../css/grades.css" media="screen" />
	<title>Alexandria</title>
    </head>
    <body class="backgroundimg">
	<div class="content">
	    <div class="cap">
		<div class="title">
		    <img src="../../img/resources/logo.png" width="17%">
		</div>
	    </div>
	    <form method="post" action="../../ModNavegar2Servlet" name="navegar">
		<p> Seleccione Tema </p>
		<select name="IdTema" class="form-control">
		    <%
			List TemaL = (List) session.getAttribute("ListaTemas");
			int currentIdTema;
			String currentNombre;
			Iterator<Tema> TIt = TemaL.iterator();
			while (TIt.hasNext()) {
			    Tema Taux = TIt.next();
			    currentIdTema = Taux.getIdTema();
			    currentNombre = Taux.getNombretema();
		    %>
		    <option value="<%=currentIdTema%>"><%=currentNombre%></option>
		    <%
			}
		    %>
		</select>
		<br>
		<input type="submit" value="Continuar">
		<a href="alumno.jsp" > <input type="button" value="Regresar"> </a>
	    </form>
	</div>
	
    </body>
</html>
