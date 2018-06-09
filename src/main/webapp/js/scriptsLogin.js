function login() {
	var login = document.getElementById("login").value;
	var password = document.getElementById("password").value;
	
	var jsonObj = {
			"login":login,
			"password":password
	};
	
	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/login',
	    data: JSON.stringify(jsonObj),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}