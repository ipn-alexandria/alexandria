<%@page import="com.model.dao.MaterialDAO"%>
<%@page import="com.model.entities.Material"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <% String id = session.getAttribute("idMaterial").toString();
	System.out.print(id);
	int idM = Integer.parseInt(id);
	String cLink;
        String cConf = "?rel=\"0\"&showinfo=\"0\"";
	Material cMat = new Material();
	Material cMat2 = new Material();
	MaterialDAO cMatDAO = new MaterialDAO();
	cMat.setIdMaterial(idM);
	cMat2 = cMatDAO.read(cMat);
	cLink = "https://www.youtube.com/embed/" + cMat2.getDireccionMaterial()+cConf;
    %>
    <body>
	<nav id="navbar-section" class="navbar navbar-default navbar-static-top navbar-sticky" role="navigation">
	    <div class="container">
		<div class="navbar-header">
		    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		    </button>
		    <a class="navbar-brand wow fadeInDownBig" href="index.html"><img src="../../assets/img/slider/Office.png" width="100" alt="Office"></a>      
		</div>
		<div id="navbar-spy" class="collapse navbar-collapse navbar-responsive-collapse">
		    <ul class="nav navbar-nav pull-right">
			<li class="active">
			    <a href="moderador.jsp">Inicio</a>
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
		    </ul>         
		</div>
	    </div>
	</nav>
	<!-- Begin #services-section -->
	<section id="services" class="services-section section-global-wrapper">
	    <div class="container">
		<div class="row">
		    <div class="services-header">
			<h3 class="services-header-title">Vea su video</h3>
			<p class="services-header-body"><em>  </em>  </p><hr>
		    </div>
		</div>
		<!-- Begin Services Row 2 -->
		<div class="row services-row services-row-tail services-row-2">
		    <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12" >
			<div class="services-group wow animated zoomIn" data-wow-offset="40">
			    <iframe width="90%" height="500px" src=<%=cLink%> frameborder="0" allowfullscreen></iframe>
			</div>
		    </div>
		</div>
		<!-- End Serivces Row 2 -->
	    </div>      
	</section>
	<!-- End #services-section -->
	<!-- Footer -->
	<footer> 
	    <div class="container">
		<div class="row">
		    <div class="col-md-4">
			<jsp:include page="../../footer.jsp" />
		    </div>
		</div>
	    </div>
	</footer>
	<!-- Footer End -->
	<script type="text/javascript" src="../../js/jquery-1.10.2.min.js"></script>
	<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="../../js/wow.min.js"></script>
	<script>
	    new WOW().init();
	</script>
    </body>
</html>
