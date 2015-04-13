<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<div id="person-lookup">
	<fieldset>
		<div id="person-lookup-error" class="error"></div>
			
		<div style="border: 1px solid #ccc; width: 250px;">
				NWU ID: <br/>
			<input id="person-lookup-id" type="text" size="25">
			<br/>
			<button type="button" onclick="add()">...</button>
		</div>
		<div id="person-lookup-detail" class="success"></div>
	</fieldset>

	<script type="text/javascript">
		$(document).ready( function() {
			$("#person-lookup-detail").hide();
			$("#person-lookup-error").hide();
		});
		function add() {
			$.get("/backbone/person/lookup", 
					{ personLookupId: $("#person-lookup-id").val() }, function(data) {
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
		}
	</script>
</div>