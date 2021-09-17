<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <form:form modelAttribute="member" method="post" cssClass="loginForm" action="/user/signup">
      <h2>Sign Up</h2>
      <div class="nameForm">
        <form:input path="userName" cssClass="name" placeholder="NAME" />
      </div>
      <div class="idForm">
        <form:input path="userId" cssClass="id" placeholder="ID" />
      </div>
      <div class="passForm">
        <form:password path="userPw" cssClass="pw" placeholder="PW" />
      </div>
      <button type="submit" class="btn">
        Sign Up
      </button>
      <div class="bottomText">
        Do you have ID? <a href="/user/login">Log In</a>
      </div>
    </form:form>
    
  </body>
</html>