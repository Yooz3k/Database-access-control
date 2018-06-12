function actionCreate() {
	document.getElementById("actionCreate").style.display = "inline";
	document.getElementById("actionUpdate").style.display = "none";
	document.getElementById("actionRead").style.display = "none";
	document.getElementById("actionDelete").style.display = "none";
}

function actionUpdate() {
	document.getElementById("actionUpdate").style.display = "inline";
	document.getElementById("actionCreate").style.display = "none";
	document.getElementById("actionRead").style.display = "none";
	document.getElementById("actionDelete").style.display = "none";
}

function actionRead() {
	document.getElementById("actionRead").style.display = "inline";
	document.getElementById("actionCreate").style.display = "none";
	document.getElementById("actionUpdate").style.display = "none";
	document.getElementById("actionDelete").style.display = "none";
	
	getSuppliers();
}

function actionDelete() {
	document.getElementById("actionDelete").style.display = "inline";
	document.getElementById("actionCreate").style.display = "none";
	document.getElementById("actionUpdate").style.display = "none";
	document.getElementById("actionRead").style.display = "none";
}

function getSuppliers() {
	$.getJSON("/DatabaseAccessControl/services/suppliers/get", function(result) {
		$("#suppliersTable tbody tr").remove();       //Clear all but header rows of the table
        $.each(result, function(i, supplier) {
            var row = $("<tr>");
            
            var idCell = document.createElement("td");
            var nameCell = document.createElement("td");
            var cityCell = document.createElement("td");
            var phoneNumberCell = document.createElement("td");
            var cooperationStartDateCell = document.createElement("td");
            idCell.innerHTML = supplier.supplierId;
            nameCell.innerHTML = supplier.name;
            cityCell.innerHTML = supplier.city;
            phoneNumberCell.innerHTML = supplier.phoneNumber;
            cooperationStartDateCell.innerHTML = supplier.cooperationStartDate;

            row.append(idCell)
            	.append(nameCell)
            	.append(cityCell)
            	.append(phoneNumberCell)
            	.append(cooperationStartDateCell);
            
            $("#suppliersTable tbody").append(row);
        });
	})
}

function createSupplier() {
	var name = document.getElementById("nameCreate").value;
	var city = document.getElementById("cityCreate").value;
	var phoneNumber = document.getElementById("phoneNumberCreate").value;
	var cooperationStartDate = document.getElementById("cooperationStartDateCreate").value;
	
	var jsonObj = { 
			"name":name,
			"city":city,
			"phoneNumber":phoneNumber,
			"cooperationStartDate":cooperationStartDate
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/suppliers/add',
	    data: JSON.stringify(jsonObj),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function updateSupplier() {
	var id = document.getElementById("supplierIdUpdate").value;
	var name = document.getElementById("nameUpdate").value;
	var city = document.getElementById("cityUpdate").value;
	var phoneNumber = document.getElementById("phoneNumberUpdate").value;
	var cooperationStartDate = document.getElementById("cooperationStartDateUpdate").value;
	
	var jsonOb = { 
			"id":id,
			"name":name,
			"city":city,
			"phoneNumber":phoneNumber,
			"cooperationStartDate":cooperationStartDate
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/suppliers/edit',
	    data: JSON.stringify(jsonOb),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function deleteSupplier() {
	var supplierId = document.getElementById("supplierIdDelete").value;
	
	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/suppliers/delete',
	    data: JSON.stringify({"supplierId":supplierId}),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}