<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>masa</title>
	<link href="<c:url value="/resources/jqueryui/1.11.2/jquery-ui.css" />"	rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/jquery/appendGrid/jquery.appendGrid-1.5.1.css" />"	rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/masa.css" />" rel="stylesheet"  type="text/css" />
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-1.11.2.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.11.2/jquery-ui.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/appendGrid/jquery.appendGrid-1.5.1.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/dataTables/jquery.dataTables.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/masa.js" />"></script>
</head>
<body>
<h2>Masa Banner Here!</h2>

<P>  Some instructional text..... </P>

<a href="<c:url value="/discipline" />" title="disciplines">Create New Member</a>
<a href="<c:url value="/discipline/all" />" title="disciplines">Existing Members</a>
</body>
</html>
