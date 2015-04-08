<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>NWU Backbone</title>
	<link href="<c:url value="/resources/jqueryui/1.11.2/jquery-ui.css" />"	rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/jquery/appendGrid/jquery.appendGrid-1.5.1.css" />"	rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/backbone.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-1.11.2.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.11.2/jquery-ui.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/appendGrid/jquery.appendGrid-1.5.1.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/dataTables/jquery.dataTables.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bacbone.js" />"></script>
</head>
<body>
	<h2>NWU Backbone!</h2>

	<p><%= request.getAttribute("message") == null ? "" : request.getAttribute("message") %></p>

	<form:form id="leave-application-form" method="post" modelAttribute="leave-application-form"
		cssClass="cleanform" action="/backbone/leave/apply">
		<fieldset>
		
			<legend>Leave Application Form</legend>
			<div id="leave-application-info" class="info"></div>
			<jsp:include page="person-lookup.jsp" />
			
			<!-- Allow form submission with keyboard without duplicating the dialog button -->
			<button type="submit">Submit</button>
	
		</fieldset>
	</form:form>
	<script type="text/javascript">
		$(document).ready( function() {
			$("#leave-application-info").hide();
			$("#leave-application-form").submit( function() {
				$.post($(this).attr("action"), $(this).serialize(), function(data) {
					var infoSection = $("#leave-application-info").empty();
					infoSection.append("<h3>" + data + "</h3>");
					infoSection.show();
				});
			});
		});
	</script>
	<ul>
		<li><a href="task?user=jiri&amp;cmd=list">Jiri's Task</a></li>
		<li><a href="task?user=mary&amp;cmd=list">Mary's Task</a></li>
	</ul>
</body>
</html>
