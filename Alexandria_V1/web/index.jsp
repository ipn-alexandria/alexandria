<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%
    
    
    
    if ((session.getAttribute("idTipo") == null) || (session.getAttribute("IdTipo") == ""))
    {
         
%>






<html lang="en">
    <head>

        <!-- meta data & title -->
        <meta charset="utf-8">
        <title>Alexandria </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Alexandria Oficial WebPage">
        <meta name="author" content="Vargas Gamboa Ricardo Alan">
        <link rel="icon" href="favicon.ico">
         <link rel="shortcut icon" href="favicon.ico">

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300">
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="http://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/animate.min.css">
        <link rel="stylesheet" type="text/css" media="all" href="assets/css/style-projects.css">
        

        
        
    </head>
  <body>
      <div class ="backgroundimg">  </div>

    <!-- Header -->
        
    <nav id="navbar-section" class="navbar navbar-default navbar-static-top navbar-sticky" role="navigation">
        <div class="container">
        
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand wow fadeInDownBig" href="index.jsp"><img src="assets/img/slider/Office.png" width="200" alt="Office"></a>      
            </div>
        
            <div id="navbar-spy" class="collapse navbar-collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav pull-right">
                    <li class="active">
                        <a href="index.jsp">Inicio</a>
                    </li>
                  <li>
                        <a href="login.jsp">Login</a>
                    </li>
                   
                     <li>
                        <a href="register.jsp"><span>Registro</span></a>
                    </li>

                    
              </ul>         
            </div>
        </div>
    </nav>

    <!-- End Header -->


    <!-- Begin #carousel-section -->
    <section id="carousel-section" class="section-global-wrapper"> 
        <div class="container-fluid-kamn">
            <div class="row">
                <div id="carousel-1" class="carousel slide">

                    <!-- Indicators -->
                    <ol class="carousel-indicators visible-lg">
                        <li data-target="#carousel-1" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-1" data-slide-to="1"></li>
                        <li data-target="#carousel-1" data-slide-to="2"></li>
                        <li data-target="#carousel-1" data-slide-to="3"></li>
                    </ol>
        
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <!-- Begin Slide 1 -->
                        <div class="item active">
                            <img src="assets/img/slider/slide1.jpg" height="400" alt="2">
                            <div class="carousel-caption">
                                <h3 class="carousel-title hidden-xs"></h3>   <!--Texto Carrousel  -->
                                <p class="carousel-body"></p>                <!--Texto Carrousel 2 -->
                            </div>
                        </div>
                        <!-- End Slide 1 -->

                        <!-- Begin Slide 2 -->
                        <div class="item">
                            <img src="assets/img/slider/slide2.jpg" height="400" alt="2">
                            <div class="carousel-caption">
                                <h3 class="carousel-title hidden-xs"></h3> <!--Texto Carrousel  -->
                                <p class="carousel-body"></p> <!--Texto Carrousel  -->
                            </div>
                        </div>
                        <!-- End Slide 2 -->

                        <!-- Begin Slide 3 -->
                        <div class="item">
                            <img src="assets/img/slider/slide3.jpg" height="400" alt="2">
                            <div class="carousel-caption">
                                <h3 class="carousel-title hidden-xs"></h3> <!--Texto Carrousel  -->
                                <p class="carousel-body"> </p> <!--Texto Carrousel  -->
                            </div>
                        </div>
                        <!-- End Slide 3 -->
                         <!-- Begin Slide 4 -->
                        <div class="item">
                            <img src="assets/img/slider/slide4.jpg" height="400" alt="2">
                            <div class="carousel-caption">
                                <h3 class="carousel-title hidden-xs"></h3> <!--Texto Carrousel  -->
                                <p class="carousel-body"> </p> <!--Texto Carrousel  -->
                            </div>
                        </div>
                        <!-- End Slide 4 -->
                    </div>
        
                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-1" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-1" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>
        </div>
    </section>
    <!-- End #carousel-section -->


    <!-- Begin #services-section -->
    <section id="services" class="services-section section-global-wrapper">
        <div class="container">
            <div class="row">
                <div class="services-header">
                    <h3 class="services-header-title">Alexandria Beyond Knowledge</h3>
                    <p class="services-header-body"><em> IPN 2017 </em>  </p><hr>
                </div>
            </div>
      
        </div>



      <!-- Footer -->
     <footer> 
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <jsp:include page="footer.jsp" />
                </div>


                 
            </div>
        </div>
    </footer>

     <!-- Footer End -->

    
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script>
      new WOW().init();
    </script>
    
       
  </body>
</html>


<!-- redirecting -->

<% }


String currentTipo;
try
    {
    
    
    System.out.print(session.getAttribute("idTipo"));
    currentTipo = session.getAttribute("idTipo").toString();
    
    


if((currentTipo).equals("4")) {

System.out.print(currentTipo);

response.sendRedirect("jsp/alumno/alumno.jsp");

}

if((currentTipo).equals("3")) {

System.out.print(currentTipo);

response.sendRedirect("jsp/moderador/moderador.jsp");

}

if((currentTipo).equals("2")) {

System.out.print(currentTipo);

response.sendRedirect("jsp/profesor/profesor.jsp");

}

if((currentTipo).equals("1")) {

System.out.print(currentTipo);

response.sendRedirect("jsp/administrador/admin.jsp");

}

} catch(Exception e){}

%>









<%
    
%>

<!-- end redirecting -->