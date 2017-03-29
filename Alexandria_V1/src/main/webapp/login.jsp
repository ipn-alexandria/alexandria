<%
	String currentTipo;
	try {
		System.out.print("CodigoJSP");
		System.out.print(session.getAttribute("idTipo"));
		currentTipo = session.getAttribute("idTipo").toString();
		if ((currentTipo.equals("1"))
				|| (currentTipo.equals("2"))
				|| (currentTipo.equals("3"))
				|| (currentTipo.equals("4"))) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	} catch (Exception e) {
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
			<form method="post" action="LoginServlet">
				<input type="text" placeholder="Usuario" name="uname" required>
				<input type="password" placeholder="Contraseña" name="pass" required>
				<a href="#" >¿Olvidaste tu nombre de usuario o contraseña?</a>
				<input type="submit" value="Entrar">
				<a href="index.jsp" > <input type="button" value="Regresar"> </a>
			</form>
		</div>
		
	</body>
</html>
