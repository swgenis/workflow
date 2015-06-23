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
		<h1>Identity Management</h1>

		<div class="list-group">
			<a
				href="${pageContext.request.contextPath}/identity/search-person.jsp"
				class="list-group-item">
				<h4 class="list-group-item-heading">Search</h4>
				<p class="list-group-item-text">Click here to search for
					persons.</p>
			</a>
		</div>
	</div>

	<jsp:include page="/shared/include/footer.jsp"></jsp:include>

</body>
</html>