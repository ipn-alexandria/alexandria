<%-- 
    Document   : recuperar
    Created on : 29/03/2017, 05:11:09 PM
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
		<title>Alexandria</title>
	</head>
	<body class="backgroundimg">
		<div class="content">
			<div class="cap">
				<div class="title">
					<img src="./img/resources/logo.png" width="17%">
				</div>
			</div>
			<form method="post" action="RecuperarServlet" name="recuperacion" width="70%">
				
				<input type="text" placeholder="Email" name="Email"  required />
				
				<br>
				<a href="login.jsp" >Ya Conozco mis datos de acceso</a>
				<input type="submit" value="recuperar" />
				<a href="index.jsp"><input type="button" value="Regresar" /></a>
			</form>
		</div>
		<jsp:include page="footer.jsp" />
	</body>
</html>
