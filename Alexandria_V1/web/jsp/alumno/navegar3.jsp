<%@page import="com.model.entities.Material"%>
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
    <link rel="icon" href="./img/resources/logo.ico" sizes="16x16 32x32 48x48 64x64 110x110 114x114" type="image/vnd.microsoft.icon">
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
    
    
    <div class="table" width="100%"> 
    <form method="post" action="../../Navegar3Servlet" name="form1">
        <div>Nombre  <input type="hidden" name="name" > </div>
        <div>Nivel  <input type="hidden" name="level" > </div>
        <div>Tipo  <input type="hidden" name="type" > </div>
        
    </form >
    
     <% 
  List MatL = (List) session.getAttribute("ListaMaterial");
 
  
  int currentIdMat;
  String currentNombre;
  int currentNivel;
  int currentTipo;
  int currentshow;
  
  
  Iterator<Material> MIt = MatL.iterator();
  while (MIt.hasNext()) {
  Material Maux = MIt.next();
  
  currentIdMat = Maux.getIdMaterial();
  currentNombre = Maux.getNombreMaterial();
  currentNivel = Maux.getNivelMaterial();
  currentTipo = Maux.getTipoMaterial();
  currentshow = Maux.getVisibilidadMaterial();
 
  
  %>
    
 <% if (currentshow == 1){  %>
  
  
          <form method="post" action="../../Navegar3Servlet" name="form2">
        <div>   <%=currentNombre %>  <input type="hidden" name="name" > </div> 
    <div>    <% if (currentNivel == 1 ) {out.print("Principiante");  }
    if (currentNivel == 2 ) {out.print("Intermedio");  }
    if (currentNivel == 3 ) {out.print("Experto");  }
    if (currentNivel == 4 ) {out.print("Challenger");  }
        %>  </div>
        
        <div>  <% if (currentTipo == 1 ) {out.print("Video Tutorial");   }
    if (currentTipo == 0 ) {out.print("PDF");  }
  
        %>  </div>
        
        <div> <input type="hidden" name="IdMaterial" value=<%= currentIdMat %> > </div>
        <div> <input type="submit" name="go" value="Ir" > </div>
       
        
        
        
    </form>
        
         <% }  %>
        

    
  

  
  <%
  }
  %>

  
  
  </div>
  
  

  
  
  
  
  
  
 

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
