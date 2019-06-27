window.addEventListener("load", function() {
	var banner = document.querySelector("#banner .center");
	var ul = banner.querySelector("ul");
	var lis = banner.querySelectorAll("li");

	var prev = banner.querySelector(".prev-banner");
	var next = banner.querySelector(".next-banner");

	next.onclick = function() {
		var main = banner.querySelector(".main");
		var left;

		if (main.previousElementSibling)
			left = main.previousElementSibling;
		else
			left = ul.querySelector("li:last-child");

		for (var i = 0; i < lis.length; i++) {
			lis[i].classList.remove("main");
			lis[i].style["animation-name"] = "";
		}

		left.style["animation-name"] = "left";
		left.classList.add("main");

	};

	prev.onclick = function() {
		var main = banner.querySelector(".main");
		var right;

		if (main.nextElementSibling)
			right = main.nextElementSibling;
		else
			right = lis[0];

		for (var i = 0; i < lis.length; i++) {
			lis[i].classList.remove("main");
			lis[i].style["animation-name"] = "";
		}

		right.style["animation-name"] = "right";
		right.classList.add("main");

	};
})