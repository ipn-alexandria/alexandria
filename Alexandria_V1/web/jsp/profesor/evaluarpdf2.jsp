<%@page import="com.model.dao.UaDAO"%>
<%@page import="com.model.entities.Ua"%>
<%@page import="com.model.entities.Ua"%>
<%@page import="com.model.dao.MaterialDAO"%>
<%@page import="com.model.entities.Material"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if ((session.getAttribute("idTipo") == null) || (session.getAttribute("IdTipo") == "")) {
        System.out.print("Acceso denegado Principal");
	response.sendRedirect("../../index.jsp");
        return;
        
    }
    
  try{
    
    String cTipo;
    cTipo = session.getAttribute("idTipo").toString();
    
    
    
    
    if ((!cTipo.equals("2"))) {
        System.out.print("Acceso denegado del try");
        System.out.print(cTipo+"if");
        session.invalidate();
	response.sendRedirect("../../index.jsp");
        return;
    }
    
    
    
    System.out.print("Validado con exito");
    System.out.print(cTipo);
    
    
    }catch(Exception e){
         System.out.print("Acceso denegado del Catch");
        response.sendRedirect("../../index.jsp");
       
        return;
    
    }
    
    %>
<!doctype html>
<html lang="en">
    <head>
        <!-- meta data & title -->
        <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="favicon.ico">
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="stylesheet" type="text/css" href="../../css/grades.css" media="screen" />
        <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="../../assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="../../assets/css/style.css">
        <link rel="stylesheet" href="../../assets/css/animate.min.css">
        <link rel="stylesheet" type="text/css" media="all" href="../../assets/css/style-projects.css">
    </head>
    <% String id = session.getAttribute("idMaterial").toString();
	System.out.print(id);
	int idM = Integer.parseInt(id);
	
        
	Material cMat = new Material();
	Material cMat2 = new Material();
	MaterialDAO cMatDAO = new MaterialDAO();
	cMat.setIdMaterial(idM);
	cMat2 = cMatDAO.read(cMat);
	
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
			    <a href="profesor.jsp">Inicio</a>
			</li>
			<li>
			    <a href="navegar.jsp">Navegar</a>
			</li>
			<li>
			    <a href="subir.jsp"><span>Subir</span></a>
			</li>
			
                        <li>
			    <a href="evaluarFiltro1.jsp"><span>Revisar</span></a>
			</li>
                        <li>
			    <a href="evaluarFiltro2.jsp"><span>Aprobar</span></a>
			</li>
			<li>
			    <a href="../../LogoutServlet1"><span>Cerrar Sesión</span></a>
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
			<h3 class="services-header-title">  <% 
                                                        int idm = Integer.parseInt(session.getAttribute("idMaterial").toString()); 
                                                        Material m1 = new Material();
                                                        Material m2 = new Material();
                                                        MaterialDAO mdao1 = new MaterialDAO();
                                                        m1.setIdMaterial(idm);
                                                        m2 = mdao1.read(m1);
                                                    %>
                                                    <% out.println(m2.getNombreMaterial());%>
                                                </h3>
                                                <h3>
                                                    Nivel:
                                                    
                                                    <%
                                                        int c = m2.getNivelMaterial();
                                                        switch (c) {
                                                            case 1: out.println("Básico");
                                                                    break;
                                                            case 2: out.println("Intermedio");
                                                                    break;
                                                            case 3: out.println("Avanzado");
                                                                    break;
                                                        }
                                                    %>
                                                        
                                                </h3>
                                                <h3>
                                                    Unidad de Aprendizaje:
                                                    
                                                    <%
                                                        int d = m2.getIdUa();
                                                        Ua ua1 = new Ua();
                                                        Ua ua2 = new Ua();
                                                        UaDAO uadao1 = new UaDAO();
                                                        ua1.setIdUA(d);
                                                        ua2 = uadao1.read(ua1);
                                                        out.println(ua2.getNombreUA());
                                                    %></h3>
		    </div>
		</div>
		<div style="height:1200px;">
		    <% String ruta = session.getAttribute("rutaMaterial").toString();%>
		    <object data="<%=ruta%>" type="application/pdf" width="100%" height="100%">
			<p><b>Example fallback content</b>: This browser does not support PDFs. Please download the PDF to view it: <a href="<%=ruta%>">Download PDF</a>.</p>
		    </object>
		</div>      
	</section>
                        <div class="content">
	   
	    <form method="post" action="../../ProfEvF2Servlet" name="evf1">
		<p> Estatus </p>
		<select name="filtro2" class="form-control">
		   
		    <option value= 1 >   Aprobado </option>
                    <option value= 0 >   Rechazado </option>
		   
		</select>
                <p> Nivel de dificultad </p>
                <select name="nivel" class="form-control">
		   
		    <option value= 1 >  Principiante  </option>
                    <option value= 2 >   Intermedio </option>
                    <option value= 3 >   Avanzado </option>
		   
		</select>
                <p> Observaciones </p>
                <textarea name="obs" rows=4 cols=50> </textarea>
                
		<br><br>
		<input type="submit" value="Enviar">
                <br><br>
		<a href="profesor.jsp"><input type="button" value="Regresar"></a>
	    </form>
	</div>
	<!-- End #services-section -->
	<!-- Footer -->
	
	<!-- Footer End -->
	<script type="text/javascript" src="../../js/jquery-1.10.2.min.js"></script>
	<script src="../../assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="../../js/wow.min.js"></script>
	<script>
	    new WOW().init();
	</script>
    </body>
</html>
