<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="/" />
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/loginStyle.css" >
</head>
<body>
	<sec:authorize access="isAuthenticated()">
	<script>
		location.href='/';
	</script>
	</sec:authorize>
    <form action="/login" method="post" class="loginForm">
      <h2>Login</h2>
      <div class="idForm">
        <input name="username" type="text" class="id" placeholder="ID">
      </div>
      <div class="passForm">
        <input name="password" type="password" class="pw" placeholder="PW">
      </div>
      <button type="submit" class="btn">
        LOG IN
      </button>
      <c:if test="${not empty error}" >
      <div class="errorText">
        아이디 또는 패스워드가 일치하지않습니다.
      </div>
      </c:if>
      <div class="bottomText">
        Don't you have ID? <a href="/user/signup">sign up</a>
      </div>
    </form>
  </body>
</html>