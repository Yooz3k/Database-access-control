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
	
	getWarehouses();
}

function actionDelete() {
	document.getElementById("actionDelete").style.display = "inline";
	document.getElementById("actionCreate").style.display = "none";
	document.getElementById("actionUpdate").style.display = "none";
	document.getElementById("actionRead").style.display = "none";
}

function getWarehouses() {
	$.getJSON("/DatabaseAccessControl/services/warehouses/get", function(result) {
		$("#warehousesTable tbody tr").remove();       //Clear all but header rows of the table
        $.each(result, function(i, warehouse) {
            var row = $("<tr>");
            
            var idCell = document.createElement("td");
            var capacityCell = document.createElement("td");
            idCell.innerHTML = warehouse.warehouseId;
            capacityCell.innerHTML = warehouse.capacity;

            row.append(idCell)
            	.append(capacityCell);
            
            $("#warehousesTable tbody").append(row);
        });
	})
}

function createWarehouse() {
	var capacity = document.getElementById("capacityCreate").value;
	
	var jsonObj = { 
			"capacity":capacity
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/warehouses/add',
	    data: JSON.stringify(jsonObj),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function updateWarehouse() {
	var id = document.getElementById("warehouseIdUpdate").value;
	var capacity = document.getElementById("capacityUpdate").value;
	
	var jsonOb = { 
			"id":id,
			"capacity":capacity
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/warehouses/edit',
	    data: JSON.stringify(jsonOb),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function deleteWarehouse() {
	var warehouseId = document.getElementById("warehouseIdDelete").value;
	
	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/warehouses/delete',
	    data: JSON.stringify({"warehouseId":warehouseId}),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}