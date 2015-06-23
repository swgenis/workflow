<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/backbone/header.jsp"></jsp:include>

<body ng-app="identity">

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/identity/js/identity.app.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/identity/js/identity.directives.js"></script>
	<jsp:include page="../backbone/navbar.jsp"></jsp:include>

	<!-- Main content view -->
	<div class="container" ng-controller="IdentityCtrl"
		style="margin-top: 60px; margin-bottom: 60px">
		<h1>Search for persons</h1>
		<person-lookup person="person"></person-lookup>

		<div>
			<table class="table table-bordered">
				<caption>Search Result</caption>
				<thead>
					<tr>
						<th>Name</th>
						<th>Surname</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="person in persons">
						<td>{{person.name}}</td>
						<td>{{person.surname}}</td>
					<tr>
				</tbody>
			</table>
		</div>

	</div>

	<jsp:include page="/shared/include/footer.jsp"></jsp:include>

</body>
</html>