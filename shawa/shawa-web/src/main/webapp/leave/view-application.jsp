<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/leave/header.jsp"></jsp:include>

<body ng-app="leave">

	<!-- Main content view -->
	<div class="container" ng-controller="LeaveViewCtrl"
		style="margin-top: 60px; margin-bottom: 60px">
		<h1>Leave Application</h1>
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">NWU ID</label>
				<div class="col-sm-10">
					<p class="form-control-static">{{person.id}}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Naam</label>
				<div class="col-sm-10">
					<p class="form-control-static">{{person.name}}
						{{person.surname}}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Skool / Departement</label>
				<div class="col-sm-10">
					<p class="form-control-static">Ontwikkeling (TODO)</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Bussie</label>
				<div class="col-sm-10">
					<p class="form-control-static">53 (TODO)</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Uitbreiding</label>
				<div class="col-sm-10">
					<p class="form-control-static">007 (TODO)</p>
				</div>
			</div>

			<hr />

			<div>
				<table class="table table-bordered">
					<caption>Bookings</caption>
					<thead>
						<tr>
							<th>Type</th>
							<th>From</th>
							<th>To</th>
							<th>Days</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="period in taskSummary.data.leavePeriods"
							class="ng-cloak">
							<td>{{period.typeKey | typeLabel}}</td>
							<td>{{period.startDate | date:'yyyy-MM-dd'}}</td>
							<td>{{period.endDate | date:'yyyy-MM-dd'}}</td>
							<td>{{period.startDate |days:period.endDate}}</td>
							<td>&nbsp;<!-- <button class="btn btn-danger btn-xs" type="submit"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button> --></td>
						<tr>
					</tbody>
				</table>
			</div>
			<div class="form-group" ng-if="taskSummary.data.address">
				<label for="address" class="col-sm-2 control-label">Adres
					Tydens Verlof</label>
				<div class="col-sm-10">
					<p>{{taskSummary.data.address}}</p>
				</div>
			</div>
			<div class="form-group" ng-if="taskSummary.data.reason">
				<label for="reason" class="col-sm-2 control-label">Rede</label>
				<div class="col-sm-10">
					<p>{{taskSummary.data.reason}}</p>
				</div>
			</div>
			<div>
				<input class="btn btn-default" type="submit" value="Approve"
					ng-click="approve();"> <input class="btn btn-default"
					type="submit" value="Decline" ng-click="decline();">
			</div>

		</form>

	</div>


	<!-- Include our scripts -->
	<script type="text/javascript">
	// Pass the Java params to javascript
	var applicationId = "<%=request.getParameter("aid")%>
		";
	</script>

</body>
</html>