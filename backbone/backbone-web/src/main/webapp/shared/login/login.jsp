<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/backbone/header.jsp"></jsp:include>

<body ng-app="backbone">

	<form class="form-signin" role="form"
		style="max-width: 400px; margin: auto" action='j_security_check'
		method='post'>

		<h2 class="form-signin-heading">Please sign in</h2>
		<input type="text" name="j_username" class="form-control"
			placeholder="Name" required autofocus> <input type="password"
			name="j_password" class="form-control" placeholder="Password"
			required>
		<p>(Use name "me" and password "me".)</p>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
	</form>

</body>
</html>
