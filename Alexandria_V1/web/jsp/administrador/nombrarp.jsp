<%-- 
    Document   : nombrar
    Created on : 29/03/2017, 06:10:15 PM
    Author     : Alan
--%>

<%@page import="com.model.entities.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.model.dao.UsuarioDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			UsuarioDAO udao = new UsuarioDAO();
			List<Usuario> ListaUsuario = (List) udao.readAll();
                        session.setAttribute("ListaUsuario", ListaUsuario);
			
                        
			
		    %>
    
    
    
    <body class="backgroundimg">
	<div class="content">
	    <div class="cap">
		<div class="title">
		    <img src="../../img/resources/logo.png" width="17%">
		</div>
	    </div>
	    <div class="datagrid">
		<c:if test="${empty ListaUsuario}">
		    <p>No hay datos.</p>
		</c:if>
		<c:if test="${not empty ListaUsuario}">
		    <table>
			<thead>
			    <tr>
                                <th>ID</th>
				<th>Nombre</th>
				<th>Apellido Paterno</th>
                                <th>Apellido Materno</th>
				<th>Boleta</th>
				<th>Enlace</th>
			    </tr>
			<thead>
			<tbody>
			    <c:forEach var="usuario" begin="0" items="${ListaUsuario}">
				<c:if test="${usuario.estado == 0 && usuario.idTipodeusuario == 2}">
				    <tr>
                                        <td>
					    <c:out value="${usuario.idUsuario}" />
					</td>
					<td>
					    <c:out value="${usuario.nombre}" />
					</td>
					<td>
					    <c:out value="${usuario.apellidoPaterno}" />
                                            
					</td>
					<td>
					    <c:out value="${usuario.apellidoMaterno}" />
					</td>
                                        <td>
					    <c:out value="${usuario.matricula}" />
					</td>
					<td>
                                            <form action="nombrarp2.jsp" method="post">
                                         
                                          
                                        <input type="hidden" name="id" value=<c:out value="${usuario.idUsuario}" />>
                                       
                                        <button name="out" type="submit">Dar de Alta</button>
                                       
                                            </form>
                                            
                                           
                                            
                                            
					</td>
				    </tr>
				</c:if>
			    </c:forEach>
			</tbody>
		    </table>
		</c:if>
	    </div>
	    <a href="admin.jsp"><button type="button">Regresar</button></a>
	</div>
	
    </body>
</html>
