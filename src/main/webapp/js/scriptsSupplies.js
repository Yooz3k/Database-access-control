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
	
	getSupplies();
}

function actionDelete() {
	document.getElementById("actionDelete").style.display = "inline";
	document.getElementById("actionCreate").style.display = "none";
	document.getElementById("actionUpdate").style.display = "none";
	document.getElementById("actionRead").style.display = "none";
}

function getSupplies() {
	$.getJSON("/DatabaseAccessControl/services/supplies/get", function(result) {
		$("#suppliesTable tbody tr").remove();       //Clear all but header rows of the table
        $.each(result, function(i, supply) {
            var row = $("<tr>");
            
            var idCell = document.createElement("td");
            var shippingNumberCell = document.createElement("td");
            var shippingDateCell = document.createElement("td");
            var shippingTimeCell = document.createElement("td");
            var supplierIdCell = document.createElement("td");
            var warehousemanIdCell = document.createElement("td");
            var warehouseIdCell = document.createElement("td");
            idCell.innerHTML = supply.supplyId;
            shippingNumberCell.innerHTML = supply.shippingNumber;
            shippingDateCell.innerHTML = supply.shippingDate;
            shippingTimeCell.innerHTML = supply.shippingTime;
            supplierIdCell.innerHTML = supply.supplierId;
            warehousemanIdCell.innerHTML = supply.warehousemanId;
            warehouseIdCell.innerHTML = supply.warehouseId;

            row.append(idCell)
            	.append(shippingNumberCell)
            	.append(shippingDateCell)
            	.append(shippingTimeCell)
            	.append(supplierIdCell)
            	.append(warehousemanIdCell)
            	.append(warehouseIdCell);
            
            $("#suppliesTable tbody").append(row);
        });
	})
}

function createSupply() {
	var shippingNumber = document.getElementById("shippingNumberCreate").value;
	var shippingDate = document.getElementById("shippingDateCreate").value;
	var shippingTime = document.getElementById("shippingTimeCreate").value;
	var supplierId = document.getElementById("supplierIdCreate").value;
	var warehousemanId = document.getElementById("warehousemanIdCreate").value;
	var warehouseId = document.getElementById("warehouseIdCreate").value;
	
	var jsonObj = { 
			"shippingNumber":shippingNumber,
			"shippingDate":shippingDate,
			"shippingTime":shippingTime,
			"supplierId":supplierId,
			"warehousemanId":warehousemanId,
			"warehouseId":warehouseId
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/supplies/add',
	    data: JSON.stringify(jsonObj),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function updateSupply() {
	var id = document.getElementById("supplyIdUpdate").value;
	var shippingNumber = document.getElementById("shippingNumberUpdate").value;
	var shippingDate = document.getElementById("shippingDateUpdate").value;
	var shippingTime = document.getElementById("shippingTimeUpdate").value;
	var supplierId = document.getElementById("supplierIdUpdate").value;
	var warehousemanId = document.getElementById("warehousemanIdUpdate").value;
	var warehouseId = document.getElementById("warehouseIdUpdate").value;
	
	var jsonOb = { 
			"id":id,
			"shippingNumber":shippingNumber,
			"shippingDate":shippingDate,
			"shippingTime":shippingTime,
			"supplierId":supplierId,
			"warehousemanId":warehousemanId,
			"warehouseId":warehouseId
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/supplies/edit',
	    data: JSON.stringify(jsonOb),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function deleteSupply() {
	var supplyId = document.getElementById("supplyIdDelete").value;
	
	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/supplies/delete',
	    data: JSON.stringify({"supplyId":supplyId}),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}