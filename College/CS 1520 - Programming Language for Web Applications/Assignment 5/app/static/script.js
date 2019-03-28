var categories = {};
var purchases = {};
var categoryTable;
var purchaseTable;
var months = ['January','February','March','April','May','June','July','August','September','October','November','December'];
var date = new Date();
var currentMonth = date.getMonth();
var currentYear = date.getFullYear();

window.onload = function(){
	categoryTable = document.getElementById("categoryTable");
	purchaseTable = document.getElementById("purchaseTable");
	document.getElementById("currentMonth").innerHTML = months[currentMonth] + ", " + currentYear;
	fetchAll();
};

function fetchAll() {
	fetchCategories();
	fetchPurchases();
}

function fetchCategories() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			response = JSON.parse(this.responseText);
			console.log(response);
			categories = response;
			updateCategories();
		}
	};
	xhttp.open("GET", "/cats");
	xhttp.send();
}

function fetchPurchases() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			response = JSON.parse(this.responseText);
			console.log(response);
			purchases = response;
			calculateRemaining();
		}
	};
	xhttp.open("GET", "/purchases");
	xhttp.send();
}

function updateCategories() {
	if (document.getElementsByClassName("c_row").length > 0) {
		var c_rows = Array.from(document.getElementsByClassName("c_row"));
		c_rows.map(function(row, index, c_rows) {
			row.parentElement.removeChild(row);
		});
	}
	var categorySelect = document.getElementById("p_categorySelect");
	var options = Array.from(categorySelect.children);
	options.map(function(option, index, options) {
		option.parentElement.removeChild(option);
	});

	var categoryTableInput = document.getElementById("c_input");
	var categoryKeys = Object.keys(categories);
	var purchaseKeys = Object.keys(purchases);
	categoryKeys.map(function(category, index, categoryKeys) {
		var cat = categories[category]["cat"];
		var budget = categories[category]["budget"];
		var remaining = budget;
		var button = document.createElement("button");
		button.innerHTML = "&#10006;";
		button.onclick = function(){deleteCategory(category);};

		var row = document.createElement("tr");
		row.classList.add("c_row");
		var cols = [document.createElement("td"), document.createElement("td"), document.createElement("td"), document.createElement("td")];
		cols[0].innerHTML = cat;
		cols[1].innerHTML = "$" + parseFloat(budget).toFixed(2);
		cols[2].innerHTML = "$" + parseFloat(remaining).toFixed(2);
		cols[2].id = "cid_" + category;
		cols[3].appendChild(button);

		if (category == -1) {
			row.classList.add("bold");
			cols[0].innerHTML = "Uncategorized";
			cols[1].innerHTML = "$" + parseFloat("0").toFixed(2);
			cols[2].innerHTML = "$" + parseFloat(remaining).toFixed(2);
			cols[3].removeChild(button);
		}

		cols.map(function(col) {
			row.appendChild(col);
		});
		categoryTableInput.parentElement.insertBefore(row, categoryTableInput);

		var option = document.createElement("option");
		option.value = category;
		if (category == -1) {
			option.selected = true;
		}
		option.innerHTML = cat;
		categorySelect.appendChild(option);
	});
}

function submitCategoryInput() {
	var catInput = document.getElementById("c_categoryInput");
	var budgetInput = document.getElementById("c_budgetInput");

	if (catInput.value.length == 0 || Object.keys(categories).filter(function(cat){ return categories[cat]["cat"] == catInput.value;}).length > 0) {
		alert("Category name cannot be blank or the same as any other category name.");
	} else if (budgetInput.value.length == 0 || budgetInput.value < 0 || budgetInput.checkValidity() == false) {
		alert("Category budget cannot be left blank and must be a valid dollar amount.");
	} else {
		var postable = {"cat": {"cat": catInput.value, "budget": budgetInput.value}};
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 201) {
				response = JSON.parse(this.responseText);
				console.log(response);
				catInput.value = "";
				budgetInput.value = "";
				fetchAll();
			}
		};
		xhttp.open("POST", "/cats");
		xhttp.setRequestHeader("Content-Type", "application/json");
		xhttp.send(JSON.stringify(postable));
	}
}

function deleteCategory(id) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 204) {
			console.log(this.responseText);
			fetchAll();
		}
	};
	xhttp.open("DELETE", "/cats/" + id);
	xhttp.send();
}

function submitPurchaseInput() {
	var item = document.getElementById("p_purchaseInput");
	var cost = document.getElementById("p_costInput");
	var category = document.getElementById("p_categorySelect");
	var date = document.getElementById("p_dateInput");

	if (item.value.length < 1) {
		alert("Purchase name cannot be left blank.");
	} else if (cost.value.length == 0 || cost.value < 0 ||cost.checkValidity() == false) {
		alert("Purchase cost cannot be left blank and must be a valid dollar amount.");
	} else if (date.checkValidity() == false) {
		alert("Purchase date must be set.");
	} else {
		var postable = {"purchase": {"item": item.value, "cost": cost.value, "date": date.value, "cat_id": category.value}};
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 201) {
				response = JSON.parse(this.responseText);
				console.log(response);
				item.value = "";
				cost.value = "";
				date.value = "";
				category.value = "-1";
				fetchAll();
			}
		};
		xhttp.open("PUT", "/purchases/" + new Date().getTime());
		xhttp.setRequestHeader("Content-Type", "application/json");
		xhttp.send(JSON.stringify(postable));
	}
}

function calculateRemaining() {
	var categoryKeys = Object.keys(categories);
	var purchaseKeys = Object.keys(purchases);
	var c_rows = Array.from(document.getElementsByClassName("c_row"));

	purchaseKeys.map(function (purchase, index, purchaseKeys) {
		if (purchases[purchase]["date"].substr(0, 7) == currentYear + "-" + (currentMonth+1).toString().padStart(2, '0')) {
			var category_id = purchases[purchase]["cat_id"];
			if (document.getElementById("cid_" + category_id)) {
				var remaining = parseFloat(document.getElementById("cid_" + category_id).innerHTML.substr(1));
				remaining -= parseFloat(purchases[purchase]["cost"]);
				document.getElementById("cid_" + category_id).innerHTML = "$" + remaining.toFixed(2);
			}
		}
	});

}
