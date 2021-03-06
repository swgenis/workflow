<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/leave/header.jsp"></jsp:include>

<body ng-app="leave">

	<!-- Main content view -->
	<div class="container" ng-controller="LeaveApplicationCtrl"
		style="margin-top: 60px; margin-bottom: 60px">
		<h1>Leave</h1>

		<div class="list-group">
			<a
				href="${pageContext.request.contextPath}/leave/application.jsp"
				class="list-group-item">
				<h4 class="list-group-item-heading">Apply</h4>
				<p class="list-group-item-text">Click here to apply for new
					leave.</p>
			</a> <a
				href="${pageContext.request.contextPath}/leave/search-task.jsp"
				class="list-group-item">
				<h4 class="list-group-item-heading">Leave Applications</h4>
				<p class="list-group-item-text">Click here to search for leave
					applications in progress.</p>
			</a> <a
				href="${pageContext.request.contextPath}/leave/search-leave.jsp"
				class="list-group-item">
				<h4 class="list-group-item-heading">Finalized Leave</h4>
				<p class="list-group-item-text">Click here to search for
					finalized leave applications.</p>
			</a>
		</div>
	</div>

</body>
</html>