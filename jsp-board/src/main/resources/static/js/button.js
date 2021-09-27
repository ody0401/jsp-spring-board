function backBtnClick() {
	const x = confirm("뒤로 돌아가시겠습니까?");

	if (x) {
		return location.href='/';
	}

}
const btn = document.getElementById("backBtn");

const backBtn = btn.addEventListener("click", backBtnClick);

