<%@page import="java.util.Iterator"%>
<%@page import="com.model.entities.Tema"%>
<%@page import="java.util.List"%>
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
    
    
<form method="post" action="../../Navegar2Servlet" name="navegar">
  <p> Seleccione Tema </p>
  <select name="IdTema" class="form-control">
  <% 
  List TemaL = (List) session.getAttribute("ListaTemas");
 
  
  int currentIdTema;
  String currentNombre;
  int currentIdUA;
  
  Iterator<Tema> TIt = TemaL.iterator();
  while (TIt.hasNext()) {
  Tema Taux = TIt.next();
  
  currentIdTema = Taux.getIdTema();
  currentNombre = Taux.getNombretema();
  currentIdUA = Taux.getIdUA();
  
  %>
 
  <option value= <%=currentIdTema %> >  <%=currentNombre %>  </option>
 
  
  

  
  <%
  }
  %>

  </select>
  
 

  <br>
 
  <input type="submit" value="Continuar">
  <a href="alumno.jsp" > <input type="button" value="Regresar"> </a>

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
