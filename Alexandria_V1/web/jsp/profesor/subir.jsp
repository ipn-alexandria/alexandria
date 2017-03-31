<%@page import="com.model.entities.Ua"%>
<%@page import="com.model.dao.UaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.model.entities.Tema"%>
<%@page import="java.util.List"%>
<%@page import="com.model.dao.TemaDAO"%>
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
    
    
    
    
    if ((!cTipo.equals("2"))) {
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
	    <form method="post" action="../../ProfSubirMaterialServlet" name="subir">
		<input type="text" placeholder="Nombre del Material" name="NombreMaterial" required>
		<p> Unidad de Aprendizaje </p>
		<select name="IdUa" class="form-control">
		    <%
			UaDAO udao = new UaDAO();
			List<Ua> UL = (List) udao.readAll();
			String currentNombreUA;
			int currentIdUA;
			Iterator<Ua> UIt = UL.iterator();
			while (UIt.hasNext()) {
			    Ua Uaux = UIt.next();
			    currentIdUA = Uaux.getIdUA();
			    currentNombreUA = Uaux.getNombreUA();
		    %>
		    <option value= <%=currentIdUA%> >  <%=currentNombreUA%>  </option>
		    <%
			}
		    %>
		</select>
		<p>Elija el tema</p>
		<select name="IdTema" class="form-control" >
		    <%
			TemaDAO tdao = new TemaDAO();
			List<Tema> TemaL = (List) tdao.readAll();
			int currentIdTema;
			String currentNombreTema;
			int currentTemaIdUA;
			Iterator<Tema> TIt = TemaL.iterator();
			while (TIt.hasNext()) {
			    Tema Taux = TIt.next();
			    currentIdTema = Taux.getIdTema();
			    currentNombreTema = Taux.getNombretema();
			    currentTemaIdUA = Taux.getIdUA();
		    %>
		    <option value= <%=currentIdTema%> >  <%=currentNombreTema%>  </option>
		    <%
			}
		    %>
		</select>
		<p> Nivel el tema </p>
		<select name="NivelMaterial" class="form-control" >
		    <option value="1">Principiante</option>
		    <option value="2">Intermedio</option>
		    <option value="3">Avanzado</option>
		    <option value="4">Tipo ETS</option>
		</select>
		<p> Tipo de archivo </p>
		<select name="TipoMaterial" class="form-control" >
		    <option value="0">PDF</option>
		    <option value="1">Video</option>
		</select>
		<br>
		<input type="submit" value="Subir">
		<a href="profesor.jsp" > <input type="button" value="Regresar"> </a>
	    </form>
	</div>
	
    </body>
</html>
