<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="../include/header.jsp"></jsp:include>

<body ng-app="backbone">
	<jsp:include page="../include/navbar.jsp"></jsp:include>

	<!-- Main content view -->
	<div class="container" style="margin-top: 60px; margin-bottom: 60px">
		<div>
			<h1>Backbone</h1>
			<p>Select an option from the navigation menu to start</p>

			<action-list></action-list>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp"></jsp:include>

</body>
</html>