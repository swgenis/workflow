<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<div id="discipline-section">
	<form:form id="discipline-form" method="post" class="cleanform"
		modelAttribute="disciplineForm">
		<div class="header">
			<h2>Form</h2>
			<c:if test="${not empty message}">
				<div id="message" class="success">${message}</div>
			</c:if>
			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="message" class="error">Form has errors</div>
				</c:if>
			</s:bind>
		</div>
		<fieldset>
			<legend>Discipline Info</legend>
			<form:label path="year">
		  			Year <form:errors path="year" cssClass="error" />
			</form:label>
			<form:input path="year" />
			
			<form:select path="category">
				<c:forEach items="${disciplineCategories}" var="type">
    				<form:option value="${type.key}">${type.description}</form:option>
				</c:forEach>
			</form:select>

			<form:label path="website">
		  			WebSite <form:errors path="website" cssClass="error" />
			</form:label>
			<form:input path="website" />

			<div>
				<form:label path="magcsaRepPerson">
		  				MAGCSA Representative <form:errors path="magcsaRepPerson"
						cssClass="error" />
				</form:label>
				<form:input id="field-magcsarep" path="magcsaRepPerson" />
				<button id="search-magcsarep" type="button">Search</button>
				<button id="create-magcsarep" type="button">Create</button>
			</div>

		</fieldset>
		<fieldset>

			<div>
				<form:label path="chiefInstructor">
		  				Chief Instructor <form:errors path="chiefInstructor"
						cssClass="error" />
				</form:label>
				<form:input path="chiefInstructor" />
				<button id="search-instructor" type="button">Search</button>
				<button id="create-instructor" type="button">Create</button>
			</div>

			<div>
				<form:label path="adminAssistant">
		  				Assistant <form:errors path="adminAssistant" cssClass="error" />
				</form:label>
				<form:input path="adminAssistant" />
				<button id="search-assistant" type="button">Search</button>
				<button id="create-assistant" type="button">Create</button>
			</div>
	
		</fieldset>
		<fieldset>

			<form:label path="physicalAddress">
		  			Physical Address <form:errors path="physicalAddress"
					cssClass="error" />
			</form:label>
			<form:input path="physicalAddress" />
			
			<form:label path="physicalAddressCode">
		  			Physical Code <form:errors path="physicalAddressCode"
					cssClass="error" />
			</form:label>
			<form:input path="physicalAddressCode" />

			<form:label path="postalAddress">
		  			Postal Address <form:errors path="postalAddress" cssClass="error" />
			</form:label>
			<form:input path="postalAddress" />
			
			<form:label path="postalAddressCode">
		  			Postal Code <form:errors path="postalAddressCode" cssClass="error" />
			</form:label>
			<form:input path="postalAddressCode" />

		</fieldset>

		<p>
		<table id="affiliations-grid"></table>
		</p>
		<p>
		<table id="clubs-grid"></table>
		</p>
		<p>
			<button type="submit">Save</button>
		</p>

	</form:form>

</div>