<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<meta content="user-scalable=no, initial-scale=1.0, maximum-scale=1, height=device-height, width=device-width" name="viewport" />
	<title>Backbone</title>
	<!-- link rel="shortcut icon" href="${pageContext.request.contextPath}/css/images/favicon.ico" -->
	<script>
		var contextPath = "${pageContext.request.contextPath}";
	</script>
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.1.min.js" ></script>
	<script	type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<!-- Latest compiled and minified JavaScript -->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/backbone.css">
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	    <script type="text/javascript" src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	    <script type="text/javascript" src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	<!-- Additional libraries -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
	
	<!-- Include our scripts -->
	<script type="text/javascript" src="/backbone/resources/js/backbone.app.js"></script>
	<script type="text/javascript" src="/backbone/resources/js/backbone.directives.js"></script>
	
</head>
<body ng-app="backbone">
	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse" style="padding: 3px 3px 1px 6px;" type="button">
				<span class="glyphicon glyphicon-th glyphicon-inverse" style="font-size: 1.5em;"></span>
			</button>
			<a class="navbar-brand" href="#"><i>Backbone</i>
			</a>
		</div>
		<div ng-controller="ConfigCtrl" class="navbar-collapse collapse no-transition">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}/jsp/home.jsp"><span class="glyphicon glyphicon-home">&nbsp;</span>Home</a></li>
				<li ng-repeat="process in processes" class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-list">&nbsp;</span>{{process.name}}<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li ng-repeat="subProcess in process.subProcesses"><a href="${pageContext.request.contextPath}{{subProcess.url}}">{{subProcess.name}}</a></li>
					</ul>
				</li>
				<li><a href="${pageContext.request.contextPath}/login/logout.jsp"><span class="glyphicon glyphicon-log-out">&nbsp;</span>Log Out</a></li>
			</ul>
		</div>		
		<!--/.nav-collapse -->
	</nav>
	
	<!-- Main content view -->
	<div class="container"  style="margin-top: 60px; margin-bottom: 60px">