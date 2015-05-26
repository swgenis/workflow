<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"></jsp:include>

	<!-- Main content view -->
	<div ng-controller="ActionListCtrl" style="margin-top: 60px; margin-bottom: 60px">
		<h1>Action List</h1>
			<div>
				<table class="table table-bordered">
					<caption>Tasks</caption>
					<thead>
						<tr>
							<th>ID</th>
							<th>Details</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="task in tasks" class="ng-cloak">
							<td>{{task.id}}</td>
							<td>{{task.status}}</td>
							<td>
								<button class="btn btn-primary" type="button" ng-click="approveTask(task)">Approve</button>
								<button class="btn btn-danger" type="button" ng-click="denyTask(task)">Deny</button>
							</td>
						<tr>
					</tbody>
				</table>
			</div>
			
	</div>
	<script type="text/javascript" src="/backbone/resources/js/action-list/actionList.app.js"></script>
<jsp:include page="../include/footer.jsp"></jsp:include>