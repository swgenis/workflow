<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<jsp:include page="/backbone/header.jsp"></jsp:include>

<body ng-app="backbone">

	<nav-bar></nav-bar>

	<div class="bacbone-content" >

		<bread-crumbs></bread-crumbs>

		<div id="content" class="container">
			<div class="row">
				<!-- Main Content View -->
				<div class="col-md-9" role="main">
					<thumb-nails></thumb-nails>					
				</div>

				<!-- Side bar -->
				<div class="col-md-3" role="complementary">					
					<action-list></action-list>
				</div>
			</div>

		</div>

	</div>

	<jsp:include page="/shared/include/footer.jsp"></jsp:include>
</body>
</html>