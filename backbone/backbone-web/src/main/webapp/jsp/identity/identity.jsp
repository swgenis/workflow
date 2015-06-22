<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/include/header.jsp"></jsp:include>
<script type="text/javascript"
	src="/backbone/resources/js/identity/identity.app.js"></script>
<script type="text/javascript"
	src="/backbone/resources/js/identity/identity.rest.js"></script>
<jsp:include page="/include/navbar.jsp"></jsp:include>

<body ng-app="backbone">

	<!-- Main content view -->
	<div class="container" ng-controller="IdentityCtrl"
		style="margin-top: 60px; margin-bottom: 60px">
		<h1>Identity Management</h1>

		<div class="list-group">
			<a href="/backbone/jsp/identity/search-person.jsp"
				class="list-group-item">
				<h4 class="list-group-item-heading">Search</h4>
				<p class="list-group-item-text">Click here to search for
					persons.</p>
			</a>
		</div>
	</div>
	
	<jsp:include page="/include/footer.jsp"></jsp:include>
	
</body>
</html>