<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/backbone/header.jsp"></jsp:include>

<body ng-app="backbone" ng-controller="ConfigCtrl">

	<nav-bar></nav-bar>

	<!-- Main content view -->
	<div class="container" style="margin-top: 60px; margin-bottom: 60px">
		<div>
			<h1>Welcome</h1>
			<p>Select an option from the navigation menu to start</p>

			<action-list></action-list>
		</div>
	</div>

	<jsp:include page="/shared/include/footer.jsp"></jsp:include>

</body>
</html>