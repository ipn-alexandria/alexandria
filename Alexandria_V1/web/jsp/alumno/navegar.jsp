<%@page import="com.model.dao.UaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.model.entities.Ua"%>
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
    body{
    
    
    }
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
    
    
<form method="post" action="../../NavegarServlet" name="navegar">
 
  

  <p> Unidad de Aprendizaje </p>
  <select name="IdUA" class="form-control">
      
      <% 
          
          UaDAO udao = new UaDAO();
          
          
  List<Ua> UL = (List) udao.readAll();
 
  
 
  String currentNombre;
  int currentIdUA;
  
  Iterator<Ua> UIt = UL.iterator();
  while (UIt.hasNext()) {
  Ua Uaux = UIt.next();
  
  currentIdUA = Uaux.getIdUA();
  currentNombre = Uaux.getNombreUA();
  
  
  %>
      
      
      
      <option value= <%=currentIdUA %> >  <%=currentNombre %>  </option>
  
      
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
