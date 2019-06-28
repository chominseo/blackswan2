

window.addEventListener("load", function() {

	var select = document.querySelector("#mySelect");
	var fp = document.querySelector("#aa input");
	
	select.addEventListener("change", function() {

		var x = document.getElementById("mySelect").value;
		document.getElementById("demo").innerHTML = x;
		fp.value = x;
		
	})

});

