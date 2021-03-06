<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/leave/header.jsp"></jsp:include>s"></script>

<body ng-app="leave">

	<!-- Main content view -->
	<div class="container" ng-controller="LeaveApplicationCtrl"
		style="margin-top: 60px; margin-bottom: 60px">
		<h1>Tasklist</h1>

		<div>
			<form class="form-inline">
				<div class="form-group">
					<label for="nwuid" class="sr-only">NWU ID</label> <input
						type="text" class="form-control" id="nwuid" placeholder="NWU ID"
						ng-model="username">
				</div>
				<button type="submit" class="btn btn-default"
					ng-click="searchLeaveTasks()">Search</button>
			</form>
		</div>
		<div>
			<table class="table table-bordered">
				<caption>Bookings</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="task in tasks">
						<td>{{task.id}}</td>
						<td>{{task.status}}</td>
						<td>
							<button class="btn btn-primary" type="button"
								ng-click="approveLeave(task)">Approve</button>
							<button class="btn btn-danger" type="button"
								ng-click="denyLeave(task)">Deny</button>
						</td>
					<tr>
				</tbody>
			</table>
		</div>

	</div>

</body>
</html>