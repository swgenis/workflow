<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/backbone/header.jsp"></jsp:include>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/pay/js/pay-advice.app.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/pay/js/pay.rest.js"></script>

<body ng-app="backbone">

	<!-- Main content view -->
	<div class="container" ng-controller="PayAdviceCtrl"
		style="margin-top: 60px; margin-bottom: 60px">
		<h1>Pay Advice</h1>
		<person-lookup person="person"></person-lookup>
		<form class="form-horizontal">

			<div class="form-group">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<p class="form-control-static">example@example.com</p>
				</div>
			</div>

			<div>
				<div class="alert alert-success" role="alert" ng-if="submitSuccess">Your
					leave has been submitted</div>
				<div class="alert alert-danger" role="alert" ng-if="submitFail">Failed
					to submit leave</div>
				<input class="btn btn-primary" type="submit" value="Submit"
					ng-click="submitLeave()"> <input class="btn btn-default"
					type="submit" value="Email" ng-click="submitLeave()"> <input
					class="btn btn-default" type="submit" value="PDF"
					ng-click="submitLeave()">
			</div>

		</form>

	</div>

</body>
</html>