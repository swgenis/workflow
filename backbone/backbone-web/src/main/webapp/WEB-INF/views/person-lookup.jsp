<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<script type="text/javascript" src="<c:url value="/resources/jquery/dataTables/jquery.dataTables.js" />"></script>
<div id="person-lookup">
	<script type="text/javascript" src="<c:url value="/resources/js/person.js" />"></script>
	<div style="border: 1px solid #ccc; width: 250px;">
		Search Criteria: <br/>
		<input id="nameLookup" type="text" size="25"> +
		<input id="surnameLookup" type="text" size="25">
		<br/>
		Sum: <span id="sum">(Result will be shown here)</span>
	</div>
	<p>
		<table id="results-grid" class="display" width="100%" cellspacing="0">
        	<thead>
            	<tr>
                	<th>Name</th>
                	<th>Surname</th>
                	<th>Email</th>
            	</tr>
        	</thead>
        	<c:forEach items="${searchResult}" var="discipline">
    			<tr>      
        			<td>${result.name}</td>
	       			<td>${result.surname}</td>
	       			<td>${result.email}</td>
	    		</tr>
			</c:forEach>
		</table>
	</p>
</div>