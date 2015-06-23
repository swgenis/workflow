<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8" />
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<meta
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1, height=device-height, width=device-width"
	name="viewport" />
<title>Backbone</title>

<jsp:include page="/shared/include/dependencies.jsp"></jsp:include>

<script>
	var contextPath = "${pageContext.request.contextPath}";
</script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/backbone.css">

<jsp:include page="/backbone/dependencies.jsp"></jsp:include>

</head>