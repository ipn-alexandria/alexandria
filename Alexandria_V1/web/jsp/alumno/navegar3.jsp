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
	<link rel="icon" href="./img/resources/logo.ico" sizes="16x16 32x32 48x48 64x64 110x110 114x114" type="image/vnd.microsoft.icon">
	<link rel="stylesheet" type="text/css" href="./css/grades.css" media="screen" />
	<style> 
	    body{background-image: url(./img/background.jpg);  }
	</style>
	<title>Alexandria</title>
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
					<c:when test="${material.tipoMaterial == 1}">
					    Principiante
					</c:when>
					<c:when test="${material.tipoMaterial == 2}">
					    Intermedio
					</c:when>
					<c:when test="${material.tipoMaterial == 3}">
					    Experto
					</c:when>
					<c:when test="${material.tipoMaterial == 4}">
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
				    <form method="post" action="../../Navegar3Servlet" name="form2">
					<input type="hidden" name="IdMaterial" value="<c:out value="${material.idMaterial}" />">
					<button type="submit" name="go">Ir</button>
				    </form>
				</td>
			    </tr>
			</c:if>
		    </c:forEach>
		</tbody>
	    </table>
	</div>
	<button type="submit">Continuar</button>
	<a href="alumno.jsp"><button type="button">Regresar</button></a>
	<footer class="footer">
	    Alexandria-IPN 2016 ©
	</footer>
    </body>
</html>
