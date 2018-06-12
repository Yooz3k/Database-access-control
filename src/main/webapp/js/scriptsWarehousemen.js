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
	
	getWarehousemen();
}

function actionDelete() {
	document.getElementById("actionDelete").style.display = "inline";
	document.getElementById("actionCreate").style.display = "none";
	document.getElementById("actionUpdate").style.display = "none";
	document.getElementById("actionRead").style.display = "none";
}

function getWarehousemen() {
	$.getJSON("/DatabaseAccessControl/services/warehousemen/get", function(result) {
		$("#warehousemenTable tbody tr").remove();       //Clear all but header rows of the table
        $.each(result, function(i, warehouseman) {
            var row = $("<tr>");
            
            var idCell = document.createElement("td");
            var peselCell = document.createElement("td");
            var nationalityCell = document.createElement("td");
            var fullNameCell = document.createElement("td");
            var employmentDateCell = document.createElement("td");
            idCell.innerHTML = warehouseman.warehousemanId;
            peselCell.innerHTML = warehouseman.pesel;
            nationalityCell.innerHTML = warehouseman.nationality;
            fullNameCell.innerHTML = warehouseman.fullName;
            employmentDateCell.innerHTML = warehouseman.employmentDate;

            row.append(idCell)
            	.append(peselCell)
            	.append(nationalityCell)
            	.append(fullNameCell)
            	.append(employmentDateCell);
            
            $("#warehousemenTable tbody").append(row);
        });
	})
}

function createWarehouseman() {
	var pesel = document.getElementById("peselCreate").value;
	var nationality = document.getElementById("nationalityCreate").value;
	var fullName = document.getElementById("fullNameCreate").value;
	var employmentDate = document.getElementById("employmentDateCreate").value;
	
	var jsonObj = { 
			"pesel":pesel,
			"nationality":nationality,
			"fullName":fullName,
			"employmentDate":employmentDate
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/warehousemen/add',
	    data: JSON.stringify(jsonObj),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function updateWarehouseman() {
	var id = document.getElementById("warehousemanIdUpdate").value;
	var pesel = document.getElementById("peselUpdate").value;
	var nationality = document.getElementById("nationalityUpdate").value;
	var fullName = document.getElementById("fullNameUpdate").value;
	var employmentDate = document.getElementById("employmentDateUpdate").value;
	
	var jsonOb = { 
			"id":id,
			"pesel":pesel,
			"nationality":nationality,
			"fullName":fullName,
			"employmentDate":employmentDate
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/warehousemen/edit',
	    data: JSON.stringify(jsonOb),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function deleteWarehouseman() {
	var warehousemanId = document.getElementById("warehousemanIdDelete").value;
	
	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/warehousemen/delete',
	    data: JSON.stringify({"warehousemanId":warehousemanId}),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}