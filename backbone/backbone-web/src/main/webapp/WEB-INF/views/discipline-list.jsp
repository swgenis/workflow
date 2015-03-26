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
	<p>
		<a href="<c:url value="/" />" title="masa">Home</a>
	</p>

	<script type="text/javascript"
		src="<c:url value="/resources/js/discipline.js" />"></script>

<div>
		
	<table id="discipline-table" class="display" width="100%" cellspacing="0">
        <thead>
            <tr>
                <th>Year</th>
                <th>Website</th>
                <th>Action</th>
            </tr>
        </thead>
 
        <c:forEach items="${allDisciplines}" var="discipline">
    		<tr>      
        		<td>${discipline.year}</td>
	       		<td>${discipline.website}</td>
    	   		<td><a href="<c:url value="/discipline/${discipline.id}" />" title="disciplines">edit</a><td>
	    	</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
