<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/leave/header.jsp"></jsp:include>

<body ng-app="leave">

	<!-- Main content view -->
	<div class="container" ng-controller="LeaveSearchCtrl"
		style="margin-top: 60px; margin-bottom: 60px">
		<h1>Search for leave</h1>
		<person-lookup person="person"></person-lookup>

		<div>
			<table class="table table-bordered">
				<caption>Bookings</caption>
				<thead>
					<tr>
						<th>Type</th>
						<th>From</th>
						<th>To</th>
						<th>Days</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="leaveEntry in leaveEntries">
						<td>{{leaveEntry.typeKey}}</td>
						<td>{{leaveEntry.startDate}}</td>
						<td>{{leaveEntry.endDate}}</td>
						<td>4 days (TODO)</td>
						<td>{{leaveEntry.status}}</td>
					<tr>
				</tbody>
			</table>
		</div>

	</div>

</body>
</html>