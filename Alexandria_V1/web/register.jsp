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
 <!--  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet"> -->
    <title>Alexandria</title>

    <!-- Bootstrap Core CSS -->


</head>
<video id="videobcg" preload="auto" autoplay="true" loop="loop" muted="muted" volume="0">
  <!--  <source src="./img/video/IMG_3727.mov" type="video/mp4"> -->
    <source src="movie.webm" type="video/webm">
         Sorry, your browser does not support HTML5 video. //
         Lo sentimos, tu navegador no soporta la visualizacion de video <a href src="https://www.google.com.mx/chrome/">https://www.google.com.mx/chrome/</a>
</video>
<body>
  <div class="cap">
    <div class="title">
        <img src="./img/resources/logo.png" width="17%">
    </div>
</div>
<form method="post" action="RegistroServlet" name="registro" width="70%">


  

  <input type="text" placeholder="Usuario" name="Usuario"required>
  <input type="password" placeholder="Contraseña" name="Pass" required>
  <input type="text" placeholder="Nombre" name="Nombre" required>
  <input type="text" placeholder="Apellido Paterno" name="Paterno" required>
  <input type="text" placeholder="Apellido Materno" name="Materno" required>
<input type="text" placeholder="Matricula" name="Matricula"  required>


<select name="Tipo" class="form-control">
  <option value="4">Alumno</option>
  <option value="2">Profesor</option>
</select>

  <br>
  <a href="login.jsp" >¿Ya estas Registrado? ¿Que haces aqui? =o </a>
  <input type="submit" value="Registrar">
  <a href="index.jsp" > <input type="button" value="Regresar"> </a>

</form>
</body>
    <br>
    <br>    <br>
    <br>    <br>
    <br>    
    <footer>
        Alexandria-IPN 2016 ©
    </footer>

</html>
