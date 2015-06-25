<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/backbone/header.jsp"></jsp:include>

<body ng-app="identity">

	<jsp:include page="/identity/dependencies.jsp"></jsp:include>
	<jsp:include page="../backbone/navbar.jsp"></jsp:include>

	<!-- Main content view -->
	<div class="container" ng-controller="IdentityCtrl"
		style="margin-top: 60px; margin-bottom: 60px">
		<h1>Search for persons</h1>

		<div>

			<form class="form-inline" ng-submit="searchPersons()">
				<div class="form-group">
					<label for="name">Name</label> <input type="text"
						class="form-control" id="name" placeholder="Name" ng-model="name">
				</div>
				<div class="form-group">
					<label for="surname">Surname</label> <input type="text"
						class="form-control" id="surname" placeholder="Surname"
						ng-model="surname">
				</div>
				<button type="submit" class="btn btn-default">Search</button>
			</form>
		</div>
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