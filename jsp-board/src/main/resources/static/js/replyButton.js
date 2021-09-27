let toggle = true;

let test = document.getElementById("test");

const onClickSubmit = () => {
	alert("버튼눌림");
}

const onClickReply = () => {

	if (toggle == true) {
		test.style.display = 'block';
		toggle = false;
	} else if (toggle == false) {
		test.style.display = 'none';
		toggle = true;
	}
}

const onClickDisplay = (e) => {
	console.log(e.id);

	let x = document.getElementById('reply' + e.id);

	if (x.style.display == "" || x.style.display == "none") {
		console.log(x.style.display);
		x.style.display = "block";
	} else if (x.style.display == "block") {
		console.log(x.style.display);
		x.style.display = "none";
	}
}

const onClickReplyDisplay = () => {
	
	let x = document.getElementById('dvdvDiv');
	
	if (x.style.display == "" || x.style.display == "none") {
		console.log(x.style.display);
		x.style.display = "block";
	} else if (x.style.display == "block") {
		console.log(x.style.display);
		x.style.display = "none";
	}
}
