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
	<link rel="stylesheet" type="text/css" href="../../css/grades.css" media="screen" />
	<title>Alexandria</title>
    </head>
    <body class="backgroundimg">
	<div class="content">
	    <div class="cap">
		<div class="title">
		    <img src="../../img/resources/logo.png" width="25%">
		</div>
	    </div>
	    <% String idmatac = (String) session.getAttribute("idmatup");
		System.out.println("idmatup = " + idmatac);
	    %>
	    <div class="center">
		<form method="post" action="../../SubirPDF1Servlet" enctype="multipart/form-data">
		    <table border="0" class="center">
			<tr>
			    <td><p>PDF:</p></td>
			    <td><input type="file" name="pdf" accept="application/pdf" /></td>
			</tr>
			<tr>
			    <td colspan="2">
				<input type="submit" value="Guardar" />
			    </td>
			</tr>
		    </table>
		</form>
	    </div>
	</div>
	<jsp:include page="../../footer.jsp" />
    </body>
</html>
