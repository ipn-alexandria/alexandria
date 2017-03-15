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
		<script src="js/jquery-1.10.2.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/grades.css" media="screen" />
		<title>Alexandria</title>
	</head>
	<body class="backgroundimg">
		<div class="content">
			<div class="cap">
				<div class="title">
					<img src="./img/resources/logo.png" width="25%">
				</div>
			</div>
			<div class="center datagrid">
				<table border="0" class="center">
					<tr>
						<td>
							<c:if test="${param.credential != 1}">
								<p>Necesita autorizar el ingreso a Youtube.</p>
							</c:if>
							<c:if test="${param.credential == 1}">
								<form enctype="multipart/form-data">
									<input name="file" type="file" accept="video/*"/>
									<input type="button" value="Subir"/>
								</form>
								<progress value="0">
								</progress>
							</c:if>
						</td>
					</tr>
					<tr>
					</tr>
				</table>
			</div>
		</div>
		<jsp:include page="../../footer.jsp" />
		<script>
			$(':button').on('click', function () {
				$.ajax({
					// Your server script to process the upload
					url: '../../YoutubeUpload',
					type: 'POST',
					// Form data
					data: new FormData($('form')[0]),
					// Tell jQuery not to process data or worry about content-type
					// You *must* include these options!
					cache: false,
					contentType: false,
					processData: false,
					// Custom XMLHttpRequest
					xhr: function () {
						var myXhr = $.ajaxSettings.xhr();
						if (myXhr.upload) {
							// For handling the progress of the upload
							myXhr.upload.addEventListener('progress', function (e) {
								if (e.lengthComputable) {
									$('progress').attr({
										value: e.loaded,
										max: e.total
									});
								}
							}, false);
						}
						return myXhr;
					},
				});
			});
		</script>
	</body>
</html>
