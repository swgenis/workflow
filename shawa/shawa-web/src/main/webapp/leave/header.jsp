<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8" />
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<meta
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1, height=device-height, width=device-width"
	name="viewport" />

<jsp:include page="/shared/include/dependencies.jsp"></jsp:include>

<script>
	var contextPath = "${pageContext.request.contextPath}";
</script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/backbone.css">

<jsp:include page="/backbone/dependencies.jsp"></jsp:include>
<jsp:include page="/identity/dependencies.jsp"></jsp:include>

<%
    String applicationId = request.getParameter("aid");
			String action = request.getParameter("a");
%>

<!-- Include our scripts -->
<script type="text/javascript">
	// Pass the Java params to javascript
	var applicationId = "<%=request.getParameter("aid")%>";
	var action = "<%=request.getParameter("a")%>";
</script>

<!-- Include our scripts -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/leave/js/leave.app.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/leave/js/leave.rest.js"></script>

</head>