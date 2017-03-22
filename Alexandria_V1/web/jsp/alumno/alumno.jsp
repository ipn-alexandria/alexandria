<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if ((session.getAttribute("idTipo") == null) || (session.getAttribute("IdTipo") == "")) {
	response.sendRedirect("../../index.jsp");
    }
%>
<!doctype html>
<html lang="en">
    <head>
        <!-- meta data & title -->
        <meta charset="utf-8">
        <title>Alexandria Alumno</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Alexandria Oficial WebPage">
        <meta name="author" content="Vargas Gamboa Ricardo Alan">
        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300">
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href="http://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="../../assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="../../assets/css/style.css">
        <link rel="stylesheet" href="../../assets/css/animate.min.css">
        <link rel="stylesheet" type="text/css" media="all" href="../../assets/css/style-projects.css">
        <link rel="icon" href="favicon.ico">
	<link rel="shortcut icon" href="favicon.ico">
    </head>
    <body>
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
		    <a class="navbar-brand wow fadeInDownBig" href="../../index.jsp"><img src="../../assets/img/slider/Office.png" width="100" alt="Office"></a>      
		</div>
		<div id="navbar-spy" class="collapse navbar-collapse navbar-responsive-collapse">
		    <ul class="nav navbar-nav pull-right">
			<li class="active">
			    <a href="alumno.jsp">Home</a>
			</li>
			<li>
			    <a href="navegar.jsp">Navegar</a>
			</li>
			<li>
			    <a href="subir.jsp"><span>Subir</span></a>
			</li>
			<li>
			    <a href="perfil.jsp"><span>Perfil</span></a>
			</li>
			<li>
			    <a href="../../LogoutServlet1"><span>Cerrar Sesión</span></a>
			</li>
		    </ul>         
		</div>
	    </div>
	</nav>
	<!-- End Header -->
	<!-- Begin #services-section -->
	<section id="services" class="services-section section-global-wrapper">
	    <div class="container">
		<div class="row">
		    <div class="services-header">
			<h3 class="services-header-title">Pagina de Alumno</h3>
			<p class="services-header-body"><em>Segundo Mensaje</em></p><hr>
		    </div>
		</div>
	    </div>
	</section>
	<footer> 
	    <div class="container">
		<div class="row">
		    <div class="col-md-4">
			<h3><i class="fa fa-map-marker"></i>Contacto:</h3>
			<p class="footer-contact">
			    Alexandria <br>
			    <br>
			    Email: Alexandria@Gmail.com<br>
			</p>
		    </div>
		</div>
	    </div>
	</footer>
	<!-- Footer End -->
	<script type="text/javascript" src="../../js/jquery-1.10.2.min.js"></script>
	<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="../../js/wow.min.js"></script>
	<script>new WOW().init();</script>
    </body>
</html>
