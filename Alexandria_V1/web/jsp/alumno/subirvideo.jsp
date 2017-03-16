<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<link rel="stylesheet" type="text/css" href="../../css/ytUpload.css" media="screen" />
		<title>Alexandria</title>
	</head>
	<body class="backgroundimg">
		<div class="content">
			<div class="cap">
				<div class="title">
					<img src="./img/resources/logo.png" width="25%">
				</div>
			</div>
			<span id="signinButton" class="pre-sign-in">
				<span
					class="g-signin"
					data-callback="signinCallback"
					data-clientid="155787557946-u3b5so0ik3eautotv8k29v1c6oihoe23.apps.googleusercontent.com"
					data-cookiepolicy="single_host_origin"
					data-scope="https://www.googleapis.com/auth/youtube.upload https://www.googleapis.com/auth/youtube">
				</span>
			</span>
			<div class="post-sign-in center">
				<div>
					<label for="title">Título:</label>
					<input id="title" type="text" value=""/>
				</div>
				<div>
					<label for="description">Descripción:</label>
					<textarea id="description"></textarea>
				</div>
				<div>
					<input input type="file" id="file" class="button" accept="video/*">
					<button id="button">Subir</button>
					<div class="during-upload">
						<p><span id="percent-transferred"></span>% (<span id="bytes-transferred"></span>/<span id="total-bytes"></span> bytes)</p>
						<progress id="upload-progress" max="1" value="0"></progress>
					</div>
					<div class="post-upload">
						<p>Video subido con ID <span id="video-id"></span>.</p>
						<span id="post-upload-status"></span>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../../footer.jsp" />
		<script src="../../js/jquery-1.10.2.min.js"></script>
		<script src="../../js/plusone.js"></script>
		<script src="../../js/ytCorsUpload.js"></script>
		<script src="../../js/ytUpload.js"></script>
	</body>
</html>
