<%@page import="com.model.entities.Material"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.model.entities.Tema"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
     <link rel="stylesheet" type="text/css" href="./css/grades.css" media="screen" />
   
 
    <title>Alexandria</title>

    <!-- Bootstrap Core CSS -->


</head>
 
   
    <body>
	<div class="cap">
	    <div class="title">
		<img src="./img/resources/logo.png" width="17%">
	    </div>
	</div>
	<div class="datagrid">
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
		    <c:forEach var="material" begin="0" items="${ListaMaterial}">
			<c:if test="${material.visibilidadMaterial == 1}">
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
				    <a href="../../Navegar3Servlet?IdMaterial=<c:out value="${material.idMaterial}" />"><button type="button">Ir</button></a>
				</td>
			    </tr>
			</c:if>
		    </c:forEach>
		</tbody>
	    </table>
	</div>
	<a href="alumno.jsp"><button type="button">Regresar</button></a>
	<footer class="footer">
	    Alexandria-IPN 2016 ©
	</footer>
    </body>

</html>
