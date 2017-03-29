<%-- 
    Document   : failrec
    Created on : 29/03/2017, 05:19:31 PM
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
		<link rel="icon" href="favicon.ico">
		<link rel="shortcut icon" href="favicon.ico">
		<link rel="stylesheet" type="text/css" href="./css/grades.css" media="screen" />
		<style> 
			body{background-image: url(./img/background.jpg);  }
		</style>
		<title>Alexandria</title>
	</head>
	<body>
		<div class="content">
			<div class="cap">
				<div class="title">
					<img src="./img/resources/logo.png" width="25%">
				</div>
			</div>
			<form>
				<p> E-mail no registrado </p>
                                
                                <p> ¿Eso significa que no recupere nada? (Pues si wey no mames) </p>
				<a href="recuperar.jsp" > <input type="button" value="Reintentar"> </a>
				<a href="index.jsp" > <input type="button" value="Regresar"> </a>
			</form>
		</div>
		<jsp:include page="../../footer.jsp" />
	</body>
</html>
