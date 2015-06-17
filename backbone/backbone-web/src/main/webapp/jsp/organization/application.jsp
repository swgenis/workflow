<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../include/header.jsp"></jsp:include>
	
	<!-- Include our scripts -->
	<script type="text/javascript" src="/backbone/resources/js/organization/organization.app.js"></script>
	<script type="text/javascript" src="/backbone/resources/js/organization/organization.rest.js"></script>

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
	<div class="container" ng-controller="OrganizationCtrl" style="margin-top: 60px; margin-bottom: 60px">		
	</div>

<jsp:include page="../../include/footer.jsp"></jsp:include>