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

<body >
    
  <div class="cap">
    <div class="title">
        <img src="./img/resources/logo.png" width="25%">
    </div>
</div>
    <% String idmatac = (String)session.getAttribute("idmatup");
        System.out.println("idmatup = " + idmatac);
    %>
    <form method="post" action="../../SubirPDF1Servlet" enctype="multipart/form-data">
        <table border="0">

            <tr>
                <td>Pdf: </td>
                <td><input type="file" name="pdf" accept="application/pdf"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
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
