<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<div id="person-lookup">
	<script type="text/javascript"
		src="<c:url value="/resources/js/person.js" />"></script>
	<form:form id="person-lookup-form" method="post" modelAttribute="person-lookup-form"
		cssClass="cleanform" action="/backbone/person/lookup">
		<fieldset>
			<legend>Person Inspector</legend>			
			<div id="person-lookup-error" class="error"></div>
			<form:label path="id">
		  			NWU ID: <form:errors path="id" cssClass="error" />
			</form:label>
			<form:input path="id" />

			<!-- Allow form submission with keyboard without duplicating the dialog button -->
			<button type="submit">Submit</button>
			
			<div id="person-lookup-detail" class="success"></div>
		</fieldset>

	</form:form>
	<script type="text/javascript">
		$(document).ready( function() {
					$("#person-lookup-form").submit( function() {
								$.post($(this).attr("action"), $(this)
										.serialize(), function(data) {
									var detailSection = $("#person-lookup-detail").empty();
									var errorSection = $("#person-lookup-error").empty();
									if(data.name!=null){
										detailSection.append("<h3>Name: " + data.name + " " + data.surname + "</h3>");
										detailSection.append("<h3>Email: " + data.email + "</h3>");
										detailSection.show();
										errorSection.hide();
									} else {
										errorSection.append("<h3>Unable to retrieve person.</h3>");
										errorSection.show();
										detailSection.hide();
									}
								});
								return false;
							});
				});
	</script>
</div>