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
			<form method="post" action="RegistroServlet" name="registro" width="70%">
				<input type="text" placeholder="Usuario" name="Usuario"required />
				<input type="password" placeholder="Contraseña" name="Pass" required />
				<input type="text" placeholder="Nombre" name="Nombre" required />
				<input type="text" placeholder="Apellido Paterno" name="Paterno" required />
				<input type="text" placeholder="Apellido Materno" name="Materno" required />
				<input type="text" placeholder="Matricula" name="Matricula"  required />
				<select name="Tipo" class="form-control">
					<option value="4">Alumno</option>
					<option value="2">Profesor</option>
				</select>
				<br>
				<a href="login.jsp" >¿Ya estás registrado?</a>
				<input type="submit" value="Registrar" />
				<a href="index.jsp"><input type="button" value="Regresar" /></a>
			</form>
		</div>
		<jsp:include page="footer.jsp" />
	</body>
</html>
