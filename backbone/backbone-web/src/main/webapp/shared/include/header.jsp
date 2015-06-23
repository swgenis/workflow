<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8" />
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<meta
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1, height=device-height, width=device-width"
	name="viewport" />
<title>Backbone</title>
<!-- link rel="shortcut icon" href="${pageContext.request.contextPath}/css/images/favicon.ico" -->
<script>
	var contextPath = "${pageContext.request.contextPath}";
</script>
<script type="text/javascript"
	src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/backbone.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	    <script type="text/javascript" src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	    <script type="text/javascript" src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->

<!-- Additional libraries -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>

<!-- Include our scripts -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backbone/js/backbone.app.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backbone/js/backbone.directives.js"></script>

</head>