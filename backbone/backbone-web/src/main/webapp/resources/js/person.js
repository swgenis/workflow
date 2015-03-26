function updateTips(t) {
	tips.text(t).addClass("ui-state-highlight");
	setTimeout(function() {
		tips.removeClass("ui-state-highlight", 1500);
	}, 500);
}

function checkLength(o, n, min, max) {
	if (o.val().length > max || o.val().length < min) {
		o.addClass("ui-state-error");
		updateTips("Length of " + n + " must be between " + min + " and " + max
				+ ".");
		return false;
	} else {
		return true;
	}
}

function checkRegexp(o, regexp, n) {
	if (!(regexp.test(o.val()))) {
		o.addClass("ui-state-error");
		updateTips(n);
		return false;
	} else {
		return true;
	}
}

$(function() {
	var dialog, form,
	// From
	// http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
	emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/, name = $("#name"), email = $("#email"), password = $("#password"), allFields = $(
			[]).add(name).add(email).add(password), tips = $(".validateTips");

	function addPerson() {
		var valid = true;
		allFields.removeClass("ui-state-error");
		valid = valid && checkLength(name, "name", 3, 16);
		valid = valid && checkLength(email, "email", 6, 80);
		valid = valid
				&& checkRegexp(
						name,
						/^[a-z]([0-9a-z_\s])+$/i,
						"Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter.");
		valid = valid && checkRegexp(email, emailRegex, "eg. ui@jquery.com");
		if (valid) {
			form.submit();
			dialog.dialog("close");
		}
		return valid;
	}
	
	dialog = $("#person-dialog").dialog({
		autoOpen : false,
		height : 500,
		width : 650,
		modal : true,
		buttons : {
			"Create a Person" : addPerson,
			Cancel : function() {
				dialog.dialog("close");
			}
		},
		close : function() {
			form[0].reset();
			allFields.removeClass("ui-state-error");
		}
	});
	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		addPerson();
	});
	$("#create-magcsarep").button().on("click", function() {
		dialog.dialog("open");
	});
});

$(function() {
	var dialog, form, table;
	
	dialog = $("#person-lookup").dialog({
		autoOpen : false,
		height : 500,
		width : 650,
		modal : true,
		buttons : {
			"Search" : searchPerson,
			"Return" : returnPerson,
			Cancel : function() {
				dialog.dialog("close");
			}
		},
		close : function() {
			form[0].reset();
			allFields.removeClass("ui-state-error");
		}
	});
	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		addPerson();
	});
	$("#search-magcsarep").button().on("click", function() {
		dialog.dialog("open");
	});
	table = $('#results-grid').DataTable();
	

	function searchPerson() {
		$.post("/masa/person/search", {
			name : $("#nameLookup").val(),
			surname : $("#surnameLookup").val()
		}, function(data) {
			data.forEach(function(s){
				table.row.add(s).draw();
			})			
		});
	}

	function returnPerson() {
		//
	}
});
