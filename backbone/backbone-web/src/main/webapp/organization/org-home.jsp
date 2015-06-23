<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/backbone/header.jsp"></jsp:include>

<body ng-app="backbone">

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/organization/js/organization.app.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/organization/js/organization.rest.js"></script>
	<jsp:include page="../backbone/navbar.jsp"></jsp:include>

	<!-- Main content view -->
	<div class="container" ng-controller="OrganizationCtrl"
		style="margin-top: 60px; margin-bottom: 60px">
		<h1>Organizational Management</h1>

		<div class="list-group">
			<a href=""
				${pageContext.request.contextPath}/jsp/org/search-org.jsp" class="list-group-item">
				<h4 class="list-group-item-heading">Search</h4>
				<p class="list-group-item-text">Click here to search for
					Organizational Units.</p>
			</a>
		</div>
	</div>

	<jsp:include page="/shared/include/footer.jsp"></jsp:include>

</body>
</html>