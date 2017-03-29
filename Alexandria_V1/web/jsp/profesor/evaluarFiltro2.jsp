<%-- 
    Document   : evaluarFiltro1
    Created on : 22/03/2017, 07:20:16 PM
    Author     : Alan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.model.entities.Material"%>
<%@page import="com.model.dao.MaterialDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

   <% MaterialDAO mDAO = new MaterialDAO();
Material n1 = new Material();
List ListaMaterial2;
ListaMaterial2 = mDAO.readAll();
session.setAttribute("ListaMaterial2", ListaMaterial2);


%>
<!DOCTYPE html>
<html>
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
   
    

<body class="backgroundimg">
	<div class="content">
	    <div class="cap">
		<div class="title">
		    <img src="../../img/resources/logo.png" width="17%">
		</div>
	    </div>
	    <div class="datagrid">
		<c:if test="${empty ListaMaterial2}">
		    <p>No hay datos.</p>
		</c:if>
		<c:if test="${not empty ListaMaterial2}">
		    <table>
			<thead>
			    <tr>
				<th>Nombre</th>
				<th>Nivel</th>
				<th>Tipo</th>
				<th>Enlace</th>
			    </tr>
			<thead>
			<tbody>
			    <c:forEach var="material" begin="0" items="${ListaMaterial2}">
				
                                    <c:if test="${(material.filtroDos == 0) && (material.filtroUno == 1) }">
				    <tr>
					<td>
					    <c:out value="${material.nombreMaterial}" />
					</td>
					<td>
					    <c:choose>
						<c:when test="${material.nivelMaterial == 1}">
						    Principiante
						</c:when>
						<c:when test="${material.nivelMaterial == 2}">
						    Intermedio
						</c:when>
						<c:when test="${material.nivelMaterial == 3}">
						    Experto
						</c:when>
						<c:when test="${material.nivelMaterial == 4}">
						    Challenger
						</c:when>
					    </c:choose>
					</td>
					<td>
					    <c:choose>
						<c:when test="${material.tipoMaterial == 0}">
						    PDF
						</c:when>
						<c:when test="${material.tipoMaterial == 1}">
						    Video Tutorial
						</c:when>
					    </c:choose>
					</td>
					<td>
					    <a href="../../NavegarF2Servlet?IdMaterial=<c:out value="${material.idMaterial}" />"><button type="button">Ir</button></a>
					</td>
				    </tr>
				</c:if>
                                   
			    </c:forEach>
			</tbody>
		    </table>
		</c:if>
	    </div>
	    <a href="profesor.jsp"><button type="button">Regresar</button></a>
	</div>
	
    </body>
    
</html>
