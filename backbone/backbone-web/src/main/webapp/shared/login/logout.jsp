<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<jsp:include page="/backbone/header.jsp"></jsp:include>
User '<%=request.getRemoteUser()%>' has been logged out.

<% session.invalidate(); %>

<br/><br/>
<jsp:include page="../include/footer.jsp"></jsp:include>