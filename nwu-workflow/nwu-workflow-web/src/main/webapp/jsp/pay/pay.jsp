<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String applicationId = request.getParameter("aid");
	String action = request.getParameter("a");
%>


<jsp:include page="../../include/header.jsp"></jsp:include>

<!-- Main content view -->
<div ng-controller="LeaveApplicationCtrl" style="margin-top: 60px; margin-bottom: 60px">
	<h1>Pay Advice</h1>
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
		
	</form>
	
</div>


<!-- Include our scripts -->
<script type="text/javascript">
	// Pass the Java params to javascript
	var applicationId = "<%= request.getParameter("aid") %>";
	var action = "<%= request.getParameter("a") %>";
</script>
<script type="text/javascript" src="/backbone/resources/js/pay/pay-advice.app.js"></script>
<script type="text/javascript" src="/backbone/resources/js/pay/pay.rest.js"></script>

<jsp:include page="../../include/footer.jsp"></jsp:include>