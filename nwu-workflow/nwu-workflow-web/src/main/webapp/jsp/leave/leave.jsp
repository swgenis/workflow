<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../include/header.jsp"></jsp:include>

	<script type="text/javascript" src="/backbone/resources/js/leave/leave-application.app.js"></script>
	<script type="text/javascript" src="/backbone/resources/js/leave/leave.rest.js"></script>

	<!-- Main content view -->
	<div ng-controller="LeaveApplicationCtrl" style="margin-top: 60px; margin-bottom: 60px">
		<h1>Leave</h1>
		
		<div class="list-group">
			<a href="/backbone/jsp/leave/application.jsp" class="list-group-item">
				<h4 class="list-group-item-heading">Apply</h4>
				<p class="list-group-item-text">Click here to apply for new leave.</p>
			</a>
			<a href="/backbone/jsp/leave/search-task.jsp" class="list-group-item">
				<h4 class="list-group-item-heading">Leave Applications</h4>
				<p class="list-group-item-text">Click here to search for leave applications in progress.</p>
			</a>
			<a href="/backbone/jsp/leave/search-leave.jsp" class="list-group-item">
				<h4 class="list-group-item-heading">Finalized Leave</h4>
				<p class="list-group-item-text">Click here to search for finalized leave applications.</p>
			</a>
		</div>
	</div>

<jsp:include page="../../include/footer.jsp"></jsp:include>