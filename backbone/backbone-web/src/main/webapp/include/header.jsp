<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
	<meta content="user-scalable=no, initial-scale=1.0, maximum-scale=1, height=device-height, width=device-width" name="viewport" />
	<title>NWU Backbone</title>
	<!-- link rel="shortcut icon" href="${pageContext.request.contextPath}/css/images/favicon.ico" -->
	
	<script src="//code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"	type="text/javascript"></script>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
	<!-- Latest compiled and minified JavaScript -->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="/backbone/resources/backbone.css">
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	    <script type="text/javascript" src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	    <script type="text/javascript" src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	<!-- Include our scripts -->
	<script type="text/javascript" src="/backbone/resources/js/nwu-backbone.app.js"></script>
</head>
<body ng-app="nwu-backbone">
	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse" style="padding: 3px 3px 1px 6px;" type="button">
				<span class="glyphicon glyphicon-th glyphicon-inverse" style="font-size: 1.5em;"></span>
			</button>
			<a class="navbar-brand" href="#"><i>NWU Backbone</i>
			</a>
		</div>
		<div class="navbar-collapse collapse no-transition">
			<ul class="nav navbar-nav">
				<li><a href="/backbone/html/home.html"><span class="glyphicon glyphicon-home">&nbsp;</span>Home</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-list">&nbsp;</span>Processes <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="/backbone/html/leave/leave.html">Leave</a></li>
					</ul>
				</li>
				<li><a href="/backbone/html/taskList.html"><span class="glyphicon glyphicon-home">&nbsp;</span>Task List</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</nav>
	
	<!-- Main content view -->
	<div class="container"  style="margin-top: 60px; margin-bottom: 60px">