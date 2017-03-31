<%@page import="com.model.dao.UaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.model.entities.Ua"%>
<%@page import="java.util.List"%>
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
	    <form method="post" action="../../AdminNavegarServlet" name="navegar">
		<p> Unidad de Aprendizaje </p>
		<select name="IdUA" class="form-control">
		    <%
			UaDAO udao = new UaDAO();
			List<Ua> UL = (List) udao.readAll();
			String currentNombre;
			int currentIdUA;
			Iterator<Ua> UIt = UL.iterator();
			while (UIt.hasNext()) {
			    Ua Uaux = UIt.next();
			    currentIdUA = Uaux.getIdUA();
			    currentNombre = Uaux.getNombreUA();
		    %>
		    <option value= <%=currentIdUA%> >  <%=currentNombre%>  </option>
		    <%
			}
		    %>
		</select>
		<br>
		<input type="submit" value="Continuar">
		<a href="admin.jsp"><input type="button" value="Regresar"></a>
	    </form>
	</div>
	
    </body>
</html>
