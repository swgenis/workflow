<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<div id="person-dialog">
	<script type="text/javascript" src="<c:url value="/resources/js/person.js" />"></script>
	<form:form method="post" modelAttribute="personForm" cssClass="cleanform" action="/masa/person">
		<div class="header">
			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="message" class="error">Form has errors</div>
				</c:if>
			</s:bind>
		</div>
		<fieldset>
			<legend>Person Information</legend>
			<form:label path="name">
		  			Name <form:errors path="name" cssClass="error" />
			</form:label>
			<form:input path="name" />

			<form:label path="surname">
		  			Surname <form:errors path="surname" cssClass="error" />
			</form:label>
			<form:input path="surname" />

			<form:label path="email">
		  			Email <form:errors path="email" cssClass="error" />
			</form:label>
			<form:input path="email" />

			<form:label path="faxNumber">
		  			Fax <form:errors path="faxNumber" cssClass="error" />
			</form:label>
			<form:input path="faxNumber" />

			<form:label path="phoneNumber">
		  			Phone <form:errors path="phoneNumber" cssClass="error" />
			</form:label>
			<form:input path="phoneNumber" />

			<form:label path="racialType">
					Race Group (select one)
				</form:label>
			<form:select path="racialType">
				<form:option value="1">race 1</form:option>
				<form:option value="2">race 2</form:option>
				<form:option value="3">race 3</form:option>
			</form:select>

			<form:label path="licenseType">
					Gender Group (select one)
				</form:label>
			<form:select path="licenseType">
				<form:option value="male">Male</form:option>
				<form:option value="female">Female</form:option>
			</form:select>

			<label><form:checkbox path="active" value="true" />Active</label>
			
			<!-- Allow form submission with keyboard without duplicating the dialog button -->
			<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
		</fieldset>

		<fieldset>
			<legend>Instructor Information</legend>
			<label><form:checkbox path="firstAid" value="true" />First
				Aid?</label> <label><form:checkbox path="previousDisadvantage"
					value="true" />Previously Disadvantaged?</label>

			<form:label path="licenseType">
					License (select one)
				</form:label>
			<form:select path="licenseType">
				<form:option value="comment">Comment</form:option>
				<form:option value="feedback">Feedback</form:option>
				<form:option value="suggestion">Suggestion</form:option>
			</form:select>
		</fieldset>
	</form:form>
</div>