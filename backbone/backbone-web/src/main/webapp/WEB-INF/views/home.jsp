<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

	<P>  Some instructional text..... </P>

	<jsp:include page="person-lookup.jsp" />
</body>
</html>
