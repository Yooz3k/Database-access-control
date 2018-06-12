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
	
	getProducers();
}

function actionDelete() {
	document.getElementById("actionDelete").style.display = "inline";
	document.getElementById("actionCreate").style.display = "none";
	document.getElementById("actionUpdate").style.display = "none";
	document.getElementById("actionRead").style.display = "none";
}

function getProducers() {
	$.getJSON("/DatabaseAccessControl/services/producers/get", function(result) {
		$("#producersTable tbody tr").remove();       //Clear all but header rows of the table
        $.each(result, function(i, producer) {
            var row = $("<tr>");
            
            var idCell = document.createElement("td");
            var nameCell = document.createElement("td");
            var countryCell = document.createElement("td");
            idCell.innerHTML = producer.producerId;
            nameCell.innerHTML = producer.name;
            countryCell.innerHTML = producer.country;

            row.append(idCell)
            	.append(nameCell)
            	.append(countryCell);
            
            $("#producersTable tbody").append(row);
        });
	})
}

function createProducer() {
	var name = document.getElementById("nameCreate").value;
	var country = document.getElementById("countryCreate").value;
	
	var jsonObj = { 
			"name":name,
			"country":country
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/producers/add',
	    data: JSON.stringify(jsonObj),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function updateProducer() {
	var id = document.getElementById("producerIdUpdate").value;
	var name = document.getElementById("nameUpdate").value;
	var country = document.getElementById("countryUpdate").value;
	
	var jsonOb = { 
			"id":id,
			"name":name,
			"country":country
			};

	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/producers/edit',
	    data: JSON.stringify(jsonOb),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}

function deleteProducer() {
	var producerId = document.getElementById("producerIdDelete").value;
	
	$.ajax({
	    type: 'POST',
	    url: '/DatabaseAccessControl/services/producers/delete',
	    data: JSON.stringify({"producerId":producerId}),
	    success: function() {},
	    contentType: "application/json",
	    dataType: 'json'
	});
}