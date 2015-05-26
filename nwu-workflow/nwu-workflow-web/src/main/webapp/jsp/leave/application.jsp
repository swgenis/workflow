<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../include/header.jsp"></jsp:include>
	
	<!-- Include our scripts -->
	<script type="text/javascript" src="/backbone/resources/js/leave/leave-application.app.js"></script>
	<script type="text/javascript" src="/backbone/resources/js/leave/leave.rest.js"></script>
	
	<!-- Main content view -->
	<div ng-controller="LeaveApplicationCtrl" style="margin-top: 60px; margin-bottom: 60px">
		<h1>HC113 - AANSOEKVORM OM VERLOF</h1>
		<person-lookup person="person"></person-lookup>
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
					<p class="form-control-static">{{person.name}} {{person.surname}}</p>
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
					<p class="form-control-static">53  (TODO)</p>
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
						<tr ng-repeat="leaveEntry in leaveEntries" class="ng-cloak">
							<td>{{leaveEntry.typeKey}}</td>
							<td>{{leaveEntry.startDate}}</td>
							<td>{{leaveEntry.endDate}}</td>
							<td>x (TODO)</td>
							<td>&nbsp;<!-- <button class="btn btn-danger btn-xs" type="submit"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button> --></td>
						<tr>
						<tr>
							<td>
								<select class="form-control" id="leavetype" ng-model="newEntry.typeKey">
									<option ng-repeat="leaveType in leaveTypes" value="{{leaveType.id}}">{{leaveType.description}}</option>
								</select>
							</td>
							<td><input type="text" ng-model="newEntry.startDate"/></td>
							<td><input type="text" ng-model="newEntry.endDate"/></td>
							<td>&nbsp;</td>
							<td><button class="btn btn-primary btn-sm" type="submit" ng-click="addLeaveRecord()">Add</button></td>
						<tr>
					</tbody>
				</table>
			</div>
			<div class="form-group">
				<label for="address" class="col-sm-2 control-label">Adres Tydens Verlof</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" id="address"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="reason" class="col-sm-2 control-label">Rede</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" id="reason"></textarea>
				</div>
			</div>
			<div>
				<div class="alert alert-success" role="alert" ng-if="submitSuccess">Your leave has been submitted</div>
				<div class="alert alert-info" role="alert" ng-if="submitFail">Failed to submit leave</div>
				<input class="btn btn-default" type="submit" value="Dien in" ng-click="submitLeave()">
			</div>
			
		</form>
		
	</div>

<jsp:include page="../../include/footer.jsp"></jsp:include>