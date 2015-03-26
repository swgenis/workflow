$(function() {
	// Initialize appendGrid
	$('#affiliations-grid')
			.appendGrid(
					{
						caption : 'International Affiliations',
						initRows : 1,
						columns : [
								{
									name : 'name',
									display : 'Name',
									type : 'text',
									ctrlAttr : {
										maxlength : 100
									},
									ctrlCss : {
										width : '160px'
									}
								},
								{
									name : 'address',
									display : 'Address',
									type : 'text',
									ctrlAttr : {
										maxlength : 100
									},
									ctrlCss : {
										width : '100px'
									}
								},
								{
									name : 'email',
									display : 'Email',
									type : 'text',
									ctrlAttr : {
										maxlength : 4
									},
									ctrlCss : {
										width : '40px'
									}
								},
								{
									name : 'phoneNumber',
									display : 'Tel',
									type : 'text',
									ctrlAttr : {
										maxlength : 4
									},
									ctrlCss : {
										width : '40px'
									}
								},
								{
									name : 'faxNumber',
									display : 'Fax',
									type : 'text',
									ctrlAttr : {
										maxlength : 4
									},
									ctrlCss : {
										width : '40px'
									}
								} ],
						// Add a row limit for demo purpose
						maxRowsAllowed : 8,
						maxNumRowsReached : function() {
							alert('(Demo purpose) You cannot add more than 8 rows!');
						}
					});
});

$(function() {
	// Initialize appendGrid
	$('#clubs-grid')
			.appendGrid(
					{
						caption : 'Club Section',
						initRows : 1,
						columns : [
								{
									name : 'name',
									display : 'Club Name',
									type : 'text',
									ctrlAttr : {
										maxlength : 100
									},
									ctrlCss : {
										width : '160px'
									}
								},
								{
									name : 'city',
									display : 'City',
									type : 'text',
									ctrlAttr : {
										maxlength : 100
									},
									ctrlCss : {
										width : '100px'
									}
								},
								{
									name : 'district',
									display : 'District',
									type : 'select',
									ctrlOptions : {
										0 : '{Choose}',
										1 : 'Hong Kong',
										2 : 'Taiwan',
										3 : 'Japan',
										4 : 'Korea',
										5 : 'US',
										6 : 'Others'
									}
								},
								{
									name : 'province',
									display : 'Province',
									type : 'select',
									ctrlOptions : {
										0 : '{Choose}',
										1 : 'Hong Kong',
										2 : 'Taiwan',
										3 : 'Japan',
										4 : 'Korea',
										5 : 'US',
										6 : 'Others'
									}
								},
								{
									name : 'category',
									display : 'Category',
									type : 'select',
									ctrlOptions : {
										0 : '{Choose}',
										1 : 'Hong Kong',
										2 : 'Taiwan',
										3 : 'Japan',
										4 : 'Korea',
										5 : 'US',
										6 : 'Others'
									}
								},
								{
									name : 'numberOfMaleStudents',
									display : 'Male Students',
									type : 'text',
									ctrlAttr : {
										maxlength : 10
									},
									ctrlCss : {
										width : '50px',
										'text-align' : 'right'
									},
									value : 0
								},
								{
									name : 'numberOfFemaleStudent',
									display : 'Female Students',
									type : 'text',
									ctrlAttr : {
										maxlength : 10
									},
									ctrlCss : {
										width : '50px',
										'text-align' : 'right'
									},
									value : 0
								},
								{
									name : 'active',
									display : 'Active',
									type : 'checkbox'
								}, 
								{
									name : 'instructor',
									display : 'Instructor',
									type : 'text',
									ctrlAttr : {
										maxlength : 10
									},
									ctrlCss : {
										width : '50px',
										'text-align' : 'right'
									},
									value : 0
								} ],
						// Add a row limit for demo purpose
						maxRowsAllowed : 8,
						maxNumRowsReached : function() {
							alert('(Demo purpose) You cannot add more than 8 rows!');
						}
					});
});

$(function() {	
	//Initialize list all table
	$('#discipline-table').DataTable();
	$("#category").selectmenu();
});

$(document).ready(function() {
	$("#discipline-form").submit(function() {
		$.post($(this).attr("action"), $(this).serialize(), function(html) {
			$("#discipline-section").replaceWith(html);
			$('html, body').animate({
				scrollTop : $("#message").offset().top
			}, 500);
		});
		return false;
	});
} );