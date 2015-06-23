<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> <img alt="BackBone"
				src="${pageContext.request.contextPath}/resources/images/OpenCollab-300x60.png">
			</a>
		</div>
		<div ng-controller="ConfigCtrl"
			class="navbar-collapse collapse no-transition">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}/backbone/home.jsp"><span
						class="glyphicon glyphicon-home">&nbsp;</span>Home</a></li>
				<li ng-repeat="process in processes" class="dropdown"><a
					class="dropdown-toggle" data-toggle="dropdown" href="#"><span
						class="glyphicon glyphicon-list">&nbsp;</span>{{process.name}}<b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li ng-repeat="subProcess in process.subProcesses"><a
							href="${pageContext.request.contextPath}{{subProcess.url}}">{{subProcess.name}}</a></li>
					</ul></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">{{principal.name}} {{principal.surname}}<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/shared/login/logout.jsp"><span
								class="glyphicon glyphicon-log-out">&nbsp;</span>Log Out</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>