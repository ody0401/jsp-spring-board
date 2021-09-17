const onClickWriteBtn1 = () => {
	const x = confirm('로그인이 되어있지않습니다. 로그인 하시겠습니까?');

	if (x) {
		return location.href = "user/login";
	}
}

const onClickWriteBtn2 = () => {
	alert('로그인이 되어있습니다');
}

const onClickLogOut = () => {
	const x = confirm('로그아웃 하시겠습니까?');
	
	if (x) {
		return location.href = "/logout";
	}
}

const onClickLogIn = () => {
	return location.href = "/user/login";
}

const onClickSignUp = () => {
	return location.href = "/user/signup";
}
