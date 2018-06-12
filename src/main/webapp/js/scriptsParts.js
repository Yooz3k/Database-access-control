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
	
	getParts();
}

function actionDelete() {
	document.getElementById("actionDelete").style.display = "inline";
	document.getElementById("actionCreate").style.display = "none";
	document.getElementById("actionUpdate").style.display = "none";
	document.getElementById("actionRead").style.display = "none";
}

function getParts() {
	$.getJSON("/DatabaseAccessControl/services/parts/get", function(result) {
		$("#partsTable tbody tr").remove();       //Clear all but header rows of the table
        $.each(result, function(i, part) {
            var row = $("<tr>");
            
            var idCell = document.createElement("td");
            var stockNumberCell = document.createElement("td");
            var nameCell = document.createElement("td");
            var amountCell = document.createElement("td");
            var priceCell = document.createElement("td");
            var categoryCell = document.createElement("td");
            var warehouseIdCell = document.createElement("td");
            var producerIdCell = document.createElement("td");
            idCell.innerHTML = part.partId;
            stockNumberCell.innerHTML = part.stockNumber;
            nameCell.innerHTML = part.name;
            amountCell.innerHTML = part.amount;
            priceCell.innerHTML = part.price;
            categoryCell.innerHTML = part.category;
            warehouseIdCell.innerHTML = part.warehouseId;
            producerIdCell.innerHTML = part.producerId;

            row.append(idCell)
            	.append(stockNumberCell)
            	.append(nameCell)
            	.append(amountCell)
            	.append(priceCell)
            	.append(categoryCell)
            	.append(warehouseIdCell)
            	.append(producerIdCell);
            
            $("#partsTable tbody").append(row);
        });
	})
}

function createPart() {
	var stockNumber = document.getElementById("stockNumberCreate").value;
	var name = document.getElementById("nameCreate").value;
	var amount = document.getElementById("amountCreate").value;
	var price = document.getElementById("priceCreate").value;
	var category = document.getElementById("categoryCreate").value;
	var warehouseId = document.getElementById("warehouseIdCreate").value;
	var producerId = document.getElementById("producerIdCreate").value;
	
	var jsonObj = { 
			"stockNumber":stockNumber,
			"name":name,
			"amount":amount,
			"price":price,
			"category":category,
			"warehouseId":warehouseId,
			"producerId":producerId
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/parts/add',
	    data: JSON.stringify(jsonObj),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function updatePart() {
	var id = document.getElementById("partIdUpdate").value;
	var stockNumber = document.getElementById("stockNumberUpdate").value;
	var name = document.getElementById("nameUpdate").value;
	var amount = document.getElementById("amountUpdate").value;
	var price = document.getElementById("priceUpdate").value;
	var category = document.getElementById("categoryUpdate").value;
	
	var jsonOb = { 
			"id":id,
			"stockNumber":stockNumber,
			"name":name,
			"amount":amount,
			"price":price,
			"category":category
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/parts/edit',
	    data: JSON.stringify(jsonOb),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function deletePart() {
	var partId = document.getElementById("partIdDelete").value;
	
	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/parts/delete',
	    data: JSON.stringify({"partId":partId}),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}