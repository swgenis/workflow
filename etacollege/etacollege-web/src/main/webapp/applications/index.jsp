<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/backbone/header.jsp"></jsp:include>

<body ng-app="intelitravel">

	<jsp:include page="/identity/dependencies.jsp"></jsp:include>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/intelitravel/js/travel.app.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/intelitravel/js/travel.rest.js"></script>
	<jsp:include page="/backbone/navbar.jsp"></jsp:include>

	<!-- Main content view -->
	<div class="container" ng-controller="TravelRequestCtrl"
		style="margin-top: 60px; margin-bottom: 60px">
		<h1>InteliTravel</h1>
		<user-info person="person"></user-info>
		<form class="form-horizontal">

			<div class="form-group">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<p class="form-control-static">example@example.com</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Cell</label>
				<div class="col-sm-10">
					<p class="form-control-static">0831234567</p>
				</div>
			</div>

			<div>
				<table class="table table-hover">
					<caption>Flights</caption>
					<thead>
						<tr>
							<th>Date</th>
							<th>From</th>
							<th>To</th>
							<th>Time</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="flight in flights" class="ng-cloak">
							<td><input type="date" class="form-control" datepicker-popup
								ng-model="flight.date" is-open="opened" min-date="minDate"
								max-date="'2015-06-22'" datepicker-options="dateOptions"
								date-disabled="disabled(date, mode)" ng-required="true"
								close-text="Close" /> <span class="input-group-btn">
									<button type="button" class="btn btn-default"
										ng-click="open($event)">
										<i class="glyphicon glyphicon-calendar"></i>
									</button>
							</span></td>

							<td><input class="form-control" type="text"
								ng-model="flight.from" /></td>
							<td><input class="form-control" type="text"
								ng-model="flight.to" /></td>
							<td><select class="form-control" id="departurePrefType"
								ng-model="flight.departurePrefTypeKey">
									<option ng-repeat="departurePrefType in departurePrefTypes"
										value="{{departurePrefType.key}}">{{departurePrefType.description}}</option>
							</select></td>
							<td><button class="btn btn-default btn-sm" type="submit"
									ng-click="removeFlight($index)">
									<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
								</button>

								<button class="btn btn-default btn-sm" type="submit"
									ng-click="addFlight($index)">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
								</button>
								<button class="btn btn-default btn-sm" type="submit"
									ng-click="returnFlight()" ng-if="$last">
									<span class="glyphicon glyphicon-transfer" aria-hidden="true"></span>
								</button></td>
						<tr>
					</tbody>
				</table>
			</div>

			<div>
				<div class="alert alert-success" role="alert" ng-if="submitSuccess">Your
					leave has been submitted</div>
				<div class="alert alert-danger" role="alert" ng-if="submitFail">Failed
					to submit leave</div>
				<input class="btn btn-primary" type="submit" value="Submit"
					ng-click="submitTravelRequest()">
			</div>

		</form>

	</div>

	<jsp:include page="/shared/include/footer.jsp"></jsp:include>

</body>
</html>